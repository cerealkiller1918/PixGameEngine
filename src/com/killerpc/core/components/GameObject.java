package com.killerpc.core.components;

import java.util.ArrayList;

import com.killerpc.core.GameContainer;
import com.killerpc.core.Renderer;

public abstract class GameObject {
	
	
	protected int  x, y ;
	protected float w , h ;
	protected String tag = null;
	protected ArrayList<Component> components = new ArrayList<Component>();
	
	public abstract void update (GameContainer gc, float dt);
	public abstract void render (GameContainer gc, Renderer r);
	
	public void updateComponents(GameContainer gc, float dt){
		for(Component c : components){
			c.update(gc, this, dt);
		}
	}
	
	public void renderCompoents(GameContainer gc, Renderer r){
		for(Component c: components){
			c.render(gc, r);
		}
	}
	
	public abstract void componentEvent(String name, GameContainer gc);
	public abstract void dispose();
	
	public void addComponent(Component c){
		components.add(c);
	}
	

}
