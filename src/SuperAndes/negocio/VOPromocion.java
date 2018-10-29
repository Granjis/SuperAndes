package SuperAndes.negocio;


import java.util.Date;

public interface VOPromocion
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id de la Promocion.
	 */
	public int getId();

	public int getTipo();

	public String getDescripcion();
	
	public int getSucursalId();
	
	public  int getCantidadProductos();
	
	public Date getFechaExpiracion();
	
	public int getProductoCodigoBarras();
	


}
