package Single;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.xml.soap.Node;

//곡들이 담겨져있는 더블링크드리스트
class Album_Node {
	Album_Node prev;
	Image cover;
	String name;
	Album_Node next;

	public Image getImage() {
		return cover;
	}

	public String getName() {
		return name;
	}

	public Album_Node() {
		this.cover = null;
		this.prev = null;
		this.next = null;
	}

	public Album_Node(Image cover, String name) {
		this.cover = cover;
		this.name = name;
	}

	public Album_Node(Album_Node prev, Image cover, Album_Node next) {
		this.cover = cover;
		this.prev = prev;
		this.next = next;
		name = cover.getClass().getName();
	}
}

public class Album_List {
	Album_Node head = null;
	Album_Node current = null;

	private Image Jumpystar = new ImageIcon(Single_List.class.getResource("../Single_Image/Album_Jumpystar.jpg"))
			.getImage();
	private Image Magnolia = new ImageIcon(Single_List.class.getResource("../Single_Image/Album_Magnolia.jpg"))
			.getImage();
	private Image Dream = new ImageIcon(Single_List.class.getResource("../Single_Image/Album_Dream.jpg")).getImage();
	private Image Nomusic = new ImageIcon(Single_List.class.getResource("../Single_Image/Album_Nomusic.png"))
			.getImage();

	Album_List() {
		insertFirstNode(Jumpystar, "Jumpy star.mp3");
		insertFirstNode(Dream, "Dream.mp3");
		insertFirstNode(Magnolia, "Magnolia.mp3");
		insertFirstNode(Nomusic, "Nomusic");

		current = head;
	}

	public void insertFirstNode(Image cover, String name) {
		Album_Node node = new Album_Node(cover, name);
		if (head == null) {
			head = node;
			node.prev = node;
			node.next = node;
		} else {
			Album_Node current = head;
			Album_Node prev = current.prev;
			node.prev = prev;
			node.next = current;
			current.prev = node;
			prev.next = node;
			head = node;
		}
	}

	public Image currentImage() {
		return current.getImage();
	}

	public void nextImage() {
		current = current.next;
	}

	public void prevImage() {
		current = current.prev;
	}

}