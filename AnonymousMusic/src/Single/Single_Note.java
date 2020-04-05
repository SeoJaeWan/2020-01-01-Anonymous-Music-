package Single;

import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Image;

public class Single_Note extends Thread {
	Image Note = new ImageIcon(Single_Note.class.getResource("../Single_Image/Note1.png")).getImage();
	Image Note2 = new ImageIcon(Single_Note.class.getResource("../Single_Image/Note#.png")).getImage();
	Fivesingle fs;
	private int maxWidth = 1230;

	public Single_Note() {// ��з��� ��ǥ ���
	}

	public void drawNote(Single single, double s, int y, String key) {
		fs=single.fs;
		Graphics g = fs.fg;//�������׸��� �׷���
		int x = (int) (maxWidth * s / 100.0);

		if (!key.contains("#"))
			g.drawImage(Note, x, y, null);
		else
			g.drawImage(Note2, x, y, null);
	}
}
