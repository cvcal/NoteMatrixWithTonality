//give this class access to the jMusic classes

package tutorials;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;
import jm.audio.*;

/**
* This is the simplest jMusic program of all, based off of tutorial's sample 
* code in from http://explodingart.com/jmusic/jmtutorial/x34.html.
* The equivalent to a programming language's 'Hello World.
* 
* Chloe Calvarin
* 	I've used this file to get a sense of the jmusic scene, combining multiple 
*   tutorials into one
*/

public final class Bing implements JMC{

	public static void main(String[] args){
		//create a bunch of Cs minim (half note)
		Note c5 = new Note(C5, MINIM);
		Note c4 = new Note(C4, MINIM);
		Note c3 = new Note(C3, MINIM);
		Note c2 = new Note(C2, MINIM);
		
		//create a phrase		
		Phrase phr = new Phrase();
		
		//put the note inside the phrase
		phr.addNote(c5);
		phr.addNote(c3);
		phr.addNote(c2);
		phr.addNote(c4);
		
		//pack the phrase into a part
		Part p = new Part();
		p.addPhrase(phr);
		
		//pack the part into a score titled 'Bing'
		Score s = new Score("Bing");
		s.addPart(p);
		
		//write the score as a MIDI file to disk, and then play it back
		Write.midi(s,"Bing.mid");
		Play.mid("Bing.mid");
		Instrument inst = new SawtoothInst(44100);
		Write.au(s, inst);
	}

}