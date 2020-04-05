package Single;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Menu.Scene;

public class Single extends JPanel {
//�떛湲� 裕ㅼ쭅寃� �븯�뒗 怨�
	Fivesingle fs;// �븙蹂�,�쓬�몴
	Mid mid;// 踰꾪듉�뱾
	Keysingle ks;// �뵾�븘�끂 嫄대컲
	Scene sc;
	File file = null;
	Single_Keyevent keyevent;
	// �끃�쓬 �쓬 ���옣
	public ArrayList<ArrayList<String>> pianoSoundRecord = new ArrayList<ArrayList<String>>();
	// keyOn, keyOff �솗�씤 map
	public Map<String, Integer> pianoKeyRecord = new HashMap<String, Integer>();

	// �깉 諛곌꼍�씠誘몄�濡� 諛붽퓭二쇱꽭�슂
	private Image background = new ImageIcon(Scene.class.getResource("../Top_Image/Background.png")).getImage();

	public Single(Scene sc, File getFile) {
		this.sc = sc;
		this.file = getFile;

		setLayout(null);
		setFocusable(true);
		this.addKeyListener(keyevent = new Single_Keyevent(this));

		fs = new Fivesingle();// �븙蹂�

		mid = new Mid(this, true, file);// 踰꾪듉�뱾
		add(mid);
		mid.setBounds(30, 430, mid.getWidth(), mid.getHeight());

		ks = new Keysingle();// �뵾�븘�끂嫄대컲

		class MyThread extends Thread {
			public void run() {
				while (true) {
					fs.update();
					ks.update();
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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		fs.draw(g);
		ks.draw(g);
	}
}
