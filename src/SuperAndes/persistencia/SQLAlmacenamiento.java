package SuperAndes.persistencia;

import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import SuperAndes.negocio.Almacenamiento;
import SuperAndes.negocio.Sucursal;



/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Almacenamiento de SuperAndes
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * @author ja.penat
 */
class SQLAlmacenamiento
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
	public SQLAlmacenamiento (PersistenciaSuperAndes pp)
	{
		this.pp = pp;
	}
	/**
	 * Metodo que retorna el almacenamiento de un producto por su sucursal 
	 * @param pm
	 * @param idSucursal
	 * @param productoCodigoBarras
	 * @return null si no lo encuentra
	 */
	public Almacenamiento darAlmacenamientoPorId (PersistenceManager pm,  int idSucursal, int productoCodigoBarras) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaSucursal() + " WHERE idSucursal = ? AND productoCodigoBarras = ?");
		q.setResultClass(Almacenamiento.class);
		q.setParameters( idSucursal, productoCodigoBarras);
		return (Almacenamiento) q.executeUnique();
	}
	
	/**
	 * Metodo que registra un almacenamiento
	 * @param pm
	 * @param tipo
	 * @param volumen
	 * @param peso
	 * @param nivelAbastecimiento
	 * @param unidadesDisponibles
	 * @param categoriaId
	 * @param idSucursal
	 * @param productoCodigoBarras
	 * @return
	 */
	public long registrarAlmacenamiento(PersistenceManager pm,int tipo, int volumen, int peso, int nivelAbastecimiento, int unidadesDisponibles,
			int categoriaId, int idSucursal, int productoCodigoBarras) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAlmacenamiento () + "(idSucursal, tipo, volumen, peso, nivelAbastecimiento, unidadesDisponible, idCategoria, productoCodigoBarras) values (?, ?, ?, ?, ?, ?, ?, ?)");
		q.setParameters(idSucursal, tipo, volumen, peso, nivelAbastecimiento, unidadesDisponibles, categoriaId, productoCodigoBarras);
		return (long) q.executeUnique();            
	}
	
	public long eliminarAlmacenamiento(PersistenceManager pm, int idSucursal, int productoCodigoBarras)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAlmacenamiento() + " WHERE idSucursal = ? AND productoCodigoBarras = ?");
		q.setParameters(idSucursal,  productoCodigoBarras);
		return (long) q.executeUnique();

	}

}
