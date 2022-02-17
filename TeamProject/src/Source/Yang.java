package Source;
import Source.Scar;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Yang extends JPanel{
	private JButton btn[] = new JButton[10];
	private JLabel la[] = new JLabel[10];
	private String[] PastaImages = {"images/���/1.jpg","images/���/2.jpg","images/���/3.jpeg","images/���/4.jpeg","images/���/5.jpg"};
	//�Ľ�Ÿ �̹��� �迭
	private String[] PastaName = {"�������","�˸����ø���","���� �Ľ�Ÿ","�ع� �Ľ�Ÿ","�丶�� �Ľ�Ÿ"};//�Ľ�Ÿ �̸� �迭
	private String[] PizzaImages = {"images/���/6.jpg","images/���/7.png","images/���/8.jpeg","images/���/9.jpg","images/���/10.jpeg"};
	//���� �̹��� �迭
	private String[] PizzaName = {"���۷δ� ����","�Ұ�� ����","��ī�� ����","��ĥ���� ����","������ ����"};//���� �̸� �迭
	private int money[] = {8000,9000,8000,9500,8000,14000,14000,18000,17000,16000};//����
	//*****�ַ�*****//
	private JButton DrinkBtn[] = new JButton[3];
	private String DrinkName[] = {"���丮��","�˺������","�׺�÷�"};
	private String[] DrinkImages = {"images/���/���丮��.jpeg","images/���/�˺������.jpg","images/���/�׺�÷�.png"};
	private int DrinkMoney[] = {300000,150000,200000};
	private JLabel DrinkLabel[] = new JLabel[3];
	//*****�ֹ�����*****//
	private TextArea ta;
	private int sum=0;
	private JButton cancel = new JButton("�ֹ� ���");
    private JButton next = new JButton("�ֹ� �ϱ�");
    protected Scar frame;
	public Yang() {
		setLayout(null);
		this.setBounds(150, 130, 1350, 700);
		//ta = new TextArea("�ֹ�����\n",10,30);ta.setBounds(200, 600, 500, 300);ta.setVisible(true);ta.setFont(new Font("����ǹ��� �ѳ�",1,15));
		JLabel acount = new JLabel("�ֹ� �ݾ� : 0 ��");acount.setBounds(700, 600, 500, 50);acount.setVisible(true);acount.setFont(new Font("����ǹ��� �ѳ�",1,30));
		JLabel menu = new JLabel("��� �޴���");
		JLabel pasta = new JLabel("Pasta");
		JLabel pizza = new JLabel("Pizza");
		JLabel drink = new JLabel("Drink");
		menu.setBounds(250,200, 50, 30); menu.setFont(new Font("����ǹ��� �ѳ�", 1, 30));
		pasta.setBounds(200,250, 50, 30); pasta.setFont(new Font("����ǹ��� �ѳ�",Font.ITALIC, 30));
		pizza.setBounds(200,600, 50, 30); pizza.setFont(new Font("����ǹ��� �ѳ�",Font.ITALIC, 30));
		drink.setBounds(1000,900, 50, 30); drink.setFont(new Font("����ǹ��� �ѳ�",Font.ITALIC, 30));
		menu.setOpaque(true);add(menu);pasta.setOpaque(true);add(pasta);pizza.setOpaque(true);add(pizza);//add(ta);
		drink.setOpaque(true);add(drink);
		acount.setOpaque(true);add(acount);
		//*****�ַ� �߰�*****//3��
		for(int i=0;i<DrinkBtn.length;i++) {
			DrinkBtn[i]= new JButton();
			DrinkBtn[i].setBounds(1000+(i*150), 200, 100, 100);
			DrinkBtn[i].setIcon(changeImage(DrinkImages[i]));
			DrinkBtn[i].setText(Integer.toString(DrinkMoney[i]));
			DrinkLabel[i] = new JLabel(DrinkName[i]);
			DrinkLabel[i].setBounds(1000+(i*150), 300, 140, 50);DrinkLabel[i].setFont(new Font("����ǹ��� �ѳ�",1,20));
			DrinkLabel[i].setOpaque(true);
			add(DrinkBtn[i]);add(DrinkLabel[i]);
			DrinkBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton)e.getSource();
					int num = getDrinkButtonIndex(btn);
					ta.append("�޴�: "+DrinkName[num]+" ���� :"+btn.getText()+"\n");
					sum+=Integer.parseInt(btn.getText());
					acount.setText("�ֹ� �ݾ�: "+Integer.toString(sum)+ " ��");
				}
			});
		}
		for(int i=0;i<btn.length;i++) {//1~2��
			btn[i] = new JButton();
			if(i<=4) {//0~4 �Ľ�Ÿ ������
				btn[i].setBounds(200+(i*50),300,100, 100);//�Ľ�Ÿ ��ư�迭 ��ġ 
				btn[i].setIcon(changeImage(PastaImages[i]));//�Ľ�Ÿ �̹��� ũ�� ����
				btn[i].setText(Integer.toString(money[i]));//����
				la[i] = new JLabel(PastaName[i]);//�Ľ�Ÿ �̸�
				la[i].setBounds(200+(i*50),400,130,50);la[i].setFont(new Font("����ǹ��� �ѳ�",1,20));//�Ľ�Ÿ �̸� ��Ʈ �� ��ġ
				la[i].setOpaque(true);//�Ľ�Ÿ �̸� ���̰�
				add(btn[i]);add(la[i]);//Frame�� add
				
			}
			else if(i<=4&&i>2) {
				btn[i].setBounds(200+(i*50),470,100, 100);//�Ľ�Ÿ ��ư�迭 ��ġ 
				btn[i].setIcon(changeImage(PastaImages[i]));//�Ľ�Ÿ �̹��� ũ�� ����
				btn[i].setText(Integer.toString(money[i]));//����
				la[i] = new JLabel(PastaName[i]);//�Ľ�Ÿ �̸�
				la[i].setBounds(200+(i*50),570,130,50);la[i].setFont(new Font("����ǹ��� �ѳ�",1,20));//�Ľ�Ÿ �̸� ��Ʈ �� ��ġ
				la[i].setOpaque(true);//�Ľ�Ÿ �̸� ���̰�
				add(btn[i]);add(la[i]);//Frame�� add
			}
			else if(i>4){//5~9 ���� ������
				btn[i].setBounds(200+((i-5)*50),650,100, 100);//���� ��ư�迭 ��ġ
				btn[i].setIcon(changeImage(PizzaImages[i-5]));//���� �̹��� ũ�� ����
				btn[i].setText(Integer.toString(money[i]));//����
				la[i] = new JLabel(PizzaName[i-5]);//���� �̸�
				la[i].setBounds(200+((i-5)*50),680,130,50);la[i].setFont(new Font("����ǹ��� �ѳ�",1,20));//���� �̸� ��Ʈ �� ��ġ
				la[i].setOpaque(true);//���� �̸� ���̰�
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
		
		// �ֹ� ��� ��ư �̹��� //
				cancel.setBounds(1000, 700, 110, 70);
				cancel.setFont(new Font("����ǹ��� �ѳ�",1,15));
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JButton btn = (JButton)e.getSource();
						if(btn.getText()=="�ֹ� ���")
						{
							new Scar();
							setVisible(false);
						}
					}
				});
				add(cancel);
				// �ֹ��ϱ� ��ư �ҽ� //
				next.setBounds(1150, 700, 110, 70);
				next.setFont(new Font("����ǹ��� �ѳ�",1,15));
				next.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new Order(ta,sum);
						setVisible(false);
					}
				});
				add(next);
				setVisible(true);
	}
	public int getDrinkButtonIndex(JButton btn)
	{
		int num = 0;
		for(int i =0; i<3; i++)
		{
			if(DrinkBtn[i] == btn)
			{
				num = i;
			}
		}
		return num;
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
