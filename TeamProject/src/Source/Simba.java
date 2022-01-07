package Source;
import java.awt.*;
import javax.swing.*;

public class Simba extends JFrame{
	public Scar scar = null;
	public start s = null;
	public Simba() {
		setTitle("키오스크");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public void change(String panelName) {
		if(panelName.equals("start")) {
			scar = new Scar();
			getContentPane().removeAll();
			getContentPane().add(scar);
			revalidate();
			repaint();
		}
	}
	public static void main(String[] args) {
		Simba a = new Simba();
		a.s = new start(a);
		a.add(a.s);
		a.setVisible(true);
	}
}
