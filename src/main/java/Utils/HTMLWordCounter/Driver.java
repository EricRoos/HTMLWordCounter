package Utils.HTMLWordCounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import Exceptions.TransitionException;

public class Driver {

	public static void main(String[] args) throws TransitionException, IOException {
		FileInputStream is = new FileInputStream(new File("/Users/ericroos/Desktop/words.txt"));
		HTMLWordCounter counter = new HTMLWordCounter();
		

		long startTime = System.nanoTime();
		int wc = counter.getWordCount(is);
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		System.out.println(wc);
		is.close();
	}

}
