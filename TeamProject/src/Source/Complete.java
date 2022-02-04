package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.*;
public class Complete extends JFrame{
	private int sec=8; // 8sec
	private Calendar cal = Calendar.getInstance(); // Calendar
	private int year = cal.get(Calendar.YEAR); // 년
	private int month = cal.get(Calendar.MONDAY)+1; // 월
	private int date = cal.get(Calendar.DATE); // 일
	private int hour = cal.get(Calendar.HOUR); // 시
	private int minute = cal.get(Calendar.MINUTE); // 분
	private int second = cal.get(Calendar.SECOND); // 초
	public Complete() {
		setLayout(null);
		JLabel complete = new JLabel("결제가 완료되었습니다.");
		complete.setFont(new Font("배달의민족 한나",Font.BOLD,20));
		complete.setBounds(100, 100, 300, 100);
		complete.setOpaque(true);
		add(complete);
		
		// 결제완료 창에 날짜 및 시간 표시
		JLabel now = new JLabel();
		now.setFont(new Font("배달의민족 한나",Font.BOLD,20));
      	now.setBounds(100, 200, 300, 100);add(now);
		Timer timer = new Timer();
      	TimerTask task = new TimerTask() {
      		@Override
      		public void run() {
      			if (sec > 0) {
      				--sec;// 8초 카운트
      				now.setText("<html>"+year+". "+month+". "+date+"<br>"+hour+" : "+minute+" : "+second+"</html>");
      			}
      			else if(sec==0) {
      				timer.cancel();
      				setVisible(false);
      	      		new start();
      			}
      		}
      	};
      	timer.schedule(task, 800,800);// 8초 뒤 시작,8초마다 반복
		setTitle("결제 완료");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
