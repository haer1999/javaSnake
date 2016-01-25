package main;

import java.util.Random;

public class Food extends SnakeNode{
	public Food(Snake snake){
		super(0, 0);
		boolean finished;
		do{
			finished = true;
			Random r = new Random();
			x = r.nextInt(Board.col);
			y = r.nextInt(Board.row);
			for(int i=0; i<snake.getLenth(); i++){
				if(x==snake.nodes.get(i).x&&y==snake.nodes.get(i).y){
					finished = false;
				}
			}
		}while(!finished);
	}
}
