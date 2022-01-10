package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Scar extends JFrame{
	private ImageIcon icon = new ImageIcon("images/sic.png");
	private Image img = icon.getImage();
	private Image changeImg =img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
	private ImageIcon change = new ImageIcon(changeImg);
	private JButton btn[] =new JButton[3];
	private String name[] = {"���","�߽�","�Ͻ�"};
	private JLabel label[] = new JLabel[3];
	public Scar() {
		setLayout(null);
		for(int i=0;i<name.length;i++) {
			btn[i] = new JButton();
			btn[i].setBounds(470+(i*200),400,100,100);
			btn[i].setIcon(change);
			btn[i].setVisible(true);
			label[i] = new JLabel();
			label[i].setText(name[i]);
			label[i].setBounds(500+(i*200), 500, 50, 50);
			label[i].setFont(new Font("����ǹ��� �ѳ�", 1, 20));
			add(btn[i]);add(label[i]);
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button =(JButton)e.getSource();
					int num = getButtonIndex(button);
					if(num==0) {new Yang();}
					else if(num==1) {new China();}
					else {new Japan();}
					setVisible(false);
				}
			});
		}
		setTitle("Ű����ũ");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public int getButtonIndex(JButton button){
       int num = 0;
       for(int i =0; i<3; i++){
          if(btn[i] == button){
             num = i;
          }
       }
       return num;
    }
}
