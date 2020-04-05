package Menu;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Multi.Multi_Ip;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Single.Single_Instrument;

public class Menu_Mode extends JPanel {
	private Image background = new ImageIcon(Scene.class.getResource("../Menu_Image/background.png")).getImage();
	private ImageIcon Singleplay_Basic = new ImageIcon(Scene.class.getResource("../Menu_Image/Singleplay_Basic.png"));
	private ImageIcon Singleplay_Entered = new ImageIcon(
			Scene.class.getResource("../Menu_Image/Singleplay_Entered.png"));
	private ImageIcon Multi_Basic = new ImageIcon(Scene.class.getResource("../Menu_Image/Multi_Basic.png"));
	private ImageIcon Multi_Entered = new ImageIcon(Scene.class.getResource("../Menu_Image/Multi_Entered.png"));
	private ImageIcon Manual_Basic = new ImageIcon(Scene.class.getResource("../Menu_Image/Manual_Basic.png"));
	private ImageIcon Manual_Entered = new ImageIcon(Scene.class.getResource("../Menu_Image/Manual_Entered.png"));
	private ImageIcon Back_Basic = new ImageIcon(Scene.class.getResource("../Menu_Image/Back_Basic.png"));
	private ImageIcon Back_Entered = new ImageIcon(Scene.class.getResource("../Menu_Image/Back_Entered.png"));

	private JButton SinglePlay;// �̱۳������
	private JButton Multi;// ��Ƽ�������
	private JButton Manual;// ����â
	private JButton Back;// �ڷΰ��� ��ư

	Scene sc;

	public Menu_Mode(Scene sc) {
		this.sc = sc;
		setLayout(null);

		SinglePlay = new JButton(Singleplay_Basic);
		Multi = new JButton(Multi_Basic);
		Manual = new JButton(Manual_Basic);
		Back = new JButton(Back_Basic);

		SinglePlay.setBorderPainted(false);
		SinglePlay.setContentAreaFilled(false);
		SinglePlay.setFocusPainted(false);
		Multi.setBorderPainted(false);
		Multi.setContentAreaFilled(false);
		Multi.setFocusPainted(false);
		Manual.setBorderPainted(false);
		Manual.setContentAreaFilled(false);
		Manual.setFocusPainted(false);
		Back.setBorderPainted(false);
		Back.setContentAreaFilled(false);
		Back.setFocusPainted(false);

		SinglePlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SinglePlay.setIcon(Singleplay_Entered);// �˰Ժ��Ѵ�
				SinglePlay.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SinglePlay.setIcon(Singleplay_Basic);// �ٽ� �����·�
				SinglePlay.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				SinglePlay.setIcon(Singleplay_Basic);
				// ���� ������ ��������
				sc.getContentPane().removeAll();
				sc.add(new Single_Instrument(sc));// �̱� �Ǳ⼱�� �ǾƳ� ��
			}
		});// �̱۸��� ������� �̺�Ʈó��

		Multi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Multi.setIcon(Multi_Entered);// �˰Ժ��Ѵ�
				Multi.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Multi.setIcon(Multi_Basic);// �ٽ� �����·�
				Multi.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				 Multi.setIcon(Multi_Basic);
				sc.getContentPane().removeAll();
				sc.add(new Multi_Ip(sc));
			}
		});// ��Ƽ ������� �̺�Ʈ

		Manual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Manual.setIcon(Manual_Entered);// �˰Ժ��Ѵ�
				Manual.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Manual.setIcon(Manual_Basic);// �ٽ� �����·�
				Manual.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Manual.setIcon(Manual_Basic);
				sc.getContentPane().removeAll();
				sc.add(new Manual_Start(sc));
				sc.repaint();
				sc.revalidate();
				// ���� ������ ��������
			}
		});// �����̺�Ʈ

		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Back.setIcon(Back_Entered);// �˰Ժ��Ѵ�
				Back.setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Back.setIcon(Back_Basic);// �ٽ� �����·�
				Back.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Back.setIcon(Back_Basic);
				sc.getContentPane().removeAll();
				sc.add(new Menu_Start(sc));
				// ���� ������ �ڷΰ���
			}
		});// �ڷΰ���

		add(SinglePlay);
		add(Multi);
		add(Manual);
		add(Back);

		SinglePlay.setBounds(300, 300, Singleplay_Basic.getIconWidth(), Singleplay_Basic.getIconHeight());
		Multi.setBounds(300, 400, Multi_Basic.getIconWidth(), Multi_Basic.getIconHeight());
		Manual.setBounds(300, 500, Manual_Basic.getIconWidth(), Manual_Basic.getIconHeight());
		Back.setBounds(300, 600, Back_Basic.getIconWidth(), Back_Basic.getIconHeight());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}

}