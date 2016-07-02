package test;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import com.killerpc.core.AbstractGame;
import com.killerpc.core.GameContainer;
import com.killerpc.core.Input;
import com.killerpc.core.Renderer;
import com.killerpc.core.fx.Image;
import com.killerpc.core.fx.SoundClip;
import com.killerpc.errorMessage.ErrorMessage;

public class Game extends AbstractGame{
	
	private Image image = new Image("/test.png");
	private SoundClip clip1 = new SoundClip("/coin pickup.wav");
	private SoundClip clip2 = new SoundClip("/War Machine.wav");
	private static String iconFileName = "/icon.png";
	private ErrorMessage error = new ErrorMessage();
	
	

	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new Game());
		Toolkit tk =Toolkit.getDefaultToolkit();
		double width = tk.getScreenSize().getWidth();
		double height = tk.getScreenSize().getHeight();
		double scale1 = width/gc.getWidth();
		double scale2 = height/gc.getHeight();
		double scale = (scale1+scale2)/2;
		gc.setScale((int)scale-1);
		gc.setShowFPS(true);
		gc.setAllWaysOnTop(true);
		gc.setFullScreen(false);
		gc.setIconFileName(iconFileName);
		gc.start();
		
	}
	float x =0;
	float y =0;

	@Override
	public void update(GameContainer gc, float dt) {
		
		if (Input.isKeyPressed(KeyEvent.VK_ESCAPE)){
			gc.stop();
		}
		if (Input.isKeyReleased(KeyEvent.VK_Z)){
			clip1.stop();
			clip2.stop();
		}
		if (Input.isKeyPressed(KeyEvent.VK_1)){
			clip1.play();
		}
		if (Input.isKeyPressed(KeyEvent.VK_2)){
			clip2.play();
		}
		if (Input.isKeyPressed(KeyEvent.VK_P)){
			clip2.pause();
		}
		if(Input.isKey(KeyEvent.VK_A)||Input.isKey(KeyEvent.VK_LEFT)){
			x-= dt;
		}
		if(Input.isKey(KeyEvent.VK_D)|| Input.isKey(KeyEvent.VK_RIGHT)){
			x+=dt;
		}
		if(Input.isKey(KeyEvent.VK_W)|| Input.isKey(KeyEvent.VK_UP)){
			y-=dt;
		}
		if(Input.isKey(KeyEvent.VK_S)|| Input.isKey(KeyEvent.VK_DOWN)){
			y+=dt;
		}
		if (Input.isKeyPressed(KeyEvent.VK_T)){
			error.showErrorMessage("Test");
		}
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(image, (int)x, (int) y);
		
		
	}

}
