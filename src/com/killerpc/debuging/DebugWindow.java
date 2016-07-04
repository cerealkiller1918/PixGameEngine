package com.killerpc.debuging;


import java.awt.Color;
import java.awt.GridLayout;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DebugWindow {
	
	private JFrame frame;
	private JLabel FPSLabel;
	private JLabel TicksLabel;
	private JLabel TimeLabel;
	private JLabel FPS;
	private JLabel ticks;
	private JLabel time;
	private JPanel panel;
	private final int WIDTH = 250, HIGHT = 200;
	private JLabel DebugMode, debugState;
	private JLabel ConsoleMode, consoleStat;
	private JLabel LoggerMode, loggerState;
	
	public DebugWindow(){
		frame = new JFrame();
		setupLabels();
		buildPanel();
	}
	
	public void Window(){
		
		frame.setTitle("Debug");
		frame.setSize(WIDTH, HIGHT);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//add labels
		frame.add(panel);
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
		DebugMode = new JLabel();
		debugState = new JLabel();
		ConsoleMode = new JLabel();
		consoleStat = new JLabel();
		LoggerMode = new JLabel();
		loggerState = new JLabel();
		
		FPSLabel.setText("FPS");
		TicksLabel.setText("Ticks");
		TimeLabel.setText("Time");
		DebugMode.setText("Debug Mode");
		ConsoleMode.setText("Console Mode");
		LoggerMode.setText("Logger Mode");
		
		
	}
	
	public void update(int tick, int fps){
		FPS.setText(Integer.toString(fps));
		ticks.setText(Integer.toString(tick));
		time.setText("0");
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
	
	private void buildPanel(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(7, 2));
		panel.add(FPSLabel);
		panel.add(FPS);
		panel.add(TicksLabel);
		panel.add(ticks);
		panel.add(TimeLabel);
		panel.add(time);
		panel.add(DebugMode);
		panel.add(debugState);
		panel.add(ConsoleMode);
		panel.add(consoleStat);
		panel.add(LoggerMode);
		panel.add(loggerState);
	}
	
	public void cleanup(){
		if(frame.isVisible()){
			frame.setVisible(false);
			frame.dispose();
		}
	}
	
	public void setDebugStates(boolean debugMode, boolean consoleMode, boolean loggerMode){
		debugState.setText(Boolean.toString(debugMode));
		consoleStat.setText(Boolean.toString(consoleMode));
		loggerState.setText(Boolean.toString(loggerMode));
	}
	
	
	
	
	
	
	
	
	

}
