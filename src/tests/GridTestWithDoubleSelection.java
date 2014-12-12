package tests;
import main.Grid;
import jm.util.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This test plays the same set of notes as BasicGridTest,
 * but does so from the GUI, so that it checks that the cells
 * that are selected twice are colored in two colors. 
 * 
 * @author Chloe Calvarin
 */
public final class GridTestWithDoubleSelection{
	
	public static void main(String[] args){		
		final Grid grid = new Grid(12,24);
		
		// Define the 4 instruments
		grid.addInstrument(0,0);
		grid.addInstrument(1,1);
		grid.addInstrument(2,2);
		grid.addInstrument(3,3);
		
		// Add notes for instrument 0
		grid.changeLocation(0,0,12);
		grid.changeLocation(0,1,14);
		grid.changeLocation(0,2,15);
		grid.changeLocation(0,3,14);
		grid.changeLocation(0,4,12);

		// Add notes for instrument 1
		grid.changeLocation(1,2,12);
		grid.changeLocation(1,3,14);
		grid.changeLocation(1,4,15);
		grid.changeLocation(1,5,14);
		grid.changeLocation(1,6,12);

		// Add notes for instrument 2
		grid.changeLocation(2,4,12);
		grid.changeLocation(2,5,14);
		grid.changeLocation(2,6,15);
		grid.changeLocation(2,7,14);
		grid.changeLocation(2,8,12);

		// Add notes for instrument 
		grid.changeLocation(3,6,12);
		grid.changeLocation(3,7,14);
		grid.changeLocation(3,8,15);
		grid.changeLocation(3,9,14);
		grid.changeLocation(3,10,12);
		
		// Open up le GUI
		
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                JFrame window = new JFrame();
                window.setSize(600, 500);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(grid);
                window.setVisible(true);
                // Start playing the default input
                (new Thread(new Runnable() {
		            @Override
		            public void run() {
		            	Play.midi(grid.getScoreWithRepeats(1));
		            }
		        })).start();
            }
        });
	}
	
}


