File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;



public class Hangman extends ConsoleProgram {
  
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
		addActionListeners();
		
		}
		

    public void run() {
    	
    	canvas.reset();
    	println("WELCOME TO HANGMAN!!");
    	selectarandomwordfromthelexicon();
    	hashingtheselectedword();
    	implement();
    	
    	
	}
  
//  selecting a random word from the hangman lexicon
    private void selectarandomwordfromthelexicon(){ 
    	h=new HangmanLexicon();//  HangmanLexicon h=new HangmanLexicon();    can declare it here also
    	h.addingwordsfromfile();
    	int arreysize=h.sizeofarraylist();
	int y=rgen.nextInt(0,arreysize-1);
	println(y);
	str=(h.getWord(y));
	println(str);
    }
   
    
    private void hashingtheselectedword(){
    	hash="";
    	guessed="";
     for(int i=0;i<str.length();i++){
    	 guessed+="_";                      ///creating string to overwrite whose length is equal to hash
    	 hash+="_ ";
     }
     println("The World Looks Like this:"+ hash);
   
    }
   
    
    private  void implement(){
    	
    	   char a =' ';
    	for(int i=8;i>0;i--)
    	{   
    		canvas.noteIncorrectGuess(a,i);///calling to add bodypart depending on value of i
    		//else canvas.noteIncorrectGuess(a,i)
    		println("\nYou have "+ i +" guesses left");
    		
    		String forChar=readLine("Enter Your Guess: ");
    		forChar=forChar.toUpperCase();  ///converts nterd string to upper case
    		a=forChar.charAt(0);      //selects the character and stores it to char type
    		int m=0;      //we need to print line /the guess is correct only once //hence we use this flag
    		for(int l=0;l<str.length();l++)   ///compares entered alphabet to each individual character of string
    		{
    			if(a==str.charAt(l))
    			{
    				if(m==0)
    				{
    				m=1;
    				i++;
    				println("The guess is correct");
    				}
    				///making the string guessed to be equal to you part of the guessed word so far ex:__A_B
/*most imp*/    	if(l==(str.length()-1))  guessed=guessed.substring(0,l)+a;    //taking into consideration if word to replace is last word in the string
    				else guessed=guessed.substring(0,l)+a+guessed.substring(l+1);

    				
    			}
    			
    			
    		}
    		if(m==0) println("The Guess is incorrect");
    		print("The world now looks like:");
    		canvas.displayWord(guessed);
    		for(int me=0;me<guessed.length();me++) print(""+ guessed.charAt(me) +" ");///ENTERS the word with a spaced sequence to display on screen
    		if(guessed.equals(str))   ///CHECKS to see if u have won the game prints and exits function
    		{
    			println("\n You guessed the word:: "+ str +" \n CONGRATULATIONS BUDDY !!!YOU WIN!!");
    			return ;
    			}
    	}
    	canvas.noteIncorrectGuess(a,0); ///calling to add bodypart depending on value of 0
    	println("\n  The word is:: "+ str +" \n YOU SUCK BUDDY !!!YOU LOSE!!");
	System.out.flush();
    			
    	
    }
    	
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private String str;
    private String hash;
    private String guessed;
    private HangmanLexicon h;
    private HangmanCanvas canvas;
    
    
}
