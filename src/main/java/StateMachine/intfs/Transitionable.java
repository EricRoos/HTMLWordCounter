package StateMachine.intfs;

import Exceptions.TransitionException;

public interface Transitionable {
	public Transitionable transition() throws TransitionException;
}
