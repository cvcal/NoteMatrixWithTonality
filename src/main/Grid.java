package main;

/**
 * This class represents the grid, the "matrix" part of the tone matrix
 * 
 * @author Chloe Calvarin
 */

public class Grid {
	// -------------------------
	// Data Members
	// -------------------------
	int length;
	int height;
	// TODO add the grid type

	// -------------------------
	// Constructor
	// -------------------------
	public Grid(int matrixLength, int matrixHeight) {
		// TODO check limits of length and height
		length = matrixLength;
		height = matrixHeight;
	}

	// -------------------------
	// Public Methods
	// -------------------------
	
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
	public void changeLocation(Tone t, int x, int y) {
		if (x < 0 || x >= length || y < 0 || y >= height){
			// out of grid bounds
			// TODO add error
		}
		
		
	}
	
	// TODO Add the 'make 

	// -------------------------
	// Private Methods
	// -------------------------
	
	/**
	 * @param t - tone to add to the grid, the instrument/color type
	 * @param x - the note's horizontal position in the grid
	 * @param y - the note's vertical position in the grid, the pitch
	 */
	private void addNote(Tone t, int x, int y) {		
		// Add the note to the matrix
		// TODO
	}
	
	/**
	 * @param t - instrument type to remove from the grid,
	 * @param x - the note's horizontal position in the grid
	 * @param y - the note's vertical position in the grid, the pitch
	 */
	private void removeNote(Tone t, int x, int y) {
		// Remove the note from the matrix
		// TODO
	}
}
