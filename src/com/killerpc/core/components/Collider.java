package com.killerpc.core.components;

import com.killerpc.core.GameContainer;
import com.killerpc.core.Renderer;

public class Collider extends Component{
	
	private GameObject object;
	private float x,y,hW, hH;
	
	public Collider() {
		setTag("collider");
	}
	@Override
	public void update(GameContainer gc, GameObject object, float dt) {
		if(this.object == null)
			this.object = object;
		hW = object.getW() / 2;
		hH = object.getH() / 2;
		x = object.getX() + hW;
		y = object.getY() + hH;
		//gc.getPhysics().addCollider(this);
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		// TODO Auto-generated method stub
		
	}

}
