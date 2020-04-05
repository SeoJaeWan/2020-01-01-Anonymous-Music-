package Multi;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Menu.Scene;
import Server.EventParent;
import Single.Single_Keyevent;

public class Multi extends JPanel {
	private Image background = new ImageIcon(Scene.class.getResource("../Top_Image/Background.png")).getImage();

	Multi_Mid Multi_mid;// ��ư
	public Multi_Chat Multi_chat;// ä���г�
	File file = null;
	Scene sc;
	String nick;
	public Multi_Keyevent keyevent;
	// ���� �� ����
	public ArrayList<ArrayList<String>> pianoSoundRecord = new ArrayList<ArrayList<String>>();
	// keyOn, keyOff Ȯ�� map
	public ArrayList<String> pianoKeyRecord = new ArrayList<String>();

	Fiveline fiveline;// ������
	Keyboard keyboard;// Ű����
	public String ip;
	private Socket gameS;
	private Socket userS;
	private ClientReceiver clientReceiver;
	public ObjectOutputStream outObj;
	public DataOutputStream outData;

	public Multi(Scene sc, File getFile, String nickname,String ip) {
		this.sc = sc;
		this.nick = nickname;
		this.ip = ip;
		sc.setBig();// ���η� �ø���.
		setFocusable(true);
		setLayout(null);
		this.addKeyListener(keyevent = new Multi_Keyevent(this));
		this.file = getFile;
			try {
				gameS = new Socket(ip, 9004);
				userS = new Socket(ip, 9005);

			outObj = new ObjectOutputStream(gameS.getOutputStream());
			outData = new DataOutputStream(userS.getOutputStream());
			outData.writeUTF(nick);
			
			clientReceiver = new ClientReceiver(gameS, this);
			clientReceiver.start();
			//out.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Multi_chat = new Multi_Chat(this);
		Multi_mid = new Multi_Mid(this, file, gameS);
		add(Multi_mid);
		Multi_mid.setBounds(30, 430, Multi_mid.getWidth(), Multi_mid.getHeight());

		
		add(Multi_chat);
		Multi_chat.setBounds(1280, 0, Multi_chat.getWidth(), Multi_chat.getHeight());

		fiveline = new Fiveline();
		keyboard = new Keyboard();

		class MyThread extends Thread {
			public void run() {
				while (true) {
					fiveline.update();
					keyboard.update();
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {

					}
				}
			}
		}
		Thread t = new MyThread();
		t.start();
	}

	public String getNickName() {
		return nick;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		fiveline.draw(g);
		keyboard.draw(g);
	}
	
	public Socket getGameSocket() {
		return gameS;
	}
	public Socket getUserSocket() {
		return userS;
	}
}
