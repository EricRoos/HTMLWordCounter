package Exceptions;

public class EndOfStreamException extends TransitionException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3845789854569498252L;

	public EndOfStreamException(Throwable e, String msg) {
		super(e, msg);
	}

	public EndOfStreamException(String msg) {
		super(msg);
	}

}
