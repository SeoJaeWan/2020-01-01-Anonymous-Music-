package SoundKey;

import java.io.File;
import java.util.Enumeration;
import java.util.Properties;

import Menu.Scene;

public class PianoSoundFile extends PianoSoundKey {

	protected static Properties piano = new Properties();
	public static int set = 0;

	public PianoSoundFile() {

		setPianoFile();
	}

	private void setPianoFile() { // 피아노 키에 따른 음 파일 입력 13 24

		Enumeration<?> e = pianoKey.propertyNames();

		while (e.hasMoreElements()) {
			String element = (String) e.nextElement();

			piano.setProperty(pianoKey.getProperty(element), element + ".wav");
		}
	}

	public File getFile(String file) { // 키 입력에 대한 파일을 받아옴
		try {

			return new File(Scene.class.getResource("../Piano_Sound/" + file).toURI());
		} catch (Exception e) {
			// TODO: handle exception 
			return null;// 예외가 뜨면 공백을 리턴
		}
	}

	public String getFileName(String key) {
		try {
			int num = Integer.parseInt(piano.getProperty(key).charAt(0) + "");
			String str = piano.getProperty(key).substring(1);
			return (set + num) + str;
		} catch (Exception e) {
			// TODO: handle exception 
			return null;// 예외가 뜨면 공백을 리턴
		}
		
	}
	
	public int getPianoPoint(String file) {// 피아노 음에 대한 이미지 좌표를 불러온다.
		String note = file.substring(0, file.indexOf("."));// 음이름만 받아오기 위해서
		//System.out.print(note);
		return pianoPoint.get(note);
	}
}