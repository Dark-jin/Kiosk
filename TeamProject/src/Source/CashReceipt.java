package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CashReceipt extends JDialog{
	JLabel topla = new JLabel("현금 영수증 발급");
	JLabel middlela = new JLabel("휴대폰 번호나 사업자 번호를 입력해주세요.");
	JLabel middleunderla = new JLabel("(발행하지 않으시려면 발행안함을 누르시오.)");
	
	JTextArea ja = new JTextArea();
	JButton numbtn[] = new JButton[12];
	String numname[] = {"1","2","3","4","5","6","7","8","9","-","0","Clear"};
	
	JButton clearbtn = new JButton("발행 안함");
	JButton okaybtn = new JButton("완료");
	public CashReceipt()
	{
		setTitle("Cash Receipt");
		setLayout(null);
		// 라벨
		topla.setBounds(110, 30, 300, 50);
		topla.setFont(new Font("배달의민족 한나",1,30));
		middlela.setBounds(120, 90, 330, 30);
		middlela.setFont(new Font("배달의민족 한나",1,15));
		middleunderla.setBounds(130, 130, 300, 30);
		middleunderla.setFont(new Font("배달의민족 한나",1,10));
		add(topla);add(middlela);add(middleunderla);
		//휴대전화
		ja.setBounds(140, 250, 200, 30);
		ja.setFont(new Font("배달의민족 한나",1,20));
		add(ja);
		for(int i =0; i<numbtn.length; i++)
		{
			if(i<3)
			{
				numbtn[i] = new JButton(numname[i]);
				numbtn[i].setBounds(70+(i+1)*70, 300, 60, 40);
			}
			else if(i>2&&i<6)
			{
				numbtn[i] = new JButton(numname[i]);
				numbtn[i].setBounds(70+(i-2)*70, 350, 60, 40);
			}
			else if(i>5&&i<9)
			{
				numbtn[i] = new JButton(numname[i]);
				numbtn[i].setBounds(70+(i-5)*70, 400, 60, 40);
			}
			else
			{
				numbtn[i] = new JButton(numname[i]);
				numbtn[i].setBounds(63+(i-8)*75, 450, 65, 40);
			}
			numbtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getActionCommand()=="1") {ja.append("1");}
					else if(e.getActionCommand()=="2") {ja.append("2");}
					else if(e.getActionCommand()=="3") {ja.append("3");}
					else if(e.getActionCommand()=="4") {ja.append("4");}
					else if(e.getActionCommand()=="5") {ja.append("5");}
					else if(e.getActionCommand()=="6") {ja.append("6");}
					else if(e.getActionCommand()=="7") {ja.append("7");}
					else if(e.getActionCommand()=="8") {ja.append("8");}
					else if(e.getActionCommand()=="9") {ja.append("9");}
					else if(e.getActionCommand()=="-") {ja.append("-");}
					else if(e.getActionCommand()=="0") {ja.append("0");}
					else {ja.append("");}
				}
			});
			add(numbtn[i]);
		}
		//나머지 버튼
		clearbtn.setBounds(100, 650, 100, 50);
		clearbtn.setFont(new Font("배달의민족 한나",1,10));
		okaybtn.setBounds(300, 650, 100, 50);
		okaybtn.setFont(new Font("배달의민족 한나",1,10));
		add(clearbtn);add(okaybtn);
		
		setSize(500,800);
		setLocationRelativeTo(null);
	}
}
