package Single;

import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Image;

import Multi.GraphicObject;


//������ �̹���
public class Smbar implements GraphicObject {
	Image bar = new ImageIcon(Smbar.class.getResource("../Top_Image/Bar.png")).getImage();
	int x=30,y=70;
	int speed=3;//�ӵ�
	
	Fivesingle fivesingle;
	public Smbar(Fivesingle fivesingle) {
		this.fivesingle=fivesingle;
	}
		
	public void setX(int x) {
		this.x=x;
	}//x��ǥ������
	
	public int getX() {
		return x;
	}//x��ǥ ��ȯ��
	
	public void setSpeed(int s) {
		speed=s;
	}//���ǵ� ������
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(bar,x,y,null);
	}

	@Override
	public void update() {
		x+=speed;
		if(x>1220) {
			x=30;
			if(fivesingle.MergedList.size()%2==0)
				fivesingle.MergedList.add(fivesingle.copyImage(fivesingle.FiveLinePaper));
			else
				fivesingle.MergedList.add(fivesingle.copyImage(fivesingle.FiveLinePaper2));
			++fivesingle.chapter;//��é�� �귯�������� 5������ é�͸� �ø���
		}
	}
}
