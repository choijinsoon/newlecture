package com.newlecture.part3.ch6;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

public class GameFrame extends Frame {

	public GameFrame() {
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine(20, 20, 200, 200);
	}
}
