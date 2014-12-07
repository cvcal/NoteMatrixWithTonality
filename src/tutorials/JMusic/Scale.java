package tutorials.JMusic;

import jm.JMC;
import jm.music.data.*;
import jm.util.*;

/**
 * A short example which generates a one octave c chromatic scale
 * and writes to a standard MIDI file called ChromaticScale.mid
 * @author Andrew Sorensen and Andrew Brown
 */
public final class Scale implements JMC{

	public static void main(String[] args){
		Score s = new Score("JMDemo - Scale");
		Part p = new Part("Flute", FLUTE, 0);
		Phrase phr = new Phrase("Chromatic scale", 0.0); 
		
		// create the scale notes and 
		// add them to a phrase
		for(short i=0;i<=13;i++){
			Note n = new Note(C4+i, .2);
			phr.addNote(n);
		}
		for(short i=12;i>=0;i--){
			Note n = new Note(C4+i, .2);
			phr.addNote(n);
		}
		// add the phrase to a part
		p.addPhrase(phr);
		// add the part to the score
		s.addPart(p);
		
		//write a MIDI file to disk of the score
		Play.midi(s);
	}
	
}