package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Japan extends JFrame{
	private JButton btn[] = new JButton[10];
	private JLabel la[] = new JLabel[10];
	private String[] japanimages = {"images/�Ͻ�/����.png","images/�Ͻ�/����.png","images/�Ͻ�/���쵤��.png","images/�Ͻ�/���.png","images/�Ͻ�/Ÿ�ھ߳�.png",
			"images/�Ͻ�/����.png","images/�Ͻ�/����.png","images/�Ͻ�/���ڳ�̾߳�.png","images/�Ͻ�/��ġ.png","images/�Ͻ�/ī�پ�Ű.png"};
	//�Ͻ� �̹��� �迭
	private String[] japanName = {"����","����","���쵤��","���","Ÿ�ھ߳�","����","����","���ڳ�̾߳�","��ġ","ī�پ�Ű"}; //�Ͻ� �̸� �迭
	private ImageIcon icon[] = new ImageIcon[10]; //�Ͻ� �̹��� ���� Icon�迭
	private int money[] = {8000,13000,7000,5500,4000,10000,6000,7000,4500,8000}; //����
	private String count="";
	private TextArea ta;
	private int sum=0;
	private JButton cancel = new JButton("�ֹ� ���");
    private JButton next = new JButton("�ֹ� �ϱ�");
	public Japan()
	{
		setTitle("�Ͻ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		ta = new TextArea("�ֹ�����\n",10,30);ta.setBounds(200, 600, 500, 300);ta.setVisible(true);ta.setFont(new Font("����ǹ��� �ѳ�",1,15));
		JLabel acount = new JLabel("�ֹ� �ݾ� : 0 ��");acount.setBounds(700, 600, 300, 50);acount.setVisible(true);acount.setFont(new Font("����ǹ��� �ѳ�",1,30));
		JLabel menu = new JLabel("�Ͻ� �޴���");
		menu.setBounds(650, 50, 300, 100); menu.setFont(new Font("����ǹ��� �ѳ�", 1, 40));
		menu.setOpaque(true);add(menu);
		add(ta);
		acount.setOpaque(true);
		add(acount);
		for(int i=0;i<btn.length;i++) 
		{
			btn[i] = new JButton();
			if(i<=4) //0~4��° �Ͻ� �̹���
			{
				btn[i].setBounds(200+(i*150), 200,100, 100); //�Ͻ� ��ư�迭 ��ġ 
				btn[i].setIcon(changeImage(japanimages[i])); //�Ͻ� �̹��� ũ�� ����
				btn[i].setText(Integer.toString(money[i])); //����
				la[i] = new JLabel(japanName[i]); //�Ͻ� �̸�
				la[i].setBounds(200+(i*150),300,130,50);la[i].setFont(new Font("����ǹ��� �ѳ�",1,20)); //�Ͻ� �̸� ��Ʈ �� ��ġ
				la[i].setOpaque(true); //�Ͻ� �̸� ���̰�
				add(btn[i]);add(la[i]); //Frame�� add
			}
			else if(i>4) //5~9��° �Ͻ� �̹���
			{
				btn[i].setBounds(200+((i-5)*150), 440,100, 100);//�Ͻ� ��ư�迭 ��ġ
				btn[i].setIcon(changeImage(japanimages[i]));//�Ͻ� �̹��� ũ�� ����
				btn[i].setText(Integer.toString(money[i]));//����
				la[i] = new JLabel(japanName[i]);//�Ͻ� �̸�
				la[i].setBounds(200+((i-5)*150),540,130,50);la[i].setFont(new Font("����ǹ��� �ѳ�",1,20));//�Ͻ� �̸� ��Ʈ �� ��ġ
				la[i].setOpaque(true);//�Ͻ� �̸� ���̰�
				add(btn[i]);add(la[i]);//Frame�� add
			}
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton)e.getSource();
					int num = getButtonIndex(button);
					
					ta.append(japanName[num]+" ���� : "+button.getText()+"\n");
					sum+=Integer.parseInt(button.getText());
					acount.setText("�ֹ� �ݾ�: "+Integer.toString(sum)+ " ��");
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
