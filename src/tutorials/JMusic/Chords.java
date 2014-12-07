package tutorials.JMusic;

import jm.JMC;
import jm.util.*;
import jm.music.data.*;

/**
 * This class uses the jMusic CPhrase (Chord Phrase)
 * The class generates a chord progression 
 * around the cycle of 5ths
 * It uses static methods in the one file.
 * @author Andrew Brown
 */
public final class Chords implements JMC{
	
	private static Score s = new Score("CPhrase class example");
	private static Part p = new Part("Piano", 0, 0);
		
	public static void main(String[] args){		
		//Let us know things have started
		System.out.println("Creating chord progression . . .");
		
		//choose rootPitch notes around the cycle of fifths
		int rootPitch = C4; //set start note to middle C
		for (int i = 0; i < 6; i++) {
			secondInversion(rootPitch);
			rootPitch -= 7;
			p.addPhrase(new Phrase(new Rest()));
			rootPosition(rootPitch);
			rootPitch += 5;
		}
		
		//add a final chord
		ending(rootPitch);
		
		//pack the part into a score
		s.addPart(p);
		s.setTempo(150);
		//display the music
		View.show(s);
		
		// write the score to a MIDIfile
		Play.midi(s);
	}	
	
	private static void rootPosition(int rootPitch) {
		// build the chord from the rootPitch 
	 	int[] pitchArray = new int[4];
	 	pitchArray[0] = rootPitch;
	 	pitchArray[1] = rootPitch + 4;
	 	pitchArray[2] = rootPitch + 7;
	 	pitchArray[3] = rootPitch + 10;
	 	//add chord to the part
		CPhrase chord = new CPhrase();
		chord.addChord(pitchArray, C);
		p.addCPhrase(chord);
	}
	
	private static void secondInversion(int rootPitch) {
		// build the chord from the rootPitch 
	 	int[] pitchArray = new int[4];
	 	pitchArray[0] = rootPitch;
	 	pitchArray[1] = rootPitch + 4;
	 	pitchArray[2] = rootPitch - 2;
	 	pitchArray[3] = rootPitch - 5;
	 	//add chord to the part
		CPhrase chord = new CPhrase();
		chord.addChord(pitchArray, C);
		p.addCPhrase(chord);
	}		
	
	private static void ending(int rootPitch) {
		// build the chord from the rootPitch 
	 	int[] pitchArray = new int[4];
	 	pitchArray[0] = rootPitch;
	 	pitchArray[1] = rootPitch + 4;
	 	pitchArray[2] = rootPitch + 7;
	 	pitchArray[3] = rootPitch + 12;
	 	//add chord to the part
		CPhrase chord = new CPhrase();
		chord.addChord(pitchArray, SB);
		p.addCPhrase(chord);
	}				
}