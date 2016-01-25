package main;

public class mainProcess {
	public static void main(String args[]){
		Snake snake = new Snake();
		Food food = new Food(snake);
		Board board = new Board("贪吃蛇", snake, food);
		Updater updater = new Updater(board, snake);
		updater.run();
	}
}
