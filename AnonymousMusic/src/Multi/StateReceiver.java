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
			// TODO �ڵ� ������ catch ���
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		String choice;
		System.out.println("����?");
		while(true) {
			choice = Receive.receiveString(inData);
			System.out.println("rudlek");
			
			String[] data = choice.split(":");
			System.out.println(Arrays.toString(data));
			if(data[0].equals("list")) {  // ���� �߰�
				
				pl.removeLabel();  // ���� �� ���� ����
				
				pl.removeAll();
				
				for(int i = 1;i< data.length; i++) {
					pl.addPlayer(data[i]);
				}
				
				pl.printLabel();	// �� ���
				
				pl.revalidate();
				pl.repaint();
			}
			else {  // ���� ��ȯ	
				
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
