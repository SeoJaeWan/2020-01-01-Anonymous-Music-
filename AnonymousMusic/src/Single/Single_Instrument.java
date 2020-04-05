package Single;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Menu.Scene;
import Menu.Menu_Mode;

public class Single_Instrument extends JPanel {
	private ImageIcon Piano_Background = new ImageIcon(
			Single_Instrument.class.getResource("../Single_Image/Piano_Choice.png"));// �޹�� �̹���

	private ImageIcon Back_Basic = new ImageIcon(Single_Instrument.class.getResource("../Single_Image/Back_Basic.png"));
	private ImageIcon Back_Entered = new ImageIcon(
			Single_Instrument.class.getResource("../Single_Image/Back_Entered.png"));
	// �ڷΰ��� ��ư

	private Image background;// ���
	private JLabel Piano;// �ǾƳ�
	private JButton Back;// �ڷΰ����ư
	
	private Scene sc;

	public Single_Instrument(Scene sc) {
		this.sc = sc;

		setLayout(null);
		background = Piano_Background.getImage();

		Piano = new JLabel();// �ǾƳ� ���� ��
		Back = new JButton(Back_Basic);// �ڷΰ��� ��ư

		add(Piano);
		Piano.setBounds(900, 500, 400, 400);// �ǾƳ� �� ũ��

		add(Back);
		Back.setBorderPainted(false);
		Back.setContentAreaFilled(false);
		Back.setFocusPainted(false);
		Back.setBounds(50, 50, 284, 107);

		Piano.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				revalidate();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				sc.getContentPane().removeAll();
				sc.add(new Single_List(sc));//�ǾƳ� ���� ��-> ���ȭ������
				sc.revalidate();
			}
		});

		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Back.setIcon(Back_Entered);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Back.setIcon(Back_Basic);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Back.setIcon(Back_Basic);
				sc.getContentPane().removeAll();
				sc.add(new Menu_Mode(sc));
			}
		});
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}

}
