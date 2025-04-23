package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	private Color color;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		this.x = Math.random() * 0.95 + 0.025;
		this.y = Math.random() * 0.95 + 0.025;
		this.color = Color.red;
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledCircle(this.x, this.y, FOOD_SIZE);
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
}
