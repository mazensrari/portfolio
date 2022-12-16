import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Triangle extends Drawable {
	private int height;
	private int width;

	/**
	 * Create a new triangle at default position with default color.
	 */
	public Triangle() {
		this(40, 50);
	}

	/**
	 * Create a new triangle of a given height and width at default position
	 * with default color.
	 */
	public Triangle(int height, int width) {
		super(0, 0, "green");
		this.height = height;
		this.width = width;
		control = new Control(this);
	}

	/**
	 * Change the size to the new size (in pixels). Size must be >= 0.
	 */
	public void changeSize(int newHeight, int newWidth) {
		control.erase();
		height = newHeight;
		width = newWidth;
		control.draw();
	}

	private class Control implements DrawControl {
		private Triangle t;

		public Control(Triangle t) {
			this.t = t;
		}

		/**
		 * Draw the triangle with current specifications on screen.
		 */
		public void draw() {
			if (t.isVisible()) {
				Canvas canvas = Canvas.getCanvas();
				int xPosition = t.getX();
				int yPosition = t.getY();
				int[] xpoints = { xPosition, xPosition + (width / 2),
						xPosition - (width / 2) };
				int[] ypoints = { yPosition, yPosition + height,
						yPosition + height };
				canvas.draw(t, new Polygon(xpoints, ypoints, 3));
				canvas.wait(10);
			}
		}

		/**
		 * Erase the triangle on screen.
		 */
		public void erase() {
			if (t.isVisible()) {
				Canvas canvas = Canvas.getCanvas();
				canvas.erase(t);
			}
		}
	}
}
