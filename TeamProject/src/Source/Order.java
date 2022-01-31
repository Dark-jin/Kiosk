package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Order extends JFrame{
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
		ta.setBounds(0, 0, 750, 1000);
		ta.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,20));
		ta.append("\n�� ���� : "+sum+" ��");
		add(ta);
		// ī�� ����
		cardbtn.setBounds(1000, 100, 300, 100);
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
		cashbtn.setBounds(1000, 300, 300, 100);
		cashbtn.setFont(new Font("����ǹ��� �ѳ�",1,20));
		cashbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Cash s = new Cash(ta.getText(),sum);
				s.setVisible(true);
			}
		});
		add(cashbtn);
		
		setTitle("�ֹ�");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
