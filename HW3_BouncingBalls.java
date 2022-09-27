package hw3;

import java.awt.Color;
import edu.princeton.cs.algs4.StdDraw;

public class BouncingBalls {
	// Number of balls
	private static final int BALL_COUNT = 4;
	
	// Window runs from (-WINDOW_MAX,-WINDOW_MAX) in bottom left to
	// (WINDOW_MAX, WINDOW_MAX) in the top right
	private static final int WINDOW_MAX = 400;
	
	// The maximum ball radius
	private static final int MAX_BALL_RADIUS = 40;
	
	// The maximam velocity in both the x direction and the y direction.
	private static final double MAX_VELOCITY = 1.0;

	public static void main(String[] args) throws Exception {
		// Initialize StdDraw
		StdDraw.enableDoubleBuffering();
		int windowSize = 2 * WINDOW_MAX + 1;
		StdDraw.setCanvasSize(windowSize, windowSize);
		StdDraw.setXscale(-WINDOW_MAX, WINDOW_MAX);
		StdDraw.setYscale(-WINDOW_MAX, WINDOW_MAX);
		StdDraw.clear(Color.BLACK);
		
		// Let the Ball class know the min and max coordinates of the window
		Ball.setScreen(-WINDOW_MAX, -WINDOW_MAX, WINDOW_MAX, WINDOW_MAX);
		
		// Initialize Ball objects in animation
		Ball[] ball = new Ball[BALL_COUNT];
		for(int i = 0; i < ball.length; i++) {
			ball[i] = createRandomBall();
		}
		
		while(true) {
			// clear the screen
			StdDraw.clear(Color.BLACK);
			
			// move and draw the balls in window buffer
			for(Ball b : ball) {
				b.move();
				b.draw();
			}
			// draw window buffer on screen and pause
			StdDraw.show();
			StdDraw.pause(5);
			
			// If there is a collision pause and then
			// start over with random balls.
			if (checkCollisions(ball)) {
				StdDraw.pause(2000);
				for(int i = 0; i < ball.length; i++)
					ball[i] = createRandomBall();
			}
		}
	}
	
	/**
	 * Checks if any of the <code>Ball</code>s in <code>b</code>
	 * have collided.
	 * @param b an array of <code>Ball</code> objects to check
	 * @return <code>true</code> if any of the <code>Ball</code>
	 * objects in <code>b</code> have collided and
	 * <code>false</code> otherwise.
	 */
	private static boolean checkCollisions(Ball[] b) {
		// TODO - this code is wrong and needs to be fixed.
		for (int i = 0; i < b.length - 1; i++) {
			if(b[i].collision(b[i+1]) == true) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Creates a new <code>Ball</code> that is randomly placed on the screen
	 * and given a random size (radius), a random velocity, and a random color.
	 * @return a new randomly generated <code>Ball</code> object.
	 */
	private static Ball createRandomBall() {
			double minPos = -WINDOW_MAX + MAX_BALL_RADIUS;
			double maxPos = WINDOW_MAX - MAX_BALL_RADIUS;
			double x = HW3Utils.randomDouble(minPos, maxPos);
			double y = HW3Utils.randomDouble(minPos, maxPos);
			double r = HW3Utils.randomDouble(0.5 * MAX_BALL_RADIUS, MAX_BALL_RADIUS);
			double vX = HW3Utils.randomDouble(-MAX_VELOCITY, MAX_VELOCITY);
			double vY = HW3Utils.randomDouble(-MAX_VELOCITY, MAX_VELOCITY);
			Color c = HW3Utils.randomColor();
			Ball b = new Ball(x, y, r, vX, vY, c);
			return b;
		}
	}