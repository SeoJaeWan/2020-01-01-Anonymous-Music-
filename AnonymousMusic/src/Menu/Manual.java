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
	
	protected Image manual;// ���� �̹���
	protected JPanel canvas;// ��ũ�Ѵ� �г�
	protected JButton prev;// �ڷΰ��� ��ư
	protected JButton esc;// �޴��� �ٷΰ���
	protected JButton next;// ���� �޴����

	public Manual(Scene sc) {
		//��� ���� �� manualName �̸� ���ϰ� prev,esc ��ư�� �̺�Ʈ�� �־�����Ѵ�
		//canvas�� setPreferredSize�� ����������Ѵ�. ��ư�� ��ǥ�� ����������Ѵ�
		//manual = new ImageIcon(Scene.class.getResource("../Manual_Image/StartManual.png")).getImage();// ���� �̹���
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
	

		JScrollPane sp = new JScrollPane(canvas);// ��ũ��
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		setLayout(new BorderLayout());
		add(sp, BorderLayout.CENTER);
	}
}
