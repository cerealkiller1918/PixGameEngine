package com.killerpc.errorMessage;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorMessage {
	
	private JFrame frame;
	private String title = "Error Message";
	private int WIDTH = 500;
	private int HIGHT = 200;
	private JButton okBtn;
	private JPanel errorLogo;
	private JPanel errorMessage; 
	private JLabel message;
	
	public void showErrorMessage(String e){
		frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(WIDTH, HIGHT);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//errorLogoPanel();
		//errorMessagePanel();
		//Test
		message = new JLabel();
		message.setText(e);
		message.setSize(WIDTH, HIGHT);
		//
		frame.add(message);
		//frame.add(errorLogo);
		//frame.add(errorMessage);
		frame.setVisible(true);
	}

	
	private int closeErrorMessage(){
		frame.setVisible(false);
		frame.dispose();
		return 1;
	}
	
}
