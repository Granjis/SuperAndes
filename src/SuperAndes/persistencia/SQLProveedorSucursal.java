package SuperAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import SuperAndes.negocio.ProveedorSucursal;


class SQLProveedorSucursal
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
	public SQLProveedorSucursal(PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Da la sucursales con sus proveedores
	 */
	public ProveedorSucursal darProveedorSucursalPorId (PersistenceManager pm, int idSucursal, int idProveedor) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProveedorSucursal() + " WHERE idSucursal = ? AND  idProveedor = ?");
		q.setResultClass(ProveedorSucursal.class);
		q.setParameters(idSucursal, idProveedor);
		return (ProveedorSucursal) q.executeUnique();
	}
}
