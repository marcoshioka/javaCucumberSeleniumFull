package exceptions;

/**
 * 
 * Name: {@link BasicActionsException}
 * 
 * Propósito: Exception
 * 
 * @author Leonardo Costa
 * 
 * @version 1.0
 *
 */
public class BasicActionsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor
	 * @param msg
	 */
	public BasicActionsException(String msg) {
		super(msg);
	}
	
	/**
	 * Construtor
	 * @param e
	 */
	public BasicActionsException(Exception e) {
		super(e);
	}
	
	/**
	 * Construtor
	 * @param msg
	 * @param e
	 */
	public BasicActionsException(String msg, Exception e) {
		super(msg, e);
	}

}
