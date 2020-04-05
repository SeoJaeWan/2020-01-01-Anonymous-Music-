package Single;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import SoundKey.PianoSoundFile;
import SoundKey.PianoSoundPlay;

public class Single_Keyevent implements KeyListener {
	Single_Note note=new Single_Note();
	Single single;
	PianoSoundFile soundKey = new PianoSoundFile();
	boolean checkSpace = true;// �븙�꽱�듃媛� 耳쒖졇�엳�뒗吏� �븘�땶吏� �솗�씤. 利� �궎�뀑�씠 1�씤吏� 2�씤吏��솗�씤
	int keyCount = 0;//�끃�쓬 由ъ뒪�듃 �씤�뜳�뒪
	Long recordStartTime = (System.currentTimeMillis() / 100);//�떆�옉 �떆媛�
	
	// �뿬湲곗꽌 �궎 �씠踰ㅽ듃瑜� 愿�由ы븷�젮硫� Single 媛앹껜媛� �엳�뼱�빞�맖
	public Single_Keyevent(Single single) {
		// TODO Auto-generated constructor stub
		this.single = single;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// �쓬�몴李띻린 + �냼由ъ텧�젰
		String key = soundKey.getFileName(e.getKeyChar() + "");// 醫뚰몴 �쐞移섎�� 諛쏄퀬
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {// �뒪�럹�씠�뒪瑜� �늻瑜대㈃ �삦��釉�?媛� �삱�씪媛꾨떎
			if (PianoSoundFile.set > 0) {
				PianoSoundFile.set--;
				checkSpace = true;// �궎�뀑 2濡�
			} else {
				PianoSoundFile.set++;
				checkSpace = false;// �궎�뀑1濡�
			}
			single.ks.releaseAll();// �뒪�럹�씠�뒪諛� 利� �븙�꽱�듃媛� �닃�젮議뚯쑝�땲 紐⑤몢 �빐�젣 �븯寃좊떎.紐⑤뱺 �닃�윭吏먯쓣 �빐�젣
		} else if(!single.pianoKeyRecord.containsKey(key)){
			// �씠嫄� �썝蹂� �씠誘몄��쓽 諛깅텇瑜좊줈 �씠誘몄�瑜� 李띻린 �븣臾몄뿉 諛깅텇瑜좎쓣 援ы븿
			double s = single.fs.smbar.getX() / 1220.0 * 100.0;
			try {
				int position = soundKey.getPianoPoint(key);
				note.drawNote(single, s, position, key);
				new PianoSoundPlay(soundKey.getFile(key)).start();// �뵾�븘�끂 �냼由� 異쒕젰

				single.pianoSoundRecord.add(new ArrayList<String>());
				single.pianoSoundRecord.get(keyCount).add(key);
				single.pianoSoundRecord.get(keyCount).add(String.format("%.1f", (System.currentTimeMillis() / 100 - recordStartTime)/10.0));
				
				single.pianoKeyRecord.put(key, keyCount);
				keyCount++;
				
				if (checkSpace)
					single.ks.pressType1(key);
				else
					single.ks.pressType2(key);
				System.out.println(key);
			} catch (Exception e1) {
				// TODO: handle exception
				// e1.printStackTrace();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		try {
			String key = soundKey.getFileName(e.getKeyChar() + "");
			int num = single.pianoKeyRecord.get(key);
			single.pianoSoundRecord.get(num).add(String.format("%.1f", (System.currentTimeMillis() / 100 - recordStartTime)/10.0));
			
			single.pianoKeyRecord.remove(key);
			
			if (checkSpace)
				single.ks.releaseType1(key);
			else
				single.ks.releaseType2(key);
		} catch (Exception e1) {

		}
	}

}
