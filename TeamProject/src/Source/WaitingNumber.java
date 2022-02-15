package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
public class WaitingNumber extends JDialog{
	private int sec=5; // 5sec
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
					ja.setText("    "+Integer.toString(rand.nextInt(30)+1));
					new Table();
				}
			}
		});
		add(btn);
		// JTextArea
		ja.setBounds(140, 200, 100, 50);
		ja.setFont(new Font("배달의민족 한나",Font.BOLD,30));
		ja.setForeground(Color.BLUE);
		add(ja);
		// Timer
		Timer timer = new Timer();
      	TimerTask task = new TimerTask() {
      		@Override
      		public void run() {
      			--sec;// 5초 카운트
      			if(sec==0) {
      				timer.cancel();
      				setVisible(false);
      			}
      		}
      	};
      	timer.schedule(task,1000,1000);
		setSize(400,400);
		setVisible(true);
	}
}
