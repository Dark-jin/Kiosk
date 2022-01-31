package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Cash extends JDialog{
	TextArea ta;
	JTextField jf;
	int sum;
	private JButton moneybtn[] = new JButton[3]; // �������� ������ ��õ����
	private String money[] = {"��������","������","��õ����"};
	private int aCount [] = {50000,10000,5000};
	private int change=0;
	public Cash(String taGetText, int sum)
	{
		setTitle("Cash Payment");
		setLayout(null);	
		//**** ta,jf ���� *****//
		ta=new TextArea();
		ta.setText(taGetText);
		this.sum=sum;
		jf=new JTextField("0");
		jf.setBounds(370,200, 100,50);
		jf.setFont(new Font("����ǹ��� �ѳ�",1,15));
		//*****�� �ޱ�******//
		JLabel la = new JLabel("*** ���� ���� ***");
		la.setBounds(230, 20, 300, 50); la.setFont(new Font("����ǹ��� �ѳ�", 1, 40));
		//*****����,��ȯ �ݾ� ��*****//
		JLabel inputM = new JLabel("���Աݾ� : ");
		inputM.setBounds(270,200, 100,50);
		inputM.setFont(new Font("����ǹ��� �ѳ�",1,17));
		JLabel outputM = new JLabel("�ܵ� : ");
		outputM.setBounds(270,350, 300,50);
		outputM.setFont(new Font("����ǹ��� �ѳ�",1,20));
		//*****Dialog add*****//
		add(la);add(jf);add(inputM);add(outputM);
		// ����ǥ
		ta.setVisible(true);
		ta.setBounds(0, 100, 250, 250);
		ta.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,20));
		add(ta);
		// �� ��ư
		for(int i =0; i<moneybtn.length; i++)
		{
			moneybtn[i] = new JButton(money[i]);
			moneybtn[i].setBounds(500, 100*(i+1), 200, 50);
			moneybtn[i].setFont(new Font("����ǹ��� �ѳ�",1,20));
			moneybtn[i].setText(money[i]);
			add(moneybtn[i]);
			moneybtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton)e.getSource();
					int num = getButtonIndex(btn);
					change+=aCount[num];
					jf.setText(Integer.toString(change));
					if(change>=sum) outputM.setText("�ܵ� : "+(change-sum));
					else outputM.setText("���Աݾ��� �����մϴ�.");
				}
			});
		}
		// ���� ������ ��ư
		JButton receipt = new JButton("���� ������");
		receipt.setBounds(500, 400, 200, 30);
		receipt.setFont(new Font("����ǹ��� �ѳ�",1,20));
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
