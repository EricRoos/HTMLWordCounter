package Utils.HTMLWordCounter;

import java.io.BufferedInputStream;
import Exceptions.TransitionException;
import StateMachine.intfs.State;
import StateMachine.intfs.Transitionable;

public class WordDetectedStateSecondary extends State {

	public WordDetectedStateSecondary(BufferedInputStream rdr) {
		super(rdr);
	}

	public Transitionable transition() throws TransitionException {
		int ch = this.getNextChar();
		if(ch == '>'){
			return new StartingState(rdr);
		}else{
			return new TagState(rdr);
		}
	}

}
