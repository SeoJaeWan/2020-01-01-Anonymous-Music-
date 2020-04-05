package Multi.Util;

import java.io.DataInputStream;
import java.io.IOException;

public class Receive {
	public static int receiveInt(DataInputStream inData) {
		try {
			return inData.readInt();
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static String receiveString(DataInputStream inData) {
		try {
			return inData.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
