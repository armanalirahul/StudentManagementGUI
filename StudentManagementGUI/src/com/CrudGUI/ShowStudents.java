package com.CrudGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Dimension;

public class ShowStudents extends JFrame {

	
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowStudents frame = new ShowStudents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	 public ShowStudents() throws SQLException, ClassNotFoundException {
	
		setTitle("Show Name");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "mysql");
		
		
		setBounds(100, 100, 537, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btn = new JButton("Show Students name");
		btn.setBounds(5, 5, 517, 31);
		btn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn.setBackground(Color.DARK_GRAY);
		btn.setForeground(Color.white);
		
		setLocationRelativeTo(null);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query = "select * from Student";
					PreparedStatement ps=con1.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btn);
		
		table = new JTable();
		table.setBounds(5, 36, 517, 222);
		contentPane.add(table);
		

	}
}