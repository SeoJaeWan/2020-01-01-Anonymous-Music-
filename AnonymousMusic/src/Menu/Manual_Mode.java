package Menu;

import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manual_Mode extends Manual {

	public Manual_Mode(Scene sc) {
		super(sc);
		manual = new ImageIcon(Scene.class.getResource("../Manual_Image/Manual_Mode.png")).getImage();// 설명서 이미지
	
		canvas.setPreferredSize(new Dimension(1280,1800));
		
		prev.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.getContentPane().removeAll();
				sc.add(new Manual_Start(sc));
				sc.revalidate();
			}
		});
		
		next.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.getContentPane().removeAll();
				sc.add(new Manual_Instrument(sc));
				sc.revalidate();
			}
		});
	
		prev.setBounds(300, 1700, prevIcon.getIconWidth(), prevIcon.getIconHeight());
		esc.setBounds(500, 1700, exitIcon.getIconWidth(), exitIcon.getIconHeight());
		next.setBounds(700, 1700, nextIcon.getIconWidth(), nextIcon.getIconHeight());
	}
}
