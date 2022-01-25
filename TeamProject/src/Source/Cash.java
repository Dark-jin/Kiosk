package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Cash extends JDialog{
	TextArea ta;
	int sum;
	private JButton moneybtn[] = new JButton[3]; // �������� ������ ��õ����
	private String money[] = {"��������","������","��õ����"};
	public Cash(TextArea ta, int sum)
	{
		setTitle("Cash Payment");
		setLayout(null);
		
		JLabel la = new JLabel("*** ���� ���� ***");
		la.setBounds(230, 20, 300, 50); la.setFont(new Font("����ǹ��� �ѳ�", 1, 40));
		add(la);
		// ����ǥ
		this.ta=ta;
		this.sum=sum;
		ta.setVisible(true);
		ta.setBounds(0, 100, 300, 300);
		ta.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,10));
		add(ta);
		// �� ��ư
		for(int i =0; i<moneybtn.length; i++)
		{
			moneybtn[i] = new JButton(money[i]);
			moneybtn[i].setBounds(500, 100*(i+1), 200, 50);
			moneybtn[i].setFont(new Font("����ǹ��� �ѳ�",1,20));
			add(moneybtn[i]);
		}
		
		setSize(800,800);
		setLocationRelativeTo(null);
	}
}
