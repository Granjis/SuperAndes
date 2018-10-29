package SuperAndes.negocio;

import java.sql.Date;

public class Categoria implements VOCategoria
{

	

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private int id;
	
    private int tipo;
    
    private Date fechaVencimiento;
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	
    public Categoria()
    {
    	this.id = 0;
    	this.tipo = 0;
    	this.fechaVencimiento = null;
    }
    
    public Categoria(int id, int tipo, Date fechaVencimiento)
    {
    	this.id = id;
    	this.tipo = tipo;
    	this.fechaVencimiento = fechaVencimiento;
    }
	public int getId() 
	{
		return id;
	}

	
	public int getTipo()
	{
	    return tipo;
	}

	
	public Date getFechaVenc() 
	{
	    return fechaVencimiento;
	}
	
	public void setFechaVencimiento(Date fechaVencimiento)
	{
		this.fechaVencimiento = fechaVencimiento;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setTipo(int tipo) 
	{
		this.tipo = tipo;
	}
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Categoria [id=" + id + ", tipo =" + tipo + ", fechaVencimiento =" + fechaVencimiento + "]";
	}
}
