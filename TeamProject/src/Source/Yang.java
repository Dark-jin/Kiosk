package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Yang extends JFrame{
	
	public Yang() {
		setLayout(null);
		JLabel la = new JLabel("hi");
		la.setBounds(100,100,500,500);
		la.setVisible(true);
		la.setOpaque(true);
		add(la);
		
		
		setTitle("키오스크");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
