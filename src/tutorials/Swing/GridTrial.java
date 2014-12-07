package tutorials.Swing;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Based off of response to the stackoverflow question
 * 	http://stackoverflow.com/questions/15870608/
 * 
 * @author MadProgrammer, Chloe Calvarin
 *
 */
public class GridTrial {

    public static class Grid extends JPanel implements MouseListener {
    	
    	private class PointAndCount {
    		private Point point;
    		private int count;
    		
    		public PointAndCount(Point p) {
    			point = p;
    			count = 1;
    		}
    		
    		public void incrementCount() {
    			count++;
    		}
    		
    		public int getX() {
    			return point.x;
    		}
    		
    		public int getY() {
    			return point.y;
    		}
    		
    		public int getCount() {
    			return count;
    		}
    		
    		/**
    		 * This equals method only checks if the points are the same,
    		 */
    		@Override
    		public boolean equals(Object obj) {
    			if (obj.getClass() == this.getClass()) {
    				PointAndCount pc = (PointAndCount)obj;
    				if (pc.getX() == point.x && pc.getY() == point.y) 
    					return true;
    				else
    					return false;
    			} else 
    				return false;
    		}
    	}
    	
        private List<PointAndCount> fillCells;
        
        private static int horizOffset = 10;
        private static int vertOffset = 10;
        private static int widthOfCell = 20;
        private static int heightOfCell = 25;
        private static int widthOfGrid = 800;
        private static int heightOfGrid = 500;
        
        public Grid() {
            fillCells = new ArrayList<PointAndCount>(25);
            addMouseListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(horizOffset, vertOffset, widthOfGrid, heightOfGrid);
            
            // Fill the cells that have been selected
            for (PointAndCount cell : fillCells) {
            	if (cell.getCount() == 1) {
            		paintWholeFilledCell(horizOffset + (cell.getX() * widthOfCell), vertOffset + (cell.getY() * heightOfCell), Color.RED, g);
            	} else {
            		paintTwoColoredCell(horizOffset + (cell.getX() * widthOfCell), vertOffset + (cell.getY() * heightOfCell), Color.BLUE, Color.ORANGE, g);
            	}
            	
            }
            
            // Overlay the outline of the rest of the grid
            g.setColor(Color.WHITE);
            g.drawRect(horizOffset, vertOffset, widthOfGrid, heightOfGrid);

            for (int i = horizOffset; i <= widthOfGrid; i += widthOfCell) {
                g.drawLine(i, vertOffset, i, heightOfGrid+vertOffset);
            }

            for (int i = vertOffset; i <= heightOfGrid; i += heightOfCell) {
                g.drawLine(horizOffset, i, widthOfGrid+horizOffset, i);
            }
        }

        /**
         * Add a rectangle to the specified position
         * 
         * @param x - x position in element to be painted
         * @param y - y position in element to be painted
         * @param c1 - color of the cell.
         * @param g
         */
        public void paintWholeFilledCell(int x, int y, Color c, Graphics g) {
        	g.setColor(c);
            g.fillRect(x, y, widthOfCell, heightOfCell);
        }
        
        /**
         * Add a rectangle filled with both specified colors to the specified position
         * 
         * @param x - x position in element to be painted
         * @param y - y position in element to be painted
         * @param c1 - color of first section
         * @param c2 - color of second section
         * @param g
         */
        public void paintTwoColoredCell(int x, int y, Color c1, Color c2, Graphics g) {
        	// Paint 1st half
        	g.setColor(c1);
            int x1points[] = {x, x+widthOfCell, x};
            int y1points[] = {y, y, y+heightOfCell};
            int npoints = 3;
            g.fillPolygon(x1points, y1points, npoints);
            
            // Paint 2nd half
        	g.setColor(c2);
            int x2points[] = {x, x+widthOfCell, x+widthOfCell};
            int y2points[] = {y+heightOfCell, y, y+heightOfCell};
            npoints = 3;
            g.fillPolygon(x2points, y2points, npoints);
        }

        /**	
         * If the cell has never been filled, this marks it as a cell to be filled,
         * otherwise, it marks it as a cell to be filled with more colors
         * 
         * @param x - the x index of cell to be filled
         * @param y - the y index of cell to be filled
         */
        public void fillCell(int x, int y) {
        	int index = fillCells.indexOf(new PointAndCount(new Point(x,y)));
        	if (index >= 0) {
        		System.out.println("ShouldBeIncrementingCount!");
        		fillCells.get(index).incrementCount();
        	} else {
        		fillCells.add(new PointAndCount(new Point(x,y)));
        	}
            
            repaint();
        }
        
		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			int x = (e.getX() - horizOffset) / widthOfCell;
			int y = (e.getY() - vertOffset) / heightOfCell;
			System.out.println("x = " + x + " and y = " + y);
			
			fillCell(x,y);
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

    }

    public static void main(String[] a) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                Grid grid = new Grid();
                JFrame window = new JFrame();
                window.setSize(840, 560);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(grid);
                window.setVisible(true);
            }
        });
    }
}
