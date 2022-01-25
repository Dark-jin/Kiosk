package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Cash extends JDialog{
	TextArea ta;
	int sum;
	private JButton moneybtn[] = new JButton[3]; // 오만원권 만원권 오천원권
	private String money[] = {"오만원권","만원권","오천원권"};
	public Cash(TextArea ta, int sum)
	{
		setTitle("Cash Payment");
		setLayout(null);
		
		JLabel la = new JLabel("*** 현금 결제 ***");
		la.setBounds(230, 20, 300, 50); la.setFont(new Font("배달의민족 한나", 1, 40));
		add(la);
		// 가격표
		this.ta=ta;
		this.sum=sum;
		ta.setVisible(true);
		ta.setBounds(0, 100, 300, 300);
		ta.setFont(new Font("배달의민족 한나",Font.BOLD,10));
		add(ta);
		// 돈 버튼
		for(int i =0; i<moneybtn.length; i++)
		{
			moneybtn[i] = new JButton(money[i]);
			moneybtn[i].setBounds(500, 100*(i+1), 200, 50);
			moneybtn[i].setFont(new Font("배달의민족 한나",1,20));
			add(moneybtn[i]);
		}
		
		setSize(800,800);
		setLocationRelativeTo(null);
	}
}
