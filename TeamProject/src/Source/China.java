package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class China extends JFrame{
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JButton btn [] = new JButton[12];
    static String[] food = { "images/¥���.png","images/����.png","images/������.png","images/«��.png","images/�Ⱥ�ä.png",
    		"images/���ĵκ�.png","images/����¡ ��.png","images/�߱���.png","images/���Ƕ��̽�.png","images/�⽺��.png","images/������.png"
    		,"images/�쵿.png"}; // �� 12��
    //
    private JTextArea a = new JTextArea(7,5);
    private String s [] = {"¥���","����","������","«��","�Ⱥ�ä","���ĵκ�","����¡ ��","�߱���","���Ƕ��̽�","�⽺��","������","�쵿"};
    private int chinaprice[] = {5000,8000,2000,5500,30000,7000,40000,2500,6000,6000,12000,5000}; // �߱� ���� ����
    private JLabel la = new JLabel();
    private int sum = 0;
	public China()
	{
		setTitle("�߽�");
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
			setLayout(new GridLayout(4,3,10,10)); // �׸��� ���̾ƿ�
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
	static ImageIcon changeImage(String filename) // �߱����� �̹���
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
			if(button.getText()=="¥���")
			{
				a.append(button.getText() + " "+ chinaprice[0] +"\n");
				sum += chinaprice[0];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
			else if(button.getText()=="����")
			{
				a.append(button.getText() + " "+ chinaprice[1] +"\n");
				sum+=chinaprice[1];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
			else if(button.getText()=="������")
			{
				a.append(button.getText() + " "+ chinaprice[2] +"  ");
				sum+=chinaprice[2];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
			else if(button.getText()=="«��")
			{
				a.append(button.getText() + " "+ chinaprice[3] +"\n");
				sum+=chinaprice[3];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
			else if(button.getText()=="�Ⱥ�ä")
			{
				a.append(button.getText() + " "+ chinaprice[4] +"\n");
				sum+=chinaprice[4];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
			else if(button.getText()=="���ĵκ�")
			{
				a.append(button.getText() + " "+ chinaprice[5] +"\n");
				sum+=chinaprice[5];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
			else if(button.getText()=="����¡ ��")
			{
				a.append(button.getText() + " "+ chinaprice[6] +"\n");
				sum+=chinaprice[6];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
			else if(button.getText()=="�߱���")
			{
				a.append(button.getText() + " "+ chinaprice[7] +"\n");
				sum+=chinaprice[7];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
			else if(button.getText()=="���Ƕ��̽�")
			{
				a.append(button.getText() + " "+ chinaprice[8] +"\n");
				sum+=chinaprice[8];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
			else if(button.getText()=="�⽺��")
			{
				a.append(button.getText() + " "+ chinaprice[9] +"\n");
				sum+=chinaprice[9];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
			else if(button.getText()=="������")
			{
				a.append(button.getText() + " "+ chinaprice[10] +"\n");
				sum+=chinaprice[10];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
			else
			{
				a.append(button.getText() + " "+ chinaprice[11] +"\n");
				sum+=chinaprice[11];
				la.setText("�� �ֹ��ݾ� : "+Integer.toString(sum)+" ��");
			}
		}
	}
}
