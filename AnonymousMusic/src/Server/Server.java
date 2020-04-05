package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
	
	ServerSocket gSocket = null;
	ServerSocket uSocket = null;
	public Server() {

	}
	
	public void run() {
		System.out.println("¼­¹ö");
		try {
			gSocket = new ServerSocket(9004);
			uSocket = new ServerSocket(9005);
			
			while(true) {
				Socket gameSocket = gSocket.accept();
				Socket userSocket = uSocket.accept();
				Thread serverThread = new ServerReceiver(gameSocket,userSocket);
				
				serverThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
