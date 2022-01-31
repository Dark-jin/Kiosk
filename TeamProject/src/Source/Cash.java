package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Cash extends JDialog{
	TextArea ta;
	JTextField jf;
	int sum;
	private JButton moneybtn[] = new JButton[3]; // 오만원권 만원권 오천원권
	private String money[] = {"오만원권","만원권","오천원권"};
	private int aCount [] = {50000,10000,5000};
	private int change=0;
	public Cash(String taGetText, int sum)
	{
		setTitle("Cash Payment");
		setLayout(null);	
		//**** ta,jf 설정 *****//
		ta=new TextArea();
		ta.setText(taGetText);
		this.sum=sum;
		jf=new JTextField("0");
		jf.setBounds(370,200, 100,50);
		jf.setFont(new Font("배달의민족 한나",1,15));
		//*****라벨 달기******//
		JLabel la = new JLabel("*** 현금 결제 ***");
		la.setBounds(230, 20, 300, 50); la.setFont(new Font("배달의민족 한나", 1, 40));
		//*****투입,반환 금액 라벨*****//
		JLabel inputM = new JLabel("투입금액 : ");
		inputM.setBounds(270,200, 100,50);
		inputM.setFont(new Font("배달의민족 한나",1,17));
		JLabel outputM = new JLabel("잔돈 : ");
		outputM.setBounds(270,350, 300,50);
		outputM.setFont(new Font("배달의민족 한나",1,20));
		//*****Dialog add*****//
		add(la);add(jf);add(inputM);add(outputM);
		// 가격표
		ta.setVisible(true);
		ta.setBounds(0, 100, 250, 250);
		ta.setFont(new Font("배달의민족 한나",Font.BOLD,20));
		add(ta);
		// 돈 버튼
		for(int i =0; i<moneybtn.length; i++)
		{
			moneybtn[i] = new JButton(money[i]);
			moneybtn[i].setBounds(500, 100*(i+1), 200, 50);
			moneybtn[i].setFont(new Font("배달의민족 한나",1,20));
			moneybtn[i].setText(money[i]);
			add(moneybtn[i]);
			moneybtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton)e.getSource();
					int num = getButtonIndex(btn);
					change+=aCount[num];
					jf.setText(Integer.toString(change));
					if(change>=sum) outputM.setText("잔돈 : "+(change-sum));
					else outputM.setText("투입금액이 부족합니다.");
				}
			});
		}
		// 현금 영수증 버튼
		JButton receipt = new JButton("현금 영수증");
		receipt.setBounds(500, 400, 200, 30);
		receipt.setFont(new Font("배달의민족 한나",1,20));
		receipt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				CashReceipt cashr = new CashReceipt();
				cashr.setVisible(true);
			}
		});
		add(receipt);
		
		setSize(800,500);
		setLocationRelativeTo(null);
	} 
	public int getButtonIndex(JButton button){
	       int num = 0;
	       for(int i =0; i<moneybtn.length; i++){
	          if(moneybtn[i] == button){
	             num = i;
	          }
	       }
	       return num;
	    }
}
