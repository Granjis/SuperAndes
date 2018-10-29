package SuperAndes.negocio;

/**
 * Clase para modelar el concepto  ALMACENAMIENTO del negocio de SuperAndes
 * @author ja.penat
 */
public class Almacenamiento implements VOAlmacenamiento
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	

	private int tipo;

	private int volumen;

	private int peso;

	private int nivelAbastecimiento;

	private int unidadesDisp;

	private int idCategoria;

	private int idSucursal;
	
	private int idProducto;
	
	

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/


	public Almacenamiento()
	{
		
		this.tipo = 0  ;
		this.volumen = 0;
		this.peso = 0;
		this.nivelAbastecimiento = 0;
		this.unidadesDisp = 0;
		this.idCategoria = 0;
		this.idSucursal = 0;
		this.idProducto = 0;
	}
	


	public Almacenamiento( int tipo, int volumen, int peso, int nivelAbastecimiento, int unidadesDisp,
			int categoriaId, int sucursalId, int productoCodigoBarras) 
	{
	
		this.tipo = tipo;
		this.volumen = volumen;
		this.peso = peso;
		this.nivelAbastecimiento = nivelAbastecimiento;
		this.unidadesDisp = unidadesDisp;
		this.idCategoria = categoriaId;
		this.idSucursal = sucursalId;
		this.idProducto = productoCodigoBarras;
	}



	public int getProductoCodigoBarras() 
	{
		return idProducto;
	}



	public void setProductoCodigoBarras(int productoCodigoBarras) 
	{
		this.idProducto = productoCodigoBarras;
	}



	

	public int getTipo()
	{
		return tipo;
	}


	public int getVolumen() 
	{	
		return volumen;
	}


	public int getPeso() 
	{
		return peso;
	}

	public int getNivelAbastecimiento() 
	{
		return nivelAbastecimiento;
	}


	public int getUnidadesDisp()
	{
		return unidadesDisp;
	}

	public int getCategoriaId() 
	{
		return idCategoria;
	}


	public int getSucursalId() 
	{
		return idSucursal;
	}


	


	public void setTipo(int tipo)
	{
		this.tipo = tipo;
	}


	public void setVolumen(int volumen)
	{
		this.volumen = volumen;
	}


	public void setPeso(int peso) 
	{
		this.peso = peso;
	}


	public void setNivelAbastecimiento(int nivelAbastecimiento) 
	{
		this.nivelAbastecimiento = nivelAbastecimiento;
	}


	public void setUnidadesDisp(int unidadesDisp) 
	{
		this.unidadesDisp = unidadesDisp;
	}


	public void setCategoriaId(int categoriaId)
	{
		this.idCategoria = categoriaId;
	}


	public void setSucursalId(int sucursalId) 
	{
		this.idSucursal = sucursalId;
	}

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del Almacenamieto
	 */
	public String toString() 
	{
		return "Almacenamiento [ tipo =" + tipo + ", volumen =" + volumen+ ", peso =" + peso
				+ ", nivel de Abastecimiento=" + nivelAbastecimiento + ", unidades disponibles =" +"]";
	}
}
