package Menu;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//게임시작, 옵션, 종료
public class Menu_Start extends JPanel {
	private Image background = new ImageIcon(Scene.class.getResource("../Menu_Image/background.jpg")).getImage();// 배경이미지
	private ImageIcon Start_BasicImage = new ImageIcon(Scene.class.getResource("../Menu_Image/Start_basic.png"));// 스타트기본이미지
	private ImageIcon Start_EnteredImage = new ImageIcon(Scene.class.getResource("../Menu_Image/Start_Entered.png"));// 스타트검은이미지.
	private ImageIcon Setting_BasicImage = new ImageIcon(Scene.class.getResource("../Menu_Image/Setting_basic.png"));// 옵션기본이미지
	private ImageIcon Setting_EnteredImage = new ImageIcon(
			Scene.class.getResource("../Menu_Image/Setting_Entered.png"));// 옵션검은이미지.
	private ImageIcon Exit_BasicImage = new ImageIcon(Scene.class.getResource("../Menu_Image/Exit_basic.png"));// 종료기본이미지
	private ImageIcon Exit_EnteredImage = new ImageIcon(Scene.class.getResource("../Menu_Image/Exit_entered.png"));// 옵션검은이미지.
	// 여기까지 기본 이미지

	private JButton Start;// 게임 시작버튼
	private JButton Setting;// 게임 옵션 버튼
	private JButton Exit;// 게임 종료 버튼

	Scene sc;

	public Menu_Start(Scene scene) {
		this.sc = scene;
		setLayout(null);

		setLayout(null);
		Start = new JButton(Start_BasicImage);// 게임스타트버튼 이미지가 Start_BasicImage로
		Setting = new JButton(Setting_BasicImage);// 게임옵션버튼 이미지가 Setting_BasicImage로
		Exit = new JButton(Exit_BasicImage);// 게임종료버튼 이미지가 Exit_BasicImage로

		Start.setBorderPainted(false);// 버튼에 기본적으로 설정되있는 옵션해제
		Start.setContentAreaFilled(false);
		Start.setFocusPainted(false);
		Setting.setBorderPainted(false);
		Setting.setContentAreaFilled(false);
		Setting.setFocusPainted(false);
		Exit.setBorderPainted(false);
		Exit.setContentAreaFilled(false);
		Exit.setFocusPainted(false);

		Start.addMouseListener(new MouseAdapter() {// 게임 시작 버튼을 눌렀을 때 이벤트
			@Override
			public void mouseEntered(MouseEvent e) {
				Start.setIcon(Start_EnteredImage);// 검게변한다
				Start.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}// 마우스 커서가 버튼에 올라갔을때의 반응

			@Override
			public void mouseExited(MouseEvent e) {
				Start.setIcon(Start_BasicImage);// 기본 이미지로 변한다.
				Start.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}// 마우스 커서가 바깥으로 나갔을 때의 반응

			@Override
			public void mousePressed(MouseEvent e) {
				Start.setIcon(Start_BasicImage);

				// 게임 모드 선택화면으로 넘어간다.
				scene.getContentPane().removeAll();
				scene.add(new Menu_Mode(sc));//->게임모드로 싱글레코드, 멀티레코드
			}// 버튼을 누름
		});

		Setting.addMouseListener(new MouseAdapter() {// 게임 세팅 버튼을 눌렀을 때 이벤트
			@Override
			public void mouseEntered(MouseEvent e) {
				Setting.setIcon(Setting_EnteredImage);// 검게변한다
				Setting.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}// 마우스 커서가 버튼에 올라갔을때의 반응

			@Override
			public void mouseExited(MouseEvent e) {
				Setting.setIcon(Setting_BasicImage);// 기본 이미지로 변한다.
				Setting.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}// 마우스 커서가 바깥으로 나갔을 때의 반응

			@Override
			public void mousePressed(MouseEvent e) {
				Setting.setIcon(Setting_BasicImage);
				new Alert();//설정없으니 경고창!
				// 게임 세팅화면으로 넘어간다.
			}// 버튼을 누름
		});

		Exit.addMouseListener(new MouseAdapter() {// 게임 종료 버튼을 눌렀을 때 이벤트
			@Override
			public void mouseEntered(MouseEvent e) {
				Exit.setIcon(Exit_EnteredImage);// 검게변한다
				Exit.setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}// 마우스 커서가 버튼에 올라갔을때의 반응

			@Override
			public void mouseExited(MouseEvent e) {
				Exit.setIcon(Exit_BasicImage);// 기본 이미지로 변한다.
				Exit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}// 마우스 커서가 바깥으로 나갔을 때의 반응

			@Override
			public void mousePressed(MouseEvent e) {
				Exit.setIcon(Exit_BasicImage);
				System.exit(0);
			}// 버튼을 누름
		});
		add(Start);
		add(Setting);
		add(Exit);
		Start.setBounds(300, 300, Start_BasicImage.getIconWidth(), Start_BasicImage.getIconHeight());
		Setting.setBounds(300, 500, Setting_BasicImage.getIconWidth(), Setting_BasicImage.getIconHeight());
		Exit.setBounds(300, 700, Exit_BasicImage.getIconWidth(), Exit_BasicImage.getIconHeight());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
