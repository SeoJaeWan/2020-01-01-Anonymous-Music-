package Single;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import Menu.Music_Back;
import Menu.Scene;
import SoundKey.PianoSoundPlay;

public class Mid extends JPanel {
	// ��� ��ư���� ����ִ� ���̾ƿ�
	// ������ ���� ��ư �̹����� ���⼭ �־���
	private ImageIcon backBasic = new ImageIcon(Mid.class.getResource("../Mid_Image/back.png"));
	private ImageIcon backEnter = new ImageIcon(Mid.class.getResource("../Mid_Image/backEnter.png"));
	private ImageIcon loadBasic = new ImageIcon(Mid.class.getResource("../Mid_Image/load.png"));
	private ImageIcon loadEnter = new ImageIcon(Mid.class.getResource("../Mid_Image/loadEnter.png"));
	private ImageIcon pauseBasic = new ImageIcon(Mid.class.getResource("../Mid_Image/pause.png"));
	private ImageIcon pauseEnter = new ImageIcon(Mid.class.getResource("../Mid_Image/pauseEnter.png"));
	private ImageIcon playBasic = new ImageIcon(Mid.class.getResource("../Mid_Image/play.png"));
	private ImageIcon playEnter = new ImageIcon(Mid.class.getResource("../Mid_Image/playEnter.png"));
	private ImageIcon saveBasic = new ImageIcon(Mid.class.getResource("../Mid_Image/save.png"));
	private ImageIcon saveEnter = new ImageIcon(Mid.class.getResource("../Mid_Image/saveEnter.png"));

	JButton load;// �ҷ������ư
	JButton play;// �����ư
	JButton pause;// �Ͻ�������ư
	JButton save;// �����ư
	JButton back;// �ڷΰ����ư
	File file = null;

	Single single;
	Scene sc;
	static PianoSoundPlay soundWav;
	static Music_Back soundMp3;
	boolean am_i_pause = false;// ���� �����°� �Ͻ��������� �ƴ��� �˼��ִ�.

