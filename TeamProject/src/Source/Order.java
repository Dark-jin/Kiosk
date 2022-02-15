package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Order extends JDialog{
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
		ta.setBounds(0, 0, 800, 400);
		ta.setFont(new Font("배달의민족 한나",Font.BOLD,20));
		ta.append("\n\n\n\n총 가격 : "+sum+" 원");
		add(ta);
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
