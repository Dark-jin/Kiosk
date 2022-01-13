package Source;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Yang extends JFrame{
	private JButton btn[] = new JButton[10];
	private JLabel la[] = new JLabel[10];
	private String[] PastaImages = {"images/양식/1.jpg","images/양식/2.jpg","images/양식/3.jpeg","images/양식/4.jpeg","images/양식/5.jpg"};
	//파스타 이미지 배열
	private String[] PastaName = {"까르보나라","알리오올리오","로제 파스타","해물 파스타","토마토 파스타"};//파스타 이름 배열
	private String[] PizzaImages = {"images/양식/6.jpg","images/양식/7.png","images/양식/8.jpeg","images/양식/9.jpg","images/양식/10.jpeg"};
	//피자 이미지 배열
	private String[] PizzaName = {"페퍼로니 피자","불고기 피자","시카고 피자","시칠리아 피자","나폴리 피자"};//피자 이름 배열
	private ImageIcon icon[] = new ImageIcon[5];//파스타 이미지 받을 Icon배열
	private int money[] = {8000,9000,8000,9500,8000,14000,14000,18000,17000,16000};//가격
	private TextArea ta;
	private int sum=0;
	public Yang() {
		setLayout(null);
		ta = new TextArea("주문내역\n",10,30);ta.setBounds(200, 600, 500, 300);ta.setVisible(true);ta.setFont(new Font("배달의민족 한나",1,15));
		JLabel acount = new JLabel("주문 금액 : 0 원");acount.setBounds(700, 600, 300, 50);acount.setVisible(true);acount.setFont(new Font("배달의민족 한나",1,30));
		JLabel menu = new JLabel("양식 메뉴판");
		JLabel pasta = new JLabel("Pasta");
		JLabel pizza = new JLabel("Pizza");
		menu.setBounds(650, 50, 300, 100); menu.setFont(new Font("배달의민족 한나", 1, 40));
		pasta.setBounds(200,100, 100, 100); pasta.setFont(new Font("배달의민족 한나",Font.ITALIC, 30));
		pizza.setBounds(200,340, 100, 100); pizza.setFont(new Font("배달의민족 한나",Font.ITALIC, 30));
		menu.setOpaque(true);add(menu);pasta.setOpaque(true);add(pasta);pizza.setOpaque(true);add(pizza);add(ta);
		acount.setOpaque(true);add(acount);
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton();
			if(i<=4) {//0~4 파스타 종류만
				btn[i].setBounds(200+(i*150), 200,100, 100);//파스타 버튼배열 위치 
				btn[i].setIcon(changeImage(PastaImages[i]));//파스타 이미지 크기 조절
				btn[i].setText(Integer.toString(money[i]));//가격
				la[i] = new JLabel(PastaName[i]);//파스타 이름
				la[i].setBounds(200+(i*150),300,130,50);la[i].setFont(new Font("배달의민족 한나",1,20));//파스타 이름 폰트 및 위치
				la[i].setOpaque(true);//파스타 이름 보이게
				add(btn[i]);add(la[i]);//Frame에 add
			}
			else if(i>4){//5~9 피자 종류만
				btn[i].setBounds(200+((i-5)*150), 440,100, 100);//피자 버튼배열 위치
				btn[i].setIcon(changeImage(PizzaImages[i-5]));//피자 이미지 크기 조절
				btn[i].setText(Integer.toString(money[i]));//가격
				la[i] = new JLabel(PizzaName[i-5]);//파스타 이름
				la[i].setBounds(200+((i-5)*150),540,130,50);la[i].setFont(new Font("배달의민족 한나",1,20));//파스타 이름 폰트 및 위치
				la[i].setOpaque(true);//파스타 이름 보이게
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
		
		
		setTitle("키오스크");
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
