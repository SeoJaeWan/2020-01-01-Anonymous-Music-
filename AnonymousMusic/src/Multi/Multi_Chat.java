package Multi;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Server.ChatEvent;
import Server.EventParent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Multi_Chat extends JPanel {
	private Image peopleBack = new ImageIcon(Multi_Chat.class.getResource("../Chat_Image/peoBack.png")).getImage();
	private Image chatBack = new ImageIcon(Multi_Chat.class.getResource("../Chat_Image/chatBack.png")).getImage();

	PeopleList people;// 유저목록
	JScrollPane peopleScroll;// 유저목록스크롤

	public JTextArea ta;// 텍스트보여지는 영역
	JScrollPane sta;// 텍스트보여지는 영역스크롤

	JTextField tf;// 텍스트 치는창
	StateReceiver sr; // 유저 상태 쓰레드
	
	public Multi_Chat(Multi multi) {
		setLayout(null);
		setSize(new Dimension(320, 1024));

		people = new PeopleList(multi);
		peopleScroll = new JScrollPane(people) {
			{
				setOpaque(false);// 투명
			}
			public void paintComponent(Graphics g) {
				g.drawImage(peopleBack, 0, 0, null);// 화면그리기
			}
		};
		peopleScroll.getViewport().setOpaque(false);// 스크롤투명
		peopleScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		peopleScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(peopleScroll);
		peopleScroll.setBounds(0, 0, 320, 140);

		sr = new StateReceiver(multi.getUserSocket(), people);  // 쓰레드 실행
		
		ta = new JTextArea(45, 27);
		ta.setOpaque(false);
		ta.setForeground(Color.white);
		ta.setFont(new Font("굴림", 1, 15));
		ta.setEditable(false);
		sta = new JScrollPane(ta) {
			{
				setOpaque(false);
			}

			public void paintComponent(Graphics g) {
				g.drawImage(chatBack, 0, 0, null);
			}
		};
		ta.setLineWrap(true);// 자동줄바꿈
		sta.getViewport().setOpaque(false);
		sta.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sta.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(sta);
		sta.setBounds(0, 140, 320, 830);//프레임이 setUndecorate시에는 y축 크기를 860

		tf = new JTextField(29);
		add(tf);
		tf.setBounds(0, 970, 320, 30);//프레임이 setUndecorate 시에는 y축 좌표를 1000으로

		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				String str = tf.getText();
				switch (key) {
				case KeyEvent.VK_ENTER:
					try {
						multi.outObj.writeObject(new ChatEvent(multi.getNickName(),multi.nick + "> " + str + "\n"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//ta.append(str + "\n");
					tf.setText("");
					ta.setCaretPosition(ta.getDocument().getLength());
					break;
				case KeyEvent.VK_ESCAPE:// ESC키 누르면 게임모드로
					ta.setFocusable(false);
					multi.requestFocus();
					multi.setFocusable(true);
					break;
				}
			}
		});
	}
}
