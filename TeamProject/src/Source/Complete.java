package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.*;
public class Complete extends JFrame{
	private int sec=8; // 8sec
	private Calendar cal = Calendar.getInstance(); // Calendar
	private int year = cal.get(Calendar.YEAR); // ��
	private int month = cal.get(Calendar.MONDAY)+1; // ��
	private int date = cal.get(Calendar.DATE); // ��
	private int hour = cal.get(Calendar.HOUR); // ��
	private int minute = cal.get(Calendar.MINUTE); // ��
	private int second = cal.get(Calendar.SECOND); // ��
	public Complete() {
		setLayout(null);
		JLabel complete = new JLabel("������ �Ϸ�Ǿ����ϴ�.");
		complete.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,20));
		complete.setBounds(100, 100, 300, 100);
		complete.setOpaque(true);
		add(complete);
		
		// �����Ϸ� â�� ��¥ �� �ð� ǥ��
		JLabel now = new JLabel();
		now.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,20));
      	now.setBounds(100, 200, 300, 100);add(now);
		Timer timer = new Timer();
      	TimerTask task = new TimerTask() {
      		@Override
      		public void run() {
      			if (sec > 0) {
      				--sec;// 8�� ī��Ʈ
      				now.setText("<html>"+year+". "+month+". "+date+"<br>"+hour+" : "+minute+" : "+second+"</html>");
      			}
      			else if(sec==0) {
      				timer.cancel();
      				setVisible(false);
      	      		new start();
      			}
      		}
      	};
      	timer.schedule(task, 800,800);// 8�� �� ����,8�ʸ��� �ݺ�
		setTitle("���� �Ϸ�");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
