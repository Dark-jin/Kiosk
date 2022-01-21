package Source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Card extends JDialog
{
	JButton okbtn = new JButton("확 인"); // 확인 버튼
	JTextField tf = new JTextField("******-******-****");
	public Card()
	{
		setTitle("Card Payment");
		setLayout(null);
		// 카드 일련 번호 //
		tf.setBounds(70, 80, 150, 30); // 위치는 나중에 수정
		tf.setFont(new Font("배달의민족 한나",1,20));
		add(tf);
		// 확인 버튼 //
		okbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		okbtn.setBounds(100, 150, 100, 50); // 위치는 나중에 수정
		okbtn.setFont(new Font("배달의민족 한나",1,20));
		add(okbtn);
		setSize(300,300);
		setLocationRelativeTo(null);
	}
}
