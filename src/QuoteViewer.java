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
	JButton addQuote;
	JTextField txt;
	private static int currQIndex = 0;
	
	ArrayList quotes = new ArrayList<String>();
	
	QuoteViewer(){
		
		setLayout(new FlowLayout());
		
		this.btnNextQ = new JButton ("Next Quote");
		add(btnNextQ);

		this.addQuote = new JButton ("Add Quote");
		add(addQuote);

		txt = new JTextField(20);
		add(txt);
		
		this.btnNextQ.addActionListener(this);
		this.addQuote.addActionListener(this);
		addMouseMotionListener(this);
		
		quotes.add("Don't pee into the wind - My Dad");
		quotes.add("Don't get Covid - My Mom");
		quotes.add("I'm Batman - Batman");
		quotes.add("I'm the Joker baby - The Joker Baby");
		quotes.add("Woah! Hey guys, welcome to EB Games - EB Games Employee");
		quotes.add("Don't put me on the penny - Abe Lincoln");
		quotes.add("The trail of tears is a bad idea - Everyone except Andrew Jackson");
		quotes.add("Why the long face - The bartender talking to the horse");
		quotes.add("Pizza Pizza - Ceasar");
		quotes.add("The day of reckoning is coming - Papa John");
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
		else if (e.getSource() == addQuote){
			if (txt.getText().length()>0){
				quotes.add((String)(txt.getText()));
				txt.setText("");
				repaint();
			}
		}

	}

}
