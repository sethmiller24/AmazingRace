import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
public class QuoteViewer extends javax.swing.JComponent implements MouseMotionListener, ActionListener{
	int x = 100, y = 100;
	JButton btnNextQ;
	private static int currQIndex = 0;
	ArrayList quotes = new ArrayList<String>();
	
	QuoteViewer(){
		
		setLayout(new FlowLayout());
		
		this.btnNextQ = new JButton ("Next Quote");
		add(btnNextQ);
		
		this.btnNextQ.addActionListener(this);
		addMouseMotionListener(this);
		
		for (int i = 1; i<=10; i++) {
			quotes.add("Default Quote "+i);
		}
	}
	
	public void paintComponent (Graphics g) {
		g.drawString((String) quotes.get(currQIndex++), x, y);
		if(currQIndex >= quotes.size())
			currQIndex = 0;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnNextQ)
			repaint();
		
	}

}
