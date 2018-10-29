package SuperAndes.negocio;

public class ProveedorSucursal implements VOProveedorSurcusal
{

	private int idProveedor;
	
	private int idSucursal;

	public ProveedorSucursal()
	{
		idProveedor = 0;
		idSucursal =0;
	}
	
	

	public ProveedorSucursal(int idProveedor, int idSucursal) {
		super();
		this.idProveedor = idProveedor;
		this.idSucursal = idSucursal;
	}



	public int getProveedorNIT()
	{
		return idProveedor;
	}

	public void setProveedorNIT(int proveedorNIT) 
	{
		this.idProveedor = proveedorNIT;
	}

	public int getSucursalId()
	{
		return idSucursal;
	}

	public void setSucursalId(int sucursalId) 
	{
		this.idSucursal = sucursalId;
	}

	@Override
	public String toString()
	{
		return "ProveedorSucursal [proveedorNIT=" + idProveedor + ", sucursalId=" + idSucursal + "]";
	}
	
	

}
