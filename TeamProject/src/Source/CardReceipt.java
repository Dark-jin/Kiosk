package Source;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class CardReceipt extends JDialog{
	int nnextsum; // �� ���� ����
	String receipt;
	public CardReceipt(int nnextsume)
	{
		setTitle("Card Receipt");
		setLayout(null);
		//System.out.println(nnextsume);
		JLabel la = new JLabel();
		la.setText("[ ���� ]\n\n"+"\t"+"ī��� �ſ������ǥ (IC �ſ�)\n\n"+"=========================");
		la.setHorizontalAlignment(JLabel.CENTER);
		la.setOpaque(true);
		la.setBounds(300, 100, 1000, 100);
		add(la);
		setSize(800,800);
		setLocationRelativeTo(null);
	}
}
