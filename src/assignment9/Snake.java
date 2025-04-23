package assignment9;

import java.util.LinkedList;
import java.util.List;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		deltaX = 0;
		deltaY = 0;
		segments = new LinkedList<BodySegment>();
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
		
		
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */

	public void move() {
		for (int i = (segments.size() - 1); i > 0; i--) {
			segments.get(i).setX(segments.get(i-1).getX());
			segments.get(i).setY(segments.get(i-1).getY());
		}
		
		segments.get(0).setX(deltaX + segments.get(0).getX());
		segments.get(0).setY(deltaY + segments.get(0).getY());	
		}
	
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for(int i = 0; i < segments.size(); i++) {
			segments.get(i).draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	
	public boolean eatFood(Food f) {
		double dx = segments.get(0).getX() - f.getX();
		double dy = segments.get(0).getY() - f.getY();
		if (Math.sqrt(dx*dx + dy*dy) < (1.5 * SEGMENT_SIZE)) {
			int n = segments.size() - 1;
			BodySegment newSegment = new BodySegment(segments.get(n).getX(), segments.get(n).getY(), SEGMENT_SIZE);
			segments.add(newSegment);
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		if (segments.get(0).getX() > 1) {
			return false;
		}
		if (segments.get(0).getY() > 1) {
			return false;
		}
		if (segments.get(0).getX() < 0) {
			return false;
		}
		if (segments.get(0).getY() < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean hitSelf() {
		boolean hitSelf = false;
		for (int i = 2; i < segments.size(); i++) {
			double dx = segments.get(0).getX() - segments.get(i).getX();
			double dy = segments.get(0).getY() - segments.get(i).getY();
			if (Math.sqrt(dx*dx + dy*dy) < (SEGMENT_SIZE)) {
				hitSelf = true;
				return hitSelf;
			}
		}
		
		return hitSelf;
	}
	
}

	
