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
	private SoundClip clip = new SoundClip("/coin pickup.wav");

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
	@Override
	public void update(GameContainer gc, float dt) {
		
		if (Input.isKeyReleased(KeyEvent.VK_Z)){
			clip.play();
		}
		if (Input.isKeyReleased(KeyEvent.VK_1)){
			clip.stop();
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
