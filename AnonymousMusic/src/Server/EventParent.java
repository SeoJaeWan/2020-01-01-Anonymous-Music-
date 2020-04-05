package Server;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import Multi.Multi;

public abstract class EventParent implements Serializable{
	private static final long serialVersionUID = 2658L;
	private String name = "";
	private String data = "";
	private String type = "";
	protected Multi multi = null;

	public EventParent(String name,String t, String text) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.type = t;
		this.data = text;
	}
	
	public String getName() {
		return name;
	}
	
	public String getData() {
		return data;
	}
	
	public String getType() {
		return type;
	}
	
	abstract public void event(Multi m);

}
