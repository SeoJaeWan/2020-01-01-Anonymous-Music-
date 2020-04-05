package Menu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manual extends JPanel {
	protected ImageIcon prevIcon = new ImageIcon(Scene.class.getResource("../Manual_Image/prev.png"));
	protected ImageIcon exitIcon = new ImageIcon(Scene.class.getResource("../Manual_Image/exit.png"));
	protected ImageIcon nextIcon = new ImageIcon(Scene.class.getResource("../Manual_Image/next.png"));
	
	protected Image manual;// 설명서 이미지
	protected JPanel canvas;// 스크롤달 패널
	protected JButton prev;// 뒤로가기 버튼
	protected JButton esc;// 메뉴로 바로가기
	protected JButton next;// 다음 메뉴얼로

	public Manual(Scene sc) {
		//상속 받을 때 manualName 이름 정하고 prev,esc 버튼에 이벤트를 넣어줘야한다
		//canvas의 setPreferredSize도 조절해줘야한다. 버튼의 좌표도 조절해줘야한다
		//manual = new ImageIcon(Scene.class.getResource("../Manual_Image/StartManual.png")).getImage();// 설명서 이미지
		prev = new JButton(prevIcon);
		esc = new JButton(exitIcon);
		next = new JButton(nextIcon);

		prev.setBorderPainted(false);
		prev.setContentAreaFilled(false);
		prev.setFocusPainted(false);
		esc.setBorderPainted(false);
		esc.setContentAreaFilled(false);
		esc.setFocusPainted(false);
		next.setBorderPainted(false);
		next.setContentAreaFilled(false);
		next.setFocusPainted(false);
		
		this.canvas = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(manual, 0, 0, null);
			}
		};
		canvas.setPreferredSize(new Dimension(1280, 1500));
		canvas.setLayout(null);
		canvas.add(prev);
		canvas.add(esc);
		canvas.add(next);

		
		
		esc.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				sc.getContentPane().removeAll();
				sc.add(new Menu_Mode(sc));
				sc.revalidate();
			}
		});
		
		prev.setBounds(300, 1400, prevIcon.getIconWidth(), prevIcon.getIconHeight());
		esc.setBounds(500, 1400, exitIcon.getIconWidth(), exitIcon.getIconHeight());
		next.setBounds(700, 1400, nextIcon.getIconWidth(), nextIcon.getIconHeight());
	

		JScrollPane sp = new JScrollPane(canvas);// 스크롤
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		setLayout(new BorderLayout());
		add(sp, BorderLayout.CENTER);
	}
}
