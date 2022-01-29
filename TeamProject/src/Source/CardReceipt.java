package Source;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
class CardReceipt extends JDialog{
	private int nnextsum; // 총 가격 변수
	private Calendar cal = Calendar.getInstance(); // Calendar
	private int year = cal.get(Calendar.YEAR); //년
	private int month = cal.get(Calendar.MONDAY)+1; //월
	private int date = cal.get(Calendar.DATE); //일
	private int hour = cal.get(Calendar.HOUR); //시
	private int minute = cal.get(Calendar.MINUTE); //분
	private int second = cal.get(Calendar.SECOND); // 초
	public CardReceipt(int nnextsum)
	{
		
		this.nnextsum=nnextsum;
		setTitle("Card Receipt");
		
		JLabel la = new JLabel();
		
		la.setText("<html>"+"[ 고객용 ]<br><br>"+"카드사 신용매출전표 (IC 신용)<br>"
		+"======================================<br>"
		+"&nbsp;&nbsp;&nbsp;MC FOOD&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;12호점<br>"
		+"문상원 , 최진서&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 070)111-2424<br>"
		+"서울 강남구 역삼동 648-22 역삼A타워 2층<br>"+"======================================<br>"
		+"거래 일시 : &nbsp;"+year+"년"+month+"월"+date+"일"+hour+"시"+minute+"분"+second+"초"+"<br>"
		+"카드 번호 : ******-******-****<br>"
		+"승인 번호 : 37468 - 474782 - 32<br>"
		+"======================================<br>"
		+"합계 금액 : &nbsp;"+ nnextsum + "원"
		+"</html>");
		
		la.setOpaque(true);
		add(la);
		setSize(300,300);
		setLocationRelativeTo(null);
	}
}
