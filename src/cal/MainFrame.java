package cal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{
	JPanel p_north;
	JPanel p_center;
	JLabel la_north;
	JButton bt_prev, bt_next;
	
	DateBox[] box=new DateBox[42];
	Calendar cal=Calendar.getInstance();
	
	int yy;
	int mm;
	int dd;
	
	public MainFrame() {
		
		p_north = new JPanel();
		p_center = new JPanel();
		la_north = new JLabel();
		bt_prev = new JButton("◀");
		bt_next = new JButton("▶");
		la_north.setFont(new Font("돋움", Font.BOLD, 30));
		
		p_north.add(bt_prev);
		p_north.add(la_north);
		p_north.add(bt_next);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		
		yy=cal.get(Calendar.YEAR);
		mm=cal.get(Calendar.MONTH);
		dd=cal.get(Calendar.DATE);
		
		printDate(yy,mm,dd);
		
		setSize(800,750);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void printDate(int yy, int mm, int dd){
		
		//기존에 등록된 컴포넌트 제거 
		p_center.removeAll();
		
		la_north.setText(yy+"-"+(mm+1)+"-"+dd);
		
		/*----------------------------------------------
		 해당 월의 시작 index
		 ----------------------------------------------*/  
		cal.set(yy, mm, 1); //1일로 맞춤 
		int firstDay=cal.get(Calendar.DAY_OF_WEEK);
		
		/*----------------------------------------------
		 해당 월의 총 일수
		 ----------------------------------------------*/
		cal.set(yy, mm+1, 0); //1일로 맞춤
		int lastDay=cal.get(Calendar.DATE);
		
		int n=0;
		for(int i=0;i<box.length;i++){
			if(i >= firstDay-1){
				n++;
			}else{
				n=0;
			}
			
			if(n!=0){
				if(n<=lastDay){
					box[i] = new DateBox(Integer.toString(n));
				}else{
					box[i] = new DateBox("");
				}
			}else{
				box[i] = new DateBox("");
			}
			p_center.add(box[i]);
		}
		
	}
	
	public void prev(){
		mm--;
		
		if(mm<0){
			mm=11;
			yy--;
		}
		printDate(yy, mm, dd);
	}
	
	public void next(){
		mm++;
		
		if(mm>=12){
			mm=0;
			yy++;
		}
		printDate(yy, mm, dd);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj == bt_prev){
			prev();
		}else if(obj ==bt_next){
			next();
		}
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}

