package test;

import com.killerpc.core.AbstractGame;
import com.killerpc.core.GameContainer;
import com.killerpc.core.Renderer;

public class Game extends AbstractGame{

	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new Game());
		gc.start();

	}

	@Override
	public void update(GameContainer gc, float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		// TODO Auto-generated method stub
		
	}

}
