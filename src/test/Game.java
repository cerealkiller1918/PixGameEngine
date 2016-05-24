package test;

import java.awt.event.KeyEvent;

import com.killerpc.core.AbstractGame;
import com.killerpc.core.GameContainer;
import com.killerpc.core.Input;
import com.killerpc.core.Renderer;
import com.killerpc.core.gfx.Image;

public class Game extends AbstractGame{
	
	private Image image = new Image("/test.png");

	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new Game());
		gc.setScale(2);
		gc.start();

	}
	float x =0;
	float y =0;
	@Override
	public void update(GameContainer gc, float dt) {
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
