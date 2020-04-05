package SoundKey;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

public class PianoSoundKey {

	public static Properties pianoKey = new Properties();   // �ǾƳ븸 ���� ����
	
//  �ǾƳ� ��ư 
	protected static String[] pianoSet = {"a","s","d","f","z","x","c","q","w","e","r","t","j","k","l",";","m",",",".","i","o","p","[","]"};
	protected String[] pianoNote = {"��","��","��","��","��","��","��","��#","��#","��#","��#","��#"};
	protected HashMap<String, Integer> pianoPoint = new HashMap<String, Integer>(); //�ǾƳ� ���� ���� �̹��� ��ǥ
	
	
	public PianoSoundKey() {
		setPianoKey();
	}
	
	private void setPianoKey() {
		int j=0;
		int k=0;
		
		//���� ��� �ڵ尡 �� �� �̷��� �߾��
		for(int i=1;i<=3;i++) {
			for(String str : pianoNote) {
				if(i<=2) {//�̰� �ǾƳ� �� Ű ���ÿ�
					pianoKey.setProperty(i+str, pianoSet[k]);
					k++;
				}
				if(!str.contains("#")) {//�̰Ŵ� �ǾƳ����� ���� �̹��� ��ǥ �����
					pianoPoint.put(i+str,338-(j*16));
					j++;
				}else {
					pianoPoint.put(i+str,pianoPoint.get(i+(str.charAt(0)+"")));
				}
			}
		}
	}
	
	public static void setPianoKey(int sound,String change) {	  // Ű ���� ����
		
		PianoSoundFile.piano.remove(pianoSet[sound]);
		pianoSet[sound] = change;
		
	}
	
	
}