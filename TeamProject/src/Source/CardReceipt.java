package Source;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class CardReceipt extends JDialog{
	private int nnextsum; // �� ���� ����
	public CardReceipt(int nnextsum)
	{
		this.nnextsum=nnextsum;
		setTitle("Card Receipt");
		
		JLabel la = new JLabel();
		
		la.setText("<html>"+"[ ���� ]<br><br>"+"ī��� �ſ������ǥ (IC �ſ�)<br>"
		+"======================================<br>"
		+"&nbsp;&nbsp;&nbsp;MC FOOD&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;12ȣ��<br>"
		+"����� , ������&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 070)111-2424<br>"
		+"���� ������ ���ﵿ 648-22 ����AŸ�� 2��<br>"+"======================================<br>"
		+"�ŷ� �Ͻ� : <br>"
		+"ī�� ��ȣ : ******-******-****<br>"
		+"���� ��ȣ : 37468 - 474782 - 32<br>"
		+"======================================<br>"
		+"�հ� �ݾ� : "+ nnextsum + " ��"
		+"</html>");
		
		la.setOpaque(true);
		add(la);
		setSize(300,300);
		setLocationRelativeTo(null);
	}
}
