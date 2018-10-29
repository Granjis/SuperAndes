package SuperAndes.negocio;


import java.util.Date;

public class Promocion implements VOPromocion
{

	private int id;

	private int tipo;

	private String descripcion;

	private int sucursalId;
	
	private int cantidadProductos;
	
	private int productoCodigoBarras;
	
	private Date fechaExpiracion;

	public Promocion()
	{
		id=0;
		tipo= 0 ;
		descripcion ="";
		sucursalId = 0 ;
		cantidadProductos = 0;
		fechaExpiracion = null;
		productoCodigoBarras= 0;

	}
	
	


	public Promocion(int id, int tipo, String descripcion, int sucursalId, int cantidadProductos,
			int productoCodigoBarras, Date fechaExpiracion)
	{
		
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.sucursalId = sucursalId;
		this.cantidadProductos = cantidadProductos;
		this.productoCodigoBarras = productoCodigoBarras;
		this.fechaExpiracion = fechaExpiracion;
	}




	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public int getTipo() 
	{
		return tipo;
	}

	public void setTipo(int tipo) 
	{
		this.tipo = tipo;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}

	public int getSucursalId()
	{
		return sucursalId;
	}

	public void setSucursalId(int sucursalId) 
	{
		this.sucursalId = sucursalId;
	}

	
	public int getCantidadProductos()
	{
		return cantidadProductos;
	}

	public void setCantidadProductos(int cantidadProductos) 
	{
		this.cantidadProductos = cantidadProductos;
	}

	public int getProductoCodigoBarras()
	{
		return productoCodigoBarras;
	}

	public void setProductoCodigoBarras(int productoCodigoBarras)
	{
		this.productoCodigoBarras = productoCodigoBarras;
	}

	public Date getFechaExpiracion() 
	{
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) 
	{
		this.fechaExpiracion = fechaExpiracion;
	}

	@Override
	public String toString() 
	{
		return "Promocion [id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + ", sucursalId=" + sucursalId
				+ "]";
	}



}
