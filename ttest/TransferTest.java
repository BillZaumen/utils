import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.bzdev.swing.SimpleConsole;
import org.bzdev.swing.DebugTransferHandler;

public class TransferTest {

    static void startGUI() {
	SimpleConsole tc = new SimpleConsole();
        JFrame frame = new JFrame("TextPane Test");
        Container fpane = frame.getContentPane();
	JTextField target = new JTextField("Drop Target");
        frame.addWindowListener(new WindowAdapter () {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        frame.setSize(700,400);
        JScrollPane scrollpane = new JScrollPane(tc);
        fpane.setLayout(new BorderLayout());
	
	fpane.add("North", target);
	TransferHandler th = target.getTransferHandler();
	target.setTransferHandler(new DebugTransferHandler(th,tc));
        fpane.add("Center", scrollpane);
        frame.setVisible(true);
    }


    public static void main(String argv[]) throws Exception {
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    TransferTest.startGUI();
		}
	    });
    }
}
