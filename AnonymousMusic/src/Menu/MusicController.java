package Menu;

//Music�� Scene���� �ϴϱ� �Դٰ��� �ϸ� ��������� ������ ���ܼ� ���� MusicController��� Ŭ���� ����
public class MusicController {
	public static Music_Back music;// ��� ����

	public MusicController() {

	}

	public static void startBackground() {
		music = new Music_Back("Let it be.mp3", true);// ��� ����
		music.start();
	}

	public static void closeBackground() {
		music.close();
	}
}
