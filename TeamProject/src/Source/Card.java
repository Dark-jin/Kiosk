package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Card extends JDialog
{
	JButton okbtn = new JButton("Ȯ ��"); // Ȯ�� ��ư
	JTextField tf = new JTextField("******-******-****");
	public Card()
	{
		setTitle("Card Payment");
		setLayout(null);
		// ī�� �Ϸ� ��ȣ //
		tf.setBounds(70, 80, 150, 30); // ��ġ�� ���߿� ����
		tf.setFont(new Font("����ǹ��� �ѳ�",1,20));
		add(tf);
		// Ȯ�� ��ư //
		okbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		okbtn.setBounds(100, 150, 100, 50); // ��ġ�� ���߿� ����
		okbtn.setFont(new Font("����ǹ��� �ѳ�",1,20));
		add(okbtn);
		setSize(300,300);
		setLocationRelativeTo(null);
	}
}
