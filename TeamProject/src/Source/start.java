package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class start extends JPanel{
	ImageIcon ordericon = new ImageIcon("images/order.png");
	Image img = ordericon.getImage();
	Image changeImg =img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
	ImageIcon changeordericon = new ImageIcon(changeImg);
	private Simba win;
	public start(Simba win)
	{
		this.win =win;
		setLayout(null);
		JButton orderbtn = new JButton();
		orderbtn.setIcon(changeordericon);
		orderbtn.setBounds(600, 300, 300, 300);
		orderbtn.setVisible(true);
		orderbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton)e.getSource();
				btn.setVisible(false);
				win.change("start");		
			}
		});
		add(orderbtn);
	}
}
