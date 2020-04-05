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

	private void setPianoFile() { // �ǾƳ� Ű�� ���� �� ���� �Է� 13 24

		Enumeration<?> e = pianoKey.propertyNames();

		while (e.hasMoreElements()) {
			String element = (String) e.nextElement();

			piano.setProperty(pianoKey.getProperty(element), element + ".wav");
		}
	}

	public File getFile(String file) { // Ű �Է¿� ���� ������ �޾ƿ�
		try {

			return new File(Scene.class.getResource("../Piano_Sound/" + file).toURI());
		} catch (Exception e) {
			// TODO: handle exception 
			return null;// ���ܰ� �߸� ������ ����
		}
	}

	public String getFileName(String key) {
		try {
			int num = Integer.parseInt(piano.getProperty(key).charAt(0) + "");
			String str = piano.getProperty(key).substring(1);
			return (set + num) + str;
		} catch (Exception e) {
			// TODO: handle exception 
			return null;// ���ܰ� �߸� ������ ����
		}
		
	}
	
	public int getPianoPoint(String file) {// �ǾƳ� ���� ���� �̹��� ��ǥ�� �ҷ��´�.
		String note = file.substring(0, file.indexOf("."));// ���̸��� �޾ƿ��� ���ؼ�
		//System.out.print(note);
		return pianoPoint.get(note);
	}
}