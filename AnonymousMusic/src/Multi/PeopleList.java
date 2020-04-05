package Multi;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeopleList extends JPanel {
//���� ���ӿ� �������� �������� ��Ÿ��
	Multi multi;
	private static List<JLabel> list = Collections.synchronizedList(new ArrayList<>());
	PeopleList(Multi multi) {
		setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);
	}
	
	public void addPlayer(String name) {
		JLabel user = new JLabel(name);
		
		user.setFont(new Font("����",1,15));
		user.setForeground(Color.white);
		
		list.add(user);
	}
	
	public void removeLabel() {
		list.removeAll(list);
	}
	
	public void printLabel() {
		for(JLabel i : list) {
			add(i);
		}
	}
	
	public void setPlaying(int number) {
		System.out.println(list.get(number));
		list.get(number).setForeground(Color.RED);
	}//�÷�����
	
	public void setChating(int number) {
		list.get(number).setForeground(Color.white);
	}//ä����
}
