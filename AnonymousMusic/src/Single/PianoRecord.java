package Single;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class PianoRecord {
	private double time = 0.0;
	private ArrayList<ArrayList<String>> audioArr; //������ �� ����
	private AudioFormat f;
	private int OneSecond=44100*2;
	private String filePath = "";
	
	public PianoRecord(ArrayList<ArrayList<String>> arr, String filePath) {
	    AudioInputStream ais;
	    audioArr = arr;
	    this.filePath = filePath;
	    
	    try {
	    	//�������� ������ ���� �ʸ� ����
	    	time = Double.parseDouble(audioArr.get(audioArr.size()-1).get(1));	
	    	
	    	ais = AudioSystem.getAudioInputStream(new File(PianoRecord.class.getResource("../Piano_Sound/" + audioArr.get(0).get(0)).toURI()));

		    f = ais.getFormat();
		   
		    //time�� ������ ��
		    System.out.println("�� ���� �ð� : "+time);
		    
		    //������ �ð��� ���� ���� �迭�� ����(������ ���� ���۽ð� + 2�� + 2(�̰� �ε����� ��ġ�°� �����ϱ� ���ؼ�))
		    byte[] arr2 = new byte[(int)(44100*2*time)+OneSecond*2+2];
			
		    wavFileRead(arr2);
	    }catch (Exception e) {
	    	e.printStackTrace();
		}
	}
	
	private void wavFileRead(byte[] arr2) throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    AudioInputStream ais;
	    int read;
	    byte[] buffer = new byte[1024];  // 1024��ŭ�� ����Ʈ�� �о��
	    byte[] soundBuffer;
	    int i=0;
	   
	    do {			    
		    ais = AudioSystem.getAudioInputStream(new File(PianoRecord.class.getResource("../Piano_Sound/" + audioArr.get(i).get(0)).toURI()));
		                         
		    while ((read = ais.read(buffer)) != -1)      // �Է¹��� ����Ʈ���� buffer�� ���̸�ŭ (1024) �����͸� �о�� ����
		        baos.write(buffer, 0, read);
		    baos.flush();
		    soundBuffer = baos.toByteArray();
		   
		    //���� ������
		    time = Double.parseDouble(audioArr.get(i).get(1));
		    
		    mixBuffers(arr2, soundBuffer, time);
		    
		    i++;
		    baos.reset();//��Ʈ���� ���½�Ų��.
	    }while(i<audioArr.size());
	    
	    CreateWavFile(arr2);
	    System.out.println("��������");
	}
	
	//���ϸ����
	private void CreateWavFile(byte[] byteBufferC) throws IOException{
		//������ ������ 22050hz �̱⶧���� 22050�� 1�ʰ� �ǰ� (22050*time)+(22050*2)���� �� ���� ũ��(�ð�)�� ���Ѵ�.
		AudioInputStream ais2 = new AudioInputStream(new ByteArrayInputStream(byteBufferC), f, (int)(22050*time)+(22050*2));
		AudioSystem.write(ais2, AudioFileFormat.Type.WAVE, new File(filePath+".wav"));
	}
	
	//�ͽ��ϱ�
	private void mixBuffers(byte[] bufferA, byte[] bufferB, Double con) {
	    int c=0;
	    int i;	    
	    
	    //���� ���۽ð�
	    int startTime = (int)(44100*con*2);
	    
	    //���� ���۰� Ȧ���̸� ¦���� ����� �ش�
	    //�ֳ��ϸ� �Ҹ��� ���۴� �ΰ��� ���� ���� �����.
	    if(startTime%2!=0) {
	    	startTime += 1;
	    }
	    
	    //���� ���������� �� 2�ʰ� ���� �����Ѵ�.
	    for(i=startTime;i<startTime+(OneSecond*2);) {
	    	int buf1A = bufferA[i+1];
    		int buf2A = bufferA[i];
	        buf1A = (int) ((buf1A & 0xff) << 8);
	        buf2A = (int) (buf2A & 0xff);
	        
	        int buf1B = bufferB[c+1];
	        int buf2B = bufferB[c];
	        buf1B = (int) ((buf1B & 0xff) << 8);
	        buf2B = (int) (buf2B & 0xff);

	        int buf1C = (int) (buf1A + buf1B);
	        int buf2C = (int) (buf2A + buf2B);

	        int res = (int) (buf1C + buf2C);

	        bufferA[i] = (byte) res;
	        bufferA[i+1] = (byte) (res >> 8);
	        i = i+2;
	        c = c+2;
	    }
	}

}