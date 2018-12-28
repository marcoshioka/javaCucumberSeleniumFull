package exceptions;

/**
 * 
 * Name: {@link EvidenciaException}
 * 
 * Propósito: Exception
 * 
 * @author Leonardo Costa
 * 
 * @see RuntimeException
 * 
 * @version 1.0
 *
 */
public class EvidenciaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor
	 * @param msg
	 */
	public EvidenciaException(String msg) {
		super(msg);
	}
	
	/**
	 * Construtor
	 * @param e
	 */
	public EvidenciaException(Exception e) {
		super(e);
	}
	
	/**
	 * Construtor
	 * @param msg
	 * @param e
	 */
	public EvidenciaException(String msg, Exception e) {
		super(msg, e);
	}

}
