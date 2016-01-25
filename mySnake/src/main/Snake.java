package main;

import java.util.LinkedList;
import java.util.List;

public class Snake {
	enum DIRECTION{
		RIGHT, LEFT, UP, DOWN;
	}
	List<SnakeNode> nodes;
	private DIRECTION direction;
	private DIRECTION nextDirection;
	public Snake(){
		direction = DIRECTION.RIGHT;
		this.nodes = new LinkedList<SnakeNode>();
		nodes.add(new SnakeNode(1,7));
		nodes.add(new SnakeNode(2,7));
		nodes.add(new SnakeNode(3,7));
	}
	
	public int getLenth(){
		return nodes.size();
	}
	
	public void move(Food food){
		SnakeNode head;
		SnakeNode headOld = nodes.get(0);
		if(nextDirection!=null){
			direction = nextDirection;
		}
		switch(direction){
		    case RIGHT:
		    	head = new SnakeNode(headOld.x+1,headOld.y);break;
		    case LEFT:
		    	head = new SnakeNode(headOld.x-1,headOld.y);break;
		    case UP:
		    	head = new SnakeNode(headOld.x,headOld.y-1);break;
		    case DOWN:
		    	head = new SnakeNode(headOld.x,headOld.y+1);break;
		    default:
		    	head = new SnakeNode(0,0);
		}
		nodes.add(0,head);
		if(!(head.x==food.x&&head.y==food.y)){
			nodes.remove(nodes.size()-1);
		}
	}
	
	public void setNextDirection(DIRECTION nextDirection){
		switch(nextDirection){
		case UP:
			if(direction==DIRECTION.DOWN){
				return;
			}
			break;
		case DOWN:
			if(direction==DIRECTION.UP){
				return;
			}
			break;
		case RIGHT:
			if(direction==DIRECTION.LEFT){
				return;
			}
			break;
		case LEFT:
			if(direction==DIRECTION.RIGHT){
				return;
			}
			break;
		}
		this.nextDirection = nextDirection;
	}
	
}
