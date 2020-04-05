package Menu;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//���ӽ���, �ɼ�, ����
public class Menu_Start extends JPanel {
	private Image background = new ImageIcon(Scene.class.getResource("../Menu_Image/background.jpg")).getImage();// ����̹���
	private ImageIcon Start_BasicImage = new ImageIcon(Scene.class.getResource("../Menu_Image/Start_basic.png"));// ��ŸƮ�⺻�̹���
	private ImageIcon Start_EnteredImage = new ImageIcon(Scene.class.getResource("../Menu_Image/Start_Entered.png"));// ��ŸƮ�����̹���.
	private ImageIcon Setting_BasicImage = new ImageIcon(Scene.class.getResource("../Menu_Image/Setting_basic.png"));// �ɼǱ⺻�̹���
	private ImageIcon Setting_EnteredImage = new ImageIcon(
			Scene.class.getResource("../Menu_Image/Setting_Entered.png"));// �ɼǰ����̹���.
	private ImageIcon Exit_BasicImage = new ImageIcon(Scene.class.getResource("../Menu_Image/Exit_basic.png"));// ����⺻�̹���
	private ImageIcon Exit_EnteredImage = new ImageIcon(Scene.class.getResource("../Menu_Image/Exit_entered.png"));// �ɼǰ����̹���.
	// ������� �⺻ �̹���

	private JButton Start;// ���� ���۹�ư
	private JButton Setting;// ���� �ɼ� ��ư
	private JButton Exit;// ���� ���� ��ư

	Scene sc;

	public Menu_Start(Scene scene) {
		this.sc = scene;
		setLayout(null);

		setLayout(null);
		Start = new JButton(Start_BasicImage);// ���ӽ�ŸƮ��ư �̹����� Start_BasicImage��
		Setting = new JButton(Setting_BasicImage);// ���ӿɼǹ�ư �̹����� Setting_BasicImage��
		Exit = new JButton(Exit_BasicImage);// ���������ư �̹����� Exit_BasicImage��

		Start.setBorderPainted(false);// ��ư�� �⺻������ �������ִ� �ɼ�����
		Start.setContentAreaFilled(false);
		Start.setFocusPainted(false);
		Setting.setBorderPainted(false);
		Setting.setContentAreaFilled(false);
		Setting.setFocusPainted(false);
		Exit.setBorderPainted(false);
		Exit.setContentAreaFilled(false);
		Exit.setFocusPainted(false);

		Start.addMouseListener(new MouseAdapter() {// ���� ���� ��ư�� ������ �� �̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) {
				Start.setIcon(Start_EnteredImage);// �˰Ժ��Ѵ�
				Start.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}// ���콺 Ŀ���� ��ư�� �ö������� ����

			@Override
			public void mouseExited(MouseEvent e) {
				Start.setIcon(Start_BasicImage);// �⺻ �̹����� ���Ѵ�.
				Start.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}// ���콺 Ŀ���� �ٱ����� ������ ���� ����

			@Override
			public void mousePressed(MouseEvent e) {
				Start.setIcon(Start_BasicImage);

				// ���� ��� ����ȭ������ �Ѿ��.
				scene.getContentPane().removeAll();
				scene.add(new Menu_Mode(sc));//->���Ӹ��� �̱۷��ڵ�, ��Ƽ���ڵ�
			}// ��ư�� ����
		});

		Setting.addMouseListener(new MouseAdapter() {// ���� ���� ��ư�� ������ �� �̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) {
				Setting.setIcon(Setting_EnteredImage);// �˰Ժ��Ѵ�
				Setting.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}// ���콺 Ŀ���� ��ư�� �ö������� ����

			@Override
			public void mouseExited(MouseEvent e) {
				Setting.setIcon(Setting_BasicImage);// �⺻ �̹����� ���Ѵ�.
				Setting.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}// ���콺 Ŀ���� �ٱ����� ������ ���� ����

			@Override
			public void mousePressed(MouseEvent e) {
				Setting.setIcon(Setting_BasicImage);
				new Alert();//���������� ���â!
				// ���� ����ȭ������ �Ѿ��.
			}// ��ư�� ����
		});

		Exit.addMouseListener(new MouseAdapter() {// ���� ���� ��ư�� ������ �� �̺�Ʈ
			@Override
			public void mouseEntered(MouseEvent e) {
				Exit.setIcon(Exit_EnteredImage);// �˰Ժ��Ѵ�
				Exit.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}// ���콺 Ŀ���� ��ư�� �ö������� ����

			@Override
			public void mouseExited(MouseEvent e) {
				Exit.setIcon(Exit_BasicImage);// �⺻ �̹����� ���Ѵ�.
				Exit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}// ���콺 Ŀ���� �ٱ����� ������ ���� ����

			@Override
			public void mousePressed(MouseEvent e) {
				Exit.setIcon(Exit_BasicImage);
				System.exit(0);
			}// ��ư�� ����
		});
		add(Start);
		add(Setting);
		add(Exit);
		Start.setBounds(300, 300, Start_BasicImage.getIconWidth(), Start_BasicImage.getIconHeight());
		Setting.setBounds(300, 500, Setting_BasicImage.getIconWidth(), Setting_BasicImage.getIconHeight());
		Exit.setBounds(300, 700, Exit_BasicImage.getIconWidth(), Exit_BasicImage.getIconHeight());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
