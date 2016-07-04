package com.killerpc.core;

import java.util.Stack;

import com.killerpc.core.components.State;

import test.PlayState;

public abstract class AbstractGame {

	private Stack<State> states = new Stack<State>();	
	public abstract void update(GameContainer gc, float dt);
	public abstract void render(GameContainer gc, Renderer r);
	public abstract void init(GameContainer gc);
	public State peek(){
		return states.peek();
	}
	public void push(State playState){
		states.push(playState);
	}	
	public void pop(){
		states.pop();
	}
	public void setState(State s){
		states.pop();
		states.push(s);
	}
}
