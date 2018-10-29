package SuperAndes.negocio;

import java.sql.Date;

public interface VOCategoria
{

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id de la Categoria.
	 */
	public int getId();
	
	public int  getTipo();
	
	public Date getFechaVenc();

}
