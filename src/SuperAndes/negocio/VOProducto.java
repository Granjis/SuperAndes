package SuperAndes.negocio;

public interface VOProducto
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El codigo de barras del Producto.
	 */
	public int getCodigoBarras();
	
	public String getNombre();
	
	public String getMarca();
	
	public int getPrecioUnidad();
	
	public int getPrecioMedidaU();
	
	public int getCantidadPresentacion();
	
	public String getUnidad();
	
	public String getEspecificacion();
	
	public int getNivelReorden();
	
	public int getCantidadRecompra();
	
	public String getPresentacion();
	
	public int getPrecioProveedor();
	
}
