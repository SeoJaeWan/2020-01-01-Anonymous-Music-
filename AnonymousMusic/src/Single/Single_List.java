package Single;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Menu.Menu_Mode;
import Menu.MusicController;
import Menu.Scene;
//곡 선택화면
public class Single_List extends JPanel {
	private Image background = new ImageIcon(Single_Instrument.class.getResource("../Single_Image/background.png"))
			.getImage();

	private ImageIcon leftButtonEnteredImage = new ImageIcon(
			Single_List.class.getResource("../Single_Image/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(
			Single_List.class.getResource("../Single_Image/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(
			Single_List.class.getResource("../Single_Image/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(
			Single_List.class.getResource("../Single_Image/rightButtonBasic.png"));

	private ImageIcon Back_Basic = new ImageIcon(Single_Instrument.class.getResource("../Single_Image/Back_Basic.png"));
	private ImageIcon Back_Entered = new ImageIcon(
			Single_Instrument.class.getResource("../Single_Image/Back_Entered.png"));

	Album_List Album_list = new Album_List();

	private Image Cover = Album_list.head.getImage();

	private JButton leftButton;
	private JButton rightButton;
	private JButton Start;
	private JButton Back;

	private Scene sc;

	Single_List(Scene sc) {
		this.sc = sc;
		setLayout(null);
		MusicController.closeBackground();
		leftButton = new JButton(leftButtonBasicImage);
		rightButton = new JButton(rightButtonBasicImage);
		Start = new JButton();
		Back = new JButton(Back_Basic);

		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Album_list.prevImage();
				repaint();
				revalidate();
			}
		});
		add(leftButton);

		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Album_list.nextImage();
				repaint();
				revalidate();
			}
		});
		add(rightButton);

		Start.setBounds(340, 100, 600, 450);
		Start.setBorderPainted(false);
		Start.setContentAreaFilled(false);
		Start.setFocusPainted(false);
		Start.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String selectedMusic = Album_list.current.getName();
				new Single_Namebranch(sc, selectedMusic);//Name_Branch로 넘겨서 해당곡이 바닐라인지 아닌지 확인
				
			}
		});
		add(Start);

		Back.setBounds(500, 700, 284, 107);
		Back.setBorderPainted(false);
		Back.setContentAreaFilled(false);
		Back.setFocusPainted(false);
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
				sc.add(new Single_Instrument(sc));
		//		sc.music.start();
				MusicController.startBackground();

			}
		});
		add(Back);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		g.drawImage(Album_list.currentImage(), 340, 100, null);
	}

}
