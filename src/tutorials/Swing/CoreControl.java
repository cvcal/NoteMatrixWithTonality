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
public class CoreControl {

    public static class Grid extends JPanel implements MouseListener {
	
        private List<Point> fillCells;
        
        private static int horizOffset = 10;
        private static int vertOffset = 10;
        private static int widthOfCell = 20;
        private static int heightOfCell = 25;
        private static int widthOfGrid = 800;
        private static int heightOfGrid = 500;
        
        public Grid() {
            fillCells = new ArrayList<Point>(25);
            addMouseListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(horizOffset, vertOffset, widthOfGrid, heightOfGrid);
            
            // Fill the cells that have been selected
            for (Point cell : fillCells) {
                int cellX = horizOffset + (cell.x * widthOfCell);
                int cellY = vertOffset + (cell.y * heightOfCell);
                g.setColor(Color.RED);
                g.fillRect(cellX, cellY, widthOfCell, heightOfCell);
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

        public void fillCell(int x, int y) {
            fillCells.add(new Point(x, y));
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
                grid.fillCell(0, 0);
                grid.fillCell(79, 0);
                grid.fillCell(0, 49);
                grid.fillCell(79, 49);
                grid.fillCell(39, 24);
            }
        });
    }
}
