package Single;

import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Image;

import Multi.GraphicObject;


//판정바 이미지
public class Smbar implements GraphicObject {
	Image bar = new ImageIcon(Smbar.class.getResource("../Top_Image/Bar.png")).getImage();
	int x=30,y=70;
	int speed=3;//속도
	
	Fivesingle fivesingle;
	public Smbar(Fivesingle fivesingle) {
		this.fivesingle=fivesingle;
	}
		
	public void setX(int x) {
		this.x=x;
	}//x좌표설정자
	
	public int getX() {
		return x;
	}//x좌표 반환자
	
	public void setSpeed(int s) {
		speed=s;
	}//스피드 설정자
	
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
			++fivesingle.chapter;//한챕터 흘러갈때마다 5선지의 챕터를 올린다
		}
	}
}
