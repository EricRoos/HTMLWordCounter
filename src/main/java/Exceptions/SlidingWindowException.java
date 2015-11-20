package Exceptions;

public class SlidingWindowException extends Throwable{


	public SlidingWindowException(Throwable e,String msg) {
		super(msg,e);
	}

	public SlidingWindowException(String msg) {
		super(msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -98447503186540726L;

}
