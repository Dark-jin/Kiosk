package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class WaitingNumber extends JDialog{
	private JLabel la = new JLabel("��� ��ȣ");
	private JButton btn = new JButton("����");
	private JTextArea ja = new JTextArea();
	public WaitingNumber()
	{
		setTitle("��� ��ȣ");
		setLayout(null);
		// �� 
		la.setBounds(120, 50, 200, 80);
		la.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,30));
		la.setOpaque(true);
		add(la);
		// ��ư
		btn.setBounds(140, 130, 100, 50);
		btn.setFont(new Font("����ǹ��� �ѳ�",1,20));
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Random rand = new Random();
				for(int i =0; i<10; i++)
				{
					ja.setText(Integer.toString(rand.nextInt(30)+1));
				}
			}
		});
		add(btn);
		// JTextArea
		ja.setBounds(140, 200, 100, 50);
		ja.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,30));
		ja.setForeground(Color.BLUE);
		add(ja);
		
		setSize(400,400);
		setVisible(true);
	}
}
