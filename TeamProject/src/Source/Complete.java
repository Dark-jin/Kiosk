package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.*;
public class Complete extends JFrame{
	private int sec=5;
	private Calendar cal = Calendar.getInstance(); // Calendar
	private int year = cal.get(Calendar.YEAR); //��
	private int month = cal.get(Calendar.MONDAY)+1; //��
	private int date = cal.get(Calendar.DATE); //��
	private int hour = cal.get(Calendar.HOUR); //��
	private int minute = cal.get(Calendar.MINUTE); //��
	private int second = cal.get(Calendar.SECOND); // ��
	public Complete() {
		setLayout(null);
		JLabel complete = new JLabel("������ �Ϸ�Ǿ����ϴ�.");
		complete.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,40));
		complete.setBounds(550, 300, 500, 200);
		complete.setOpaque(true);
		add(complete);
		
		JLabel now = new JLabel();
		now.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,30));
      	now.setBounds(550, 500, 500, 200);add(now);
		Timer timer = new Timer();
      	TimerTask task = new TimerTask() {
      		@Override
      		public void run() {
      			if (sec > 0) {
      				--sec;//5�� ī��Ʈ
      				now.setText(year+". "+month+". "+date+". "+hour+". "+minute+". "+second+". ");
      			}
      			else if(sec==0) {
      				timer.cancel();
      				setVisible(false);
      	      		new start();
      			}
      		}
      	};
      	timer.schedule(task, 500,500);//5�� �� ����,5�ʸ��� �ݺ�
		setTitle("Ű����ũ");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
