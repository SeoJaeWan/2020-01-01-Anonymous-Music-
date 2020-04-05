package Menu;

import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manual_List extends Manual {

	public Manual_List(Scene sc) {
		super(sc);
		manual = new ImageIcon(Scene.class.getResource("../Manual_Image/Manual_List.png")).getImage();// 설명서 이미지
		canvas.setPreferredSize(new Dimension(1280,1506));
		
		prev.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.setSmall();
				sc.getContentPane().removeAll();
				sc.add(new Manual_Instrument(sc));
				sc.revalidate();
			}
		});
		
		next.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.setSmall();
				sc.getContentPane().removeAll();
				sc.add(new Manual_Single(sc));
				sc.revalidate();
			}
		});
		
		prev.setBounds(300, 1450, prevIcon.getIconWidth(), prevIcon.getIconHeight());
		esc.setBounds(500, 1450, exitIcon.getIconWidth(), exitIcon.getIconHeight());
		next.setBounds(700, 1450, nextIcon.getIconWidth(), nextIcon.getIconHeight());
	}

}
