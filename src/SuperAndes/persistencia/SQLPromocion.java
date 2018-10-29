package SuperAndes.persistencia;


import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import SuperAndes.negocio.Promocion;



class SQLPromocion
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
	public SQLPromocion(PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}

	public long adicionarPromocion(PersistenceManager pm, long id, int tipo, String descripcion, int sucursalId, int cantidadProductos, int productoCodigoBarras, Date fechaExpiracion) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPromocion()  + "(id, sucursalId, tipo, descripcion, cantidadProductos, productoCodigoBarras, fechaExpiracion)"
				+ " values (?, ?, ?, ?, ?, ?, ?)");
		q.setParameters(id, sucursalId, tipo, descripcion, cantidadProductos, productoCodigoBarras, fechaExpiracion);
		return (long) q.executeUnique();
	}

	public Promocion darPromocionPorId (PersistenceManager pm, int id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPromocion() + " WHERE id = ?");
		q.setResultClass(Promocion.class);
		q.setParameters(id);
		return (Promocion) q.executeUnique();
	}

	public List<Promocion> darPromociones(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPromocion());
		q.setResultClass(Promocion.class);
		return(List<Promocion>)q.executeList();
	}

	public long eliminarPromocion(PersistenceManager pm, int id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPromocion() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();

	}
}
