package SuperAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


class SQLUtil
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaSuperAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLUtil (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}

	/**
	 * Crea y ejecuta la sentencia SQL para obtener un nuevo número de secuencia
	 * @param pm - El manejador de persistencia
	 * @return El número de secuencia generado
	 */
	public long nextval (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqSuperAndes () + ".nextval FROM DUAL");
		q.setResultClass(Long.class);
		long resp = (long) q.executeUnique();
		return resp;
	}

	/**
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @param pm - El manejador de persistencia
	 * @return Un arreglo con 13 números que indican el número de tuplas borradas en las tablas G
	 */
	public long [] limpiarParranderos (PersistenceManager pm)
	{
		Query qPromocion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPromocion ());          
		Query qVenta = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaVenta ());
		Query qFactura = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaFactura ());
		Query qPedido= pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPedido ());
		Query qAlmacenamiento = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAlmacenamiento ());
		Query qProveedorSucursal = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProveedorSucursal ());
		Query qClienteSucursal = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaClienteSucursal ());
		Query qCategoriaProducto = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCategoriaProducto ());
		Query qCategoria = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCategoria ());
		Query qProducto = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProducto ());
		Query qSucursal = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaSucursal ());
		Query qCliente = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCliente ());
		Query qProveedor = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProveedor());


		long promocionEliminados = (long) qPromocion.executeUnique ();
		long ventaEliminados = (long) qVenta.executeUnique ();
		long facturaEliminadas = (long) qFactura.executeUnique ();
		long pedidoEliminadas = (long) qPedido.executeUnique ();
		long almacenamientoEliminados = (long) qAlmacenamiento.executeUnique ();
		long proveedorSucursalEliminados = (long) qProveedorSucursal.executeUnique ();
		long clienteSucursalEliminados = (long) qClienteSucursal.executeUnique ();
		long categoriaProductoEliminados = (long) qCategoriaProducto.executeUnique ();
		long categoriaEliminados = (long) qCategoria.executeUnique ();
		long prodcutoEliminados = (long) qProducto.executeUnique ();
		long sucursalEliminados = (long) qSucursal.executeUnique ();
		long clienteEliminados = (long) qCliente.executeUnique ();
		long proveedorEliminados = (long) qProveedor.executeUnique ();

		return new long[] {promocionEliminados, ventaEliminados, facturaEliminadas, pedidoEliminadas, 
				almacenamientoEliminados, proveedorSucursalEliminados, clienteSucursalEliminados, categoriaProductoEliminados
				,categoriaEliminados, prodcutoEliminados, sucursalEliminados, clienteEliminados, proveedorEliminados};
	}

}

