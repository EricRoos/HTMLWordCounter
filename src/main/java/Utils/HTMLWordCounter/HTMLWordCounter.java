package Utils.HTMLWordCounter;

import java.io.InputStream;

import Exceptions.EndOfStreamException;
import Exceptions.TransitionException;
import StateMachine.intfs.Transitionable;

public class HTMLWordCounter {
	
	public int getWordCount(InputStream is) throws TransitionException{
		Transitionable currentState = new StartingState(is);
		EndOfStreamException e = null;
		int wordCount = 0;
		while( e == null){
			try {
				currentState = currentState.transition();
				if(currentState instanceof WordDetectedState ){
					wordCount++;
				}
				if(currentState instanceof WordDetectedStateSecondary ){
					wordCount++;
				}
			} catch(EndOfStreamException ex){
				e = ex;
			}
		}
		return wordCount;
	}

}
