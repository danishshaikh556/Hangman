/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */
import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.ArrayList;

public class HangmanLexicon {
  
	public void addingwordsfromfile(){
	
	try {
		BufferedReader reader =new BufferedReader(new FileReader("HangmanLexicon.txt"));
	    while ((reader.readLine()) != null) {
	        arrey.add(reader.readLine());
	    }
	} catch (IOException x) {
	    
	}
	
	}
	
	public int sizeofarraylist(){
		int xy=arrey.size();
		return xy;
	}

	
	public String getWord(int bc){
		String wordatthatindex=arrey.get(bc);
		return wordatthatindex;
	}
		


	private ArrayList<String> arrey=new ArrayList<String>();
}
