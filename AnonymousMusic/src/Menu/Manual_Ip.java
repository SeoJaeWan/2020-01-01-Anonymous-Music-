package Menu;

import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manual_Ip extends Manual {

	public Manual_Ip(Scene sc) {
		super(sc);
		manual = new ImageIcon(Scene.class.getResource("../Manual_Image/Manual_Ip.png")).getImage();// 설명서 이미지
		canvas.setPreferredSize(new Dimension(1280,1674));

		prev.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.getContentPane().removeAll();
				sc.add(new Manual_Single(sc));
				sc.revalidate();
			}
		});
		
		next.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.getContentPane().removeAll();
				sc.add(new Manual_Multi(sc));
				sc.revalidate();
			}
		});
	
		prev.setBounds(300, 1550, prevIcon.getIconWidth(), prevIcon.getIconHeight());
		esc.setBounds(500, 1550, exitIcon.getIconWidth(), exitIcon.getIconHeight());
		next.setBounds(700, 1550, nextIcon.getIconWidth(), nextIcon.getIconHeight());
	}

}
