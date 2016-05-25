package test;

import java.awt.event.KeyEvent;

import com.killerpc.core.AbstractGame;
import com.killerpc.core.GameContainer;
import com.killerpc.core.Input;
import com.killerpc.core.Renderer;
import com.killerpc.core.fx.Image;
import com.killerpc.core.fx.SoundClip;

public class Game extends AbstractGame{
	
	private Image image = new Image("/test.png");
	private SoundClip clip1 = new SoundClip("/coin pickup.wav");
	private SoundClip clip2 = new SoundClip("/War Machine.wav");

	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new Game());
		gc.setWidth(200);
		gc.setHeight(150);
		gc.setScale(4);
		gc.setShowFPS(true);
		gc.start();

	}
	float x =0;
	float y =0;
	int v = 50;
	@Override
	public void update(GameContainer gc, float dt) {
		
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
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(image, (int)x, (int) y);
		
		
	}

}
