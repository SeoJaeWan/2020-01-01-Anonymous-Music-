package Multi;

import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Image;

import Single.Single;
import Single.Single_Note;

public class Multi_Note extends Thread {
	Image Note = new ImageIcon(Single_Note.class.getResource("../Single_Image/Note1.png")).getImage();
	Image Note2 = new ImageIcon(Single_Note.class.getResource("../Single_Image/Note#.png")).getImage();
	Fiveline fiveline;
	private int maxWidth = 1230;

	public void drawNote(Multi multi, double s, int y, String key) {
		fiveline=multi.fiveline;
		Graphics g=fiveline.fg;
		int x = (int) (maxWidth * s / 100.0);

		if (!key.contains("#"))
			g.drawImage(Note, x, y, null);
		else
			g.drawImage(Note2, x, y, null);

	}
}
