package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class China extends JFrame{
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JButton btn [] = new JButton[12];
    static String[] food = { "images/짜장면.png","images/딤섬.png","images/군만두.png","images/짬뽕.png","images/팔보채.png",
    		"images/마파두부.png","images/베이징 덕.png","images/중국차.png","images/오므라이스.png","images/기스면.png","images/마라탕.png"
    		,"images/우동.png"}; // 총 12개
    //
    private JTextArea a = new JTextArea(7,5);
    private String s [] = {"짜장면","딤섬","군만두","짬뽕","팔보채","마파두부","베이징 덕","중국차","오므라이스","기스면","마라탕","우동"};
    private int chinaprice[] = {5000,8000,2000,5500,30000,7000,40000,2500,6000,6000,12000,5000}; // 중국 음식 가격
    private JLabel la = new JLabel();
    private int sum = 0;
	public China()
	{
		setTitle("중식");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		p1 = new CenterPanel();
		p2 = new SouthPanel();
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		
		setSize(1500,1000);
		setVisible(true);
		//setLocationRelativeTo(null);
	}
	class CenterPanel extends JPanel
	{
		CenterPanel()
		{
			setLayout(new GridLayout(4,3,10,10)); // 그리드 레이아웃
			for(int i =0; i<btn.length; i++)
			{
				btn[i] = new JButton(s[i],changeImage(food[i]));
				btn[i].addActionListener(new MyActionListener());
				add(btn[i]);
			}
		}
	}
	class SouthPanel extends JPanel
	{
		SouthPanel()
		{
			setLayout(new GridLayout(1,2,20,20));
	        JScrollPane sp = new JScrollPane(a);
	        add(sp);
	        add(la);
		}
	}
	static ImageIcon changeImage(String filename) // 중국음식 이미지
	{
		ImageIcon icon = new ImageIcon("./" + filename);
		Image originImage = icon.getImage();
		Image changedImage = originImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon icon_new = new ImageIcon(changedImage);
		      
		return icon_new;
	}
	class MyActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton button = (JButton)e.getSource();
			if(button.getText()=="짜장면")
			{
				a.append(button.getText() + " "+ chinaprice[0] +"\n");
				sum += chinaprice[0];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
			else if(button.getText()=="딤섬")
			{
				a.append(button.getText() + " "+ chinaprice[1] +"\n");
				sum+=chinaprice[1];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
			else if(button.getText()=="군만두")
			{
				a.append(button.getText() + " "+ chinaprice[2] +"  ");
				sum+=chinaprice[2];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
			else if(button.getText()=="짬뽕")
			{
				a.append(button.getText() + " "+ chinaprice[3] +"\n");
				sum+=chinaprice[3];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
			else if(button.getText()=="팔보채")
			{
				a.append(button.getText() + " "+ chinaprice[4] +"\n");
				sum+=chinaprice[4];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
			else if(button.getText()=="마파두부")
			{
				a.append(button.getText() + " "+ chinaprice[5] +"\n");
				sum+=chinaprice[5];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
			else if(button.getText()=="베이징 덕")
			{
				a.append(button.getText() + " "+ chinaprice[6] +"\n");
				sum+=chinaprice[6];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
			else if(button.getText()=="중국차")
			{
				a.append(button.getText() + " "+ chinaprice[7] +"\n");
				sum+=chinaprice[7];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
			else if(button.getText()=="오므라이스")
			{
				a.append(button.getText() + " "+ chinaprice[8] +"\n");
				sum+=chinaprice[8];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
			else if(button.getText()=="기스면")
			{
				a.append(button.getText() + " "+ chinaprice[9] +"\n");
				sum+=chinaprice[9];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
			else if(button.getText()=="마라탕")
			{
				a.append(button.getText() + " "+ chinaprice[10] +"\n");
				sum+=chinaprice[10];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
			else
			{
				a.append(button.getText() + " "+ chinaprice[11] +"\n");
				sum+=chinaprice[11];
				la.setText("총 주문금액 : "+Integer.toString(sum)+" 원");
			}
		}
	}
}
