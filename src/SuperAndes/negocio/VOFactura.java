package SuperAndes.negocio;

public interface VOFactura 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id de la Factura.
	 */
	public int getId();
	
	public String getNombre();
	
	public String getCorreo();
	
	public int getPuntosTotales();
	
	public int getCLienteId();
}
