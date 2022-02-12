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
		JLabel complete = new JLabel("결제가 완료되었습니다.");
		complete.setFont(new Font("배달의민족 한나",Font.BOLD,20));
		complete.setBounds(100, 100, 300, 100);
		complete.setOpaque(true);
		add(complete);
		
		thread = new Thread(this);
		thread.start();
		// 결제완료 창에 날짜 및 시간 표시
		
		now.setFont(new Font("배달의민족 한나",Font.BOLD,20));
      	now.setBounds(100, 200, 300, 100);add(now);
		Timer timer = new Timer();
      	TimerTask task = new TimerTask() {
      		@Override
      		public void run() {
      			--sec;// 8초 카운트
      			if(sec==0) {
      				timer.cancel();
      				setVisible(false);
      	      		new Log();
      			}
      		}
      	};
      	timer.schedule(task, 1000,1000);// 8초 뒤 시작,8초마다 반복
		setTitle("결제 완료");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public void run() {
		while(sec>0) {
			Calendar cal = Calendar.getInstance(); // Calendar
			int year = cal.get(Calendar.YEAR); // 년
			int month = cal.get(Calendar.MONDAY)+1; // 월
			int date = cal.get(Calendar.DATE); // 일
			int hour = cal.get(Calendar.HOUR); // 시
			int minute = cal.get(Calendar.MINUTE); // 분
			int second = cal.get(Calendar.SECOND); // 초
			now.setText("<html>"+year+"년 "+month+"월 "+date+"일<br>"+hour+"시 : "+minute+"분 : "+second+" sec</html>");
			try {
				thread.sleep(1000);
			}catch (InterruptedException e) {}
		}
	}
}
