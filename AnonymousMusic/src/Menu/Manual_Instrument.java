package Menu;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manual_Instrument extends Manual {

	public Manual_Instrument(Scene sc) {
		super(sc);
		manual = new ImageIcon(Scene.class.getResource("../Manual_Image/Manual_Instrument.png")).getImage();// 설명서 이미지
		prev.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.getContentPane().removeAll();
				sc.add(new Manual_Mode(sc));
				sc.revalidate();
			}
		});
		next.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.getContentPane().removeAll();
				sc.add(new Manual_List(sc));
				sc.revalidate();
			}
		});
	}

}
