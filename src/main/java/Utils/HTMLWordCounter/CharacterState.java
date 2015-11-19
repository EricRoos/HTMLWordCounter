package Utils.HTMLWordCounter;

import java.io.BufferedInputStream;
import Exceptions.TransitionException;
import StateMachine.intfs.Transitionable;

public class CharacterState extends StateMachine.intfs.State {

	public CharacterState(BufferedInputStream rdr) {
		super(rdr);
	}

	public Transitionable transition() throws TransitionException {
		int ch = this.getNextChar();
		if(Character.isWhitespace(ch)){
			return new WordDetectedState(rdr);
		}else if(ch == '<'){
			return new WordDetectedStateSecondary(rdr);
		}else{
			return this;
		}
	}

}
