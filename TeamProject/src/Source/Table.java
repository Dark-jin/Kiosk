package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Table extends JFrame{
	private JButton seat[] = new JButton[16];
	private JLabel la = new JLabel("Lobby");
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	public Table()
	{
		setTitle("Table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel1.setLayout(new GridLayout(2,4,5,5));
		panel2.setLayout(new GridLayout(2,4,5,5));
		panel3.setLayout(new FlowLayout());
		for(int i =0; i<seat.length; i++)
		{
			seat[i] = new JButton("Table "+Integer.toString(i+1));
			if(i<8)
			{
				panel1.add(seat[i]);
			}
			else
			{
				panel2.add(seat[i]);
			}
		}
		add(panel1,BorderLayout.WEST);
		add(panel2,BorderLayout.EAST);
		la.setOpaque(true);
		panel3.add(la);
		add(panel3,BorderLayout.CENTER);
		
		setSize(1000,800);
		setVisible(true);
	}
}
