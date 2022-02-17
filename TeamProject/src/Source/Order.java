package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Order extends JDialog{
	TextArea ta;
	int sum;
	int count = 0;
	private JButton cardbtn = new JButton("카드 결제"); // 카드 결제 버튼
	private JButton cashbtn = new JButton("현금 결제"); // 현재 결제 버튼
	private JLabel numla = new JLabel();
	private JLabel sumla = new JLabel();
	public Order(TextArea ta, int sum) {
		// 주문 내역
		setLayout(null);
		this.ta=ta;
		this.sum=sum;
		int nextsum = this.sum; // Card클래스로 총가격 넘기는 코드
		ta.setVisible(true);
		ta.setBounds(0, 0, 800, 300);
		ta.setFont(new Font("배달의민족 한나",Font.BOLD,20));
		// 주문 수량 및 총 가격
		String ss = ta.getText();
		StringTokenizer st = new StringTokenizer(ss, "가격");
		count = st.countTokens()-1;
		//ta.append("\n\n\n\n총 주문 수량 : "+count+" 개");
		//ta.append("\n총 가격 : "+sum+" 원");
		add(ta);
		// 라벨 위치
		numla.setText("총 주문 수량 : "+count+" 개");
		sumla.setText("총 가격 : "+sum+" 원");
		numla.setBounds(100, 400, 200, 50);
		numla.setFont(new Font("배달의민족 한나",Font.BOLD,20));
		numla.setOpaque(true);
		sumla.setBounds(350, 400, 200, 50);
		sumla.setFont(new Font("배달의민족 한나",Font.BOLD,20));
		sumla.setOpaque(true);
		add(numla); add(sumla);
		// 카드 결제
		cardbtn.setBounds(150, 600, 200, 80);
		cardbtn.setFont(new Font("배달의민족 한나",1,20));
		cardbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				Card c=new Card(nextsum);
				c.setVisible(true);
			}
		});
		add(cardbtn);
		// 현금 결제
		cashbtn.setBounds(450, 600, 200, 80);
		cashbtn.setFont(new Font("배달의민족 한나",1,20));
		cashbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				Cash s = new Cash(ta.getText(),sum);
				s.setVisible(true);
			}
		});
		add(cashbtn);
		
		setTitle("주문");
		setSize(800,800);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
