package com.LoginGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import com.CrudGUI.Student;

public class LogIn extends JFrame {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn login = new LogIn();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		
		frame = new JFrame("Student Application - Log in");
		frame.setFont(new Font("Dialog", Font.PLAIN, 12));
		frame.setBounds(100, 100, 604, 547);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
			
		JPanel panel1 = new JPanel();
		panel1.setForeground(Color.BLACK);
		panel1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel1.setBackground(Color.BLACK);
		panel1.setBounds(0, 0, 596, 99);
		panel1.setLayout(null);
		frame.getContentPane().add(panel1);
			
		JLabel Label1 = new JLabel("STUDENT MANAGEMENT SYSTEM");
		Label1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Label1.setFont(new Font("Tahoma", Font.BOLD, 30));
		Label1.setBounds(39, 28, 510, 49);
		Label1.setForeground(Color.WHITE);
		panel1.add(Label1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 596, 518);
		panel1.add(lblNewLabel_3);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		panel2.setBounds(39, 193, 501, 276);
		panel2.setLayout(null);
		frame.getContentPane().add(panel2);
		
		JLabel Label2 = new JLabel("User Name");
		Label2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label2.setForeground(Color.white);
		Label2.setBounds(78, 41, 98, 51);
		panel2.add(Label2);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBounds(78, 133, 90, 40);
		panel2.add(lblNewLabel);
		
		textField = new JTextField("Arman");
		textField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBounds(234, 49, 202, 24);
		panel2.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField("123456");
		passwordField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		passwordField.setBounds(234, 139, 202, 24);
		panel2.add(passwordField);
		
		JButton button2 = new JButton("Cancel");
		button2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button2.setBounds(348, 203, 83, 21);
		panel2.add(button2);
		
		JButton button1 = new JButton("Login");
		button1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button1.setBounds(234, 203, 83, 21);
		panel2.add(button1);
		
		JLabel lblNewLabel_1 = new JLabel("Devoloped by - Arman Ali");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(230, 479, 250, 30);
		lblNewLabel_1.setForeground(Color.white);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sign in - Account");
		lblNewLabel_2.setBounds(172, 113, 257, 70);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblNewLabel_2.setForeground(Color.white);
		frame.getContentPane().add(lblNewLabel_2);
		
		ImageIcon image = new ImageIcon("images\\StudentManagemet.jfif");
	    ImageIcon imageresize = resize(image,600,422);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(imageresize);
		lblNewLabel_4.setBounds(0, 97, 600, 422);
		frame.getContentPane().add(lblNewLabel_4);
		
		button1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String user = textField.getText();
				String pass = passwordField.getText();
				
				if(user.isEmpty() && pass.isEmpty()) {
					
					JOptionPane.showMessageDialog(frame,"Do not blank the fields...");
				}
				              
				 else if(user.equals("Arman") && pass.equals("123456")) {
						
						Student student = new Student();
						frame.hide();
					}
				
                  else if(user.equals("Arman") && pass != "123456") {
  					JOptionPane.showMessageDialog(frame, "Password do not match");
  				}
  				
				else if(pass.equals("123456") && user != "Arman"){
					JOptionPane.showMessageDialog(frame,"User Name do not match");
				}	
				
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}

		});
		
		frame.setVisible(true);
	}

	  private static ImageIcon resize(ImageIcon im, int w, int h) {
				BufferedImage bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
				Graphics2D gd = (Graphics2D) bi.createGraphics();
				gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
				gd.drawImage(im.getImage(), 0, 0, w, h, null);
				gd.dispose();
				return new ImageIcon(bi);
			}
}