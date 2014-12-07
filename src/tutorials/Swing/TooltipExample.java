package tutorials.Swing;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * http://zetcode.com/tutorials/javaswingtutorial/firstprograms/
 * @author zetcode
 */
public class TooltipExample extends JFrame {

    public TooltipExample() {
        
        initUI();
    }

    private void initUI() {

        JPanel pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        
        pane.setToolTipText("Content pane");

        JButton btn = new JButton("Button");
        btn.setToolTipText("click this, it won't do much");

        gl.setAutoCreateContainerGaps(true);
        
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(btn)
                .addGap(200)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(btn)
                .addGap(120)
        );
        
        pack();

        setTitle("Tooltip");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            //@Override
            public void run() {
                TooltipExample ex = new TooltipExample();
                ex.setVisible(true);
            }
        });
    }
}