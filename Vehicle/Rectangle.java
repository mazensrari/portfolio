/**
 * A Rectangle that can be manipulated and that draws itself on a canvas. Based
 * on the Square class in the original project by Kolling and Barnes.. All
 * values for distances or coordinates on the canvas are in pixels.
 * 
 * @author Tony Beaumont. Based on code written by Michael Kolling and David J.
 *         Barnes
 * @version 2011/14/09
 */

public class Rectangle extends Drawable {
    private int width;
    private int height;

    /**
     * Constructor for Rectangle objects. New Rectangle objects are all
     * positioned with their top left hand corner at (60,50), have a length of
     * 50 and a height of 30, are coloured red and are initially invisible.
     */
    public Rectangle() {
        this(50, 40);
    }

    /**
     * Constructor for Rectangle objects. New Rectangle objects are all
     * positioned with their top left hand corner at (60,50), are coloured red
     * and are initially invisible. Using this constructor the length and height
     * of the rectangle can be provided as parameters at runtime.
     * 
     * @param length
     *            The initial length of the rectangle
     * @param height
     *            The initial height of the rectangle
     */
    public Rectangle(int width, int height) {
        super(0, 0, "red");
        this.width = width;
        this.height = height;
        control = new Control(this);
    }

    /**
     * Change the length and height of the rectangle to the given values. The
     * value of length and height must each be >= 0.
     * 
     * @param newLength
     *            the new length of the rectangle.
     * @param newHeight
     *            the new height of the rectangle.
     */
    public void changeSize(int newLength, int newHeight) {
        control.erase();
        width = newLength;
        height = newHeight;
        control.draw();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        control.draw();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        control.draw();
    }

    private class Control implements DrawControl {
        private Rectangle r;

        public Control(Rectangle r) {
            this.r = r;
        }

        /**
         * Draw the square with current specifications on screen.
         */
        public void draw() {
            if (r.isVisible()) {
                Canvas canvas = Canvas.getCanvas();
                canvas.draw(r, new java.awt.Rectangle(r.getX(), r.getY(), 
                        width, height));
                canvas.wait(10);
            }
        }

        /**
         * Erase the square on screen.
         */
        public void erase() {
            if (r.isVisible()) {
                Canvas canvas = Canvas.getCanvas();
                canvas.erase(r);
            }
        }
    }
}
