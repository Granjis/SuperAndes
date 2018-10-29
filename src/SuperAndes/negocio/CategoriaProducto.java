package SuperAndes.negocio;

public class CategoriaProducto implements VOCategoriaProducto
{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private int productoCodigoBarras;

	private int categoriaId;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/


	public int getCodigoBarras() 
	{
		return productoCodigoBarras;
	}


	public CategoriaProducto()
	{
		productoCodigoBarras = 0;
	    categoriaId = 0;
	}
	
	public CategoriaProducto(int productoCodigoBarras, int categoriaId) 
	{
		this.productoCodigoBarras = productoCodigoBarras;
		this.categoriaId = categoriaId;
	}


	public int getCategoriaId() 
	{
		return categoriaId;
	}


	public void setProductocodigoBarras(int productoCodigoBarras) 
	{
		this.productoCodigoBarras = productoCodigoBarras;
	}

	public void setCategoriaId(int categoriaId) 
	{
		this.categoriaId = categoriaId;
	}

	@Override
	public String toString() 
	{
		return "CategoriaProducto [ProductocodigoBarras=" + productoCodigoBarras + ", categoriaId=" + categoriaId + "]";
	}
}
