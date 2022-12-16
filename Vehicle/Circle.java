import java.awt.geom.Ellipse2D;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author Michael Kolling and David J. Barnes. Modified by AJB.
 * @version 2011.07.25
 */

public class Circle extends Drawable {
    // instance variables - replace the example below with your own
    private int diameter;

    /**
     * Constructor for objects of class Circle
     */
    public Circle() {
        // initialise instance variables
        this(40);
    }

    public Circle(int initialDiameter) {
        super(0, 0, "blue");
        diameter = initialDiameter;
        control = new Control(this);
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newDiameter) {
        control.erase();
        diameter = newDiameter;
        control.draw();
    }
    /**
     * get the diameter of the circle (in pixels). 
     */
    public int getDiameter() {
        return diameter;
    }

    private class Control implements DrawControl {
        private Circle c;

        public Control(Circle c) {
            this.c = c;
        }

        /**
         * Draw the circle with current specifications on screen.
         */
        public void draw() {
            if (c.isVisible()) {
                Canvas canvas = Canvas.getCanvas();
                canvas.draw(c, new Ellipse2D.Double(c.getX() - (diameter / 2.0), 
                        c.getY() - (diameter / 2.0), diameter,
                        diameter));
                canvas.wait(10);
            }
        }

        /**
         * Erase the circle on screen.
         */
        public void erase() {
            if (c.isVisible()) {
                Canvas canvas = Canvas.getCanvas();
                canvas.erase(c);
            }
        }
    }

}
