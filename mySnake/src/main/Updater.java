package main;

public class Updater extends Thread{
	private Board board;
	private Snake snake;
	public Updater(Board board, Snake snake){
		this.board = board;
		this.snake = snake;
	}
	public void run(){
		boolean flag = true;
		while(flag){
			snake.move(board.food);
			board.repaint();
			try{
				sleep(500);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
