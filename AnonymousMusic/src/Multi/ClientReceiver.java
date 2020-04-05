package Multi;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;

import Server.EventParent;
import SoundKey.PianoSoundPlay;

public class ClientReceiver extends Thread{
	private Socket socket1;
	private Multi multi;
	
	public ClientReceiver(Socket s, Multi m) {
		// TODO Auto-generated constructor stub
		socket1 = s;
		this.multi = m;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream readerObject = new ObjectInputStream(socket1.getInputStream());
			System.out.println("¿©±â");
			while(true) {
				EventParent obj = (EventParent)readerObject.readObject();
				if(obj == null) break;

				obj.event(multi);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
