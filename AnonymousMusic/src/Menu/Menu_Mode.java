package Menu;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Multi.Multi_Ip;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Single.Single_Instrument;

public class Menu_Mode extends JPanel {
	private Image background = new ImageIcon(Scene.class.getResource("../Menu_Image/background.png")).getImage();
	private ImageIcon Singleplay_Basic = new ImageIcon(Scene.class.getResource("../Menu_Image/Singleplay_Basic.png"));
	private ImageIcon Singleplay_Entered = new ImageIcon(
			Scene.class.getResource("../Menu_Image/Singleplay_Entered.png"));
	private ImageIcon Multi_Basic = new ImageIcon(Scene.class.getResource("../Menu_Image/Multi_Basic.png"));
	private ImageIcon Multi_Entered = new ImageIcon(Scene.class.getResource("../Menu_Image/Multi_Entered.png"));
	private ImageIcon Manual_Basic = new ImageIcon(Scene.class.getResource("../Menu_Image/Manual_Basic.png"));
	private ImageIcon Manual_Entered = new ImageIcon(Scene.class.getResource("../Menu_Image/Manual_Entered.png"));
	private ImageIcon Back_Basic = new ImageIcon(Scene.class.getResource("../Menu_Image/Back_Basic.png"));
	private ImageIcon Back_Entered = new ImageIcon(Scene.class.getResource("../Menu_Image/Back_Entered.png"));

	private JButton SinglePlay;// 싱글녹음모드
	private JButton Multi;// 멀티녹음모드
	private JButton Manual;// 업적창
	private JButton Back;// 뒤로가기 버튼

	Scene sc;

	public Menu_Mode(Scene sc) {
		this.sc = sc;
		setLayout(null);

		SinglePlay = new JButton(Singleplay_Basic);
		Multi = new JButton(Multi_Basic);
		Manual = new JButton(Manual_Basic);
		Back = new JButton(Back_Basic);

		SinglePlay.setBorderPainted(false);
		SinglePlay.setContentAreaFilled(false);
		SinglePlay.setFocusPainted(false);
		Multi.setBorderPainted(false);
		Multi.setContentAreaFilled(false);
		Multi.setFocusPainted(false);
		Manual.setBorderPainted(false);
		Manual.setContentAreaFilled(false);
		Manual.setFocusPainted(false);
		Back.setBorderPainted(false);
		Back.setContentAreaFilled(false);
		Back.setFocusPainted(false);

		SinglePlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SinglePlay.setIcon(Singleplay_Entered);// 검게변한다
				SinglePlay.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SinglePlay.setIcon(Singleplay_Basic);// 다시 원상태로
				SinglePlay.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				SinglePlay.setIcon(Singleplay_Basic);
				// 원래 눌리면 녹음모드로
				sc.getContentPane().removeAll();
				sc.add(new Single_Instrument(sc));// 싱글 악기선택 피아노 뿐
			}
		});// 싱글리듬 녹음모드 이벤트처리

		Multi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Multi.setIcon(Multi_Entered);// 검게변한다
				Multi.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Multi.setIcon(Multi_Basic);// 다시 원상태로
				Multi.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				 Multi.setIcon(Multi_Basic);
				sc.getContentPane().removeAll();
				sc.add(new Multi_Ip(sc));
			}
		});// 멀티 녹음모드 이벤트

		Manual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Manual.setIcon(Manual_Entered);// 검게변한다
				Manual.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Manual.setIcon(Manual_Basic);// 다시 원상태로
				Manual.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Manual.setIcon(Manual_Basic);
				sc.getContentPane().removeAll();
				sc.add(new Manual_Start(sc));
				sc.repaint();
				sc.revalidate();
				// 원래 눌리면 업적으로
			}
		});// 업적이벤트

		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Back.setIcon(Back_Entered);// 검게변한다
				Back.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Back.setIcon(Back_Basic);// 다시 원상태로
				Back.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Back.setIcon(Back_Basic);
				sc.getContentPane().removeAll();
				sc.add(new Menu_Start(sc));
				// 원래 눌리면 뒤로가기
			}
		});// 뒤로가기

		add(SinglePlay);
		add(Multi);
		add(Manual);
		add(Back);

		SinglePlay.setBounds(300, 300, Singleplay_Basic.getIconWidth(), Singleplay_Basic.getIconHeight());
		Multi.setBounds(300, 400, Multi_Basic.getIconWidth(), Multi_Basic.getIconHeight());
		Manual.setBounds(300, 500, Manual_Basic.getIconWidth(), Manual_Basic.getIconHeight());
		Back.setBounds(300, 600, Back_Basic.getIconWidth(), Back_Basic.getIconHeight());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}

}