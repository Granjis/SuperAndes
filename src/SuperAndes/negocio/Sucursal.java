package SuperAndes.negocio;

public class Sucursal implements VOSurcusal
{

	private int id;

	private String compania;

	private String ciudad;
	
	private String tamano;

	private String direccion;

	

	public Sucursal()
	{
		id=0;
		compania="";
		ciudad="";
		tamano="";
		direccion="";
		

	}

	public Sucursal(int id, String compania, String tamano, String ciudad, String direccion, String nombre)
	{
		super();
		this.id = id;
		this.compania = compania;
		this.ciudad = ciudad;
		this.tamano = tamano;
		this.direccion = direccion;
	
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getCompania() 
	{
		return compania;
	}

	public void setCompania(String compania) 
	{
		this.compania = compania;
	}

	public String getTamano() 
	{
		return tamano;
	}

	public void setTamano(String tamano) 
	{
		this.tamano = tamano;
	}

	public String getCiudad()
	{
		return ciudad;
	}

	public void setCiudad(String ciudad) 
	{
		this.ciudad = ciudad;
	}

	public String getDireccion()
	{
		return direccion;
	}

	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}


	@Override
	public String toString() 
	{
		return "Sucursal [id=" + id + ", compania=" + compania + ", tamano=" + tamano + ", ciudad=" + ciudad
				+ ", direccion=" + direccion + "]";
	}


}
