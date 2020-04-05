package Menu;

import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manual_Multi extends Manual {

	public Manual_Multi(Scene sc) {
		super(sc);
		sc.setBig();
		manual = new ImageIcon(Scene.class.getResource("../Manual_Image/Manual_Multi.png")).getImage();// 설명서 이미지
		canvas.setPreferredSize(new Dimension(1596,1712));
		
		prev.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.setSmall();
				sc.getContentPane().removeAll();
				sc.add(new Manual_Ip(sc));
				sc.revalidate();
			}
		});
		
		esc.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				sc.setSmall();
				sc.getContentPane().removeAll();
				sc.add(new Menu_Mode(sc));
				sc.revalidate();
			}
		});

		
		next.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.setSmall();
				sc.getContentPane().removeAll();
				sc.add(new Manual_Start(sc));
				sc.revalidate();
			}
		});
	
		prev.setBounds(500, 1600, prevIcon.getIconWidth(), prevIcon.getIconHeight());
		esc.setBounds(700, 1600, exitIcon.getIconWidth(), exitIcon.getIconHeight());
		next.setBounds(900, 1600, nextIcon.getIconWidth(), nextIcon.getIconHeight());
	}

}
