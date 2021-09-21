package com.startGUI;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.border.BevelBorder;

import com.LoginGUI.LogIn;

class Splash {

	public static void main(String[] args) {

		JWindow frame = new JWindow();
		frame.setSize(500, 410);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setSize(500, 410);
		panel.setVisible(true);
		frame.add(panel);

		ImageIcon ic = new ImageIcon("images\\learning.jfif");
		ImageIcon resizeImage = resize(ic, 500, 410);
		JLabel jimage = new JLabel(resizeImage);
		panel.add(jimage);
		frame.setVisible(true);

		JProgressBar pb = new JProgressBar();
		pb.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pb.setBounds(0, 394, 500, 16);
		pb.setStringPainted(true);
		pb.setIndeterminate(true);
		panel.setLayout(null);
		panel.add(pb);

		for (int i = 0; i <= 100; i++) {
			pb.setValue(i);
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				System.out.println(e);
			}

		}

		if (pb.getValue() == 100) {
			frame.dispose();
			LogIn logIn = new LogIn();
		}

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