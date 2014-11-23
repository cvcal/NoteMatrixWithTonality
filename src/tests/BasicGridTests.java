package tests;
import main.Grid;
import jm.util.*;
//import jm.JMC;

/**
 * Simple test for my Grid class
 * 
 * @author Chloe Calvarin
 */
public final class BasicGridTests{
	
	public static void main(String[] args){		
		Grid grid = new Grid(12,24);
		
		// Define the 4 instruments
		grid.addInstrument(0,0);
		grid.addInstrument(1,1);
		grid.addInstrument(2,2);
		grid.addInstrument(3,3);
		
		// Add notes for instrument 1
		grid.changeLocation(0,0,12);
		grid.changeLocation(0,1,14);
		grid.changeLocation(0,2,15);
		grid.changeLocation(0,3,14);
		grid.changeLocation(0,4,12);

		grid.changeLocation(1,2,12);
		grid.changeLocation(1,3,14);
		grid.changeLocation(1,4,15);
		grid.changeLocation(1,5,14);
		grid.changeLocation(1,6,12);

		grid.changeLocation(2,4,12);
		grid.changeLocation(2,5,14);
		grid.changeLocation(2,6,15);
		grid.changeLocation(2,7,14);
		grid.changeLocation(2,8,12);

		grid.changeLocation(3,6,12);
		grid.changeLocation(3,7,14);
		grid.changeLocation(3,8,15);
		grid.changeLocation(3,9,14);
		grid.changeLocation(3,10,12);
		
		// Play the score!
		Play.midi(grid.getScoreWithRepeats(3));
	}
}