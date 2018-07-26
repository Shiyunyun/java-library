package com.neuedu.utils;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;

public class JLabel2Image extends JLabel{
	private Image image;
	
	public JLabel2Image(Image image) {
		super();
		this.image = image;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = this.getWidth();
		int y = this.getHeight();
		g.drawImage(image, 0, 0, x, y, null);
	}
	
}
