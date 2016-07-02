package com.killerpc.debuging;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DebugWindow {
	
	private JFrame frame;
	private JLabel FPSLabel;
	private JLabel TicksLabel;
	private JLabel TimeLabel;
	private JLabel FPS;
	private JLabel ticks;
	private JLabel time;
	
	public DebugWindow(){
		frame = new JFrame();
		frame.setTitle("Debug");
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//add labels
		setupLabels();
		
		
		//don't pack
		frame.setVisible(true);
	}
	
	private void setupLabels(){
		FPSLabel = new JLabel();
		TicksLabel = new JLabel();
		TimeLabel = new JLabel();
		FPS = new JLabel();
		ticks = new JLabel();
		time = new JLabel();
		
		FPSLabel.setText("FPS");
		TicksLabel.setText("Ticks");
		TimeLabel.setText("Time");
		
		FPS.setText("0");
		ticks.setText("0");
		time.setText("0");
		
	}
	
	public void update(int tick, int fps, String t){
		FPS.setText(Integer.toString(fps));
		ticks.setText(Integer.toString(tick));
		time.setText(t);
		if (fps <60 && fps >41){
			FPS.setBackground(Color.YELLOW);
		}
		else if(fps < 40){
			FPS.setBackground(Color.RED);
		}
		else{
			FPS.setBackground(Color.WHITE);
		}
		
	}
	

}
