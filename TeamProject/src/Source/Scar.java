package Source;
import java.awt.*;
import javax.swing.*;

import Source.Log.MyPanel;

import java.awt.event.*;
public class Scar extends JFrame{
	private ImageIcon icon = new ImageIcon("images/sic.png");
	private Image img = icon.getImage();
	private Image changeImg =img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
	private ImageIcon change = new ImageIcon(changeImg);
	private JButton btn[] =new JButton[4];
	private String name[] = {"���","�߽�","�Ͻ�","�ѽ�"};
	private JLabel label[] = new JLabel[4];
	private JPanel panel,panel2;
	public Scar() {
		setTitle("Ű����ũ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		panel = new MyPanel("images/top2.png");
		panel.setBackground(Color.BLUE);
		panel.setLayout(null);
		panel.setBounds(0,0, 1500, 130);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 130, 150, 850);
		panel2.setLayout(null);
		panel2.setBackground(Color.ORANGE);
		for(int i=0;i<name.length;i++) {
			btn[i] = new JButton();
			btn[i].setBounds(25,40+(i*200),100,100);
			btn[i].setVisible(true);
			btn[i].setText(name[i]);
			btn[i].setFont(new Font("����ǹ��� �ѳ�",1,25));
			btn[i].setBackground(Color.ORANGE);btn[i].setBorderPainted(false);
			panel2.add(btn[i]);
			btn[i].addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               JButton button =(JButton)e.getSource();
	               int num = getButtonIndex(button);
	               if(num==0) {new Yang();}
	               else if(num==1) {new China();}
	               else if(num==2) {new Japan();}
	               else {new Korea();}
	               setVisible(false);
	            }
	         });
	      }
		add(panel);add(panel2);
	      setSize(1500,1000);
	      setVisible(true);
	      setLocationRelativeTo(null);
	   }
	   public int getButtonIndex(JButton button){
	       int num = 0;
	       for(int i =0; i<4; i++){
	          if(btn[i] == button){
	             num = i;
	          }
	       }
	       return num;
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