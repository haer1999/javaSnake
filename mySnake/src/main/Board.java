package main;

import java.awt.*;
import java.awt.event.*;

import main.Snake.DIRECTION;

public class Board extends Frame{
	private static final int Height = 300;
	private static final int Width = 400;
	public static final int row = 15;
	public static final int col = 20;
	private static final int snakeWidth = 16;
	private static final int snakeHeight = 16;
	private static final int xOffset = (Width-col*snakeWidth)/2;
	private static final int yOffset = (Height-row*snakeHeight)/2;
	private Snake snake;
	public Food food;
	public Board(String title, Snake snake, Food food){
		super(title);
		setSize(Width,Height);
		setVisible(true);
		setResizable(false);
		addWindowListener(new BoardHandler());
		this.snake = snake;
		addKeyListener(new KeyHandler(this.snake));
		this.food = food;
	}
	
	public void paint(Graphics g){
		g.drawRect(xOffset, yOffset, col*snakeWidth, row*snakeHeight);
		drawSnake(g);
		drawFood(g);
	}
	
	public void drawSnake(Graphics g){
		for(int i=0; i<snake.getLenth();i++){
			SnakeNode node = snake.nodes.get(i);
			g.setColor(Color.GREEN);
			g.fillRect(xOffset+node.x*snakeWidth, yOffset+node.y*snakeHeight, snakeWidth, snakeHeight);
			g.setColor(Color.BLACK);
			g.drawRect(xOffset+node.x*snakeWidth, yOffset+node.y*snakeHeight, snakeWidth, snakeHeight);
		}
	}
	
	public void drawFood(Graphics g){
		g.setColor(Color.PINK);
		g.fillRect(xOffset+food.x*snakeWidth, yOffset+food.y*snakeHeight, snakeWidth, snakeHeight);
	}
	
}

class KeyHandler extends KeyAdapter{
	private Snake snake;
	public KeyHandler(Snake snake){
		this.snake = snake;
	}
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
		    case KeyEvent.VK_UP:
		    	snake.setNextDirection(DIRECTION.UP);break;
		    case KeyEvent.VK_DOWN:
		    	snake.setNextDirection(DIRECTION.DOWN);break;
		    case KeyEvent.VK_RIGHT:
		    	snake.setNextDirection(DIRECTION.RIGHT);break;
		    case KeyEvent.VK_LEFT:
		    	snake.setNextDirection(DIRECTION.LEFT);break;
		}
	}
}

class BoardHandler extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
}