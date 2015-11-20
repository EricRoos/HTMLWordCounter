package Utils.HTMLWordCounter;

import java.io.BufferedInputStream;
import Exceptions.TransitionException;
import StateMachine.intfs.State;
import StateMachine.intfs.Transitionable;

public class WordDetectedState extends State {

	public WordDetectedState(BufferedInputStream rdr) {
		super(rdr);
	}

	public Transitionable transition() throws TransitionException {
		int ch = this.getNextChar();
		if(ch == '<'){
			return new TagState(rdr);
		}
		if(ch == ' '){
			return new MultiSpaceState(rdr);
		}
		return new CharacterState(rdr);
	}

}
