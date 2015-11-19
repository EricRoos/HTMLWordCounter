package Utils.HTMLWordCounter;

import java.io.BufferedInputStream;
import Exceptions.TransitionException;
import StateMachine.intfs.State;
import StateMachine.intfs.Transitionable;

public class TagState extends State {

	public TagState(BufferedInputStream rdr) {
		super(rdr);
	}

	public Transitionable transition() throws TransitionException {
		int ch = this.getNextChar();
		if(ch == '>'){
			return new StartingState(rdr);
		}else{
			return this;
		}
	}

}
