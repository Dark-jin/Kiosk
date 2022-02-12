package Source;
import java.awt.*;
import javax.swing.*;

import Source.Log.MyPanel;

import java.awt.event.*;
public class start extends JFrame{
	ImageIcon ordericon = new ImageIcon("images/order.png");
	Image img = ordericon.getImage();
	Image changeImg =img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
	ImageIcon changeordericon = new ImageIcon(changeImg);
	private JPanel panel;
	private Scar scar;
	public start()
	{
		panel = new MyPanel("images/first main.png");
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(0, -30, 1500, 1000);
		//add(panel);
		
		setLayout(null);
		//**** �����ֹ� ****//
		JLabel inOrder = new JLabel("�����ֹ�");
		JButton orderbtn = new JButton();//����Ļ�
		inOrder.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,30)); inOrder.setBounds(410, 800, 200, 100);
		inOrder.setBackground(Color.white);inOrder.setOpaque(true);;//Font �� ��ġ ����
		//**** �����ֹ� ****//
		JLabel outOrder = new JLabel("�����ֹ�");
		JButton orderbtn2 = new JButton();
		outOrder.setFont(new Font("����ǹ��� �ѳ�",Font.BOLD,30));outOrder.setBounds(910, 800, 200, 100);
		outOrder.setBackground(Color.white);outOrder.setOpaque(true);;//Font �� ��ġ ����
		//**** ��ư �̹��� �ֱ� ****//
		orderbtn.setIcon(changeordericon);orderbtn2.setIcon(changeordericon);
		//**** ��ư ��ġ ���� ****//
		orderbtn.setBounds(330, 500, 300, 300);orderbtn2.setBounds(830, 500, 300, 300);
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
		panel.add(orderbtn);panel.add(orderbtn2);
		panel.add(inOrder);panel.add(outOrder);
		add(panel);
		setTitle("Ű����ũ");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	class MyPanel extends JPanel {//�̹��� ��ȯ�� ���� �г�
		Image image;

		MyPanel(String img) {
			image = Toolkit.getDefaultToolkit().createImage(img);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (image != null) {
				g.drawImage(image, 0, 0, this);
			}
		}

		public void update(Graphics g) {
			paintComponent(g);
		}

	}// �����г� ����
}
