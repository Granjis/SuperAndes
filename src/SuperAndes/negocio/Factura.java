package SuperAndes.negocio;

public class Factura implements VOFactura
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private int id;

	private String nombre;

	private String correo;

	private int puntosTotales;

	private int clienteId;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	public Factura()
	{
		id = 0;
		nombre= "";
		correo = "";
		puntosTotales = 0;
		clienteId = 0;
	}

	public Factura(int id, String nombre, String correo, int puntosTotales, int clienteId)
	{
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.puntosTotales = puntosTotales;
		this.clienteId = clienteId;
	}


	public void setClienteId(int clienteId) 
	{
		this.clienteId = clienteId;
	}


	public void setId(int id) 
	{
		this.id = id;
	}


	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}


	public void setCorreo(String correo)
	{
		this.correo = correo;
	}


	public void setPuntosTotales(int puntosTotales)
	{
		this.puntosTotales = puntosTotales;
	}

	public int getId()
	{
		return id;
	}


	public String getNombre()
	{
		return nombre;
	}


	public String getCorreo()
	{
		return correo;
	}


	public int getPuntosTotales() 
	{
		return puntosTotales;
	}


	public int getCLienteId() 
	{
		return clienteId;
	}

	@Override
	public String toString() 
	{
		return "Factura [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", puntosTotales=" + puntosTotales
				+ ", clienteId=" + clienteId + "]";
	}

}
