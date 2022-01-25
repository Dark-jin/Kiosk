package Source;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class CardReceipt extends JDialog{
	int nnextsum; // 총 가격 변수
	String receipt;
	public CardReceipt(int nnextsume)
	{
		setTitle("Card Receipt");
		setLayout(null);
		//System.out.println(nnextsume);
		JLabel la = new JLabel();
		la.setText("[ 고객용 ]\n\n"+"\t"+"카드사 신용매출전표 (IC 신용)\n\n"+"=========================");
		la.setHorizontalAlignment(JLabel.CENTER);
		la.setOpaque(true);
		la.setBounds(300, 100, 1000, 100);
		add(la);
		setSize(800,800);
		setLocationRelativeTo(null);
	}
}
