package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Order extends JDialog{
	TextArea ta;
	int sum;
	int count = 0;
	private JButton cardbtn = new JButton("ī�� ����"); // ī�� ���� ��ư
	private JButton cashbtn = new JButton("���� ����"); // ���� ���� ��ư
	private JLabel numla = new JLabel();
	private JLabel sumla = new JLabel();
	public Order(TextArea ta, int sum) {
		// �ֹ� ����
		setLayout(null);
		this.ta=ta;
		this.sum=sum;
		int nextsum = this.sum; // CardŬ������ �Ѱ��� �ѱ�� �ڵ�
		ta.setVisible(true);
		ta.setBounds(0, 0, 800, 300);
		ta.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,20));
		// �ֹ� ���� �� �� ����
		String ss = ta.getText();
		StringTokenizer st = new StringTokenizer(ss, "����");
		count = st.countTokens()-1;
		//ta.append("\n\n\n\n�� �ֹ� ���� : "+count+" ��");
		//ta.append("\n�� ���� : "+sum+" ��");
		add(ta);
		// �� ��ġ
		numla.setText("�� �ֹ� ���� : "+count+" ��");
		sumla.setText("�� ���� : "+sum+" ��");
		numla.setBounds(100, 400, 200, 50);
		numla.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,20));
		numla.setOpaque(true);
		sumla.setBounds(350, 400, 200, 50);
		sumla.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,20));
		sumla.setOpaque(true);
		add(numla); add(sumla);
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
