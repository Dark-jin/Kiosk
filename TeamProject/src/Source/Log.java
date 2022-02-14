package Source;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
public class Log extends JFrame{
	ImageIcon ordericon = new ImageIcon("images/order.png");
	Image img = ordericon.getImage();
	Image changeImg =img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
	ImageIcon changeordericon = new ImageIcon(changeImg);
	private JPanel panel;
	private int sec=5;
	private Scar scar;
	public Log() {
		panel = new MyPanel("images/first main.png");
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(0, -30, 1500, 1000);
		
		JLabel inOrder = new JLabel("매장주문");
		JButton orderbtn = new JButton();//매장식사
		orderbtn.setBackground(Color.WHITE);orderbtn.setBorderPainted(false);
		inOrder.setFont(new Font("배달의민족 한나",Font.BOLD,30)); inOrder.setBounds(410, 800, 200, 100);
		inOrder.setBackground(Color.white);inOrder.setOpaque(true);inOrder.setVisible(false);
		//**** 포장주문 ****//
		JLabel outOrder = new JLabel("포장주문");
		JButton orderbtn2 = new JButton();
		orderbtn2.setBackground(Color.WHITE);orderbtn2.setBorderPainted(false);
		outOrder.setFont(new Font("배달의민족 한나",Font.BOLD,30));outOrder.setBounds(910, 800, 200, 100);
		outOrder.setBackground(Color.white);outOrder.setOpaque(true);outOrder.setVisible(false);
		//**** 버튼 이미지 넣기 ****//
		orderbtn.setIcon(changeordericon);orderbtn2.setIcon(changeordericon);
		//**** 버튼 위치 조정 ****//
		orderbtn.setBounds(330, 500, 300, 300);orderbtn2.setBounds(830, 500, 300, 300);
		//****Visible True****//
		orderbtn.setVisible(false);orderbtn2.setVisible(false);
		//****매장 식사 액션 리스너 ****//
		orderbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton btn = (JButton)e.getSource();
				btn.setVisible(false);
				scar = new Scar();
				setVisible(false);
			}
		});
		//**** 포장 주문 액션 리스너 ****//
		orderbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton btn = (JButton)e.getSource();
				btn.setVisible(false);
				scar = new Scar();
				setVisible(false);
			}
		});
		//**** 액션 리스너 끝 ****//
		panel.add(orderbtn);panel.add(orderbtn2);
		panel.add(inOrder);panel.add(outOrder);
		add(panel);
		Timer timer = new Timer();
      	TimerTask task = new TimerTask() {
      		@Override
      		public void run() {
      			--sec;// 8초 카운트
      			if(sec==0) {
      				timer.cancel();
      				orderbtn.setVisible(true);orderbtn2.setVisible(true);
      				inOrder.setVisible(true);outOrder.setVisible(true);
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
