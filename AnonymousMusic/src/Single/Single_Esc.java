package Single;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.IOException;

public class Single_Esc extends JOptionPane {
	String[] choice = { "저장하고 뒤로", "저장만" };
	JFileChooser chooser;
	File savefile;
	String savepathname;
	Fivesingle fs;
	
	public Single_Esc(Single single) {
		fs=single.fs;
		int selected = this.showOptionDialog(this, "고르시오", "고르시오", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
		addFocusListener(new MyFocuseListener());

		chooser = new JFileChooser();

		switch (selected) {

		case 0:
			int re;
			chooser.setCurrentDirectory(new File("C://"));
			chooser.setFileFilter(new FileNameExtensionFilter("PNG", "PNG"));
			re = chooser.showSaveDialog(null);
			if (re == JFileChooser.APPROVE_OPTION) {
				savefile = chooser.getSelectedFile();// 저장경로를 받아오고
				savepathname = savefile.getAbsolutePath() + ".png";

				try {
					new PianoRecord(single.pianoSoundRecord,savefile.getPath());
					musicStop();
					ImageIO.write(fs.reMergedImage(), "PNG", new File(savepathname));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "경로를 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				fs.smbar.setSpeed(3);
				return;
			}
			single.sc.getContentPane().removeAll();
			fs.smbar.setSpeed(3);
			fs.smbar.setX(30);
			fs.chapter = 0;
			fs.getMergedList().clear();
			fs.add();

			single.sc.add(new Single_List(single.sc));
			single.sc.revalidate();
			break;

		case 1:
			int re1;
			chooser.setCurrentDirectory(new File("C://"));
			chooser.setFileFilter(new FileNameExtensionFilter("PNG", "PNG"));
			re1 = chooser.showSaveDialog(null);
			if (re1 == JFileChooser.APPROVE_OPTION) {
				savefile = chooser.getSelectedFile();// 저장경로를 받아오고
				savepathname = savefile.getAbsolutePath() + ".png";

				try {
					new PianoRecord(single.pianoSoundRecord,savefile.getPath());
					single.pianoSoundRecord.clear();
					single.keyevent.recordStartTime = (System.currentTimeMillis() / 100);
					single.keyevent.keyCount = 0;
					
					ImageIO.write(fs.reMergedImage(), "PNG", new File(savepathname));
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			} else {
				JOptionPane.showMessageDialog(null, "경로를 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				fs.smbar.setSpeed(3);
				return;
			}
			fs.smbar.setSpeed(3);
			break;
		default:
			fs.smbar.setSpeed(3);
			break;

		}
	}
	
	public void musicStop() {
		if(Mid.soundMp3 != null) {
			Mid.soundMp3.close();
		}else if(Mid.soundWav != null) {
			Mid.soundWav.toStop = true;
		}
	}
}
