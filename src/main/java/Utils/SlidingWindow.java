package Utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SlidingWindow {
    private int target;
    private StringBuilder bldr;
    private int windowSize;
    public SlidingWindow(String str){
        windowSize = str.length();
        target = str.hashCode();
        bldr = new StringBuilder(str.length());
    }
    
    public void slide(int in){
        if(bldr.length() >= windowSize){
            bldr.deleteCharAt(0);           
        }
        bldr.appendCodePoint(in);
    }
    public boolean found(){
        return target == bldr.toString().hashCode();
    }
    public static void main(String[] args) throws IOException{
        
        SlidingWindow slider = new SlidingWindow("</head>");
        byte[]b = "<html><head><title>baa</title></head><body>afsdf</body>".getBytes();
        ByteArrayInputStream is = new ByteArrayInputStream(b);
        do{
           slider.slide(is.read()); 
        }while(!slider.found());
        int read = -1;
        while((read = is.read()) > 0){
            System.out.print((char)read);
        }
        System.out.println("");
        
    }
}
