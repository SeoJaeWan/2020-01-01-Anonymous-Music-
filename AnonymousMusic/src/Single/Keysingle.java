package Single;

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.BitSet;

import Multi.GraphicObject;

public class Keysingle implements GraphicObject {
	BufferedImage[] Eack_Keyboard;// �� Ű���� �ǹ�
	BufferedImage All_Keyboard;// Ű����
	BitSet bitset = new BitSet(24);
	
	Keysingle(){
		Eack_Keyboard = new BufferedImage[24];
		try {
			All_Keyboard = ImageIO.read(new File("src\\Bottom_Image\\Piano.png"));// ��ü Ű���� �̹���

			for (int i = 0; i < 24; i++) {
				Eack_Keyboard[i] = ImageIO.read(new File("src\\Bottom_Image\\" + i + ".png"));
			}
		} catch (IOException e) {
			System.out.println("����");
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(All_Keyboard, 90, 640, null);
		// �迭�� boolean�� true�̸� �ش� Ű���尡 ������ ���̹Ƿ� �̸� Ű�������� ���������·� �׸���.
		if (bitset.get(0))
			g.drawImage(Eack_Keyboard[0], 90, 640, null);// 0,0�� ������ ���� Ű���忡�� �̹��� �������� ��Ų�ű� �����̴�.
		if (bitset.get(1))
			g.drawImage(Eack_Keyboard[1], 90, 640, null);
		if (bitset.get(2))
			g.drawImage(Eack_Keyboard[2], 90, 640, null);
		if (bitset.get(3))
			g.drawImage(Eack_Keyboard[3], 90, 640, null);
		if (bitset.get(4))
			g.drawImage(Eack_Keyboard[4], 90, 640, null);
		if (bitset.get(5))
			g.drawImage(Eack_Keyboard[5],90, 640, null);
		if (bitset.get(6))
			g.drawImage(Eack_Keyboard[6], 90, 640, null);
		if (bitset.get(7))
			g.drawImage(Eack_Keyboard[7], 90, 640,null);
		if (bitset.get(8))
			g.drawImage(Eack_Keyboard[8], 90, 640, null);
		if (bitset.get(9))
			g.drawImage(Eack_Keyboard[9],90, 640, null);
		if (bitset.get(10))
			g.drawImage(Eack_Keyboard[10],90, 640, null);
		if (bitset.get(11))
			g.drawImage(Eack_Keyboard[11],90, 640,null);
		if (bitset.get(12))
			g.drawImage(Eack_Keyboard[12], 90, 640, null);
		if (bitset.get(13))
			g.drawImage(Eack_Keyboard[13], 90, 640, null);
		if (bitset.get(14))
			g.drawImage(Eack_Keyboard[14], 90, 640, null);
		if (bitset.get(15))
			g.drawImage(Eack_Keyboard[15],90, 640, null);
		if (bitset.get(16))
			g.drawImage(Eack_Keyboard[16], 90, 640, null);
		if (bitset.get(17))
			g.drawImage(Eack_Keyboard[17], 90, 640,null);
		if (bitset.get(18))
			g.drawImage(Eack_Keyboard[18], 90, 640, null);
		if (bitset.get(19))
			g.drawImage(Eack_Keyboard[19],90, 640, null);
		if (bitset.get(20))
			g.drawImage(Eack_Keyboard[20],90, 640, null);
		if (bitset.get(21))
			g.drawImage(Eack_Keyboard[21],90, 640,null);
		if (bitset.get(22))
			g.drawImage(Eack_Keyboard[22], 90, 640, null);
		if (bitset.get(23))
			g.drawImage(Eack_Keyboard[23], 90, 640, null);
	}

	public void pressType1(String key) {
		switch (key) {
		case "1��.wav":// 0��
			bitset.set(0);
			break;
		case "1��.wav":// 1��
			bitset.set(1);
			break;
		case "1��.wav":// 2��
			bitset.set(2);
			break;
		case "1��.wav":// 3��
			bitset.set(3);
			break;
		case "1��.wav":// 4��
			bitset.set(4);
			break;
		case "1��.wav":// 5��
			bitset.set(5);
			break;
		case "1��.wav":// 6��
			bitset.set(6);
			break;
		
		// 1������ ���� ��������������
		// 2�� Ű��
		case "2��.wav":// 7��
			bitset.set(7);
			break;
		case "2��.wav":
			bitset.set(8);
			break;
		case "2��.wav":
			bitset.set(9);
			break;
		case "2��.wav":
			bitset.set(10);
			break;
		case "2��.wav":
			bitset.set(11);
			break;
		case "2��.wav":
			bitset.set(12);
			break;
		case "2��.wav":
			bitset.set(13);
			break;
		// �ä���;��,.
			
		case "1��#.wav":
			bitset.set(14);
			break;
		case "1��#.wav":
			bitset.set(15);
			break;
		case "1��#.wav":
			bitset.set(16);
			System.out.println("dd");
			break;
		case "1��#.wav":
			bitset.set(17);
			break;
		case "1��#.wav":
			bitset.set(18);
			break;
	
			
		case "2��#.wav":// 7��
			bitset.set(19);
			break;
		case "2��#.wav":
			bitset.set(20);
			break;
		case "2��#.wav":
			bitset.set(21);
			break;
		case "2��#.wav":
			bitset.set(22);
			break;
		case "2��#.wav":
			bitset.set(23);
			break;
	

		}
	}

	// ������ 1Ÿ�� �����̽��� ��������������
	public void releaseType1(String key) {
		switch (key) {
		case "1��.wav":
			bitset.set(0, false);
			break;
		case "1��.wav":
			bitset.set(1, false);
			break;
		case "1��.wav":
			bitset.set(2, false);
			break;
		case "1��.wav":
			bitset.set(3, false);
			break;
		case "1��.wav":
			bitset.set(4, false);
			break;
		case "1��.wav":
			bitset.set(5, false);
			break;
		case "1��.wav":
			bitset.set(6, false);
			break;
		case "2��.wav":
			bitset.set(7, false);
			break;
		case "2��.wav":
			bitset.set(8, false);
			break;
		case "2��.wav":
			bitset.set(9, false);
			break;
		case "2��.wav":
			bitset.set(10, false);
			break;
		case "2��.wav":
			bitset.set(11, false);
			break;
		case "2��.wav":
			bitset.set(12, false);
			break;
		case "2��.wav":
			bitset.set(13, false);
			break;
			
		case "1��#.wav":
			bitset.set(14, false);
			break;
		case "1��#.wav":
			bitset.set(15, false);
			break;
		case "1��#.wav":
			bitset.set(16, false);
			break;
		case "1��#.wav":
			bitset.set(17, false);
			break;
		case "1��#.wav":
			bitset.set(18, false);
			break;
			
		case "2��#.wav":
			bitset.set(19, false);
			break;
		case "2��#.wav":
			bitset.set(20, false);
			break;
		case "2��#.wav":
			bitset.set(21, false);
			break;
		case "2��#.wav":
			bitset.set(22, false);
			break;
		case "2��#.wav":
			bitset.set(23, false);
			break;
		}
	}

	// �����̽���(�Ǽ�Ʈ �������� ����)ŰŸ��2
	public void pressType2(String key) {
		switch (key) {
		case "2��.wav":
			bitset.set(0);
			break;
		case "2��.wav":
			bitset.set(1);
			break;
		case "2��.wav":
			bitset.set(2);
			break;
		case "2��.wav":
			bitset.set(3);
			break;
		case "2��.wav":
			bitset.set(4);
			break;
		case "2��.wav":
			bitset.set(5);
			break;
		case "2��.wav":
			bitset.set(6);
			break;
		// �������������� 2��
		case "3��.wav":
			bitset.set(7);
			break;
		case "3��.wav":
			bitset.set(8);
			break;
		case "3��.wav":
			bitset.set(9);
			break;
		case "3��.wav":
			bitset.set(10);
			break;
		case "3��.wav":
			bitset.set(11);
			break;
		case "3��.wav":
			bitset.set(12);
			break;
		case "3��.wav":
			bitset.set(13);
			break;
		// �ä���;��,. 3��
			
		case "2��#.wav":
			bitset.set(14);
			break;
		case "2��#.wav":
			bitset.set(15);
			break;
		case "2��#.wav":
			bitset.set(16);
			break;
		case "2��#.wav":
			bitset.set(17);
			break;
		case "2��#.wav":
			bitset.set(18);
			break;

		case "3��#.wav":
			bitset.set(19);
			break;
		case "3��#.wav":
			bitset.set(20);
			break;
		case "3��#.wav":
			bitset.set(21);
			break;
		case "3��#.wav":
			bitset.set(22);
			break;
		case "3��#.wav":
			bitset.set(23);
			break;
		}
	}

	public void releaseType2(String key) {
		switch (key) {
		case "2��.wav":
			bitset.set(0, false);
			break;
		case "2��.wav":
			bitset.set(1, false);
			break;
		case "2��.wav":
			bitset.set(2, false);
			break;
		case "2��.wav":
			bitset.set(3, false);
			break;
		case "2��.wav":
			bitset.set(4, false);
			break;
		case "2��.wav":
			bitset.set(5, false);
			break;
		case "2��.wav":
			bitset.set(6, false);
			break;
		case "3��.wav":
			bitset.set(7, false);
			break;
		case "3��.wav":
			bitset.set(8, false);
			break;
		case "3��.wav":
			bitset.set(9, false);
			break;
		case "3��.wav":
			bitset.set(10, false);
			break;
		case "3��.wav":
			bitset.set(11, false);
			break;
		case "3��.wav":
			bitset.set(12, false);
			break;
		case "3��.wav":
			bitset.set(13, false);
			break;
			
		case "2��#.wav":
			bitset.set(14, false);
			break;
		case "2��#.wav":
			bitset.set(15, false);
			break;
		case "2��#.wav":
			bitset.set(16, false);
			break;
		case "2��#.wav":
			bitset.set(17, false);
			break;
		case "2��#.wav":
			bitset.set(18, false);
			break;
			
		case "3��#.wav":
			bitset.set(19, false);
			break;
		case "3��#.wav":
			bitset.set(20, false);
			break;
		case "3��#.wav":
			bitset.set(21, false);
			break;
		case "3��#.wav":
			bitset.set(22, false);
			break;
		case "3��#.wav":
			bitset.set(23, false);
			break;
		}
	}

	// �����̽��� �� �Ǽ�Ʈ�� �������� ��� �̹��� false��
	public void releaseAll() {
		for (int i = 0; i < 27; i++) {
			bitset.set(i, false);
		}
	}
	
	@Override
	public void update() {
		
	}

	
}
