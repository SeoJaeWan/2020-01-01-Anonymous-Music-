package Menu;

import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manual_Single extends Manual {

	public Manual_Single(Scene sc) {
		super(sc);
		manual = new ImageIcon(Scene.class.getResource("../Manual_Image/Manual_Singleplay.png")).getImage();// 설명서 이미지
		canvas.setPreferredSize(new Dimension(1280,3480));

		prev.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.getContentPane().removeAll();
				sc.add(new Manual_List(sc));
				sc.revalidate();
			}
		});
		
		next.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				sc.getContentPane().removeAll();
				sc.add(new Manual_Ip(sc));
				sc.revalidate();
			}
		});
	
		prev.setBounds(300, 3380, prevIcon.getIconWidth(), prevIcon.getIconHeight());
		esc.setBounds(500, 3380, exitIcon.getIconWidth(), exitIcon.getIconHeight());
		next.setBounds(700, 3380, nextIcon.getIconWidth(), nextIcon.getIconHeight());
	}

}
