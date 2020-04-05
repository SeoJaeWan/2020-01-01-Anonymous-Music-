package Multi;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import Server.EventParent;
import Server.PianoEvent;
import SoundKey.PianoSoundFile;
import SoundKey.PianoSoundPlay;

public class Multi_Keyevent implements KeyListener {

	Multi multi;
	Multi_Note note = new Multi_Note();
	public PianoSoundFile soundKey = new PianoSoundFile();
	boolean checkSpace = true;// �Ǽ�Ʈ�� �����ִ��� �ƴ��� Ȯ��. �� Ű���� 1���� 2����Ȯ��
	public int keyCount = 0;// ���� ����Ʈ �ε���
	public Long recordStartTime = (System.currentTimeMillis() / 100);// ���� �ð�

	// ���⼭ Ű �̺�Ʈ�� �����ҷ��� Multi ��ü�� �־�ߵ�
	public Multi_Keyevent(Multi multi) {
		// TODO Auto-generated constructor stub
		this.multi = multi;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// ��ǥ��� + �Ҹ����
		String key = soundKey.getFileName(e.getKeyChar() + "");// ��ǥ ��ġ�� �ް�
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {// �����̽��� ������ ��Ÿ��?�� �ö󰣴�
			if (PianoSoundFile.set > 0) {
				PianoSoundFile.set--;
				checkSpace = true;// Ű�� 2��
			} else {
				PianoSoundFile.set++;
				checkSpace = false;// Ű��1��
			}
			multi.keyboard.releaseAll();
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {// ���� ������ ä��ġ����
			multi.Multi_chat.tf.requestFocus();
			multi.Multi_chat.tf.setFocusable(true);
		} else if (!multi.pianoKeyRecord.contains(key)) {
			// �̰� ���� �̹����� ��з��� �̹����� ��� ������ ��з��� ����
			double s = multi.fiveline.jmbar.getX() / 1220.0 * 100.0;
			try {
				int position = soundKey.getPianoPoint(key);
				note.drawNote(multi, s, position, key);
				
				
				EventParent event = new PianoEvent(multi.getNickName(),key);
				multi.outObj.writeObject(event);
				
				multi.pianoKeyRecord.add(key);
				//multi.out.flush();
				if (checkSpace) {
					multi.keyboard.pressType1(key);
				} else {
					multi.keyboard.pressType2(key);
				}
			} catch (Exception e1) {
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		try {
			String key = soundKey.getFileName(e.getKeyChar() + "");
			//int num = multi.pianoKeyRecord.get(key);
			//multi.pianoSoundRecord.get(num)
					//.add(String.format("%.1f", (System.currentTimeMillis() / 100 - recordStartTime) / 10.0));

			multi.pianoKeyRecord.remove(key);

			if (checkSpace) {
				multi.keyboard.releaseType1(key);
			} else {
				multi.keyboard.releaseType2(key);
			}
		} catch (Exception e1) {

		}
	}

}