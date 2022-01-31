package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.*;
public class Complete extends JFrame{
	private int sec=5;
	private Calendar cal = Calendar.getInstance(); // Calendar
	private int year = cal.get(Calendar.YEAR); //년
	private int month = cal.get(Calendar.MONDAY)+1; //월
	private int date = cal.get(Calendar.DATE); //일
	private int hour = cal.get(Calendar.HOUR); //시
	private int minute = cal.get(Calendar.MINUTE); //분
	private int second = cal.get(Calendar.SECOND); // 초
	public Complete() {
		setLayout(null);
		JLabel complete = new JLabel("결제가 완료되었습니다.");
		complete.setFont(new Font("배달의민족 한나",Font.BOLD,40));
		complete.setBounds(550, 300, 500, 200);
		complete.setOpaque(true);
		add(complete);
		
		JLabel now = new JLabel();
		now.setFont(new Font("배달의민족 한나",Font.BOLD,30));
      	now.setBounds(550, 500, 500, 200);add(now);
		Timer timer = new Timer();
      	TimerTask task = new TimerTask() {
      		@Override
      		public void run() {
      			if (sec > 0) {
      				--sec;//5초 카운트
      				now.setText(year+". "+month+". "+date+". "+hour+". "+minute+". "+second+". ");
      			}
      			else if(sec==0) {
      				timer.cancel();
      				setVisible(false);
      	      		new start();
      			}
      		}
      	};
      	timer.schedule(task, 500,500);//5초 뒤 시작,5초마다 반복
		setTitle("키오스크");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
