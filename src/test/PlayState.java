package test;

import com.killerpc.core.GameContainer;
import com.killerpc.core.Renderer;
import com.killerpc.core.components.ObjectManager;
import com.killerpc.core.components.State;

public class PlayState extends State
{
	public PlayState()
	{
		manager.addObject(new Player(0,0));
		manager.addObject(new Ball(156, 116));
		manager.addObject(new Enemy(304, 0));
	}
	
	@Override
	public void update(GameContainer gc, float dt)
	{
		manager.updateObjects(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r)
	{
		manager.renderObjects(gc, r);
	}

	public void dipose()
	{
	
	}

	public ObjectManager getManager()
	{
		return manager;
	}

	public void setManager(ObjectManager manager)
	{
		this.manager = manager;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
