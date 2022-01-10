package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class start extends JFrame{
	ImageIcon ordericon = new ImageIcon("images/order.png");
	Image img = ordericon.getImage();
	Image changeImg =img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
	ImageIcon changeordericon = new ImageIcon(changeImg);
	private Scar scar;
	public start()
	{
		setLayout(null);
		JButton orderbtn = new JButton();
		orderbtn.setIcon(changeordericon);
		orderbtn.setBounds(600, 300, 300, 300);
		orderbtn.setVisible(true);
		orderbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton btn = (JButton)e.getSource();
				btn.setVisible(false);
				scar = new Scar();
				setVisible(false);
			}
		});
		add(orderbtn);
		
		setTitle("키오스크");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new start();
	}
}
