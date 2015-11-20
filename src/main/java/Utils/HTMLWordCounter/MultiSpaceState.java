package Utils.HTMLWordCounter;

import java.io.BufferedInputStream;

import Exceptions.TransitionException;
import StateMachine.intfs.State;
import StateMachine.intfs.Transitionable;

public class MultiSpaceState extends State{

    public MultiSpaceState(BufferedInputStream rdr) {
        super(rdr);
    }

    public Transitionable transition() throws TransitionException {
        int ch = this.getNextChar();
        if(ch == '<'){
            return new TagState(rdr);
        }
        if(ch == ' '){
            return this;
        }
        return new CharacterState(rdr);
    }
}
