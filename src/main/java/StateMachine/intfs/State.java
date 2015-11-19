package StateMachine.intfs;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import Exceptions.EndOfStreamException;
import Exceptions.ExceptionMessaging;
import Exceptions.TransitionException;

public abstract class State implements Transitionable{
	protected BufferedInputStream rdr;	
	
	public State(InputStream is){
		rdr = new BufferedInputStream(is);
	}
	
	public State(BufferedInputStream rdr){
		this.rdr = rdr;
	}
	/**
	 * 
	 * Gets the next character from the input source
	 * 
	 * @return the integer representation of the next character used to transition
	 * @throws TransitionException if the stream can't be read from
	 * @throws EndOfStreamException when there is nothing left to read
	 */
	protected int getNextChar() throws TransitionException, EndOfStreamException{
		try {
			int read = rdr.read();
			if(read == -1){
				throw new EndOfStreamException(ExceptionMessaging.END_OF_STREAM_ERROR);
			}
			return read;
		} catch (IOException e) {
			throw new TransitionException(e,ExceptionMessaging.TRANSITION_IO_ERROR);
		}
	}
}
