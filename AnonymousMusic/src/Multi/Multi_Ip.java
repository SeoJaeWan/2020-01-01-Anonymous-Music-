package Multi;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import Menu.Menu_Mode;
import Menu.Menu_Start;
import Menu.MusicController;
import Menu.Scene;
import Server.EventParent;
import Server.Server;
import Single.Single_Instrument;

//textfield ���� �巡�� �ǵ��� �ٲ����
public class Multi_Ip extends JPanel {
	private Image background = new ImageIcon(Single_Instrument.class.getResource("../Single_Image/background.png"))
			.getImage();// ���
	private ImageIcon createBasic = new ImageIcon(Multi_Ip.class.getResource("../Menu_Image/createBasic.png"));
	private ImageIcon createEnter = new ImageIcon(Multi_Ip.class.getResource("../Menu_Image/createEnter.png"));
	private ImageIcon joinBasic = new ImageIcon(Multi_Ip.class.getResource("../Menu_Image/joinBasic.png"));
	private ImageIcon joinEnter = new ImageIcon(Multi_Ip.class.getResource("../Menu_Image/joinEnter.png"));

	private ImageIcon Back_Basic = new ImageIcon(Scene.class.getResource("../Menu_Image/Back_Basic.png"));
	private ImageIcon Back_Entered = new ImageIcon(Scene.class.getResource("../Menu_Image/Back_Entered.png"));
	private Image textareabar = new ImageIcon(Multi_Ip.class.getResource("../Multiip_Image/textbar.png")).getImage();// ���̹���

	JTextField nickname = new JTextField("�г���", 18);// �����г���
	JTextField textField = new JTextField("IP�ּ�", 18);// IP

	JButton create;// �游���
	JButton join;// �� ����
	JButton Back;// �ڷΰ���

	private Scene sc;
	private String nick;// �г����ؽ�Ʈ
	private String ip;// IP�ؽ�Ʈ
	private Server server;
	private Socket socket;
	private ClientReceiver clientReceiver;
	private ObjectOutputStream out;

	public Multi_Ip(Scene sc) {
		MusicController.closeBackground();// Let it be ����
		this.sc = sc;
		setLayout(null);
		Back = new JButton(Back_Basic);
		Back.setBorderPainted(false);
		Back.setContentAreaFilled(false);
		Back.setFocusPainted(false);

		JLabel label = new JLabel(new ImageIcon(Multi_Ip.class.getResource("../Multiip_Image/textbar.png")));
		// �ؽ�Ʈ�ʵ� �޹������ �� ���̹���
		label.setOpaque(false);
		label.setBackground(textField.getBackground());
		label.setPreferredSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height));
		JLabel label2 = new JLabel(new ImageIcon(Multi_Ip.class.getResource("../Multiip_Image/textbar.png")));
		// �ؽ�Ʈ�ʵ� �޹������ �� ���̹���
		label2.setOpaque(false);
		label2.setBackground(textField.getBackground());
		label2.setPreferredSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height));

		Font font = new Font("����", 1, 40);// ����ü
		nickname.setBorder(null);
		nickname.setFont(font);
		nickname.setForeground(Color.white);
		nickname.setOpaque(false);
		add(nickname);

		textField.setBorder(null);
		textField.setFont(font);
		textField.setForeground(Color.white);
		textField.setOpaque(false);
		add(textField);
		add(label);
		add(label2);
		Dimension d = textField.getPreferredSize();

		nickname.setBounds(325, 380, d.width, d.height);
		label2.setBounds(315, 410, d.width, d.height);

		textField.setBounds(325, 470, d.width, d.height);
		label.setBounds(315, 500, d.width, d.height);// �ؽ�Ʈ �ʵ� �ؿ� ���� ó������ �׷�����

		create = new JButton(createBasic);

		create.setBorderPainted(false);
		create.setContentAreaFilled(false);
		create.setFocusPainted(false);

		join = new JButton(joinBasic);
		join.setBorderPainted(false);
		join.setContentAreaFilled(false);
		join.setFocusPainted(false);

		add(create);
		create.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				create.setIcon(createEnter);
			}

			public void mouseExited(MouseEvent e) {
				create.setIcon(createBasic);
			}

			public void mousePressed(MouseEvent e) {
				nick = nickname.getText();
				ip = textField.getText();

				server = new Server();
				server.start();

				sc.getContentPane().removeAll();
				sc.add(new Multi(sc, null, nick, ip)).requestFocus();
				// �ϴ� ���忡 �г��� ������ �ѱ� ������ ������ �Ű������� �ѱ�ڴ�
				sc.revalidate();
			}
		});
		create.setBounds(300, 600, 374, 97);

		add(join);
		join.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				join.setIcon(joinEnter);
			}

			public void mouseExited(MouseEvent e) {
				join.setIcon(joinBasic);
			}

			public void mousePressed(MouseEvent e) {
				nick = nickname.getText();
				ip = textField.getText();

				sc.getContentPane().removeAll();
				sc.add(new Multi(sc, null, nick, ip)).requestFocus();
				sc.revalidate();
			}
		});
		join.setBounds(700, 600, 374, 97);

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
				sc.add(new Menu_Mode(sc));
				MusicController.startBackground();
				// ���� ������ �ڷΰ���
			}
		});// �ڷΰ���
		add(Back);
		Back.setBounds(50, 50, Back_Basic.getIconWidth(), Back_Basic.getIconHeight());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
