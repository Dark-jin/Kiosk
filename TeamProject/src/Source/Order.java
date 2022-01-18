package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Order extends JFrame{
	TextArea ta;
	public Order(TextArea ta) {
		this.ta=ta;
		ta.setVisible(true);
		ta.setBounds(300, 0, 500, 500);
		ta.setFont(new Font("배달의민족 한나",Font.BOLD,20));
		add(ta);
		
		setTitle("주문");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
