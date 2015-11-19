package Utils.HTMLWordCounter;

import java.io.BufferedInputStream;
import java.io.InputStream;
import Exceptions.TransitionException;
import StateMachine.intfs.State;
import StateMachine.intfs.Transitionable;

public class StartingState extends State{

	public StartingState(InputStream is) {
		super(is);
	}

	public StartingState(BufferedInputStream rdr) {
		super(rdr);
	}
	public Transitionable transition() throws TransitionException {
		int ch = this.getNextChar();
		
		if(ch == '<'){
			return new TagState(rdr);
		}else if(Character.isWhitespace(ch)){
			return this;
		}else{
			return new CharacterState(rdr);
		}

	}

}
