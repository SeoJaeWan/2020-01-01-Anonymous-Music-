package Server;

import java.io.Serializable;

import Multi.Multi;

public class ChatEvent extends EventParent implements Serializable{
	private static final long serialVersionUID = 2658L;
	
	public ChatEvent(String name,String text) {
		super(name,"chat", text);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void event(Multi m) {
		// TODO Auto-generated method stub
		this.multi = m;
		
		multi.Multi_chat.ta.append(getData());
	}

}
