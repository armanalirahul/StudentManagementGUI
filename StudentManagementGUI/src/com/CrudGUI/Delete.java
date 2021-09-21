package com.CrudGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JButton btn2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public Delete() throws ClassNotFoundException, SQLException {
		
		
		setTitle("Delete Student");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","mysql");
		
		setBounds(100, 100, 559, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JButton btn = new JButton("Show Students");
		btn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn.setBackground(Color.DARK_GRAY);
		btn.setForeground(Color.white);
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
		contentPane.add(btn, BorderLayout.NORTH);
		
		btn2 = new JButton("Delete Student");
		btn2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn2.setBackground(Color.DARK_GRAY);
		btn2.setForeground(Color.white);
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				System.out.println(row);
				String cell = table.getModel().getValueAt(row, 0).toString();
				System.out.println(cell);
				try {
					PreparedStatement ps=con1.prepareStatement("delete from student where name=(?)");
					ps.setString(1, cell);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
					updateTable();

				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
				
		contentPane.add(btn2, BorderLayout.SOUTH);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
	}
	
	public void updateTable() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","mysql");
		
		String sql = "select * from student";
		try
		{
			String query = "select * from student";
			PreparedStatement ps=con1.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
			}

}