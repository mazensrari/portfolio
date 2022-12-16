
/**
 * This class is for your week 1 portfolio project.
 * You need to draw a picture of a vehicle and add methods to move
 * the vehicle right and left across the canvas.
 * Put your name into the template below:
 * 
 * @author (Mazen Srari) 
 * @version (23/09/2022)
 */
public class Vehicle
{
    private Rectangle chassis;
    private Rectangle cab;
    private Rectangle window;
    private Circle wheel1;
    private Circle wheel2;
    private Circle sun;
    private Rectangle road;
    private Rectangle paint;
    private int x = 490;
    private int y = 390;

    /**
     * Constructor for objects of class Vehicle.
     */
    public Vehicle()
    {
        // nothing to write here for this assignment 
    }

    /**
     * Draw your vehicle.
     */
    public void draw()
    {
        chassis = new Rectangle();
        chassis.moveHorizontal(490);
        chassis.moveVertical(390);
        chassis.changeSize(140,50);
        chassis.makeVisible();
        chassis.changeColor("red");

        cab = new Rectangle();
        cab.moveHorizontal(490);
        cab.moveVertical(360);
        cab.changeSize(100,50);
        cab.makeVisible();
        cab.changeColor("black");

        window = new Rectangle();
        window.moveHorizontal(500);
        window.moveVertical(370);
        window.changeSize(25,25);
        window.makeVisible();
        window.changeColor("white");

        wheel1 = new Circle();
        wheel1.moveHorizontal(510);
        wheel1.moveVertical(440);
        wheel1.changeSize(30);
        wheel1.makeVisible();
        wheel1.changeColor("black");

        wheel2 = new Circle();
        wheel2.moveHorizontal(590);
        wheel2.moveVertical(440);
        wheel2.changeSize(30);
        wheel2.makeVisible();
        wheel2.changeColor("black");
        
        sun = new Circle();
        sun.moveHorizontal(150);
        sun.moveVertical(130);
        sun.changeSize(75);
        sun.makeVisible();
        sun.changeColor("yellow");
        
        road = new Rectangle();
        road.moveHorizontal(0);
        road.moveVertical(455);
        road.changeSize(1100,500);
        road.makeVisible();
        road.changeColor("lightGray");

        paint = new Rectangle();
        paint.moveHorizontal(0);
        paint.moveVertical(600);
        paint.changeSize(1100,20);
        paint.makeVisible();
        paint.changeColor("white");
    }

    public void positionAllShapes() {
        chassis.setPosition(x, y);
        cab.setPosition(x, y - 30);
        window.setPosition(x + 10, y - 20);
        wheel1.setPosition(x + 20, y + 50);
        wheel2.setPosition(x + 100, y + 50);
    }

    /**
     * Move your vehicle a little to the right.
     */
    public void MoveRight(int dx) {
        x = x + dx;
        positionAllShapes();
    }

    /**
     * Move your vehicle a little to the left.
     */
    public void MoveLeft(int dx) {
        x = x - dx;
        positionAllShapes();
    }
}

