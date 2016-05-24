package test;

import java.awt.event.KeyEvent;

import com.killerpc.core.AbstractGame;
import com.killerpc.core.GameContainer;
import com.killerpc.core.Input;
import com.killerpc.core.Renderer;

public class Game extends AbstractGame{

	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new Game());
		gc.start();

	}

	@Override
	public void update(GameContainer gc, float dt) {
		if(Input.isKeyPressed(KeyEvent.VK_A)){
			System.out.println("Pressed A");
		}
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		// TODO Auto-generated method stub
		
	}

}
