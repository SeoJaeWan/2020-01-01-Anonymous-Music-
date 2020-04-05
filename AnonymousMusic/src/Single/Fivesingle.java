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
	
	Smbar smbar=new Smbar(this);//������
	File f1 = new File(Fivesingle.class.getResource("../Top_Image/FiveLinePaper1.jpg").getFile());// �� 5����
	File f2 = new File(Fivesingle.class.getResource("../Top_Image/FiveLinePaper2.jpg").getFile());// �� 5����
	BufferedImage FiveLinePaper;// �� 5���� ���� �̹���
	BufferedImage FiveLinePaper2;// �� 5���� ���� �̹���
	BufferedImage Perfect;// �պ�
	Graphics fg;
	ArrayList<BufferedImage> MergedList = new ArrayList<>();// �Ǻ��� ��ü����. �� é�� ������������ �̹��� ����. �� ���� �Ǻ��̹���
	
	int chapter=0;//�Ǻ��� ��ȭ

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
	}// �������� �̷������� ���� ���縦 �����ָ� ��� �� ���������� �׸��� ����� ���� ��
	
	public void Plus(ArrayList<BufferedImage> input) {
		int width, height = 0;
		width = FiveLinePaper.getWidth() + FiveLinePaper2.getWidth();// �� ���α���
		for (int i = 0; i < input.size(); i += 2) {
			height += input.get(i).getHeight();
		}
		Perfect = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);//�Ǻ� �պ� �̹���
		Graphics2D graphics = (Graphics2D) Perfect.getGraphics();
		int h = (input.get(0).getHeight());// �⺻ ������ ���α���
	
		for (int i = 0; i < input.size(); i++) {
			if (i % 2 == 0)
				graphics.drawImage(input.get(i), 0, h * (i / 2), null);
			else
				graphics.drawImage(input.get(i), input.get(i - 1).getWidth(), h * (i / 2), null);
		}
	}//���������� ��ü
	
	public BufferedImage reMergedImage() {
		return Perfect;
	}// Plus�޼ҵ� ������ ��ģ�� �պ��� Perfect �̹����� ��ȯ
	
	public ArrayList<BufferedImage> getMergedList() {
		return MergedList;
	}
	
	public void add() {
		MergedList.add(copyImage(FiveLinePaper));
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(MergedList.get(chapter), x, y, null);//�̹����� update�� ���� ��� �ٲ��ش�. ����� �տ� �Ǻ� ����� �ڿ� �Ǻ�
		fg=MergedList.get(chapter).getGraphics();
		smbar.draw(g);
	}

	@Override
	public void update() {
		smbar.update();
	}
	
}
