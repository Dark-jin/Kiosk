package Source;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
class CardReceipt extends JDialog{
	private int nnextsum; // �� ���� ����
	private Calendar cal = Calendar.getInstance(); // Calendar
	private int year = cal.get(Calendar.YEAR); //��
	private int month = cal.get(Calendar.MONDAY)+1; //��
	private int date = cal.get(Calendar.DATE); //��
	private int hour = cal.get(Calendar.HOUR); //��
	private int minute = cal.get(Calendar.MINUTE); //��
	private int second = cal.get(Calendar.SECOND); // ��
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
		+"�ŷ� �Ͻ� : &nbsp;"+year+"��"+month+"��"+date+"��"+hour+"��"+minute+"��"+second+"��"+"<br>"
		+"ī�� ��ȣ : ******-******-****<br>"
		+"���� ��ȣ : 37468 - 474782 - 32<br>"
		+"======================================<br>"
		+"�հ� �ݾ� : &nbsp;"+ nnextsum + "��"
		+"</html>");
		
		la.setOpaque(true);
		add(la);
		setSize(300,300);
		setLocationRelativeTo(null);
	}
}
