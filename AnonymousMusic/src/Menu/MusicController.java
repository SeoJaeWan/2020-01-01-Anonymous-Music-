package Menu;

//Music을 Scene에서 하니까 왔다갔다 하면 음악재생에 문제가 생겨서 따로 MusicController라는 클래스 생성
public class MusicController {
	public static Music_Back music;// 배경 음악

	public MusicController() {

	}

	public static void startBackground() {
		music = new Music_Back("Let it be.mp3", true);// 배경 음악
		music.start();
	}

	public static void closeBackground() {
		music.close();
	}
}
