package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Card extends JDialog
{
	int nextsume;
	
	JButton okbtn = new JButton("Ȯ ��"); // Ȯ�� ��ư
	JTextField tf = new JTextField("******-******-****");
	public Card(int nextsume)
	{
		setTitle("Card Payment");
		setLayout(null);
		int nnextsume = nextsume; // ī�� ������ Ŭ������ �� ���� �ѱ�� �ڵ�
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
				new Complete();
				new WaitingNumber();
				CardReceipt rc = new CardReceipt(nnextsume);
				rc.setVisible(true);
				}
			
		});
		okbtn.setBounds(95, 150, 100, 50); // ��ġ�� ���߿� ����
		okbtn.setFont(new Font("����ǹ��� �ѳ�",1,20));
		add(okbtn);
		setSize(300,300);
		setLocationRelativeTo(null);
	}
}
