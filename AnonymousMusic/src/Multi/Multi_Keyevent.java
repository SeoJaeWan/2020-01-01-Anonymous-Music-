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
	boolean checkSpace = true;// 악센트가 켜져있는지 아닌지 확인. 즉 키셋이 1인지 2인지확인
	public int keyCount = 0;// 녹음 리스트 인덱스
	public Long recordStartTime = (System.currentTimeMillis() / 100);// 시작 시간

	// 여기서 키 이벤트를 관리할려면 Multi 객체가 있어야됨
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
		// 음표찍기 + 소리출력
		String key = soundKey.getFileName(e.getKeyChar() + "");// 좌표 위치를 받고
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {// 스페이스를 누르면 옥타브?가 올라간다
			if (PianoSoundFile.set > 0) {
				PianoSoundFile.set--;
				checkSpace = true;// 키셋 2로
			} else {
				PianoSoundFile.set++;
				checkSpace = false;// 키셋1로
			}
			multi.keyboard.releaseAll();
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {// 엔터 누르면 채팅치도록
			multi.Multi_chat.tf.requestFocus();
			multi.Multi_chat.tf.setFocusable(true);
		} else if (!multi.pianoKeyRecord.contains(key)) {
			// 이건 원본 이미지의 백분률로 이미지를 찍기 때문에 백분률을 구함
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