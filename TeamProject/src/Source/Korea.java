package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Korea extends JFrame{
	private JButton btn[] = new JButton[10];
	private JLabel la[] = new JLabel[10];
	private String[] gukImages = {"images/한식/김치찌개.jpg","images/한식/된장찌개.jpg",
			"images/한식/순두부찌개.png","images/한식/닭볶음탕.jpeg","images/한식/갈비탕.jpeg"};
	//찌개/탕 류  이미지 배열
	private String[] gukName = {"김치찌개","된장찌개","순두부찌개","닭볶음탕/2인분","갈비탕"};//찌개/탕 류 이름 배열
	private String[] riceImages = {"images/한식/간장계란밥.jpg","images/한식/김치볶음밥.jpeg",
			"images/한식/스팸김치볶음밥.jpg","images/한식/육회비빔밥.jpg","images/한식/삼겹비빔밥.jpg"};
	//식사류 이미지 배열
	private String[] riceName = {"간장계란밥","김치볶음밥","스팸김치볶음밥","육회비빔밥","삼겹비빔밥"};//식사류 이름 배열
	private int money[] = {8000,8000,9000,18000,12000,6000,6000,7000,10000,12000};//가격
	//*****주류*****//
	private JButton DrinkBtn[] = new JButton[3];
	private String DrinkName[] = {"막걸리","화요","복분자주"};
	private String[] DrinkImages = {"images/한식/막걸리.jpeg","images/한식/화요.jpg","images/한식/복분자주.jpg"};
	private int DrinkMoney[] = {5000,10000,15000};
	private JLabel DrinkLabel[] = new JLabel[3];
	//*****주문내역*****//
	private TextArea ta;
	private int sum=0;
	private JButton cancel = new JButton("주문 취소");
    private JButton next = new JButton("주문 하기");
	public Korea() {
		setLayout(null);
		ta = new TextArea("주문내역\n",10,30);ta.setBounds(200, 600, 500, 300);
		ta.setVisible(true);ta.setFont(new Font("배달의민족 한나",1,15));
		JLabel acount = new JLabel("주문 금액 : 0 원");acount.setBounds(700, 600, 300, 50);
		acount.setVisible(true);acount.setFont(new Font("배달의민족 한나",1,30));
		JLabel menu = new JLabel("한식 메뉴판");
		JLabel guk = new JLabel("찌개 / 탕 류");
		JLabel rice = new JLabel("볶음밥 / 비빔밥 류");
		JLabel drink = new JLabel("주류");
		menu.setBounds(650, 50, 300, 100); menu.setFont(new Font("배달의민족 한나", 1, 40));
		guk.setBounds(200,100, 200, 100); guk.setFont(new Font("배달의민족 한나",Font.ITALIC, 30));
		rice.setBounds(200,340, 250, 100); rice.setFont(new Font("배달의민족 한나",Font.ITALIC, 30));
		drink.setBounds(1000,100, 100, 100); drink.setFont(new Font("배달의민족 한나",Font.ITALIC, 30));
		menu.setOpaque(true);add(menu);guk.setOpaque(true);add(guk);rice.setOpaque(true);add(rice);add(ta);
		acount.setOpaque(true);add(acount);
		drink.setOpaque(true);add(drink);
		//*****주류 추가*****//
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
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton();
			if(i<=4) {//0~4 찌개/탕 종류만
				btn[i].setBounds(200+(i*150), 200,100, 100);//찌개/탕 류 버튼배열 위치 
				btn[i].setIcon(changeImage(gukImages[i]));//찌개/탕 류  이미지 크기 조절
				btn[i].setText(Integer.toString(money[i]));//가격
				la[i] = new JLabel(gukName[i]);//찌개/탕 류  이름
				la[i].setBounds(210+(i*150),300,150,50);la[i].setFont(new Font("배달의민족 한나",1,18));//찌개/탕 류  이름 폰트 및 위치
				la[i].setOpaque(true);//찌개/탕 류 이름 보이게
				add(btn[i]);add(la[i]);//Frame에 add
			}
			else if(i>4){//5~9 식사 종류만
				btn[i].setBounds(200+((i-5)*150), 440,100, 100);//식사 류 버튼배열 위치
				btn[i].setIcon(changeImage(riceImages[i-5]));//식사 류 이미지 크기 조절
				btn[i].setText(Integer.toString(money[i]));//가격
				la[i] = new JLabel(riceName[i-5]);//식사 류 이름
				la[i].setBounds(210+((i-5)*150),540,150,50);la[i].setFont(new Font("배달의민족 한나",1,18));//식사 류 이름 폰트 및 위치
				la[i].setOpaque(true);//식사 류 이름 보이게
				add(btn[i]);add(la[i]);//Frame에 add
			}
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton)e.getSource();
					int num = getButtonIndex(button);
					if(num<=4) {
						ta.append("메뉴: "+gukName[num]+" 가격 :"+button.getText()+"\n");
						sum+=Integer.parseInt(button.getText());
						acount.setText("주문 금액: "+Integer.toString(sum)+ " 원");
					}
					else if(num>4) {
						ta.append("메뉴: "+riceName[num-5]+" 가격: "+button.getText()+"\n");
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
		
		setTitle("키오스크");
		setSize(1500,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
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
