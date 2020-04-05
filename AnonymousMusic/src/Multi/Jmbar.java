package Multi;

import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Image;

//ÆÇÁ¤¹Ù
public class Jmbar implements GraphicObject {
	Image bar = new ImageIcon(Jmbar.class.getResource("../Top_Image/Bar.png")).getImage();
	boolean judgement=true;
	int x=30,y=70;
	int speed=3;
	
	Fiveline fiveline;
	public Jmbar(Fiveline fiveline) {
		this.fiveline=fiveline;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setSpeed(int s) {
		speed=s;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(bar,x,y,null);
	}

	@Override
	public void update() {
		x+=speed;
		if(x>1220) {
			x=30;
			if(fiveline.MergedList.size()%2==0)
				fiveline.MergedList.add(fiveline.copyImage(fiveline.FiveLinePaper));
			else
				fiveline.MergedList.add(fiveline.copyImage(fiveline.FiveLinePaper2));
			++fiveline.chapter;
		}
	}
}
