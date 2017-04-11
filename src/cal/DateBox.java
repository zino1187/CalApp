package cal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DateBox extends JPanel{
	JLabel la;
	
	public DateBox(String text) {
		la=new JLabel(text);
		la.setFont(new Font("±¼¸²", Font.BOLD|Font.ITALIC, 18));
		add(la);
		setPreferredSize(new Dimension(100, 100));
		setBackground(Color.YELLOW);
	}
	
}
