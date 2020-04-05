package SoundKey;

import java.io.File;
import java.net.URISyntaxException;

import javax.sound.sampled.*;

import Menu.Scene;

//���� �ڵ��� onlyMusic�� ������ �̸��� �ٲ�
public class PianoSoundPlay extends Thread {
	private File sound;
	private String fileName="";
	public boolean toStop = false;

	public PianoSoundPlay(File file) {

		sound = file;
	}// ../Gamemode_Image/Singleplay_Basic.png

	@Override
	public void run() {
		// TODO �ڵ� ������ �޼ҵ� ����
		AudioInputStream ai = null; // ���� ���� �Է�
		SourceDataLine au = null;
		try {
			ai = AudioSystem.getAudioInputStream(sound);
		} catch (Exception e) {
			e.printStackTrace();
		}

		AudioFormat form = ai.getFormat(); // ����? ���·� �޾ƿ�
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, form);
		// DataLine�� ���״�� ������ ����
		// info��� ��ü���� ���������� �����Ͷ����� ������ �� �ִ� SourceDataLine Ŭ������ ���� �����Ͷ����� �����Ͽ� info���
		// ��ü�� ����ϴ�.

		try {
			au = (SourceDataLine) AudioSystem.getLine(info);
			au.open(form);
			au.start();

			// ������ ������ �о� ���� format ���·� ����
		} catch (Exception e) {
			// TODO: handle exception
		}

		int nBytedRead = 0; // �� ����? �������� ����ϴ°� ����
		final int EBS = 524288; // ����
		byte[] abData = new byte[EBS];

		try {
			while (nBytedRead != -1 && !toStop) {

				nBytedRead = ai.read(abData, 0, abData.length); // �̰� ���ؼ� while�� Ż��� �������� ����� �̷�� ���µ�?

				if (nBytedRead >= 0 && !toStop)
					au.write(abData, 0, nBytedRead); // �������� ���

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			au.drain(); // ���� ������ ������ ���� �������� �Ѿ�� �ʰ� ����ϴ� ���
			au.close(); // �������� ���� ����
		}
	}
}
