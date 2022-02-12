package Source;
import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
public class Log extends JFrame{
	private JPanel panel;
	private int sec=5;
	public Log() {
		panel = new MyPanel("images/first main.png");
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(0, -30, 1500, 1000);
		add(panel);
		
		Timer timer = new Timer();
      	TimerTask task = new TimerTask() {
      		@Override
      		public void run() {
      			--sec;// 8초 카운트
      			if(sec==0) {
      				timer.cancel();
      				setVisible(false);
      	      		new start();
      			}
      		}
      	};
      	timer.schedule(task, 1000,1000);// 8초 뒤 시작,8초마다 반복
		setTitle("MC FOOD 키오스크");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	class MyPanel extends JPanel {//이미지 변환을 위한 패널
		Image image;

		MyPanel(String img) {
			image = Toolkit.getDefaultToolkit().createImage(img);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (image != null) {
				g.drawImage(image, 0, 0, this);
			}
		}

		public void update(Graphics g) {
			paintComponent(g);
		}

	}// 마이패널 종료
	public static void main(String[] args) {
		new Log();
	}
}
