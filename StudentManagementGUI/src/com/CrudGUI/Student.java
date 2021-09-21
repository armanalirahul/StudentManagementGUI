package com.CrudGUI;

import java.awt.EventQueue;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.border.BevelBorder;

import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Student {

	private JFrame frame3;
	private JTextField name;
	private JTextField branch;
	private JTextField gender;
	private JTextField mob;
	private Connection con;
	private PreparedStatement pst;
	private ResultSetMetaData rd;
	private JDateChooser dateChooser;
	private DefaultTableModel df;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student student = new Student();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student() {

		Component();

	}

	private void Component() {

		frame3 = new JFrame("Add Student");
		frame3.setForeground(Color.WHITE);
		frame3.setBackground(Color.WHITE);
		frame3.setTitle("Student Management - Add Student");
		frame3.setBounds(100, 100, 829, 704);
		frame3.setLocationRelativeTo(null);
		frame3.setResizable(false);
		frame3.setVisible(true);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0.f, 0.f, 0.f, 0.5f));
		panel.setLayout(null);
		panel.setBounds(227, 174, 341, 374);
		frame3.getContentPane().add(panel);

		JLabel lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 130, 71, 28);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setForeground(Color.white);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(20, 22, 71, 28);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Branch");
		lblNewLabel_1_2.setForeground(Color.white);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(20, 75, 71, 28);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Mobile");
		lblNewLabel_1_3.setForeground(Color.white);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(20, 197, 71, 28);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Date of join");
		lblNewLabel_1_4.setForeground(Color.white);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(20, 264, 95, 28);
		panel.add(lblNewLabel_1_4);

		name = new JTextField();
		name.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		name.setBounds(148, 29, 167, 21);
		panel.add(name);
		name.setColumns(10);

		branch = new JTextField();
		branch.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		branch.setColumns(10);
		branch.setBounds(148, 82, 167, 21);
		panel.add(branch);

		gender = new JTextField();
		gender.setBounds(148, 137, 167, 21);
		panel.add(gender);

		mob = new JTextField();
		mob.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		mob.setColumns(10);
		mob.setBounds(148, 204, 167, 21);
		panel.add(mob);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(148, 264, 155, 28);
		panel.add(dateChooser);

		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.setBackground(Color.darkGray);
		panel_1.setBounds(0, 0, 825, 96);
		panel_1.setLayout(null);
		frame3.getContentPane().add(panel_1);

		JLabel lblNewLabel = new JLabel("STUDENT MANAGEMENT SYSYTEM");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(50, 10, 710, 64);
		panel_1.add(lblNewLabel);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setBackground(Color.darkGray);
		btnNewButton.setForeground(Color.white);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(26, 572, 117, 45);
		frame3.getContentPane().add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBackground(Color.DARK_GRAY);
		btnCancel.setForeground(Color.white);
		btnCancel.setBounds(167, 572, 128, 45);
		frame3.getContentPane().add(btnCancel);

		JLabel lblNewLabel_1_5 = new JLabel("Devoloped by - Armaan Ali");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_5.setForeground(Color.white);
		lblNewLabel_1_5.setBounds(350, 636, 250, 30);
		frame3.getContentPane().add(lblNewLabel_1_5);

		JLabel lblNewLabel_2 = new JLabel("Add Student");
		lblNewLabel_2.setBounds(318, 112, 188, 52);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblNewLabel_2.setForeground(Color.white);
		frame3.getContentPane().add(lblNewLabel_2);

		table = new JTable();
		table.setBounds(423, 188, 1, 1);
		frame3.getContentPane().add(table);

		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.setBounds(318, 572, 128, 45);
		frame3.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete Student");
		btnNewButton_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setForeground(Color.white);
		btnNewButton_2.setBounds(466, 572, 169, 46);
		frame3.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("update");
		btnNewButton_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.white);
		btnNewButton_3.setBounds(655, 572, 128, 45);
		frame3.getContentPane().add(btnNewButton_3);

		ImageIcon image = new ImageIcon("images\\addstudent.jfif");
		ImageIcon imageresize = resize(image, 825, 580);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(imageresize);
		lblNewLabel_3.setBounds(0, 96, 825, 580);
		frame3.getContentPane().add(lblNewLabel_3);

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
							"mysql");
					pst = con.prepareStatement("insert into student(name,branch,gender,mobile,doj)values(?,?,?,?,?)");

				} catch (Exception f) {
					System.out.println(f);
				}

				String tname = name.getText();
				String br = branch.getText();
				String gdr = gender.getText();
				String mobile = mob.getText();

				SimpleDateFormat df = new SimpleDateFormat();
				String date = df.format(dateChooser.getDate());

				try {

					pst.setString(1, tname);
					pst.setString(2, br);
					pst.setString(3, gdr);
					pst.setString(4, mobile);
					pst.setString(5, date);

					pst.executeUpdate();

					JOptionPane.showMessageDialog(frame3, "Record add successfully...");

					name.setText("");
					branch.setText("");
					gender.setText("");
					mob.setText("");
					name.requestFocus();

				} catch (Exception c) {
					System.out.println(c);
				}

			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3.dispose();
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ShowStudents show = new ShowStudents();
					show.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println(e1);
				}

			}
		});

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Delete dlt = new Delete();
					dlt.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println("e1");
				}

			}
		});

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Update update = new Update();
					update.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

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
