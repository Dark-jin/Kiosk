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
	private String name[] = {"양식","중식","일식","한식"};
	private JLabel label[] = new JLabel[4];
	private JPanel panel;
	public Scar() {
		setTitle("키오스크");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		panel = new MyPanel("images/first main.png");
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(0, -30, 1500, 1000);
		
		for(int i=0;i<name.length;i++) {
			btn[i] = new JButton();
			btn[i].setBounds(370+(i*200),550,100,100);
			btn[i].setIcon(change);
			btn[i].setVisible(true);
			btn[i].setBackground(Color.WHITE);
			label[i] = new JLabel();
			label[i].setText(name[i]);
			label[i].setBounds(395+(i*200), 680, 70, 50);
			label[i].setFont(new Font("배달의민족 한나", 1, 25));
			panel.add(btn[i]);panel.add(label[i]);
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
		add(panel);
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
	   class MyPanel extends JPanel {//이미지 변환을 위한 패널
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

		}// 마이패널 종료
	}