package tests;
import main.Grid;
import jm.util.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This test a larger grid, with a round of Twinkle Twinkle
 * coded in as the initial values. 
 * 
 * @author Chloe Calvarin
 */
public final class LargeGridTest{
	
	public static void main(String[] args){		
		final Grid grid = new Grid(48,32);
		
		// Define the 4 instruments
		grid.addInstrument(0,4);
		grid.addInstrument(1,2);
		grid.addInstrument(2,1);
		grid.addInstrument(3,5);
		
		// Add notes for instrument 0
		grid.changeLocation(0,0,2);
		grid.changeLocation(0,1,2);
		grid.changeLocation(0,3,5);
		grid.changeLocation(0,4,2);
		grid.changeLocation(0,5,2);
		grid.changeLocation(0,7,5);
		grid.changeLocation(0,8,2);
		grid.changeLocation(0,9,2);
		grid.changeLocation(0,11,5);
		grid.changeLocation(0,12,2);
		grid.changeLocation(0,13,2);
		grid.changeLocation(0,15,5);
		grid.changeLocation(0,16,2);
		grid.changeLocation(0,17,2);
		grid.changeLocation(0,19,5);
		grid.changeLocation(0,20,2);
		grid.changeLocation(0,21,2);
		grid.changeLocation(0,23,5);
		grid.changeLocation(0,24,2);
		grid.changeLocation(0,25,2);
		grid.changeLocation(0,27,5);
		grid.changeLocation(0,28,2);
		grid.changeLocation(0,29,2);
		grid.changeLocation(0,31,5);
		grid.changeLocation(0,32,2);
		grid.changeLocation(0,33,2);
		grid.changeLocation(0,35,5);
		grid.changeLocation(0,36,2);
		grid.changeLocation(0,37,2);
		grid.changeLocation(0,39,5);
		grid.changeLocation(0,40,2);
		grid.changeLocation(0,41,2);
		grid.changeLocation(0,43,5);
		grid.changeLocation(0,44,2);
		grid.changeLocation(0,45,2);
		grid.changeLocation(0,47,5);
		
		// Add notes for instrument 1 - twinkle first round
		grid.changeLocation(1,0,12);
		grid.changeLocation(1,1,12);
		grid.changeLocation(1,2,19);
		grid.changeLocation(1,3,19);
		grid.changeLocation(1,4,21);
		grid.changeLocation(1,5,21);
		grid.changeLocation(1,6,19);
		
		grid.changeLocation(1,8,17);
		grid.changeLocation(1,9,17);
		grid.changeLocation(1,10,16);
		grid.changeLocation(1,11,16);
		grid.changeLocation(1,12,14);
		grid.changeLocation(1,13,14);
		grid.changeLocation(1,14,12);
		
		grid.changeLocation(1,16,19);
		grid.changeLocation(1,17,19);
		grid.changeLocation(1,18,17);
		grid.changeLocation(1,19,17);
		grid.changeLocation(1,20,16);
		grid.changeLocation(1,21,16);
		grid.changeLocation(1,22,14);
		
		grid.changeLocation(1,24,19);
		grid.changeLocation(1,25,19);
		grid.changeLocation(1,26,17);
		grid.changeLocation(1,27,17);
		grid.changeLocation(1,28,16);
		grid.changeLocation(1,29,16);
		grid.changeLocation(1,30,14);

		grid.changeLocation(1,32,12);
		grid.changeLocation(1,33,12);
		grid.changeLocation(1,34,19);
		grid.changeLocation(1,35,19);
		grid.changeLocation(1,36,21);
		grid.changeLocation(1,37,21);
		grid.changeLocation(1,38,19);
		
		grid.changeLocation(1,40,17);
		grid.changeLocation(1,41,17);
		grid.changeLocation(1,42,16);
		grid.changeLocation(1,43,16);
		grid.changeLocation(1,44,14);
		grid.changeLocation(1,45,14);
		grid.changeLocation(1,46,12);

		

		// Add notes for instrument 2 - twinkle second round
		grid.changeLocation(2,8,12);
		grid.changeLocation(2,9,12);
		grid.changeLocation(2,10,19);
		grid.changeLocation(2,11,19);
		grid.changeLocation(2,12,21);
		grid.changeLocation(2,13,21);
		grid.changeLocation(2,14,19);
		
		grid.changeLocation(2,16,17);
		grid.changeLocation(2,17,17);
		grid.changeLocation(2,18,16);
		grid.changeLocation(2,19,16);
		grid.changeLocation(2,20,14);
		grid.changeLocation(2,21,14);
		grid.changeLocation(2,22,12);
		
		grid.changeLocation(2,24,19);
		grid.changeLocation(2,25,19);
		grid.changeLocation(2,26,17);
		grid.changeLocation(2,27,17);
		grid.changeLocation(2,28,16);
		grid.changeLocation(2,29,16);
		grid.changeLocation(2,30,14);
		
		grid.changeLocation(2,32,19);
		grid.changeLocation(2,33,19);
		grid.changeLocation(2,34,17);
		grid.changeLocation(2,35,17);
		grid.changeLocation(2,36,16);
		grid.changeLocation(2,37,16);
		grid.changeLocation(2,38,14);

		grid.changeLocation(2,40,12);
		grid.changeLocation(2,41,12);
		grid.changeLocation(2,42,19);
		grid.changeLocation(2,43,19);
		grid.changeLocation(2,44,21);
		grid.changeLocation(2,45,21);
		grid.changeLocation(2,46,19);

		// Add notes for instrument 3 - twinkle third round
		grid.changeLocation(3,4,12);
		grid.changeLocation(3,5,12);
		grid.changeLocation(3,6,19);
		grid.changeLocation(3,7,19);
		grid.changeLocation(3,8,21);
		grid.changeLocation(3,9,21);
		grid.changeLocation(3,10,19);
		
		grid.changeLocation(3,12,17);
		grid.changeLocation(3,13,17);
		grid.changeLocation(3,14,16);
		grid.changeLocation(3,15,16);
		grid.changeLocation(3,16,14);
		grid.changeLocation(3,17,14);
		grid.changeLocation(3,18,12);
		
		grid.changeLocation(3,20,19);
		grid.changeLocation(3,21,19);
		grid.changeLocation(3,22,17);
		grid.changeLocation(3,23,17);
		grid.changeLocation(3,24,16);
		grid.changeLocation(3,25,16);
		grid.changeLocation(3,26,14);
		
		grid.changeLocation(3,28,19);
		grid.changeLocation(3,29,19);
		grid.changeLocation(3,30,17);
		grid.changeLocation(3,31,17);
		grid.changeLocation(3,32,16);
		grid.changeLocation(3,33,16);
		grid.changeLocation(3,34,14);

		grid.changeLocation(3,36,12);
		grid.changeLocation(3,37,12);
		grid.changeLocation(3,38,19);
		grid.changeLocation(3,39,19);
		grid.changeLocation(3,40,21);
		grid.changeLocation(3,41,21);
		grid.changeLocation(3,42,19);
		
		grid.changeLocation(3,44,17);
		grid.changeLocation(3,45,17);
		grid.changeLocation(3,46,16);
		grid.changeLocation(3,47,16);
		
		// Open up le GUI
		
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                JFrame window = new JFrame();
                window.setSize(1400, 810);
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


