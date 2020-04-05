package Menu;

import javax.swing.JFrame;

public class Scene extends JFrame {
	public static final int SCREEN_WIDTH = 1280;// 고정 가로
	public static final int SCREEN_HEIGHT = 1024;// 고정 세로
	// JFrame 게임시작창

	public Scene() {
		//this.setUndecorated(true);
		this.setSmall();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Menu_Start(this));
		// ->Menu_Start 게임시작,종료,옵션 창으로 이동
		setVisible(true);
	}

	static MusicController Musiccontroller;

	public static void main(String[] args) {
		new Scene();
		Musiccontroller = new MusicController();
		Musiccontroller.startBackground();
	}

	public void setBig() {
		this.setSize(1605, 1024);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public void setSmall() {
		this.setSize(1280, 1024);
		setResizable(false);
		setLocationRelativeTo(null);
	}

}
