package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Multi.Util.Send;

public class ServerReceiver extends Thread{
	public static Map<String, ObjectOutputStream> mainData = new HashMap<String, ObjectOutputStream>();
	public static Map<String, DataOutputStream> option = new HashMap<String, DataOutputStream>();
	private ObjectInputStream inputObj = null;
	private DataInputStream inputData = null;
	private Socket gameS = null;
	private Socket userS = null;
	private String name;
	
	public void sendUser() {	// 유저 목록 전송
		System.out.println("여기");
		Send.sendAllData(option, getNames());
	}
	
	public String getNames() {  // 유저 목록 구성
		
		String Data = new String("list");
		
		ArrayList<String> names = new ArrayList(option.keySet());
		
		for(int i = 0; i< names.size(); i++) {
			Data = Data + ":" + names.get(i);
		}
		
		System.out.println(Data);
		return Data.toString();
	}
	
	public String getIndex(EventParent event) {
		String Data = new String("State");
		ArrayList<String> names = new ArrayList(option.keySet());
		
		Data += ":" + event.getType() + ":" + names.indexOf(event.getName());
		
		System.out.println(Data);
		return Data;
	}
	
	public void inputStream(String name, Socket game,Socket user) {	// hashMap 입력
		try {
			mainData.put(name,new ObjectOutputStream(game.getOutputStream()));
			option.put(name,new DataOutputStream(user.getOutputStream()));
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
	
	public ServerReceiver(Socket game,Socket user) {
		gameS = game;
		userS = user;
		
		try {
			inputObj = new ObjectInputStream(gameS.getInputStream());
			inputData = new DataInputStream(userS.getInputStream());
			name = inputData.readUTF();
			
			inputStream(name, gameS,userS);
		
			sendUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				//String re = input.readUTF();
				EventParent event = (EventParent)inputObj.readObject();
				if(event == null) break;
				
				Send.sendAllData(option, getIndex(event));
				Send.sendAllObj(event,mainData);			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				mainData.remove(name);
				gameS.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
