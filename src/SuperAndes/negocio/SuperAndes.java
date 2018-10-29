package SuperAndes.negocio;


import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonObject;

import SuperAndes.persistencia.PersistenciaSuperAndes;


/**
 * Clase principal del negocio
 * Sarisface todos los requerimientos funcionales del negocio
 *
 * @author Ja.penat
 */
public class SuperAndes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(SuperAndes.class.getName());

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaSuperAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public SuperAndes ()
	{
		pp = PersistenciaSuperAndes.getInstance ();
	}

	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public SuperAndes (JsonObject tableConfig)
	{
		pp = pp.getInstance (tableConfig);
	}

	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	
	/* ****************************************************************
	 * 			Método para el RF7
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una promocion 
	 * Adiciona entradas al log de la aplicación
	 * @return El objeto de promocion adicionado. null si ocurre alguna Excepción
	 */
	public Promocion registrarPromocion (int tipo, String descripcion, int idSucursal, int cantidadProductos, int productoCodigoBarras, Date fechaExpiracion)
	{
		log.info ("Adicionando promocion ");
		Almacenamiento almacenado = pp.darAlmacenamientoPorId( idSucursal, productoCodigoBarras);
		Date hoy = new Date();
		if(almacenado == null)
		{
			return null;
		}
		else if(fechaExpiracion.after(hoy) || cantidadProductos > almacenado.getUnidadesDisp())
		{
			return null;
		}
		else
		{
			Promocion promocion = pp.adicionarPromocion(tipo, descripcion, idSucursal, cantidadProductos, productoCodigoBarras, fechaExpiracion);
			log.info ("Adicionando promocion: " + promocion);
			return promocion;
		}
	}
	/* ****************************************************************
	 * 			Método para el RF8
	 *****************************************************************/
	/**
	 * Elimina las promociones que estan vencidas
	 * @return La cantidad de promociones eliminadas
	 */
	public int verificarPromociones()
	{
		log.info("Verificando promociones");
		int result = 0;
		ArrayList<Promocion> promos = new ArrayList();
		Date fechaActual = new Date();
		List<Promocion> lista = pp.darPromociones();
		for(int i = 0 ; i< lista.size(); i++)
		{
			Promocion promo = lista.get(i);
			if(promo.getCantidadProductos() == 0  || promo.getFechaExpiracion().after(fechaActual))
			{
				promos.add(promo);
			}
		}
		log.info("Eliminando promociones vencidas");
		for(int j = 0; promos.size() > j ; j ++)
		{
			pp.eliminarPromocionPorId(promos.get(j).getId());
			result ++;
		}
		log.info("Las promociones vencidas han sido eliminadas");
		return result;
	}

	/**
	 * Eliminar una promocion
	 * @return La cantidad de tuplas eliminadas
	 */
	public long eliminarPromocion(int id)
	{
		log.info ("Eliminando promocion: " + id);
		long resp = pp.eliminarPromocionPorId(id) ;
		log.info ("Eliminando promocion: " + resp + " tuplas eliminadas");
		return resp;
	}

	/* ****************************************************************
	 * 			Método para el RF9
	 *****************************************************************/
	/**
	 * Metodo que registra un pedido para un proveedor de una sucursarl
	 * Retorna null si hay una excepcion
	 */
	public Pedido registrarPedido(int idSucursal, int idProveedor, int cantidad, int idProducto, boolean completo, int costo, Date fechaEntrega, int calificacionCalidad, String presentacion )
	{
		log.info("Registrando pedido de un producto a un proveedor para una sucursal");
		log.info("Verificando que el proveedor si supla a la sucursal y que el producto exista");
		if(pp.darProveedorSucursal(idSucursal, idProveedor) == null || pp.darProductoPorId(idProducto) == null)
		{
			log.info("El proveedor no suple esta sucursal" + idSucursal + "o el producto no existe");
			return null;
		}
		else
		{
			return pp.registrarPedido(idSucursal, idProveedor, idProducto, cantidad, completo, costo, fechaEntrega, calificacionCalidad, presentacion);
		}
	}
	/* ****************************************************************
	 * 			Método para el RF10
	 *****************************************************************/
	/**
	 * Metodo que registra la llegada de un pedido a la sucursal
	 * retorna null si hay algun error
	 */
	public Pedido registrarLlegadaPedido(int idPedido)
	{
		log.info("Registrando  la llegada de un pedido en la sucursal");
		log.info("Verificando que el pedido exista");
		Pedido pedido = pp.darPedidoPorId(idPedido);
		Date fecha = new Date();
		if(pedido == null)
		{
			log.info("El pedido no existe");
			return null;
		}
		else if( pedido.getFechaEntrega().before(fecha))
		{
			log.info("El pedido aun no ha llegado");
			return null;
		}
		else if(pp.darAlmacenamientoPorId(pedido.getSucursalId(), pedido.getProductoCodigoBarras()) == null)
		{
			log.info("La sucursal no tiene este producto");
			return null;
		}
		else
		{
			pp.actualizarAlmacenamiento(pedido.getCantidad(), pedido.getSucursalId(), pedido.getProductoCodigoBarras());
			return  pedido;
		}
	}
	/* ****************************************************************
	 * 			Método para el RF11
	 *****************************************************************/
}
