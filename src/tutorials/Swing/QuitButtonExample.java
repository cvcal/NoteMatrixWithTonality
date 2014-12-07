package tutorials.Swing;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * http://zetcode.com/tutorials/javaswingtutorial/firstprograms/
 * @author zetcode
 */
public class QuitButtonExample extends JFrame {

	// We position a JButton on the window. We will add an action listener to this button.
    public QuitButtonExample() {

        initUI();
    }

    private void initUI() {
    	/* 
    	 * The content pane of a JFrame is an area where child components are placed. 
    	 * The children are organized by specialized non-visible components called 
    	 * layout managers. The default layout manager of a content pane is the 
    	 * BorderLayout manager. This manager is very simple and is useful only in 
    	 * certain cases. In this tutorial, we use the GroupLayout manager which is 
    	 * more powerful and flexible.
    	 */
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        JButton quitButton = new JButton("Quit");

        quitButton.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        /*
         * GroupLayout manager defines the layout for each dimension independently. 
         * In one step, we lay out components alongside the horizontal axis; in the 
         * other step, we lay out components along the vertical axis. In both kinds 
         * of layouts we can arrange components sequentially or in parallel. In a 
         * horizontal layout, a row of components is called a sequential group and a 
         * column of components is called a parallel group. In a vertical layout, a 
         * column of components is called a sequential group and a row of components 
         * a parallel group.
         */
        gl.setAutoCreateContainerGaps(true);
        
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(quitButton)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(quitButton)
        );
        
        pack();

        setTitle("Quit button");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            //@Override
            public void run() {
                QuitButtonExample ex = new QuitButtonExample();
                ex.setVisible(true);
            }
        });
    }
}