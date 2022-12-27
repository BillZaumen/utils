import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.bzdev.swing.SimpleConsole;
import org.bzdev.swing.DebugTransferHandler;

public class TransferTest {

    static void startGUI(boolean mode) {
	SimpleConsole tc = new SimpleConsole();
        JFrame frame = new JFrame("TextPane Test");
        Container fpane = frame.getContentPane();
	JTextField target = new JTextField("Drop Target");
	if (mode) target.setEditable(false);
	target .setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        frame.addWindowListener(new WindowAdapter () {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        frame.setPreferredSize(new Dimension(700,400));
        JScrollPane scrollpane = new JScrollPane(tc);
        fpane.setLayout(new BorderLayout());
	
	fpane.add("North", target);
	TransferHandler th = target.getTransferHandler();
	target.setTransferHandler(mode?new DebugTransferHandler(tc):
				  new DebugTransferHandler(th,tc));
        fpane.add("Center", scrollpane);
	frame.pack();
        frame.setVisible(true);
    }


    public static void main(String argv[]) throws Exception {
	final boolean mode = (argv.length > 0)
	    && argv[0].equals("default");
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    TransferTest.startGUI(mode);
		}
	    });
    }
}
