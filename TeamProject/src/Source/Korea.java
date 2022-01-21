package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Korea extends JFrame{
	private JButton btn[] = new JButton[10];
	private JLabel la[] = new JLabel[10];
	private String[] gukImages = {"images/�ѽ�/��ġ�.jpg","images/�ѽ�/�����.jpg",
			"images/�ѽ�/���κ��.png","images/�ѽ�/�ߺ�����.jpeg","images/�ѽ�/������.jpeg"};
	//�/�� ��  �̹��� �迭
	private String[] gukName = {"��ġ�","�����","���κ��","�ߺ�����/2�κ�","������"};//�/�� �� �̸� �迭
	private String[] riceImages = {"images/�ѽ�/��������.jpg","images/�ѽ�/��ġ������.jpeg",
			"images/�ѽ�/���Ա�ġ������.jpg","images/�ѽ�/��ȸ�����.jpg","images/�ѽ�/�������.jpg"};
	//�Ļ�� �̹��� �迭
	private String[] riceName = {"��������","��ġ������","���Ա�ġ������","��ȸ�����","�������"};//�Ļ�� �̸� �迭
	private int money[] = {8000,8000,9000,18000,12000,6000,6000,7000,10000,12000};//����
	private TextArea ta;
	private int sum=0;
	private JButton cancel = new JButton("�ֹ� ���");
    private JButton next = new JButton("�ֹ� �ϱ�");
	public Korea() {
		setLayout(null);
		ta = new TextArea("�ֹ�����\n",10,30);ta.setBounds(200, 600, 500, 300);
		ta.setVisible(true);ta.setFont(new Font("����ǹ��� �ѳ�",1,15));
		JLabel acount = new JLabel("�ֹ� �ݾ� : 0 ��");acount.setBounds(700, 600, 300, 50);
		acount.setVisible(true);acount.setFont(new Font("����ǹ��� �ѳ�",1,30));
		JLabel menu = new JLabel("�ѽ� �޴���");
		JLabel guk = new JLabel("� / �� ��");
		JLabel rice = new JLabel("������ / ����� ��");
		menu.setBounds(650, 50, 300, 100); menu.setFont(new Font("����ǹ��� �ѳ�", 1, 40));
		guk.setBounds(200,100, 200, 100); guk.setFont(new Font("����ǹ��� �ѳ�",Font.ITALIC, 30));
		rice.setBounds(200,340, 250, 100); rice.setFont(new Font("����ǹ��� �ѳ�",Font.ITALIC, 30));
		menu.setOpaque(true);add(menu);guk.setOpaque(true);add(guk);rice.setOpaque(true);add(rice);add(ta);
		acount.setOpaque(true);add(acount);
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton();
			if(i<=4) {//0~4 �/�� ������
				btn[i].setBounds(200+(i*150), 200,100, 100);//�/�� �� ��ư�迭 ��ġ 
				btn[i].setIcon(changeImage(gukImages[i]));//�/�� ��  �̹��� ũ�� ����
				btn[i].setText(Integer.toString(money[i]));//����
				la[i] = new JLabel(gukName[i]);//�/�� ��  �̸�
				la[i].setBounds(210+(i*150),300,150,50);la[i].setFont(new Font("����ǹ��� �ѳ�",1,18));//�/�� ��  �̸� ��Ʈ �� ��ġ
				la[i].setOpaque(true);//�/�� �� �̸� ���̰�
				add(btn[i]);add(la[i]);//Frame�� add
			}
			else if(i>4){//5~9 �Ļ� ������
				btn[i].setBounds(200+((i-5)*150), 440,100, 100);//�Ļ� �� ��ư�迭 ��ġ
				btn[i].setIcon(changeImage(riceImages[i-5]));//�Ļ� �� �̹��� ũ�� ����
				btn[i].setText(Integer.toString(money[i]));//����
				la[i] = new JLabel(riceName[i-5]);//�Ļ� �� �̸�
				la[i].setBounds(210+((i-5)*150),540,150,50);la[i].setFont(new Font("����ǹ��� �ѳ�",1,18));//�Ļ� �� �̸� ��Ʈ �� ��ġ
				la[i].setOpaque(true);//�Ļ� �� �̸� ���̰�
				add(btn[i]);add(la[i]);//Frame�� add
			}
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton)e.getSource();
					int num = getButtonIndex(button);
					if(num<=4) {
						ta.append("�޴�: "+gukName[num]+" ���� :"+button.getText()+"\n");
						sum+=Integer.parseInt(button.getText());
						acount.setText("�ֹ� �ݾ�: "+Integer.toString(sum)+ " ��");
					}
					else if(num>4) {
						ta.append("�޴�: "+riceName[num-5]+" ����: "+button.getText()+"\n");
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
