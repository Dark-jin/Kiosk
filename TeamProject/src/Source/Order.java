package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Order extends JFrame{
	TextArea ta;
	int sum;
	public Order(TextArea ta, int sum) {
		setLayout(null);
		this.ta=ta;
		this.sum=sum;
		ta.setVisible(true);
		ta.setBounds(0, 0, 750, 1000);
		ta.setFont(new Font("배달의민족 한나",Font.BOLD,20));
		ta.append("\n총 가격 : "+sum+" 원");
		add(ta);
		setTitle("주문");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
