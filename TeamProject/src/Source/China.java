package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class China extends JFrame{
	private JButton btn [] = new JButton[10];
	private JLabel la[] = new JLabel[10];
    static String[] chineseimages = {"images/중식/딤섬.png","images/중식/군만두.png","images/중식/짬뽕.png","images/중식/팔보채.png",
    		"images/중식/마파두부.png","images/중식/베이징 덕.png","images/중식/오므라이스.png","images/중식/기스면.png",
    		"images/중식/마라탕.png","images/중식/우동.png"}; // 총 10개
    //
    private String chineseName [] = {"딤섬","군만두","짬뽕","팔보채","마파두부","베이징 덕","오므라이스","기스면","마라탕","우동"};
    private ImageIcon icon[] = new ImageIcon[10]; //중식 이미지 받을 Icon배열
    private int money[] = {8000,2000,5500,30000,7000,40000,6000,6000,12000,5000}; // 중국 음식 가격
    private String count="";
	private TextArea ta;
    private int sum = 0;
    private JButton cancel = new JButton("주문 취소");
    private JButton next = new JButton("주문 하기");
	public China()
	{
		setTitle("중식");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		ta = new TextArea("주문내역\n",10,30);ta.setBounds(200, 600, 500, 300);ta.setVisible(true);ta.setFont(new Font("배달의민족 한나",1,15));
		JLabel acount = new JLabel("주문 금액 : 0 원");acount.setBounds(700, 600, 300, 50);acount.setVisible(true);acount.setFont(new Font("배달의민족 한나",1,30));
		JLabel menu = new JLabel("중식 메뉴판");
		menu.setBounds(650, 50, 300, 100); menu.setFont(new Font("배달의민족 한나", 1, 40));
		menu.setOpaque(true);add(menu);
		add(ta);
		acount.setOpaque(true);
		add(acount);
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
		// 중식 이미지 버튼 소스 //
		for(int i=0;i<btn.length;i++) 
		{
			btn[i] = new JButton();
			if(i<=4) //0~4번째 중식 이미지
			{
				btn[i].setBounds(200+(i*150), 200,100, 100); //중식 버튼배열 위치 
				btn[i].setIcon(changeImage(chineseimages[i])); //중식 이미지 크기 조절
				btn[i].setText(Integer.toString(money[i])); //가격
				la[i] = new JLabel(chineseName[i]); //중식 이름
				la[i].setBounds(200+(i*150),300,130,50);la[i].setFont(new Font("배달의민족 한나",1,20)); //중식 이름 폰트 및 위치
				la[i].setOpaque(true); //중식 이름 보이게
				add(btn[i]);add(la[i]); //Frame에 add
			}
			else if(i>4) //5~9번째 중식 이미지
			{
				btn[i].setBounds(200+((i-5)*150), 440,100, 100);//중식 버튼배열 위치
				btn[i].setIcon(changeImage(chineseimages[i]));//중식 이미지 크기 조절
				btn[i].setText(Integer.toString(money[i]));//가격
				la[i] = new JLabel(chineseName[i]);//중식 이름
				la[i].setBounds(200+((i-5)*150),540,130,50);la[i].setFont(new Font("배달의민족 한나",1,20));//중식 이름 폰트 및 위치
				la[i].setOpaque(true);//중식 이름 보이게
				add(btn[i]);add(la[i]);//Frame에 add
			}
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton)e.getSource();
					int num = getButtonIndex(button);
					
					ta.append(chineseName[num]+" 가격 : "+button.getText()+"\n");
					sum+=Integer.parseInt(button.getText());
					acount.setText("주문 금액: "+Integer.toString(sum)+ " 원");
				}
			});
		}
		setSize(1500,1000);
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