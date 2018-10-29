package SuperAndes.negocio;

import java.util.Date;

public class Pedido implements VOPedido
{

	private int id;

	private int idSucursal;
	
	private int idProveedor;
	
	private int idProducto;

	private int cantidad;

	private boolean completo;

	private int costo;

	private Date fechaEntrega;

	private int calificacionCalidad;

	private String presentacion;

	public Pedido(int id, int idSucursal, int idProveedor, int idProducto, int cantidad, boolean completo, int costo,
			Date fechaEntrega, int calificacionCalidad, String presentacion) {
		this.id = id;
		this.idSucursal = idSucursal;
		this.idProveedor = idProveedor;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.completo = completo;
		this.costo = costo;
		this.fechaEntrega = fechaEntrega;
		this.calificacionCalidad = calificacionCalidad;
		this.presentacion = presentacion;
	}


	public Pedido()
	{
		id = 0;
		cantidad = 0;
		completo = false;
		costo = 0;
		fechaEntrega = null;
		calificacionCalidad = 0;
		presentacion="";
		idProducto=0;
		idSucursal=0;
		idProveedor=0;
	}


	public int getProductoCodigoBarras() 
	{
		return idProducto;
	}

	public void setProductoCodigoBarras(int productoCodigoBarras) 
	{
		this.idProducto = productoCodigoBarras;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setCantidad(int cantidad) 
	{
		this.cantidad = cantidad;
	}

	public void setCompleto(boolean completo) 
	{
		this.completo = completo;
	}

	public void setCosto(int costo)
	{
		this.costo = costo;
	}

	public void setFechaEntrega(Date fechaEntrega)
	{
		this.fechaEntrega = fechaEntrega;
	}

	public void setCalificacionCalidad(int calificacionCalidad) 
	{
		this.calificacionCalidad = calificacionCalidad;
	}

	public void setPresentacion(String presentacion)
	{
		this.presentacion = presentacion;
	}

	public void setSucursalId(int sucursalId) 
	{
		this.idSucursal = sucursalId;
	}

	public void setProveedorNIT(int proveedorNIT) 
	{
		this.idProveedor = proveedorNIT;
	}

	public int getId() 
	{
		return id;
	}


	public int getCantidad() 
	{
		return cantidad;
	}


	public boolean getCompleto() 
	{
		return completo;
	}

	public int getCosto()
	{
		return costo;
	}


	public Date getFechaEntrega() 
	{
		return fechaEntrega;
	}


	public int getCalificacionCalidad() 
	{
		return calificacionCalidad;
	}


	public String getPresentacion()
	{
		return presentacion;
	}


	public int getCodigoBarras()
	{
		return idProducto;
	}


	public int getSucursalId()
	{
		return idSucursal;
	}


	public int getProveedorNIT() 
	{
		return idProveedor;
	}


	@Override
	public String toString()
	{
		return "Pedido [id=" + id + ", idSucursal=" + idSucursal + ", idProveedor=" + idProveedor + ", idProducto="
				+ idProducto + ", cantidad=" + cantidad + ", completo=" + completo + ", costo=" + costo
				+ ", fechaEntrega=" + fechaEntrega + ", calificacionCalidad=" + calificacionCalidad + ", presentacion="
				+ presentacion + "]";
	}

	

}
