package SoundKey;

import java.io.File;
import java.net.URISyntaxException;

import javax.sound.sampled.*;

import Menu.Scene;

//이전 코드의 onlyMusic를 가져와 이름만 바꿈
public class PianoSoundPlay extends Thread {
	private File sound;
	private String fileName="";
	public boolean toStop = false;

	public PianoSoundPlay(File file) {

		sound = file;
	}// ../Gamemode_Image/Singleplay_Basic.png

	@Override
	public void run() {
		// TODO 자동 생성된 메소드 스텁
		AudioInputStream ai = null; // 음악 파일 입력
		SourceDataLine au = null;
		try {
			ai = AudioSystem.getAudioInputStream(sound);
		} catch (Exception e) {
			e.printStackTrace();
		}

		AudioFormat form = ai.getFormat(); // 포멧? 형태로 받아옴
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, form);
		// DataLine은 말그대로 데이터 라인
		// info라는 객체에는 포맷형태을 데이터라인을 기입할 수 있는 SourceDataLine 클래스를 통해 데이터라인을 구성하여 info라는
		// 객체에 담습니다.

		try {
			au = (SourceDataLine) AudioSystem.getLine(info);
			au.open(form);
			au.start();

			// 데이터 라인을 읽어 오고 format 형태로 실행
		} catch (Exception e) {
			// TODO: handle exception
		}

		int nBytedRead = 0; // 총 길이? 느낌으로 사용하는거 같음
		final int EBS = 524288; // 버퍼
		byte[] abData = new byte[EBS];

		try {
			while (nBytedRead != -1 && !toStop) {

				nBytedRead = ai.read(abData, 0, abData.length); // 이걸 통해서 while문 탈출과 음악파일 재생이 이루어 지는듯?

				if (nBytedRead >= 0 && !toStop)
					au.write(abData, 0, nBytedRead); // 음악파일 재생

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			au.drain(); // 음악 파일이 끝날때 까지 다음으로 넘어가지 않고 블록하는 기능
			au.close(); // 음악파일 연결 종료
		}
	}
}
