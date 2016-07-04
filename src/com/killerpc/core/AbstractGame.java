package com.killerpc.core;

public abstract class AbstractGame {

	public abstract void update(GameContainer gc, float dt);
	public abstract void render(GameContainer gc, Renderer r);
	public abstract void init(GameContainer gc);
}