	public Mid(Single single, boolean vanilla, File getFile) {// �ٴҶ�� �ٴҶ� ��� �ľ�, Single�� ��ư�� ���������� Ű���� ��Ŀ���� ��ã�� ����
		this.single = single;
		this.sc = single.sc;
		this.file = getFile;

		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 30));
		setOpaque(false);
		setFocusable(false);
		if (vanilla) {
			load = new JButton(loadBasic);
			load.setText("�ҷ�����");
			load.setFont(new Font("����", 1, 16));
			load.setForeground(Color.white);
			load.setVerticalTextPosition(JButton.BOTTOM);
			load.setHorizontalAlignment(JButton.LEFT);
			load.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					single.fs.smbar.setSpeed(0);// ������ �ӵ� 0����
					am_i_pause = true;// �� �ҷ����� â���� �������� �̰� true������ �ٲ��ּ���
					// ������ �ҷ����� �̺�Ʈ
					JFileChooser fs = new JFileChooser(new File("c:\\"));
					fs.setDialogTitle("Open a File");
					fs.setFileFilter(new FileTypeFilter(".wav", "WAV File"));
					int result = fs.showOpenDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						try {
							file = fs.getSelectedFile();

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage());
						}
					}
					// ������ �ҷ��� �� �� ������ Ʋ�� �̺�Ʈ �� ���� ����
					// �� �ؿ� ���ٵ� ������ �ҷ����� �̺�Ʈ���� �����ؾߵɲ�����
					// �ҷ����� �����ؾߵ�
					/*
					 * sc.getContentPane().removeAll(); sc.add(new Single(sc, file)).requestFocus();
					 * sc.revalidate();
					 */
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					load.setIcon(loadEnter);
				}

				public void mouseExited(MouseEvent e) {
					load.setIcon(loadBasic);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					load.setIcon(loadBasic);
					requestFocus(false);
					setFocusable(false);
					single.requestFocus();
				}
			});
			load.setBorderPainted(false);
			load.setContentAreaFilled(false);
			load.setFocusPainted(false);
			add(load);
		}

		play = new JButton(playBasic);
		play.setForeground(Color.white);
		play.setText("����");
		play.setFont(new Font("����", 1, 16));
		play.setVerticalTextPosition(JButton.BOTTOM);
		play.setHorizontalAlignment(JButton.LEFT);
		play.setBorderPainted(false);
		play.setContentAreaFilled(false);
		play.setFocusPainted(false);
		play.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (am_i_pause) {
					single.fs.smbar.setSpeed(3);// �ӵ��� ���󺹱�
					// ��������� ������ �ٽ� ����Ǵ� �̺�Ʈ �߰�.
					am_i_pause = false;

					String name = file.getName().substring(file.getName().length() - 4);
					if (!name.equals(".mp3")) {
						soundWav = new PianoSoundPlay(file);
						soundWav.start();
					} else {
						soundMp3 = new Music_Back("Create", file.getPath(), true);
						soundMp3.start();
					}

					sc.getContentPane().removeAll();
					sc.add(new Single(sc, file)).requestFocus();
					sc.revalidate();
				}
			}

			public void mouseExited(MouseEvent e) {
				play.setIcon(playBasic);
			}

			public void mouseReleased(MouseEvent e) {
				requestFocus(false);
				setFocusable(false);
				single.requestFocus();
			}

			public void mouseEntered(MouseEvent e) {
				play.setIcon(playEnter);
			}
		});
		add(play);

		pause = new JButton(pauseBasic);
		pause.setText("�Ͻ�����");
		pause.setForeground(Color.white);
		pause.setFont(new Font("����", 1, 16));
		pause.setVerticalTextPosition(JButton.BOTTOM);
		pause.setHorizontalAlignment(JButton.LEFT);
		pause.setBorderPainted(false);
		pause.setContentAreaFilled(false);
		pause.setFocusPainted(false);
		pause.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (!am_i_pause) {
					single.fs.smbar.setSpeed(0);// ����� �ӵ� ���η�
					// ������ ���ߴ� ����� �߰� �Ǿ���Ѵ�.
					am_i_pause = true;
				}
			}

			public void mouseEntered(MouseEvent e) {
				pause.setIcon(pauseEnter);
			}

			public void mouseExited(MouseEvent e) {
				pause.setIcon(pauseBasic);
			}

			public void mouseReleased(MouseEvent e) {
				requestFocus(false);
				setFocusable(false);
				single.requestFocus();
				revalidate();
			}
		});
		add(pause);

		save = new JButton(saveBasic);
		save.setText("����");
		save.setForeground(Color.white);
		save.setFont(new Font("����", 1, 16));
		save.setVerticalTextPosition(JButton.BOTTOM);
		save.setHorizontalAlignment(JButton.LEFT);
		save.setBorderPainted(false);
		save.setContentAreaFilled(false);
		save.setFocusPainted(false);
		save.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				single.fs.smbar.setSpeed(0);// �ӵ� 0
				single.fs.Plus(single.fs.MergedList);// �̰� ��� �����ߴ°���
				new Single_Esc(single);// ���⼭ ������ ���(�ذ�~~)
				single.requestFocus();
			}

			public void mouseEntered(MouseEvent e) {
				save.setIcon(saveEnter);
			}

			public void mouseExited(MouseEvent e) {
				save.setIcon(saveBasic);
			}

			public void mouseReleased(MouseEvent e) {
				requestFocus(false);
				setFocusable(false);
				single.requestFocus();
			}
		});
		add(save);

		back = new JButton(backBasic);
		back.setText("�ڷΰ���");
		back.setForeground(Color.white);
		back.setFont(new Font("����", 1, 16));
		back.setVerticalTextPosition(JButton.BOTTOM);
		back.setHorizontalAlignment(JButton.LEFT);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);

		back.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
					String name = file.getName().substring(file.getName().length() - 4);

					if (name.equals(".wav")) {
						soundWav.toStop = true;
					} else if (name.equals(".mp3")) {
						soundMp3.close();
					}
				} catch (NullPointerException e1) {
					System.out.println("~~~~~���Ͼ���");
				}
				sc.getContentPane().removeAll();
				sc.add(new Single_List(sc));
				sc.revalidate();
			}

			public void mouseExited(MouseEvent e) {
				back.setIcon(backBasic);
			}

			public void mouseEntered(MouseEvent e) {
				back.setIcon(backEnter);
			}

			public void mouseReleased(MouseEvent e) {
				requestFocus(false);
				setFocusable(false);
				single.requestFocus();
			}
		});
		add(back);

		setSize(new Dimension(1220, 130));
	}

}
