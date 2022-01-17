package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class start extends JFrame{
	ImageIcon ordericon = new ImageIcon("images/order.png");
	Image img = ordericon.getImage();
	Image changeImg =img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
	ImageIcon changeordericon = new ImageIcon(changeImg);
	private Scar scar;
	public start()
	{
		setLayout(null);
		//**** 매장주문 ****//
		JLabel inOrder = new JLabel("매장주문");
		JButton orderbtn = new JButton();//매장식사
		inOrder.setFont(new Font("배달의민족 한나",Font.BOLD,30)); inOrder.setBounds(410, 600, 200, 100);inOrder.setOpaque(true);;//Font 및 위치 조정
		//**** 포장주문 ****//
		JLabel outOrder = new JLabel("포장주문");
		JButton orderbtn2 = new JButton();
		outOrder.setFont(new Font("배달의민족 한나",Font.BOLD,30));outOrder.setBounds(910, 600, 200, 100);outOrder.setOpaque(true);;//Font 및 위치 조정
		//**** 버튼 이미지 넣기 ****//
		orderbtn.setIcon(changeordericon);orderbtn2.setIcon(changeordericon);
		//**** 버튼 위치 조정 ****//
		orderbtn.setBounds(330, 300, 300, 300);orderbtn2.setBounds(830, 300, 300, 300);
		//****Visible True****//
		orderbtn.setVisible(true);orderbtn2.setVisible(true);
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
		add(orderbtn);add(orderbtn2);
		add(inOrder);add(outOrder);
		setTitle("키오스크");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new start();
	}
}
