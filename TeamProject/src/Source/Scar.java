package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Source.Log.MyPanel;
import javax.swing.JScrollBar;
import java.awt.event.*;
public class Scar extends JFrame{
	private ImageIcon icon = new ImageIcon("images/sic.png");
	private Image img = icon.getImage();
	private Image changeImg =img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
	private ImageIcon change = new ImageIcon(changeImg);
	private JButton btn[] =new JButton[4];
	private String name[] = {"양식","중식","일식","한식"};
	private JLabel label[] = new JLabel[4];
	private JPanel panel,panel2,panel3;
	private Yang yang = new Yang();
	private China china = new China();
	private Japan japan = new Japan();
	private Korea korea = new Korea();
	public Scar() {
		yang.setOpaque(false);yang.setVisible(false);
		china.setOpaque(false);china.setVisible(false);
		japan.setOpaque(false);japan.setVisible(false);
		korea.setOpaque(false);korea.setVisible(false);
		setTitle("키오스크");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		panel = new MyPanel("images/top2.png");
		panel.setBackground(Color.BLUE);
		panel.setLayout(null);
		panel.setBounds(0,0, 1500, 130);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 130, 150, 870);
		panel2.setLayout(null);
		panel2.setBackground(Color.ORANGE);
		
		//panel3 = new JPanel();
		//panel3.setLayout(null);
		//panel3.setBounds(150, 130, 1350, 750);
		//panel3.setBackground(Color.GREEN);
		
		//JScrollPane pane = new JScrollPane();
		//pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//pane.getVerticalScrollBar().setUnitIncrement(15);
		//add(pane);
		
		for(int i=0;i<name.length;i++) {
			btn[i] = new JButton();
			btn[i].setBounds(25,40+(i*200),100,100);
			btn[i].setVisible(true);
			btn[i].setText(name[i]);
			btn[i].setFont(new Font("배달의민족 한나",1,25));
			btn[i].setBackground(Color.ORANGE);btn[i].setBorderPainted(false);
			panel2.add(btn[i]);
			btn[i].addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               JButton button =(JButton)e.getSource();
	               int num = getButtonIndex(button);
	               if(num==0) {
	            	//removeAll();
	            	getContentPane().removeAll();
	            	getContentPane().add(yang);
	            	yang.setVisible(true);
	               }
	               else if(num==1) {
	            	  // removeAll();
	            	   getContentPane().removeAll();
	            	   getContentPane().add(china);
	            	   china.setVisible(true);
		            	}
	               else if(num==2) {
	            	   //removeAll();
	            	   getContentPane().removeAll();
	            	   getContentPane().add(japan);
	            	   japan.setVisible(true);
	            	   }
	               else { 
	            	   //removeAll();
            	   getContentPane().removeAll();
            	   getContentPane().add(korea);
            	   korea.setVisible(true);}
	              // setVisible(false);
	            }
	         });
	      }
		add(panel);add(panel2);add(yang);add(korea);add(china);add(japan);
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