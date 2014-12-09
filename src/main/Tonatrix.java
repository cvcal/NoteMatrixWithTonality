package main;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import jm.util.Play;

public class Tonatrix {

	public static void main(String[] a) {
		
		final Grid grid = new Grid(12,18);
		
		/*
		 * For now, this is a hack, it pre-defines the instruments, but you can play with 
		 * these instruments once you are in the GUI, you just cannot change them.
		 */
		// Define the 4 instruments
		grid.addInstrument(0,0);
		grid.addInstrument(1,4);
		grid.addInstrument(2,2);
		grid.addInstrument(3,3);
		
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
            }
        });
    }
}
