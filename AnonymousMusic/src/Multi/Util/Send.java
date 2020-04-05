package Multi.Util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import Server.EventParent;

public class Send {
	public static void sendAllData(Map<String,DataOutputStream> output,String data) {
		for (DataOutputStream out : output.values()) {
			try {
				out.writeUTF(data);
				System.out.println("여기다임마!");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void sendAllInt(Map<String,DataOutputStream> output,int data) {
		for (DataOutputStream out : output.values()) {
			try {
				out.writeInt(data);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void sendAllObj(EventParent str,Map<String,ObjectOutputStream> output ) {
		for (ObjectOutputStream out : output.values()) {
			try {
				out.writeObject(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
