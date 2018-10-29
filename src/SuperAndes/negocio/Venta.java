package SuperAndes.negocio;

public class Venta implements VOVenta
{

	private int productoCodigoBarras;
	
	private int sucursalId;
	
	private int facturaId;
	
	private int promocionId;

	public Venta()
	{
		productoCodigoBarras =0;
		sucursalId=0;
		facturaId=0;
		promocionId=0;
	}
	
	public Venta(int productoCodigoBarras, int sucursalId, int facturaId, int promocionId) 
	{
		super();
		this.productoCodigoBarras = productoCodigoBarras;
		this.sucursalId = sucursalId;
		this.facturaId = facturaId;
		this.promocionId = promocionId;
	}

	public int getProductoCodigoBarras() 
	{
		return productoCodigoBarras;
	}

	public void setProductoCodigoBarras(int productoCodigoBarras)
	{
		this.productoCodigoBarras = productoCodigoBarras;
	}

	public int getSucursalId() 
	{
		return sucursalId;
	}

	public void setSucursalId(int sucursalId)
	{
		this.sucursalId = sucursalId;
	}

	public int getFacturaId()
	{
		return facturaId;
	}

	public void setFacturaId(int facturaId) 
	{
		this.facturaId = facturaId;
	}

	public int getPromocionId()
	{
		return promocionId;
	}

	public void setPromocionId(int promocionId)
	{
		this.promocionId = promocionId;
	}

	@Override
	public String toString() 
	{
		return "Venta [productoCodigoBarras=" + productoCodigoBarras + ", sucursalId=" + sucursalId + ", facturaId="
				+ facturaId + ", promocionId=" + promocionId + "]";
	}
	
	
	
	
	
	
}
