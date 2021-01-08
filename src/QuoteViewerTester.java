import java.awt.*;

import javax.swing.JFrame;
public class QuoteViewerTester {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		QuoteViewer qv = new QuoteViewer();
		frame.add(qv);
		frame.setSize(1000,1000);
		frame.setVisible(true);
	}

}
