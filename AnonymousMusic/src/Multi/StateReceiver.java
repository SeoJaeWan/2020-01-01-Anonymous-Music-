package Multi;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

import Multi.Util.Receive;

public class StateReceiver implements Runnable{

	private Socket user; 
	private DataInputStream inData;
	private PeopleList pl;
	
	public StateReceiver(Socket user,PeopleList pl) {
		try {
			this.user = user;
			this.pl = pl;
			this.inData = new DataInputStream(user.getInputStream());
			
			new Thread(this).start();
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String choice;
		System.out.println("여긴?");
		while(true) {
			choice = Receive.receiveString(inData);
			System.out.println("rudlek");
			
			String[] data = choice.split(":");
			System.out.println(Arrays.toString(data));
			if(data[0].equals("list")) {  // 유저 추가
				
				pl.removeLabel();  // 기존 라벨 전부 삭제
				
				pl.removeAll();
				
				for(int i = 1;i< data.length; i++) {
					pl.addPlayer(data[i]);
				}
				
				pl.printLabel();	// 라벨 출력
				
				pl.revalidate();
				pl.repaint();
			}
			else {  // 상태 변환	
				
				String state = data[1];
				int num = Integer.parseInt(data[2]);
				
				System.out.println(num);
				
				switch(state) {
				case "chat":
					pl.setChating(num);
					break;
				case "piano":
					pl.setPlaying(num);
					break;
				default:
					System.out.println("ErrorState");
					break;
				}
			}
		}
	}
}
