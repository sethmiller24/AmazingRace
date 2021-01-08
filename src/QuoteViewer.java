import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.font.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
public class QuoteViewer extends javax.swing.JComponent implements MouseMotionListener, ActionListener{
	int x = 100, y = 100;
	//button to rotate through quotes
	JButton btnNextQ;
	JButton btnPrevQ;
	//button to commit/add a new quote from the text box
	JButton addQuote;
	//text box to add new quotes
	JTextField txt;
	//counter to track which index of quotes it is currently displaying
	private static int currQIndex = 0;
	
	//Storage for the quotes
	private ArrayList quotes = new ArrayList<String>();
	
	static Color[] colorwheel = {Color.red, Color.orange, Color.MAGENTA};


	QuoteViewer(){
		
		setLayout(new FlowLayout());
		
		this.btnNextQ = new JButton (new ImageIcon("next-white.jpg"));
		add(btnNextQ);

		this.btnPrevQ = new JButton (new ImageIcon("previous_3.jpg"));
		add(btnPrevQ);

		this.addQuote = new JButton ("Add Quote");
		add(addQuote);

		txt = new JTextField(20);
		add(txt);
		
		this.btnNextQ.addActionListener(this);
		this.btnPrevQ.addActionListener(this);
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
		//for each repaint, this will rotate to the next quote in the array
		//will cycle through colors
		//will cycle through font sizes
		g.setColor(colorwheel[currQIndex%3]);
		g.setFont(new Font("Serif",Font.BOLD,((currQIndex%3)+2)*10));
		g.drawString((String) quotes.get(currQIndex), x, y);
		
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
		if (e.getSource()==btnNextQ){
			if(currQIndex<(quotes.size()-1))
				currQIndex++;
			repaint();
		}else if(e.getSource()==btnPrevQ){
			if(currQIndex>0)
				--currQIndex;
			repaint();
		}else if (e.getSource() == addQuote){
			if (txt.getText().length()>0){
				quotes.add((String)(txt.getText()));
				txt.setText("");
				repaint();
			}
		}

	}

}
