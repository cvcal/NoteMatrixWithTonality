//give this class access to the jMusic classes

package tutorials.JMusic;
import jm.JMC;
import jm.audio.Instrument;
import jm.music.data.*;
import jm.util.Play;
import jm.constants.*;

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
		Note c5 = new Note(C5, 0.7, P, PAN_CENTRE);
		Note c4 = new Note(C4, 1, P, PAN_CENTRE);
		Note c3 = new Note(C3, 1, MF, PAN_CENTRE);
		Note c2 = new Note(C2, 0.5, FF, PAN_CENTRE);
		
		//create a phrase		
		Phrase phr = new Phrase();
		
		//put the note inside the phrase
		phr.addNote(c5);
		phr.addNote(c4);
		phr.addNote(c3);
		phr.addNote(c2);
		
		//pack the phrase into a part
		Part p = new Part();
		p.addPhrase(phr);
		
		//pack the part into a score titled 'Bing'
		Score s = new Score("Bing");
		s.addPart(p);
		
		//write the score as a MIDI file to disk, and then play it back
		//Write.midi(s,"Bing.mid");
		//Play.mid("Bing.mid");
		
		Instrument inst = new BreathyFluteInst(44100);
		// Play the score as a Breathy Flute
		Play.audio(phr, inst);
	}

}