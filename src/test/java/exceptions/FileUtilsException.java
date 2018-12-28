package exceptions;

/**
 * 
 * Name: {@link FileUtilsException}
 * 
 * Proposito: Exception
 * 
 * @author Leonardo Costa
 * 
 * @see RuntimeException
 * 
 * @version 1.0
 *
 */
public class FileUtilsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor
	 * @param msg
	 */
	public FileUtilsException(String msg) {
		super(msg);
	}
	
	/**
	 * Construtor
	 * @param e
	 */
	public FileUtilsException(Exception e) {
		super(e);
	}
	
	/**
	 * Construtor
	 * @param msg
	 * @param e
	 */
	public FileUtilsException(String msg, Exception e) {
		super(msg, e);
	}

}
