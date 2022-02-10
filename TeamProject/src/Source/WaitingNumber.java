package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class WaitingNumber extends JDialog{
	private JLabel la = new JLabel("대기 번호");
	private JButton btn = new JButton("발행");
	private JTextArea ja = new JTextArea();
	public WaitingNumber()
	{
		setTitle("대기 번호");
		setLayout(null);
		// 라벨 
		la.setBounds(120, 50, 200, 80);
		la.setFont(new Font("배달의민족 한나",Font.BOLD,30));
		la.setOpaque(true);
		add(la);
		// 버튼
		btn.setBounds(140, 130, 100, 50);
		btn.setFont(new Font("배달의민족 한나",1,20));
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
		ja.setFont(new Font("배달의민족 한나",Font.BOLD,30));
		ja.setForeground(Color.BLUE);
		add(ja);
		
		setSize(400,400);
		setVisible(true);
	}
}
