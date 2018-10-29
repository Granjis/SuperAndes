package SuperAndes.persistencia;

import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import SuperAndes.negocio.Pedido;
import SuperAndes.negocio.Producto;

public class SQLPedido 
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
	public SQLPedido(PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}
	/**
	 * Metodo que devuelve el pedido por su id
	 */
	public Pedido darPedidoPorId (PersistenceManager pm, int idPedido) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPedido() + " WHERE idPedido = ?");
		q.setResultClass(Pedido.class);
		q.setParameters(idPedido);
		return (Pedido) q.executeUnique();
	}
	/**
	 * Metodo que registra un nuevo pedido 
	 */
	public long registrarPedido(PersistenceManager pm, int id, int idSucursal, int idProveedor , int idProducto, int cantidad, boolean completo, int costo, Date fechaEntrega, int calificacionCalidad , String presentacion)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPedido () + "(id, idSucursal, idProveedor, idProducto, cantidad, completo, costo, fechaEntrega, calificacionCalidad, presentacion) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		q.setParameters(id, idSucursal, idProveedor, idProducto, cantidad, completo, costo, fechaEntrega, calificacionCalidad, presentacion);
		return (long) q.executeUnique();            
	}
}
