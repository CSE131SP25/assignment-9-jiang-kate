package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;
	private int count = 0;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		snake = new Snake();
		food = new Food();
	}
	
	public void play() {
		while ((snake.isInbounds() == true) && (snake.hitSelf() == false)){
			snake.draw();
			int dir = getKeypress();
			if (dir != -1) {
				snake.changeDirection(dir);
			}
			snake.move();
			
			if(snake.eatFood(food) == true) {
				food = new Food();
				food.draw();
				count++;
			}
			StdDraw.text(0.5, 0.75, "Score: " + count);
			StdDraw.show();
			updateDrawing();
		}	
		StdDraw.text(0.5, 0.75, "Score: " + count);
		StdDraw.show();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();
		StdDraw.pause(50);
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
