package SuperAndes.persistencia;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import SuperAndes.negocio.Almacenamiento;
import SuperAndes.negocio.Pedido;
import SuperAndes.negocio.Producto;
import SuperAndes.negocio.Promocion;
import SuperAndes.negocio.ProveedorSucursal;
import SuperAndes.negocio.Sucursal;

/**
 * Clase para el manejador de persistencia del proyecto
 * Traduce la información entre objetos Java y tuplas de la base de datos, en ambos sentidos
 * Sigue un patrón SINGLETON (Sólo puede haber UN objeto de esta clase) para comunicarse de manera correcta
 * con la base de datos
 * 
 * @author Ja.penat
 */
public class PersistenciaSuperAndes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaSuperAndes.class.getName());

	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaSuperAndes instance;

	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;

	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden.
	 */
	private List <String> tablas;


	/**
	 * Atributo para el acceso a la tabla ALMACENAMIENTO de la base de datos
	 */
	private SQLAlmacenamiento sqlAlmacenamiento;

	/**
	 * Atributo para el acceso a la tabla CATEGORIAPRODUCTO de la base de datos
	 */
	private SLQCategoriaProducto sqlCategoriaProducto;

	/**
	 * Atributo para el acceso a la tabla CATEGORIA de la base de datos
	 */
	private SQLCategoria sqlCategoria;

	/**
	 * Atributo para el acceso a la tabla PRODUCTO de la base de datos
	 */
	private SQLProducto sqlProducto;

	/**
	 * Atributo para el acceso a la tabla SUCURSAL de la base de datos
	 */
	private SQLSucursal sqlSucursal;

	/**
	 * Atributo para el acceso a la tabla PROVEEDOR de la base de datos
	 */
	private SQLProveedor sqlProveedor;

	/**
	 * Atributo para el acceso a la tabla PROVEEDORSUCURSAL de la base de datos
	 */
	private SQLProveedorSucursal sqlProveedorSucursal;

	/**
	 * Atributo para el acceso a la tabla PROMOCION de la base de datos
	 */
	private SQLPromocion sqlPromocion;

	/**
	 * Atributo para el acceso a la tabla PEDIDO de la base de datos
	 */
	private SQLPedido sqlPedido;
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaSuperAndes
	 */
	private SQLUtil sqlUtil;



	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlProveedor = new SQLProveedor(this);
		sqlSucursal= new SQLSucursal(this);
		sqlProducto = new SQLProducto(this);
		sqlCategoria = new SQLCategoria(this);
		sqlCategoriaProducto = new SLQCategoriaProducto(this);
		sqlProveedorSucursal= new SQLProveedorSucursal (this);
		sqlAlmacenamiento= new SQLAlmacenamiento(this);
		sqlPedido = new SQLPedido(this);
		sqlPromocion = new SQLPromocion(this);		
		sqlUtil = new SQLUtil(this);
	}
	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaSuperAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("SuperAndes");		
		crearClasesSQL ();

		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("SuperAndes_sequence");
		tablas.add ("PROVEEDOR:");
		tablas.add ("CLIENTE");
		tablas.add ("SUCURSAL");
		tablas.add ("PRODUCTO");
		tablas.add ("CATEGORIA");
		tablas.add ("CATEGORIAPRODUCTO");
		tablas.add ("CLIENTESUCURSAL");
		tablas.add ("PROVEEDORSUCURSAL");
		tablas.add ("ALMACENAMIENTO");
		tablas.add ("PEDIDO");
		tablas.add ("FACTURA");
		tablas.add ("VENTA");
		tablas.add ("PROMOCION");
	}


	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaSuperAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);

		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * Transacción para el generador de secuencia de SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de SuperAndes
	 */
	private long nextval ()
	{
		long resp = sqlUtil.nextval (pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}

	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de superAndes
	 */
	public String darSeqSuperAndes ()
	{
		return tablas.get (0);
	}

	public String darTablaProveedor()
	{
		return tablas.get(1);
	}

	public String darTablaCliente()
	{
		return tablas.get(2);
	}
	public String darTablaSucursal() 
	{
		return tablas.get(3);
	}
	public String darTablaProducto() 
	{
		return tablas.get(4);
	}
	public String darTablaCategoria() 
	{
		return tablas.get(5);
	}
	public String darTablaCategoriaProducto() 
	{
		return tablas.get(6);
	}
	public String darTablaClienteSucursal()
	{
		return tablas.get(7);
	}
	public String darTablaProveedorSucursal() 
	{
		return tablas.get(8);
	}
	public String darTablaAlmacenamiento() 
	{
		return tablas.get(9);
	}
	public String darTablaPedido() 
	{
		return tablas.get(10);
	}
	public String darTablaFactura() 
	{
		return tablas.get(11);
	}
	public String darTablaVenta() 
	{
		return tablas.get(12);
	}
	public String darTablaPromocion()
	{
		return tablas.get(13);
	}


	/**
	 * @return Retorna el único objeto PersistenciaSuperAndes existente - Patrón SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes() ;
		}
		return instance;
	}

	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaSuperAndes existente - Patrón SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes(tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}

	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}

		return resp;
	}

	/* ****************************************************************
	 * 			Métodos para el RF7
	 *****************************************************************/
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Promocion
	 */
	public Promocion adicionarPromocion(int tipo, String descripcion, int sucursalId, int cantidadProductos, int productoCodigoBarras, Date fechaExpiracion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idPromocion = nextval ();
			int id = (int)idPromocion;
			long tuplasInsertadas = sqlPromocion.adicionarPromocion(pm, id, tipo, descripcion, sucursalId, cantidadProductos, productoCodigoBarras, fechaExpiracion);
			tx.commit();

			log.trace ("Inserción de la promocion: " + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Promocion((int)id, tipo, descripcion, sucursalId, cantidadProductos, productoCodigoBarras, fechaExpiracion);
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que consulta todas las tuplas en la tabla Sucursal con un identificador dado
	 * @param idSucursal- El identificador de la Sucursal.
	 * @return El objeto Sucursal, construido con base en las tuplas de la tabla SUCURSAL con el identificador dado
	 */
	public Sucursal darSucursalPorId (int sucursalId)
	{
		return sqlSucursal.darSurcusalPorId(pmf.getPersistenceManager(), sucursalId);
	}

	/**
	 * Método que consulta todas las tuplas en la tabla ALMACENAMIENTO con un identificador dado
	 * @return El objeto Almacenamiento, construido con base en las tuplas de la tabla ALMACENAMIENTO con el identificador dado
	 */
	public Almacenamiento darAlmacenamientoPorId ( int idSucursal, int productoCodigoBarras )
	{
		return sqlAlmacenamiento.darAlmacenamientoPorId(pmf.getPersistenceManager(), idSucursal, productoCodigoBarras);
	}

	/* ****************************************************************
	 * 			Métodos para el RF8
	 *****************************************************************/
	public Promocion darPromocionPorId(int id)
	{
		return sqlPromocion.darPromocionPorId(pmf.getPersistenceManager(), id);
	}

	public List<Promocion> darPromociones()
	{
		return sqlPromocion.darPromociones(pmf.getPersistenceManager());
	}

	public long eliminarPromocionPorId(int id)
	{
		return sqlPromocion.eliminarPromocion(pmf.getPersistenceManager(), id);
	}

	/* ****************************************************************
	 * 			Métodos para el RF9
	 *****************************************************************/

	public Pedido registrarPedido(int idSucursal, int idProveedor, int idProducto, int cantidad, boolean completo, int costo, Date fechaEntrega, int calificacionCalidad, String presentacion )
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();            
			long idPedido = nextval ();
			int id = (int)idPedido;
			long tuplasInsertadas = sqlPedido.registrarPedido(pm, id, idSucursal, idProveedor, idProducto, cantidad, completo, costo, fechaEntrega, calificacionCalidad, presentacion);
			tx.commit();

			log.trace ("Inserción pedido: " + tuplasInsertadas + " tuplas insertadas");
			return new Pedido(id, idSucursal, idProveedor , idProducto,cantidad, completo, costo, fechaEntrega, calificacionCalidad , presentacion);
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Medoto que retorna un ProveedorSucursal
	 * @param idSucursal
	 * @param idProveedor
	 * @return null si no encuentra la tupla.
	 */
	public ProveedorSucursal darProveedorSucursal(int idSucursal, int idProveedor)
	{
		return sqlProveedorSucursal.darProveedorSucursalPorId(pmf.getPersistenceManager(), idSucursal, idProveedor);
	}
	
	/**
	 * Metodo que retorna un producto por su id
	 * @param idProducto
	 * @return el producto o null si no lo encuentra
	 */
	public Producto darProductoPorId(int idProducto)
	{
		return sqlProducto.darProductoPorId(pmf.getPersistenceManager(), idProducto);
	}

	/* ****************************************************************
	 * 			Métodos para el RF10
	 *****************************************************************/
	/**
	 * Metodo que retorna el pedido por el id
	 * @param idPedido
	 * @return null si no lo encuentra
	 */
	public Pedido darPedidoPorId(int idPedido)
	{
		return sqlPedido.darPedidoPorId(pmf.getPersistenceManager(), idPedido);
	}
	
	public Almacenamiento actualizarAlmacenamiento(int cantidadUnidades, int idProducto, int idSucursal)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();            	
			Almacenamiento nuevo = sqlAlmacenamiento.darAlmacenamientoPorId(pmf.getPersistenceManager(), idSucursal, idProducto);
			nuevo.setUnidadesDisp(nuevo.getUnidadesDisp() + cantidadUnidades);
		    sqlAlmacenamiento.eliminarAlmacenamiento(pmf.getPersistenceManager(), idSucursal, idSucursal);
		    sqlAlmacenamiento.registrarAlmacenamiento(pmf.getPersistenceManager(), nuevo.getTipo(), nuevo.getVolumen(), nuevo.getPeso(), nuevo.getNivelAbastecimiento(), nuevo.getUnidadesDisp(), nuevo.getCategoriaId(), nuevo.getSucursalId(), nuevo.getProductoCodigoBarras());
			tx.commit();
			return nuevo;
		}
		catch (Exception e)
		{
	     	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
		
	}
}
