package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Scar extends JPanel{
	private ImageIcon icon = new ImageIcon("images/sic.png");
	private Image img = icon.getImage();
	private Image changeImg =img.getScaledInstance(100,100,Image.SCALE_SMOOTH);
	private ImageIcon change = new ImageIcon(changeImg);
	private JButton btn[] =new JButton[3];
	private String name[] = {"양식","중식","일식"};
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
			label[i].setFont(new Font("배달의민족 한나", 1, 20));
			add(btn[i]);add(label[i]);
			
		}
		
	}
}
