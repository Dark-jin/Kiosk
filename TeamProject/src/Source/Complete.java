package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.*;
public class Complete extends JFrame implements Runnable{
	private int sec=8; // 8sec
	JLabel now = new JLabel();
	Thread thread;
	public Complete() {
		setLayout(null);
		JLabel complete = new JLabel("������ �Ϸ�Ǿ����ϴ�.");
		complete.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,20));
		complete.setBounds(100, 100, 300, 100);
		complete.setOpaque(true);
		add(complete);
		
		thread = new Thread(this);
		thread.start();
		// �����Ϸ� â�� ��¥ �� �ð� ǥ��
		
		now.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,20));
      	now.setBounds(100, 200, 300, 100);add(now);
		Timer timer = new Timer();
      	TimerTask task = new TimerTask() {
      		@Override
      		public void run() {
      			--sec;// 8�� ī��Ʈ
      			if(sec==0) {
      				timer.cancel();
      				setVisible(false);
      	      		new Log();
      			}
      		}
      	};
      	timer.schedule(task, 1000,1000);// 8�� �� ����,8�ʸ��� �ݺ�
		setTitle("���� �Ϸ�");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public void run() {
		while(sec>0) {
			Calendar cal = Calendar.getInstance(); // Calendar
			int year = cal.get(Calendar.YEAR); // ��
			int month = cal.get(Calendar.MONDAY)+1; // ��
			int date = cal.get(Calendar.DATE); // ��
			int hour = cal.get(Calendar.HOUR); // ��
			int minute = cal.get(Calendar.MINUTE); // ��
			int second = cal.get(Calendar.SECOND); // ��
			now.setText("<html>"+year+"�� "+month+"�� "+date+"��<br>"+hour+"�� : "+minute+"�� : "+second+" sec</html>");
			try {
				thread.sleep(1000);
			}catch (InterruptedException e) {}
		}
	}
}
