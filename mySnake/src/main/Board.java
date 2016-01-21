package main;

import java.awt.*;
import java.awt.event.*;

public class Board extends Frame{
	private static final int Height = 300;
	private static final int Width = 400;
	private static final int row = 15;
	private static final int col = 20;
	private static final int snakeWidth = 16;
	private static final int snakeHeight = 16;
	public Board(String title){
		super(title);
		setSize(Width,Height);
		setVisible(true);
		setResizable(false);
		addWindowListener(new BoardHandler());
	}
	public static void main(String args[]){
		Board board = new Board("贪吃蛇");
	}
	public void paint(Graphics g){
		g.drawRect((Width-col*snakeWidth)/2, (Height-row*snakeHeight)/2, col*snakeWidth, row*snakeHeight);
	}
}

class BoardHandler extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
}