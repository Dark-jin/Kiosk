package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Japan extends JFrame{
	private JButton btn[] = new JButton[10];
	private JLabel la[] = new JLabel[10];
	private String[] japanimages = {"images/일식/벤또.png","images/일식/스시.png","images/일식/새우덮밥.png","images/일식/라멘.png","images/일식/타코야끼.png",
			"images/일식/사케.png","images/일식/모찌.png","images/일식/오코노미야끼.png","images/일식/꼬치.png","images/일식/카바야키.png"};
	//일식 이미지 배열
	private String[] japanName = {"벤또","스시","새우덮밥","라멘","타코야끼","사케","모찌","오코노미야끼","꼬치","카바야키"}; //일식 이름 배열
	private ImageIcon icon[] = new ImageIcon[10]; //일식 이미지 받을 Icon배열
	private int money[] = {8000,13000,7000,5500,4000,10000,6000,7000,4500,8000}; //가격
	private String count="";
	private TextArea ta;
	private int sum=0;
	private JButton cancel = new JButton("주문 취소");
    private JButton next = new JButton("주문 하기");
	public Japan()
	{
		setTitle("일식");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		ta = new TextArea("주문내역\n",10,30);ta.setBounds(200, 600, 500, 300);ta.setVisible(true);ta.setFont(new Font("배달의민족 한나",1,15));
		JLabel acount = new JLabel("주문 금액 : 0 원");acount.setBounds(700, 600, 300, 50);acount.setVisible(true);acount.setFont(new Font("배달의민족 한나",1,30));
		JLabel menu = new JLabel("일식 메뉴판");
		menu.setBounds(650, 50, 300, 100); menu.setFont(new Font("배달의민족 한나", 1, 40));
		menu.setOpaque(true);add(menu);
		add(ta);
		acount.setOpaque(true);
		add(acount);
		for(int i=0;i<btn.length;i++) 
		{
			btn[i] = new JButton();
			if(i<=4) //0~4번째 일식 이미지
			{
				btn[i].setBounds(200+(i*150), 200,100, 100); //일식 버튼배열 위치 
				btn[i].setIcon(changeImage(japanimages[i])); //일식 이미지 크기 조절
				btn[i].setText(Integer.toString(money[i])); //가격
				la[i] = new JLabel(japanName[i]); //일식 이름
				la[i].setBounds(200+(i*150),300,130,50);la[i].setFont(new Font("배달의민족 한나",1,20)); //일식 이름 폰트 및 위치
				la[i].setOpaque(true); //일식 이름 보이게
				add(btn[i]);add(la[i]); //Frame에 add
			}
			else if(i>4) //5~9번째 일식 이미지
			{
				btn[i].setBounds(200+((i-5)*150), 440,100, 100);//일식 버튼배열 위치
				btn[i].setIcon(changeImage(japanimages[i]));//일식 이미지 크기 조절
				btn[i].setText(Integer.toString(money[i]));//가격
				la[i] = new JLabel(japanName[i]);//일식 이름
				la[i].setBounds(200+((i-5)*150),540,130,50);la[i].setFont(new Font("배달의민족 한나",1,20));//일식 이름 폰트 및 위치
				la[i].setOpaque(true);//일식 이름 보이게
				add(btn[i]);add(la[i]);//Frame에 add
			}
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton)e.getSource();
					int num = getButtonIndex(button);
					
					ta.append(japanName[num]+" 가격 : "+button.getText()+"\n");
					sum+=Integer.parseInt(button.getText());
					acount.setText("주문 금액: "+Integer.toString(sum)+ " 원");
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
