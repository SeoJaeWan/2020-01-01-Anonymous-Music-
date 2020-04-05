package Server;

import java.io.Serializable;
import java.util.ArrayList;

import Multi.Multi;
import SoundKey.PianoSoundPlay;

public class PianoEvent extends EventParent implements Serializable{
	private static final long serialVersionUID = 2658L;
	
	public PianoEvent(String name,String text) {
		super(name,"piano", text);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void event(Multi m) {
		// TODO Auto-generated method stub
		this.multi = m;
		
		new PianoSoundPlay(multi.keyevent.soundKey.getFile(getData())).start();// 피아노 소리 출력
		
		multi.pianoSoundRecord.add(new ArrayList<String>());
		multi.pianoSoundRecord.get(multi.keyevent.keyCount).add(getData());
		multi.pianoSoundRecord.get(multi.keyevent.keyCount).add(String.format("%.1f", (System.currentTimeMillis() / 100 - multi.keyevent.recordStartTime) / 10.0));

		multi.keyevent.keyCount++;
	}

}
