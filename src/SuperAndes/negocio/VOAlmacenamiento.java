package SuperAndes.negocio;

/**
 * Interfaz para los métodos get de Almacenamiento.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * @author ja.penat
 */
public interface VOAlmacenamiento 
{

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id del Almacenamiento.
	 */


	public int getTipo();

	public int getVolumen();

	public int getPeso();

	public int  getNivelAbastecimiento();

	public int getUnidadesDisp();
	
	public int getCategoriaId();
	
	public int getSucursalId();
	

}
