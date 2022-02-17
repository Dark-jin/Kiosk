package Source;
import Source.Scar;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Yang extends JPanel{
	private JButton btn[] = new JButton[10];
	private JLabel la[] = new JLabel[10];
	private String[] PastaImages = {"images/양식/1.jpg","images/양식/2.jpg","images/양식/3.jpeg","images/양식/4.jpeg","images/양식/5.jpg"};
	//파스타 이미지 배열
	private String[] PastaName = {"까르보나라","알리오올리오","로제 파스타","해물 파스타","토마토 파스타"};//파스타 이름 배열
	private String[] PizzaImages = {"images/양식/6.jpg","images/양식/7.png","images/양식/8.jpeg","images/양식/9.jpg","images/양식/10.jpeg"};
	//피자 이미지 배열
	private String[] PizzaName = {"페퍼로니 피자","불고기 피자","시카고 피자","시칠리아 피자","나폴리 피자"};//피자 이름 배열
	private int money[] = {8000,9000,8000,9500,8000,14000,14000,18000,17000,16000};//가격
	//*****주류*****//
	private JButton DrinkBtn[] = new JButton[3];
	private String DrinkName[] = {"돔페리뇽","알베르비쇼","네비올로"};
	private String[] DrinkImages = {"images/양식/돔페리뇽.jpeg","images/양식/알베르비쇼.jpg","images/양식/네비올로.png"};
	private int DrinkMoney[] = {300000,150000,200000};
	private JLabel DrinkLabel[] = new JLabel[3];
	//*****주문내역*****//
	private TextArea ta;
	private int sum=0;
	private JButton cancel = new JButton("주문 취소");
    private JButton next = new JButton("주문 하기");
    protected Scar frame;
	public Yang() {
		setLayout(null);
		this.setBounds(150, 130, 1350, 700);
		//ta = new TextArea("주문내역\n",10,30);ta.setBounds(200, 600, 500, 300);ta.setVisible(true);ta.setFont(new Font("배달의민족 한나",1,15));
		JLabel acount = new JLabel("주문 금액 : 0 원");acount.setBounds(700, 600, 500, 50);acount.setVisible(true);acount.setFont(new Font("배달의민족 한나",1,30));
		JLabel menu = new JLabel("양식 메뉴판");
		JLabel pasta = new JLabel("Pasta");
		JLabel pizza = new JLabel("Pizza");
		JLabel drink = new JLabel("Drink");
		menu.setBounds(250,200, 50, 30); menu.setFont(new Font("배달의민족 한나", 1, 30));
		pasta.setBounds(200,250, 50, 30); pasta.setFont(new Font("배달의민족 한나",Font.ITALIC, 30));
		pizza.setBounds(200,600, 50, 30); pizza.setFont(new Font("배달의민족 한나",Font.ITALIC, 30));
		drink.setBounds(1000,900, 50, 30); drink.setFont(new Font("배달의민족 한나",Font.ITALIC, 30));
		menu.setOpaque(true);add(menu);pasta.setOpaque(true);add(pasta);pizza.setOpaque(true);add(pizza);//add(ta);
		drink.setOpaque(true);add(drink);
		acount.setOpaque(true);add(acount);
		//*****주류 추가*****//3번
		for(int i=0;i<DrinkBtn.length;i++) {
			DrinkBtn[i]= new JButton();
			DrinkBtn[i].setBounds(1000+(i*150), 200, 100, 100);
			DrinkBtn[i].setIcon(changeImage(DrinkImages[i]));
			DrinkBtn[i].setText(Integer.toString(DrinkMoney[i]));
			DrinkLabel[i] = new JLabel(DrinkName[i]);
			DrinkLabel[i].setBounds(1000+(i*150), 300, 140, 50);DrinkLabel[i].setFont(new Font("배달의민족 한나",1,20));
			DrinkLabel[i].setOpaque(true);
			add(DrinkBtn[i]);add(DrinkLabel[i]);
			DrinkBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton)e.getSource();
					int num = getDrinkButtonIndex(btn);
					ta.append("메뉴: "+DrinkName[num]+" 가격 :"+btn.getText()+"\n");
					sum+=Integer.parseInt(btn.getText());
					acount.setText("주문 금액: "+Integer.toString(sum)+ " 원");
				}
			});
		}
		for(int i=0;i<btn.length;i++) {//1~2번
			btn[i] = new JButton();
			if(i<=4) {//0~4 파스타 종류만
				btn[i].setBounds(200+(i*50),300,100, 100);//파스타 버튼배열 위치 
				btn[i].setIcon(changeImage(PastaImages[i]));//파스타 이미지 크기 조절
				btn[i].setText(Integer.toString(money[i]));//가격
				la[i] = new JLabel(PastaName[i]);//파스타 이름
				la[i].setBounds(200+(i*50),400,130,50);la[i].setFont(new Font("배달의민족 한나",1,20));//파스타 이름 폰트 및 위치
				la[i].setOpaque(true);//파스타 이름 보이게
				add(btn[i]);add(la[i]);//Frame에 add
				
			}
			else if(i<=4&&i>2) {
				btn[i].setBounds(200+(i*50),470,100, 100);//파스타 버튼배열 위치 
				btn[i].setIcon(changeImage(PastaImages[i]));//파스타 이미지 크기 조절
				btn[i].setText(Integer.toString(money[i]));//가격
				la[i] = new JLabel(PastaName[i]);//파스타 이름
				la[i].setBounds(200+(i*50),570,130,50);la[i].setFont(new Font("배달의민족 한나",1,20));//파스타 이름 폰트 및 위치
				la[i].setOpaque(true);//파스타 이름 보이게
				add(btn[i]);add(la[i]);//Frame에 add
			}
			else if(i>4){//5~9 피자 종류만
				btn[i].setBounds(200+((i-5)*50),650,100, 100);//피자 버튼배열 위치
				btn[i].setIcon(changeImage(PizzaImages[i-5]));//피자 이미지 크기 조절
				btn[i].setText(Integer.toString(money[i]));//가격
				la[i] = new JLabel(PizzaName[i-5]);//피자 이름
				la[i].setBounds(200+((i-5)*50),680,130,50);la[i].setFont(new Font("배달의민족 한나",1,20));//피자 이름 폰트 및 위치
				la[i].setOpaque(true);//피자 이름 보이게
				add(btn[i]);add(la[i]);//Frame에 add
			}
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton)e.getSource();
					int num = getButtonIndex(button);
					if(num<=4) {
						ta.append("메뉴: "+PastaName[num]+" 가격 :"+button.getText()+"\n");
						sum+=Integer.parseInt(button.getText());
						acount.setText("주문 금액: "+Integer.toString(sum)+ " 원");
					}
					else if(num>4) {
						ta.append("메뉴: "+PizzaName[num-5]+" 가격: "+button.getText()+"\n");
						sum+=Integer.parseInt(button.getText());
						acount.setText("주문 금액: "+Integer.toString(sum)+ " 원");
					}
				}
			});
		}
		
		// 주문 취소 버튼 이미지 //
				cancel.setBounds(1000, 700, 110, 70);
				cancel.setFont(new Font("배달의민족 한나",1,15));
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JButton btn = (JButton)e.getSource();
						if(btn.getText()=="주문 취소")
						{
							new Scar();
							setVisible(false);
						}
					}
				});
				add(cancel);
				// 주문하기 버튼 소스 //
				next.setBounds(1150, 700, 110, 70);
				next.setFont(new Font("배달의민족 한나",1,15));
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
