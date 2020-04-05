package Menu;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
//뒤에서 연주되는 음악. 게임의 일반배경음 혹은 게임배경음악을 튼다. 
public class Music_Back extends Thread {
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Music_Back(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Scene.class.getResource("../Music_Back/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Music_Back(String Album, String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			if (Album.equals("Deemo")) {
				file = new File(Scene.class.getResource("../Deemo/" + name).toURI());
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}else if(Album.equals("Create")) {
				file = new File(name);
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}

	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}

	

	@Override
	public void run() {
		try {
			do {
			
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
				player.play();
				/*
				 * if(player.isComplete()) { System.out.println("됬다 된거야 된거라고...");
				 * System.exit(0); } 이건 곡이 끝났을때 알아볼수 있는가 아닌가를 시험한 것. isComplete()를 통해 곡이 끝낫다는 걸 알수있엇다
				 */
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}