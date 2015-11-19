package Exceptions;

public class TransitionException extends Throwable{


	public TransitionException(Throwable e,String msg) {
		super(msg,e);
	}

	public TransitionException(String msg) {
		super(msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -98447503186540726L;

}
