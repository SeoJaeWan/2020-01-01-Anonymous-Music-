package SoundKey;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

public class PianoSoundKey {

	public static Properties pianoKey = new Properties();   // 피아노만 현재 구현
	
//  피아노 버튼 
	protected static String[] pianoSet = {"a","s","d","f","z","x","c","q","w","e","r","t","j","k","l",";","m",",",".","i","o","p","[","]"};
	protected String[] pianoNote = {"도","레","미","파","솔","라","시","도#","레#","파#","솔#","라#"};
	protected HashMap<String, Integer> pianoPoint = new HashMap<String, Integer>(); //피아노 음에 대한 이미지 좌표
	
	
	public PianoSoundKey() {
		setPianoKey();
	}
	
	private void setPianoKey() {
		int j=0;
		int k=0;
		
		//이전 방식 코드가 좀 길어서 이렇게 했어용
		for(int i=1;i<=3;i++) {
			for(String str : pianoNote) {
				if(i<=2) {//이건 피아노 음 키 셋팅용
					pianoKey.setProperty(i+str, pianoSet[k]);
					k++;
				}
				if(!str.contains("#")) {//이거는 피아노음에 대한 이미지 좌표 저장용
					pianoPoint.put(i+str,338-(j*16));
					j++;
				}else {
					pianoPoint.put(i+str,pianoPoint.get(i+(str.charAt(0)+"")));
				}
			}
		}
	}
	
	public static void setPianoKey(int sound,String change) {	  // 키 설정 변경
		
		PianoSoundFile.piano.remove(pianoSet[sound]);
		pianoSet[sound] = change;
		
	}
	
	
}