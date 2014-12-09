package main;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

import javax.swing.JPanel;

import jm.JMC;
import jm.music.data.*;
//import jm.music.tools.*;
//import jm.util.*;
import jm.util.Play;

/**
 * This class represents the grid, the "matrix" part of the note matrix
 * 
 * @author Chloe Calvarin
 */

public class Grid extends JPanel implements MouseListener, JMC {
	// -------------------------
	// Data Members
	// -------------------------
	private static int numInstruments = 4;
	private static double tempo = 120;
	private int length;   // length of grid
	private int height;   // height of grid
	private int baseNote; // the note of the bottom of the grid
	
	
	// The first location is the instrument value, the second is a flag
	// for whether or not the instrument has been initialized
	private int[][] instrument;
	
	// The first dimension is for the instrument, the second is for the
	// length and the last is for the height. 
	private boolean[][][] grid;
	
	// Graphics related numbers
	private int horizOffset = 10; // offset from the left edge of the component
	private int vertOffset  = 10; // offset from the top edge of the component
	private int cellHeight  = 20; // height of an individual cell
	private int cellWidth   = 20; // width of an individual cell
	private int horizSpacer = 4;  // Space between two horizontally adjacent cells
	private int vertSpacer  = 4;  // Space between two vertically adjacent cells
	private Color[] instColors;   // Colors related to the instruments.
	
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
		instColors = new Color[numInstruments];
		
