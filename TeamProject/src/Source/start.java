package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class start extends JFrame{
	ImageIcon ordericon = new ImageIcon("images/order.png");
	Image img = ordericon.getImage();
	Image changeImg =img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
	ImageIcon changeordericon = new ImageIcon(changeImg);
	private Scar scar;
	public start()
	{
		setLayout(null);
		//**** �����ֹ� ****//
		JLabel inOrder = new JLabel("�����ֹ�");
		JButton orderbtn = new JButton();//����Ļ�
		inOrder.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,30)); inOrder.setBounds(410, 600, 200, 100);inOrder.setOpaque(true);;//Font �� ��ġ ����
		//**** �����ֹ� ****//
		JLabel outOrder = new JLabel("�����ֹ�");
		JButton orderbtn2 = new JButton();
		outOrder.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,30));outOrder.setBounds(910, 600, 200, 100);outOrder.setOpaque(true);;//Font �� ��ġ ����
		//**** ��ư �̹��� �ֱ� ****//
		orderbtn.setIcon(changeordericon);orderbtn2.setIcon(changeordericon);
		//**** ��ư ��ġ ���� ****//
		orderbtn.setBounds(330, 300, 300, 300);orderbtn2.setBounds(830, 300, 300, 300);
		//****Visible True****//
		orderbtn.setVisible(true);orderbtn2.setVisible(true);
		//****���� �Ļ� �׼� ������ ****//
		orderbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton btn = (JButton)e.getSource();
				btn.setVisible(false);
				scar = new Scar();
				setVisible(false);
			}
		});
		//**** ���� �ֹ� �׼� ������ ****//
		orderbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton btn = (JButton)e.getSource();
				btn.setVisible(false);
				scar = new Scar();
				setVisible(false);
			}
		});
		//**** �׼� ������ �� ****//
		add(orderbtn);add(orderbtn2);
		add(inOrder);add(outOrder);
		setTitle("Ű����ũ");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new start();
	}
}
