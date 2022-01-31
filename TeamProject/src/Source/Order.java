package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Order extends JFrame{
	TextArea ta;
	int sum;
	private JButton cardbtn = new JButton("카드 결제"); // 카드 결제 버튼
	private JButton cashbtn = new JButton("현금 결제"); // 현재 결제 버튼
	public Order(TextArea ta, int sum) {
		// 주문 내역
		setLayout(null);
		this.ta=ta;
		this.sum=sum;
		int nextsum = this.sum; // Card클래스로 총가격 넘기는 코드
		ta.setVisible(true);
		ta.setBounds(0, 0, 750, 1000);
		ta.setFont(new Font("배달의민족 한나",Font.BOLD,20));
		ta.append("\n총 가격 : "+sum+" 원");
		add(ta);
		// 카드 결제
		cardbtn.setBounds(1000, 100, 300, 100);
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
		cashbtn.setBounds(1000, 300, 300, 100);
		cashbtn.setFont(new Font("배달의민족 한나",1,20));
		cashbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Cash s = new Cash(ta.getText(),sum);
				s.setVisible(true);
			}
		});
		add(cashbtn);
		
		setTitle("주문");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
