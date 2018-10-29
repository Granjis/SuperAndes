package SuperAndes.negocio;


import java.util.Date;

public interface VOPedido 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id del Pedido.
	 */
	public int getId();

	public int getCantidad();

	public boolean getCompleto();

	public int getCosto();

	public Date getFechaEntrega();

	public int getCalificacionCalidad();

	public String getPresentacion();
	
	public int getCodigoBarras();
	
	public int getSucursalId();
	
	public int getProveedorNIT();


}
