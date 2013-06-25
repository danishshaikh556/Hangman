/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.awt.Color;
import acm.program.*;

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
  public void reset() {
		removeAll();
		setBackground(Color.RED);
		GLine polelength=new GLine(20,20,20,SCAFFOLD_HEIGHT);
		add(polelength);
		
		GLine poleextension=new GLine(20,20,20+BEAM_LENGTH,20);
		add(poleextension);
		
		GLine ropehang=new GLine(20+BEAM_LENGTH,20,20+BEAM_LENGTH,20+ROPE_LENGTH);
		add(ropehang);
		
		
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		
	
	GLabel wordguesses=new GLabel(""+ word +"",20,400);
	 wordguesses.setColor(Color.YELLOW);
	  add(wordguesses);
	 
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter,int no) {
		
		printincorrectcharacter=printincorrectcharacter+letter;
		GLabel wrongword=new GLabel(""+ printincorrectcharacter +"" ,20,450);
		    wrongword.setColor(Color.BLUE);
		GOval head=new GOval((20+BEAM_LENGTH)-HEAD_RADIUS,20+ROPE_LENGTH,2*HEAD_RADIUS,2*HEAD_RADIUS);
		//add(c);
		
		GLine spinelength=new GLine(20+BEAM_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS),20+BEAM_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS)+BODY_LENGTH);
		//add(l);
		
		GLine leftarm=new GLine(20+BEAM_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS)+ARM_OFFSET_FROM_HEAD,20+BEAM_LENGTH+UPPER_ARM_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS)+ARM_OFFSET_FROM_HEAD);
		//add(m);
		
		GLine rightarm=new GLine(20+BEAM_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS)+ARM_OFFSET_FROM_HEAD,20+BEAM_LENGTH-UPPER_ARM_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS)+ARM_OFFSET_FROM_HEAD);
		//add(n);
		
		GLine lefthand=new GLine(20+BEAM_LENGTH+UPPER_ARM_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS)+ARM_OFFSET_FROM_HEAD,20+BEAM_LENGTH+UPPER_ARM_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS)+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
		//add(o);
		
		GLine righthand=new GLine(20+BEAM_LENGTH-UPPER_ARM_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS)+ARM_OFFSET_FROM_HEAD,20+BEAM_LENGTH-UPPER_ARM_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS)+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
		//add(p);
		
		GLine hipwidth =new GLine(20+BEAM_LENGTH-(HIP_WIDTH/2),20+ROPE_LENGTH+(2*HEAD_RADIUS)+BODY_LENGTH,20+BEAM_LENGTH+(HIP_WIDTH/2),20+ROPE_LENGTH+(2*HEAD_RADIUS)+BODY_LENGTH);
		//add(q);
		
		GLine leftleg=new GLine(20+BEAM_LENGTH-(HIP_WIDTH/2),20+ROPE_LENGTH+(2*HEAD_RADIUS)+BODY_LENGTH,20+BEAM_LENGTH-(HIP_WIDTH/2),20+ROPE_LENGTH+(2*HEAD_RADIUS)+BODY_LENGTH+LEG_LENGTH);
		//add(s);
		
		GLine rightleg=new GLine(20+BEAM_LENGTH+(HIP_WIDTH/2),20+ROPE_LENGTH+(2*HEAD_RADIUS)+BODY_LENGTH,20+BEAM_LENGTH+(HIP_WIDTH/2),20+ROPE_LENGTH+(2*HEAD_RADIUS)+BODY_LENGTH+LEG_LENGTH);
		//add(t);
		
		GLine leftfoot=new GLine(20+BEAM_LENGTH-(HIP_WIDTH/2)-FOOT_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS)+BODY_LENGTH+LEG_LENGTH,20+BEAM_LENGTH-(HIP_WIDTH/2),20+ROPE_LENGTH+(2*HEAD_RADIUS)+BODY_LENGTH+LEG_LENGTH);
		//add(x);
		
		GLine rightfoot=new GLine(20+BEAM_LENGTH+(HIP_WIDTH/2)+FOOT_LENGTH,20+ROPE_LENGTH+(2*HEAD_RADIUS)+BODY_LENGTH+LEG_LENGTH,20+BEAM_LENGTH+(HIP_WIDTH/2),20+ROPE_LENGTH+(2*HEAD_RADIUS)+BODY_LENGTH+LEG_LENGTH);
		//add(y);
		
		int number=no;
		switch(number){
		case 7: add(head);
		        add(wrongword);
		        break;
		case 6: add(spinelength);
				
		        add(wrongword);
                break;
		case 5: add(leftarm);
				
		        add(wrongword);
				break;
		case 4: add(rightarm);
				
		        add(wrongword);
				break;
		case 3: add(lefthand);
			    add(righthand);
			    
			    add(wrongword);
				break;
		case 2:add(hipwidth);
				
		       add(wrongword);
			   break;
		case 1:add(leftleg);
			   add(rightleg);
			  
			   add(wrongword);
		       break;
		case 0: add(leftfoot);
			    add(rightfoot);
			    add(wrongword);
        		break;
        default: break;		
		}
		
		
		
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private String printincorrectcharacter="";

}
