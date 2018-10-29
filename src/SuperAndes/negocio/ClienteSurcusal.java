package SuperAndes.negocio;

public class ClienteSurcusal implements VOClienteSucursal
{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	private int clienteId;

	private int surcusalId;


	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/


	public ClienteSurcusal(int clienteId, int surcusalId) 
	{
		this.clienteId = clienteId;
		this.surcusalId = surcusalId;
	}


	public int getClienteId()
	{
		return clienteId;
	}


	public int getSucursalId() 
	{
		return surcusalId;
	}

	public void setSurcusalId(int surcusalId) 
	{
		this.surcusalId = surcusalId;
	}


	public void setClienteId(int clienteId) 
	{
		this.clienteId = clienteId;
	}


	@Override
	public String toString() {
		return "ClienteSurcusal [clienteId=" + clienteId + ", surcusalId=" + surcusalId + "]";
	}
}
