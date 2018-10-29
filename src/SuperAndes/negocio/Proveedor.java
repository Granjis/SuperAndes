package SuperAndes.negocio;

public class Proveedor implements VOProveedor 
{

	private int NIT;

	private String nombre;

	private String tpoProdc;

	private int calificacion;

	public Proveedor()
	{
		NIT = 0;
		nombre="";
		tpoProdc="";
		calificacion=0;
	}

	public Proveedor(int nIT, String nombre, String tpoProdc, int calificacion) 
	{
		super();
		NIT = nIT;
		this.nombre = nombre;
		this.tpoProdc = tpoProdc;
		this.calificacion = calificacion;
	}

	public int getNIT() 
	{
		return NIT;
	}

	public void setNIT(int nIT)
	{
		NIT = nIT;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;

	}

	public String getTpoProdc()
	{
		return tpoProdc;
	}

	public void setTpoProdc(String tpoProdc) 
	{
		this.tpoProdc = tpoProdc;
	}

	public int getCalificacion() 
	{
		return calificacion;
	}

	public void setCalificacion(int calificacion) 
	{
		this.calificacion = calificacion;
	}

	@Override
	public String toString() 
	{
		return "Proveedor [NIT=" + NIT + ", nombre=" + nombre + ", tpoProdc=" + tpoProdc + ", calificacion="
				+ calificacion + "]";
	}


}
