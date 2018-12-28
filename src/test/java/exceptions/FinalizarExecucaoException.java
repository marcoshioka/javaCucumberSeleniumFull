package exceptions;

/**
 * 
 * Name: {@link FinalizarExecucaoException}
 * 
 * Propósito: Exception
 * 
 * @author Leonardo Costa
 * 
 * @version 1.0
 *
 */
public class FinalizarExecucaoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor
	 * @param msg
	 */
	public FinalizarExecucaoException(String msg) {
		super(msg);
	}
	
	/**
	 * Construtor
	 * @param e
	 */
	public FinalizarExecucaoException(Exception e) {
		super(e);
	}
	
	/**
	 * Construtor
	 * @param msg
	 * @param e
	 */
	public FinalizarExecucaoException(String msg, Exception e) {
		super(msg, e);
	}

}
