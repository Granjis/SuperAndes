package SuperAndes.negocio;

public class Producto implements VOProducto
{
   
	private int codigoBarras;
	
	private String nombre;
	
	private String marca;
	
	private int precioUnidad;
	
	private int precioMedidaU;
	
	private int cantidadPresentacion;
	
	private String unidad;
	
	private String especificacion;
	
	private int nivelReorden;
	
	private int cantidadRecompra;
	
	private String  presentacion;
	
	private int precioProveedor;

	
	public Producto(int codigoBarras, String nombre, String marca, int precioUnidad, int precioMedidaU,
			int cantidadPresentacion, String unidad, String especificacion, int nivelReorden, int cantidadRecompra,
			String presentacion, int precioProveedor) 
	{
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.marca = marca;
		this.precioUnidad = precioUnidad;
		this.precioMedidaU = precioMedidaU;
		this.cantidadPresentacion = cantidadPresentacion;
		this.unidad = unidad;
		this.especificacion = especificacion;
		this.nivelReorden = nivelReorden;
		this.cantidadRecompra = cantidadRecompra;
		this.presentacion = presentacion;
		this.precioProveedor = precioProveedor;
	}
	
	public Producto()
	{
		codigoBarras = 0;
		nombre="";
		marca="";
		precioMedidaU =0;
		precioUnidad=0;
		cantidadPresentacion=0;
		unidad="";
		especificacion="";
		nivelReorden=0;
		cantidadRecompra=0;
		presentacion ="";
		precioProveedor=0;
		
	}
	
	public int getCodigoBarras() 
	{
		return codigoBarras;
	}

	public void setCodigoBarras(int codigoBarras) 
	{
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getMarca() 
	{
		return marca;
	}

	public void setMarca(String marca) 
	{
		this.marca = marca;
	}

	public int getPrecioUnidad() 
	{
		return precioUnidad;
	}

	public void setPrecioUnidad(int precioUnidad)
	{
		this.precioUnidad = precioUnidad;
	}

	public int getPrecioMedidaU() 
	{
		return precioMedidaU;
	}

	public void setPrecioMedidaU(int precioMedidaU) 
	{
		this.precioMedidaU = precioMedidaU;
	}

	public int getCantidadPresentacion()
	{
		return cantidadPresentacion;
	}

	public void setCantidadPresentacion(int cantidadPresentacion) 
	{
		this.cantidadPresentacion = cantidadPresentacion;
	}

	public String getUnidad() 
	{
		return unidad;
	}

	public void setUnidad(String unidad)
	{
		this.unidad = unidad;
	}

	public String getEspecificacion() 
	{
		return especificacion;
	}

	public void setEspecificacion(String especificacion)
	{
		this.especificacion = especificacion;
	}

	public int getNivelReorden() 
	{
		return nivelReorden;
	}

	public void setNivelReorden(int nivelReorden)
	{
		this.nivelReorden = nivelReorden;
	}

	public int getCantidadRecompra() 
	{
		return cantidadRecompra;
	}

	public void setCantidadRecompra(int cantidadRecompra) 
	{
		this.cantidadRecompra = cantidadRecompra;
	}

	public String getPresentacion() 
	{
		return presentacion;
	}

	public void setPresentacion(String presentacion) 
	{
		this.presentacion = presentacion;
	}

	public int getPrecioProveedor() 
	{
		return precioProveedor;
	}

	public void setPrecioProveedor(int precioProveedor)
	{
		this.precioProveedor = precioProveedor;
	}
	@Override
	public String toString()
	{
		return "Producto [codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", marca=" + marca + ", precioUnidad="
				+ precioUnidad + ", precioMedidaU=" + precioMedidaU + ", cantidadPresentacion=" + cantidadPresentacion
				+ ", unidad=" + unidad + ", especificacion=" + especificacion + ", nivelReorden=" + nivelReorden
				+ ", cantidadRecompra=" + cantidadRecompra + ", presentacion=" + presentacion + ", precioProveedor="
				+ precioProveedor + "]";
	}
	
	

}
