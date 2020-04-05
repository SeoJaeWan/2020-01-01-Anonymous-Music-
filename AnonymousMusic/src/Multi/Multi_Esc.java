package Multi;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Single.Mid;
import Single.PianoRecord;

public class Multi_Esc extends JOptionPane {
	String[] choice = {"�����ϰ� �ڷ�", "���常" };
	JFileChooser chooser;
	File savefile;
	String savepathname;
	Fiveline fl;
	
	public Multi_Esc(Multi multi) {
		fl=multi.fiveline;
		int selected = this.showOptionDialog(this, "���ÿ�", "���ÿ�", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
	
		chooser = new JFileChooser();

		switch (selected) {
		
		case 0:
			int re;
			chooser.setCurrentDirectory(new File("C://"));
			chooser.setFileFilter(new FileNameExtensionFilter("PNG", "PNG"));
			re = chooser.showSaveDialog(null);
			if (re == JFileChooser.APPROVE_OPTION) {
				savefile = chooser.getSelectedFile();// �����θ� �޾ƿ���
				savepathname = savefile.getAbsolutePath() + ".png";

				try {
					new PianoRecord(multi.pianoSoundRecord,savefile.getPath());
					musicStop();
					ImageIO.write(fl.reMergedImage(), "PNG", new File(savepathname));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "��θ� �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
				fl.jmbar.setSpeed(3);
				return;
			}
			multi.sc.getContentPane().removeAll();
			fl.jmbar.setSpeed(3);
			fl.jmbar.setX(30);
			fl.getMergedList().clear();
			fl.add();
			
			multi.sc.add(new Multi_Ip(multi.sc));//��Ƽ����Ʈ�ιٲٱ�
			multi.sc.setSmall();
			multi.sc.revalidate();
			break;

		case 1:
			int re1;
			chooser.setCurrentDirectory(new File("C://"));
			chooser.setFileFilter(new FileNameExtensionFilter("PNG", "PNG"));
			re1 = chooser.showSaveDialog(null);
			if (re1 == JFileChooser.APPROVE_OPTION) {
				savefile = chooser.getSelectedFile();// �����θ� �޾ƿ���
				savepathname = savefile.getAbsolutePath() + ".png";

				try {
					new PianoRecord(multi.pianoSoundRecord,savefile.getPath());
					multi.pianoSoundRecord.clear();
					multi.keyevent.recordStartTime = (System.currentTimeMillis() / 100);
					multi.keyevent.keyCount = 0;
					
					ImageIO.write(fl.reMergedImage(), "PNG", new File(savepathname));
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			} else {
				JOptionPane.showMessageDialog(null, "��θ� �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
				fl.jmbar.setSpeed(3);
				return;
			}
			fl.jmbar.setSpeed(3);
			break;
		default:
			fl.jmbar.setSpeed(3);
			break;

		}
	}
	
	public void musicStop() {
		if(Multi_Mid.soundMp3 != null) {
			Multi_Mid.soundMp3.close();
		}else if(Multi_Mid.soundWav != null) {
			Multi_Mid.soundWav.toStop = true;
		}
	}
}