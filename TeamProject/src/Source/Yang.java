package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Yang extends JFrame{
	private JButton btn[] = new JButton[10];
	private JLabel la[] = new JLabel[10];
	private String[] PastaImages = {"images/���/1.jpg","images/���/2.jpg","images/���/3.jpeg","images/���/4.jpeg","images/���/5.jpg"};
	//�Ľ�Ÿ �̹��� �迭
	private String[] PastaName = {"�������","�˸����ø���","���� �Ľ�Ÿ","�ع� �Ľ�Ÿ","�丶�� �Ľ�Ÿ"};//�Ľ�Ÿ �̸� �迭
	private String[] PizzaImages = {"images/���/6.jpg","images/���/7.png","images/���/8.jpeg","images/���/9.jpg","images/���/10.jpeg"};
	//���� �̹��� �迭
	private String[] PizzaName = {"���۷δ� ����","�Ұ�� ����","��ī�� ����","��ĥ���� ����","������ ����"};//���� �̸� �迭
	private ImageIcon icon[] = new ImageIcon[5];//�Ľ�Ÿ �̹��� ���� Icon�迭
	private int money[] = {8000,9000,8000,9500,8000,14000,14000,18000,17000,16000};//����
	private TextArea ta;
	private int sum=0;
	public Yang() {
		setLayout(null);
		ta = new TextArea("�ֹ�����\n",10,30);ta.setBounds(200, 600, 500, 300);ta.setVisible(true);ta.setFont(new Font("����ǹ��� �ѳ�",1,15));
		JLabel acount = new JLabel("�ֹ� �ݾ� : 0 ��");acount.setBounds(700, 600, 300, 50);acount.setVisible(true);acount.setFont(new Font("����ǹ��� �ѳ�",1,30));
		JLabel menu = new JLabel("��� �޴���");
		JLabel pasta = new JLabel("Pasta");
		JLabel pizza = new JLabel("Pizza");
		menu.setBounds(650, 50, 300, 100); menu.setFont(new Font("����ǹ��� �ѳ�", 1, 40));
		pasta.setBounds(200,100, 100, 100); pasta.setFont(new Font("����ǹ��� �ѳ�",Font.ITALIC, 30));
		pizza.setBounds(200,340, 100, 100); pizza.setFont(new Font("����ǹ��� �ѳ�",Font.ITALIC, 30));
		menu.setOpaque(true);add(menu);pasta.setOpaque(true);add(pasta);pizza.setOpaque(true);add(pizza);add(ta);
		acount.setOpaque(true);add(acount);
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton();
			if(i<=4) {//0~4 �Ľ�Ÿ ������
				btn[i].setBounds(200+(i*150), 200,100, 100);//�Ľ�Ÿ ��ư�迭 ��ġ 
				btn[i].setIcon(changeImage(PastaImages[i]));//�Ľ�Ÿ �̹��� ũ�� ����
				btn[i].setText(Integer.toString(money[i]));//����
				la[i] = new JLabel(PastaName[i]);//�Ľ�Ÿ �̸�
				la[i].setBounds(200+(i*150),300,130,50);la[i].setFont(new Font("����ǹ��� �ѳ�",1,20));//�Ľ�Ÿ �̸� ��Ʈ �� ��ġ
				la[i].setOpaque(true);//�Ľ�Ÿ �̸� ���̰�
				add(btn[i]);add(la[i]);//Frame�� add
			}
			else if(i>4){//5~9 ���� ������
				btn[i].setBounds(200+((i-5)*150), 440,100, 100);//���� ��ư�迭 ��ġ
				btn[i].setIcon(changeImage(PizzaImages[i-5]));//���� �̹��� ũ�� ����
				btn[i].setText(Integer.toString(money[i]));//����
				la[i] = new JLabel(PizzaName[i-5]);//�Ľ�Ÿ �̸�
				la[i].setBounds(200+((i-5)*150),540,130,50);la[i].setFont(new Font("����ǹ��� �ѳ�",1,20));//�Ľ�Ÿ �̸� ��Ʈ �� ��ġ
				la[i].setOpaque(true);//�Ľ�Ÿ �̸� ���̰�
				add(btn[i]);add(la[i]);//Frame�� add
			}
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton)e.getSource();
					int num = getButtonIndex(button);
					if(num<=4) {
						ta.append("�޴�: "+PastaName[num]+" ���� :"+button.getText()+"\n");
						sum+=Integer.parseInt(button.getText());
						acount.setText("�ֹ� �ݾ�: "+Integer.toString(sum)+ " ��");
					}
					else if(num>4) {
						ta.append("�޴�: "+PizzaName[num-5]+" ����: "+button.getText()+"\n");
						sum+=Integer.parseInt(button.getText());
						acount.setText("�ֹ� �ݾ�: "+Integer.toString(sum)+ " ��");
					}
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
	       for(int i =0; i<10; i++){
	          if(btn[i] == button){
	             num = i;
	          }
	       }
	       return num;
	    }
	static ImageIcon changeImage(String filename){
	         ImageIcon icon = new ImageIcon("./" + filename);
	         Image originImage = icon.getImage();
	         Image changedImage = originImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	         ImageIcon icon_new = new ImageIcon(changedImage);
	         
	         return icon_new;
	   }
}
