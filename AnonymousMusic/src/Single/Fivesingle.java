package Single;

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import Multi.GraphicObject;

public class Fivesingle implements GraphicObject {
	
	Smbar smbar=new Smbar(this);//판정바
	File f1 = new File(Fivesingle.class.getResource("../Top_Image/FiveLinePaper1.jpg").getFile());// 앞 5선지
	File f2 = new File(Fivesingle.class.getResource("../Top_Image/FiveLinePaper2.jpg").getFile());// 뒤 5선지
	BufferedImage FiveLinePaper;// 앞 5선지 원본 이미지
	BufferedImage FiveLinePaper2;// 뒤 5선지 원본 이미지
	BufferedImage Perfect;// 합본
	Graphics fg;
	ArrayList<BufferedImage> MergedList = new ArrayList<>();// 악보를 전체저장. 한 챕터 지나갈때마다 이미지 저장. 한 단의 악보이미지
	
	int chapter=0;//악보의 변화

	int x=30,y=70;
	public Fivesingle() {
		try {
			FiveLinePaper = ImageIO.read(f1);
			FiveLinePaper2 = ImageIO.read(f2);
		} catch (IOException e) {
			 Class<Fivesingle> clazz = Fivesingle.class;
			  URL resource = clazz.getResource("../Top_Image/");
			  System.out.println("resource: " + resource);
		}
		MergedList.add(copyImage(FiveLinePaper));
	}

	public BufferedImage copyImage(BufferedImage source) {
		BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
		Graphics g = b.getGraphics();
		g.drawImage(source, 0, 0, null);
		g.dispose();
		return b;
	}// 깊은복사 이런식으로 깊은 복사를 안해주면 계속 한 오선지에서 그리는 결과를 낳게 됨
	
	public void Plus(ArrayList<BufferedImage> input) {
		int width, height = 0;
		width = FiveLinePaper.getWidth() + FiveLinePaper2.getWidth();// 총 가로길이
		for (int i = 0; i < input.size(); i += 2) {
			height += input.get(i).getHeight();
		}
		Perfect = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);//악보 합본 이미지
		Graphics2D graphics = (Graphics2D) Perfect.getGraphics();
		int h = (input.get(0).getHeight());// 기본 오선지 세로길이
	
		for (int i = 0; i < input.size(); i++) {
			if (i % 2 == 0)
				graphics.drawImage(input.get(i), 0, h * (i / 2), null);
			else
				graphics.drawImage(input.get(i), input.get(i - 1).getWidth(), h * (i / 2), null);
		}
	}//오선지들을 합체
	
	public BufferedImage reMergedImage() {
		return Perfect;
	}// Plus메소드 과정을 거친후 합병된 Perfect 이미지를 반환
	
	public ArrayList<BufferedImage> getMergedList() {
		return MergedList;
	}
	
	public void add() {
		MergedList.add(copyImage(FiveLinePaper));
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(MergedList.get(chapter), x, y, null);//이미지를 update를 통해 계속 바꿔준다. 어떨때는 앞에 악보 어떨때는 뒤에 악보
		fg=MergedList.get(chapter).getGraphics();
		smbar.draw(g);
	}

	@Override
	public void update() {
		smbar.update();
	}
	
}
