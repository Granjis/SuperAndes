package SuperAndes.negocio;

public class Cliente implements VOCliente
{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private int id;

	private int tipo;

	private String nombre;

	private String correo;

	private int puntos;

	private String direccion;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/


	public Cliente(int id, int tipo, String nombre, String correo, int puntos, String direccion) 
	{
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.correo = correo;
		this.puntos = puntos;
		this.direccion = direccion;
	}

	public Cliente ()
	{
		id = 0;
		tipo = 0;
		nombre = "";
		correo = "";
		puntos = 0;
		direccion = "";
	}
	public int getId() 
	{
		return id;
	}

	public int getTipo()
	{
		return tipo;
	}

	public String getNombre() 
	{
		return nombre;
	}


	public String getCorreo() 
	{
		return correo;
	}


	public int getPuntos() 
	{
		return puntos;
	}


	public String getDireccion() 
	{
		return direccion;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setTipo(int tipo) 
	{
		this.tipo = tipo;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public void setCorreo(String correo) 
	{
		this.correo = correo;
	}

	public void setPuntos(int puntos) 
	{
		this.puntos = puntos;
	}

	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", correo=" + correo + ", puntos="
				+ puntos + ", direccion=" + direccion + "]";
	}
}