        addMouseListener(this);
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
				instColors[numInGrid] = Color.RED;
				break;
			case 1: instrument[numInGrid][0] = CLAVINET;
				instrument[numInGrid][1] = 1;
				instColors[numInGrid] = Color.BLUE;
				break;
			case 2: instrument[numInGrid][0] = CLARINET;
				instrument[numInGrid][1] = 1;
				instColors[numInGrid] = Color.ORANGE;
				break;
			case 3: instrument[numInGrid][0] = BIRD;
				instrument[numInGrid][1] = 1;
				instColors[numInGrid] = Color.GREEN;
				break;
			case 4: instrument[numInGrid][0] = PANFLUTE;
				instrument[numInGrid][1] = 1;
				instColors[numInGrid] = Color.YELLOW;
				break;
			case 5: instrument[numInGrid][0] = GLOCK;
				instrument[numInGrid][1] = 1;
				instColors[numInGrid] = Color.PINK;
				break;
			default:
				// TODO error of color choice
				break;
		}
	}
	
	/** 
	 * Heads the visual representation of current grid
	 */
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
		
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, horizOffset * 2 + cellWidth  * length + horizSpacer * (length-1),
        		         vertOffset * 2  + cellHeight * height + vertSpacer  * (height-1));
        
        // draw all the grid elements
        for (int i = 0; i < length; i++) {
        	for (int j = 0; j < height; j++) {
        		int numInstrumentsInCell = 0;
        		for (int k = 0; k < numInstruments; k++) {
        			if (grid[k][i][j]) {
        				numInstrumentsInCell++;
        			}
        		}
        		
        		// Draw the cell (interestingly, you want to draw them vertically upside 
        		// down, so the lower pitches (lower indices in grid) are lower in the 
        		// visual field (higher "y" values) 
        		int x = horizOffset + (cellWidth + horizSpacer)*i;
        		int y = vertOffset  + (cellHeight + vertSpacer)*(height-1-j);
        		if (numInstrumentsInCell == 0) {
        			// draw an empty cell if no instruments have selected it
        			g.setColor(Color.WHITE);
        			g.fillRect(x, y, cellWidth, cellHeight);
        		} else {
        			// Get the appropriate colors for the cell
        			Color[] colorArray = new Color[numInstrumentsInCell];
        			int numSoFar = 0;
        			for (int k = 0; k < numInstruments; k++) {
            			if (grid[k][i][j]) {
            				colorArray[numSoFar] = instColors[k];
            				numSoFar++;
            			}
            		}
        			
        			paintColoredCell(x, y, colorArray, numInstrumentsInCell, g);
        		}
        		
        		
        	}
        }
	}
	
	/**
	 * Paint the cell with the appropriate colors
	 * 
	 * @param x - x position of cell (relative to component)
	 * @param y - y ''
	 * @param colorArray - array of the colors this cell is to be painted with
	 * @param numColors - number of colors this cell is to be painted with
	 * @param g 
	 */
	private void paintColoredCell(int x, int y, Color[] colorArray, int numColors, Graphics g) {
		switch (numColors) {
		case 1 : {
			g.setColor(colorArray[0]);
			g.fillRect(x, y, cellWidth, cellHeight);
			break;
		}
		case 2 : {
			g.setColor(colorArray[0]);
			int x1points[] = {x, x+cellWidth, x};
            int y1points[] = {y, y, y+cellHeight};
            int npoints = 3;
            g.fillPolygon(x1points, y1points, npoints);
            
			g.setColor(colorArray[1]);
            int x2points[] = {x, x+cellWidth, x+cellWidth};
            int y2points[] = {y+cellHeight, y, y+cellHeight};
            g.fillPolygon(x2points, y2points, npoints);
			break;
		}
		case 3 : {
			g.setColor(colorArray[0]);
            int x1points[] = {x, x, x+cellWidth, x+cellWidth, x+cellWidth/2};
            int y1points[] = {y+2*cellHeight/3, y+cellHeight, y+cellHeight, y+2*cellHeight/3, y+cellHeight/2};
            int npoints = 5;
            g.fillPolygon(x1points, y1points, npoints);
            
			g.setColor(colorArray[1]);
            int x2points[] = {x, x+cellWidth/2, x+cellWidth/2, x};
            int y2points[] = {y, y, y+cellHeight/2, y+2*cellHeight/3};
            npoints = 4;
            g.fillPolygon(x2points, y2points, npoints);
            
			g.setColor(colorArray[2]);
            int x3points[] = {x+cellWidth, x+cellWidth/2, x+cellWidth/2, x+cellWidth};
            int y3points[] = {y, y, y+cellHeight/2, y+2*cellHeight/3};
            g.fillPolygon(x3points, y3points, npoints);
			break;
		}
		case 4 : {
			g.setColor(colorArray[0]);
            int x1points[] = {x, x, x+cellWidth/2};
            int y1points[] = {y, y+cellHeight, y+cellHeight/2};
            int npoints = 3;
            g.fillPolygon(x1points, y1points, npoints);
            
			g.setColor(colorArray[1]);
            int x2points[] = {x, x+cellWidth, x+cellWidth/2};
            int y2points[] = {y, y, y+cellHeight/2};
            g.fillPolygon(x2points, y2points, npoints);
            
			g.setColor(colorArray[2]);
            int x3points[] = {x+cellWidth, x+cellWidth, x+cellWidth/2};
            int y3points[] = {y, y+cellHeight, y+cellHeight/2};
            g.fillPolygon(x3points, y3points, npoints);
            
			g.setColor(colorArray[3]);
            int x4points[] = {x, x+cellWidth, x+cellWidth/2};
            int y4points[] = {y+cellHeight, y+cellHeight, y+cellHeight/2};
            g.fillPolygon(x4points, y4points, npoints);
			break;
		}
		default : 
			// TODO too many colors
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
	
	/**
	 * This method returns the score corresponding to the grid 
	 * @return score corresponding to the grid
	 */
	public Score getScore() {
		Score s = new Score(tempo);
		for (int i = 0; i < numInstruments; i++) {
			s.addPart(getPart(i));
		}
		return s;
	}
	
	/**
	 * This method returns the part (smaller than a full score) corresponding
	 * to the specified instrument's notes in the grid.
	 * 
	 * @param instrumentNum - number of the instrument to get the part for
	 * @return part
	 */
	public Part getPart(int instrumentNum) {
		// Use the private helper function to add a cycle of the grid.
		Part p = new Part(instrument[instrumentNum][0]);
		return addToPart(p, instrumentNum);
	}

	/**
	 *  
	 * @param numRepeats - the number of times each part should repeat
	 * @return score corresponding to the grid
	 */
	public Score getScoreWithRepeats(int numRepeats) {
		Score s = new Score(tempo);
		for (int i = 0; i < numInstruments; i++) {
			Part p = new Part(instrument[i][0]);
			
			// Add the numRepeats of each part
			for (int j = 0; j < numRepeats; j++) {
				p = addToPart(p, i);
			}
			s.addPart(p);
		}
		return s;
	}
	
	// -------------------------
	// Private Methods
	// -------------------------
	
	/**
	 * Add the note to the matrix/grid
	 * 
	 * @param miniInst - the number/index of the instrument selected
	 * @param x - the note's horizontal position in the grid
	 * @param y - the note's vertical position in the grid, the pitch
	 */
	private void addNote(int midiInst, int x, int y) {		
		grid[midiInst][x][y] = true;
	}
	
	/**
	 * Remove the note from the matrix/grid
	 * 
	 * @param miniInst - the number/index of the instrument selected
	 * @param x - the note's horizontal position in the grid
	 * @param y - the note's vertical position in the grid, the pitch
	 */
	private void removeNote(int midiInst, int x, int y) {
		grid[midiInst][x][y] = false;
	}
	
	/**
	 * This method returns the part passed in with a grid's worth of notes
	 * corresponding to the specified instrument's notes in the grid, 
	 * 
	 * @param p  - the part to add a cycle of the grid to
	 * @param instrumentNum
	 * @return
	 */
	private Part addToPart(Part p, int instrumentNum) {
		// Only add notes if there is a defined instrument for this number.
		if (instrument[instrumentNum][1] == 1){ 
			// Traverse grid to add notes
			for (int j = 0; j < length; j++) {
				// first find the number of notes at this time
				int numNotes = 0;
				for (int k = 0; k < height; k++) {
					if (grid[instrumentNum][j][k] == true) {
						numNotes++;
					}
				}
				
				// Now, add note(s) or rest depending on the number of notes
				if (numNotes == 0) {
					p.addPhrase(new Phrase(new Rest()));
				} else if (numNotes == 1) {
					// find the note again!
					for (int k = 0; k < height; k++) {
						if (grid[instrumentNum][j][k] == true){
							p.addPhrase(new Phrase(new Note(baseNote+k, 1)));
							break;
						}
					}
					
				} else {
					// Add chord
					int[] notes = new int[numNotes];
					int index = 0;
					for (int k = 0; k < height; k++) {
						if (grid[instrumentNum][j][k] == true){
							notes[index] = baseNote+k;
							index++;
						}
					}
					CPhrase chord = new CPhrase();
					chord.addChord(notes, 1);
					p.addCPhrase(chord);
				}
			}			
			return p;
		} else {
			return null;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	

		// TODO remove hack to get visual to play.
		if (e.getX() < horizOffset) {
			Play.midi(getScoreWithRepeats(3));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = (e.getX() - horizOffset) / (cellWidth+horizSpacer);
		int y = height - 1 - (e.getY() - vertOffset) / (cellHeight+vertSpacer);
		
		// TODO change to proper instrument
		changeLocation(1, x, y);
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
}
