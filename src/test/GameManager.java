package test;

import java.util.Stack;

import com.killerpc.core.AbstractGame;
import com.killerpc.core.GameContainer;
import com.killerpc.core.Renderer;
import com.killerpc.core.components.State;

public class GameManager extends AbstractGame
{
	public GameManager()
	{
		//push(new PlayState());
	}
	
	@Override
	public void update(GameContainer gc, float dt)
	{
		peek().update(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r)
	{
		peek().render(gc, r);
	}
	
	public static void main(String args[])
	{
		GameContainer gc = new GameContainer(new GameManager());
		gc.setWidth(320);
		gc.setHeight(240);
		gc.setScale(3);
		gc.setClearScreen(true);
		gc.setLightEnable(false);
		gc.setDynamicLights(false);
		gc.start();
	}

	@Override
	public void init(GameContainer gc)
	{
		// TODO Auto-generated method stub
		
	}
}
