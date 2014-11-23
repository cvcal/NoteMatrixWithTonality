package main;
import jm.JMC;
//import jm.util.*;
//import jm.music.data.*;
//import jm.music.tools.*;

/**
 * This class represents the grid, the "matrix" part of the tone matrix
 * 
 * @author Chloe Calvarin
 */

public class Grid implements JMC {
	// -------------------------
	// Data Members
	// -------------------------
	static int numInstruments = 4;
	int length;   // length of grid
	int height;   // height of grid
	int baseNote; // the note of the bottom of the grid
	
	// The first location is the instrument value, the second is a flag
	// for whether or not the instrument has been initialized
	int[][] instrument;
	
	// The first dimension is for the instrument, the second is for the
	// length and the last is for the height. 
	boolean[][][] grid;

	// -------------------------
	// Constructor
	// -------------------------
	
	public Grid(int matrixLength, int matrixHeight) {
		// TODO check limits of length and height
		length = matrixLength;
		height = matrixHeight;
		
		// Set the base note so that C4 (middle C) is in the middle 
		baseNote = C4 - height/2;
		
		// the two matrices will initialize to 0 and false, respectively.
		instrument = new int[numInstruments][2];
		grid = new boolean[numInstruments][length][height];
	}

	// ------------------------- 
	// Public Methods
	// -------------------------
	
	/**
	 * This method adds the instruments to the class
	 * 
	 * @param numInGrid - the number (0-3) that the instrument is stored in
	 * @param colorChoice - the number associated with which color (0-5, for 
	 * 						now) or type of instrument should be stored in 
	 *    					the grid
	 */
	public void addInstrument(int numInGrid, int colorChoice) {
		if (numInGrid >= numInstruments) {
			// illegal argument
			// TODO add error for illegal instrument
			return;
		}
		switch (colorChoice) {
			case 0: instrument[numInGrid][0] = PIZZICATO_STRINGS;
				instrument[numInGrid][1] = 1;
				break;
			case 1: instrument[numInGrid][0] = CLAVINET;
				instrument[numInGrid][1] = 1;
				break;
			case 2: instrument[numInGrid][0] = CLARINET;
				instrument[numInGrid][1] = 1;
				break;
			case 3: instrument[numInGrid][0] = BIRD;
				instrument[numInGrid][1] = 1;
				break;
			case 4: instrument[numInGrid][0] = PANFLUTE;
				instrument[numInGrid][1] = 1;
				break;
			case 5: instrument[numInGrid][0] = GLOCK;
				instrument[numInGrid][1] = 1;
				break;
			default:
				// TODO error of color choice
				break;
		}
	}
	
	/**
	 * This method is used for editing the content of the grid at a particular 
	 * location, linked to a particular tone, or instrument type.
	 * 
	 * If this location was empty, or contained a note of the other types, add
	 * the note to the grid. If, on the other hand, the grid already contains 
	 * a note of this type at this location, remove it.
	 * 
	 * @param t - tone to add to the grid, the instrument/color type
	 * @param x - the note's horizontal position in the grid
	 * @param y - the note's vertical position in the grid, the pitch
	 */
	public void changeLocation(int instNum, int x, int y) {
		if (x < 0 || x >= length || y < 0 || y >= height){
			// out of grid bounds
			// TODO add out of grid bounds error
			return;
		}
		if (instNum >= numInstruments || instrument[instNum][1] == 0) {
			// invalid instruments, either out of bounds or not initialized
			// TODO add invalid instrument error
			return;
		}
		if (grid[instNum][x][y] == false) {
			// add the note!
			addNote(instNum, x, y);			
		} else {
			// remove the note!
			removeNote(instNum, x, y);		
		}
	}

	/**
	 * Clear the grid, remove every note, from every instrument 
	 */
	public void clearGrid() {
		for (int i = 0; i < numInstruments; i++){
			for (int j = 0; j < length; j++){
				for (int k = 0; k < height; k++){
					grid[i][j][k] = false;
				}
			}
		}
	}
	
	// TODO Add the 'make score' method


	// -------------------------
	// Private Methods
	// -------------------------
	
	/**
	 * @param t - tone to add to the grid, the instrument/color type
	 * @param x - the note's horizontal position in the grid
	 * @param y - the note's vertical position in the grid, the pitch
	 */
	private void addNote(int midiInst, int x, int y) {		
		// Add the note to the matrix
		// TODO implement addNote
	}
	
	/**
	 * @param t - instrument type to remove from the grid,
	 * @param x - the note's horizontal position in the grid
	 * @param y - the note's vertical position in the grid, the pitch
	 */
	private void removeNote(int midiInst, int x, int y) {
		// Remove the note from the matrix
		// TODO implement removeNote
	}
}
