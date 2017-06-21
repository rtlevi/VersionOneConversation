/**
 * Grace Tshihata
 * */

package com.davita.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicLong;

import org.w3c.dom.css.Counter;

public class CSV {
	private static final AtomicLong counter = new AtomicLong();
	
	static long countMe;
	
    public static AtomicLong getCounter() {
		return counter;
	}

	public static void main(String[]args) throws FileNotFoundException{
     WriteToCsv("B-122", "comment");
    	
    }
    
    public static void WriteToCsv(String id, String comment ) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File("Production_V1ToJira.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(',');
        sb.append(comment);
        sb.append(',');
        sb.append("");
        sb.append('\n');
       
    
        pw.write(sb.toString());
        pw.close();
        setCountMe(counter.incrementAndGet());
        System.out.println(getCountMe() +" added! ");
    }

	public static long getCountMe() {
		return countMe;
	}

	public static void setCountMe(long l) {
	     countMe = l;
	}
}
