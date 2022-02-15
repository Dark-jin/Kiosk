package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Order extends JDialog{
	TextArea ta;
	int sum;
	private JButton cardbtn = new JButton("ī�� ����"); // ī�� ���� ��ư
	private JButton cashbtn = new JButton("���� ����"); // ���� ���� ��ư
	public Order(TextArea ta, int sum) {
		// �ֹ� ����
		setLayout(null);
		this.ta=ta;
		this.sum=sum;
		int nextsum = this.sum; // CardŬ������ �Ѱ��� �ѱ�� �ڵ�
		ta.setVisible(true);
		ta.setBounds(0, 0, 800, 400);
		ta.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,20));
		ta.append("\n\n\n\n�� ���� : "+sum+" ��");
		add(ta);
		// ī�� ����
		cardbtn.setBounds(150, 600, 200, 80);
		cardbtn.setFont(new Font("����ǹ��� �ѳ�",1,20));
		cardbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				Card c=new Card(nextsum);
				c.setVisible(true);
			}
		});
		add(cardbtn);
		// ���� ����
		cashbtn.setBounds(450, 600, 200, 80);
		cashbtn.setFont(new Font("����ǹ��� �ѳ�",1,20));
		cashbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				Cash s = new Cash(ta.getText(),sum);
				s.setVisible(true);
			}
		});
		add(cashbtn);
		
		setTitle("�ֹ�");
		setSize(800,800);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
