/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Picture
{
    private Rectangle wall;
    private Rectangle window;
    private Triangle roof;
    private Circle sun;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        // nothing to do... instance variables are automatically set to null
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        wall = new Rectangle();
        wall.moveHorizontal(150);
        wall.moveVertical(150);
        wall.changeSize(100, 100);
        wall.makeVisible();

        window = new Rectangle();
        window.changeColor("black");
        window.moveHorizontal(160);
        window.moveVertical(160);
        window.changeSize(30, 30);
        window.makeVisible();

        roof = new Triangle();  
        roof.changeSize(50, 140);
        roof.moveHorizontal(200);
        roof.moveVertical(100);
        roof.makeVisible();

        sun = new Circle();
        sun.changeColor("yellow");
        sun.moveHorizontal(300);
        sun.moveVertical(60);
        sun.changeSize(60);
        sun.makeVisible();
    }

    public void sunset() {
        sun.slowMoveVertical(600);
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        if(wall != null)   // only if it's painted already...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.changeColor("black");
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        if(wall != null)   // only if it's painted already...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.changeColor("yellow");
        }
    }
}