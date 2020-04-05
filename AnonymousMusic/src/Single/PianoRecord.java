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
	private ArrayList<ArrayList<String>> audioArr; //연주한 음 저장
	private AudioFormat f;
	private int OneSecond=44100*2;
	private String filePath = "";
	
	public PianoRecord(ArrayList<ArrayList<String>> arr, String filePath) {
	    AudioInputStream ais;
	    audioArr = arr;
	    this.filePath = filePath;
	    
	    try {
	    	//마지막에 녹음한 음의 초를 저장
	    	time = Double.parseDouble(audioArr.get(audioArr.size()-1).get(1));	
	    	
	    	ais = AudioSystem.getAudioInputStream(new File(PianoRecord.class.getResource("../Piano_Sound/" + audioArr.get(0).get(0)).toURI()));

		    f = ais.getFormat();
		   
		    //time이 음수가 됨
		    System.out.println("총 녹음 시간 : "+time);
		    
		    //녹음한 시간에 따른 버퍼 배열을 선언(마지막 음의 시작시간 + 2초 + 2(이건 인덱스가 넘치는걸 방지하기 위해서))
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
	    byte[] buffer = new byte[1024];  // 1024만큼의 바이트를 읽어옴
	    byte[] soundBuffer;
	    int i=0;
	   
	    do {			    
		    ais = AudioSystem.getAudioInputStream(new File(PianoRecord.class.getResource("../Piano_Sound/" + audioArr.get(i).get(0)).toURI()));
		                         
		    while ((read = ais.read(buffer)) != -1)      // 입력받을 바이트에서 buffer의 길이만큼 (1024) 데이터를 읽어와 리턴
		        baos.write(buffer, 0, read);
		    baos.flush();
		    soundBuffer = baos.toByteArray();
		   
		    //음의 시작점
		    time = Double.parseDouble(audioArr.get(i).get(1));
		    
		    mixBuffers(arr2, soundBuffer, time);
		    
		    i++;
		    baos.reset();//스트림을 리셋시킨다.
	    }while(i<audioArr.size());
	    
	    CreateWavFile(arr2);
	    System.out.println("녹음성공");
	}
	
	//파일만들기
	private void CreateWavFile(byte[] byteBufferC) throws IOException{
		//파일의 포맷이 22050hz 이기때문에 22050이 1초가 되고 (22050*time)+(22050*2)으로 총 파일 크기(시간)을 구한다.
		AudioInputStream ais2 = new AudioInputStream(new ByteArrayInputStream(byteBufferC), f, (int)(22050*time)+(22050*2));
		AudioSystem.write(ais2, AudioFileFormat.Type.WAVE, new File(filePath+".wav"));
	}
	
	//믹스하기
	private void mixBuffers(byte[] bufferA, byte[] bufferB, Double con) {
	    int c=0;
	    int i;	    
	    
	    //음의 시작시간
	    int startTime = (int)(44100*con*2);
	    
	    //시작 버퍼가 홀수이면 짝수로 만들어 준다
	    //왜냐하면 소리의 버퍼는 두개의 수가 음을 만든다.
	    if(startTime%2!=0) {
	    	startTime += 1;
	    }
	    
	    //음의 시작점부터 약 2초간 음을 막스한다.
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