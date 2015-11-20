package Utils.HTMLWordCounter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import Exceptions.EndOfStreamException;
import Exceptions.ExceptionMessaging;
import Exceptions.SlidingWindowException;
import Exceptions.TransitionException;
import StateMachine.intfs.Transitionable;
import Utils.SlidingWindow;

public class HTMLWordCounter {
    
	private void slideStreamTill(BufferedInputStream bis,String str)throws SlidingWindowException{ 
	    SlidingWindow headerWindow = new SlidingWindow("</head>");
        do{
            try {
                headerWindow.slide(bis.read());
            }
            catch (IOException e1) {
                new SlidingWindowException(e1,ExceptionMessaging.SLIDING_WINDOW_EXCEPTION_ERROR);
            }
        }while(!headerWindow.found()); 
	}
	public int getWordCount(InputStream is) throws TransitionException, SlidingWindowException{
	    BufferedInputStream bis = new BufferedInputStream(is);
	    slideStreamTill(bis,"</head>");	      
		Transitionable currentState = new StartingState(bis);
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
