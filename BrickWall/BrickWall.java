import java.util.ArrayList;

/**
 * A Java tool to draw brick walls
 * 
 * @author (Mazen Srari) 
 * @version (v1)
 */
public class BrickWall
{
    private int wallHeight;
    private int wallWidth;
    private String[] colors;
    private int currentColor;
    private ArrayList<Rectangle> bricks;
    private Rectangle brick;
    private boolean isMulticolored;
    private boolean isSymmetrical;
    private boolean isDecrease;
    //private boolean isGapped;
    private int rowlen;
    private int brickWidth;
    private int brickHeight;
    private int brickPositionX;
    private int brickPositionY;

    //complete with remaining field declarations

    /**
     * Constructor for objects of class BrickWall.
     * @param rows The number of rows in the wall
     * @param rowlen The maximum number of bricks in a row
     */
    public BrickWall(int wallHeight, int wallWidth)
    {
        setUpColors();
        currentColor = 0;
        bricks = new ArrayList<Rectangle>();
        this.wallHeight = wallHeight;
        this.wallWidth = wallWidth;
        isDecrease = false;
        isSymmetrical = false;
        isMulticolored = false;
        //isGapped = false;
        brickWidth = 52;
        brickHeight = 15;
        brickPositionX = 0;
        brickPositionY = 0;

        //complete the constructor

    }

    private void setUpColors() {
        colors = new String[6];
        colors[0] = "red";
        colors[1] = "yellow";
        colors[2] = "blue";
        colors[3] = "green";
        colors[4] = "magenta";
        colors[5] = "black";    
    }

    /**
     * Draw the wall.  The first brick will be positioned at the coordinates (10, 550).  
     * The number of bricks in a row is specified by setRowLength().  The maximum number of rows
     * is specified by setNumRows().  If decrease is true, each subsequent row of bricks 
     * contains one brick less than the previous row.  If symmetric is true AND decrease is true then
     * the wall is pyramid shaped.  If symmetric is false AND decrease is true then the wall is shaped
     * like a right angle triangle.
     */
    public void draw()
    {
        eraseWall(); 

        /* ------------------------------
        // Write your code below this comment
        -------------------------------- */
        //drawBrick(20,500);
        //drawRow(20, 500, wallWidth);
        drawWall(20,500,wallWidth, wallHeight);
    }

    public void drawBrick(int startX, int startY) {
        // draw a single brick as a Rectangle
        // if the bricks is multicolor(true) you must change value of color 
        // to move to next color (boolean - if)
        brick = new Rectangle();
        brick.setPosition(startX,startY);
        brick.changeSize(52,15);
        bricks.add(brick);
        brick.changeColor(colors[currentColor]);
        brick.makeVisible();
    }

    /**The size of the row is set by the user, but the row cannot be
     * more than 24 bricks wide.
     */
    public void drawRow(int x, int y, int rowlen) {
        // create a row of bricks  repeatedly, (int x,int y, length)
        // each brick to the right of the previous (int x)
        for (int i = 0; i < rowlen; ++i) {
            // what will be repeated, every single brick will move to the right from the previous
            drawBrick(x + (52*i), y);
            // if multiColor is enabled, the program moves to the next available color
            if (isMulticolored) {
                nextColor();
            }
        }
    }

    public void nextColor() {
        //this method changed the color of the bricks by adding one to the index
        currentColor++;
        if (currentColor == colors.length) {
            currentColor = 0;
        }
    }

    /**The size of the wall is set by the user, but the wall cannot be
     * more than 31 bricks high.
     */
    public void drawWall(int x, int y, int rowlen, int rows) {
        // draw a whole wall (int x, int y, lentgh, numRows)
        //  draw a row, but each subsequent row is positioned above the previous one (int y)
        if ( wallWidth <= 24 || wallHeight <= 31 && rowlen <= 24 || rows <= 31 ) {
            for (int i = 0; i < rows; ++i) {
                // place each row ABOVE the previous one
                //if (isGapped) {
                    //drawRow(x + (52*i) + 2, y - (15*i) - 2, rowlen);
                //} else {
                drawRow(x, y - (15*i), rowlen);
                //}
                //ALTERNATIVE = y = y - 15;
                // if the decrease method is on, then every row above the first one 
                // should miss a brick to the right
                if (isDecrease) {
                    rowlen--;
                    // if the symmetrical method is on, then the wall is mirrored on the left
                    if (isSymmetrical) {
                        x += (brickWidth/2);
                    }
                } 
            }
        } else {
            System.out.println("Wall size if out of boundaries. Enter different values.");
        }
    }  

    public void toggleDecrease() {
        // I need a method that will toggle from a decreasing wall to 
        // a non-decreasing wall
        isDecrease = !isDecrease;
    }

    public void toggleMulticolor() {
        // I need a method that will switch from plain colored wall 
        // to multicolor wall
        isMulticolored = !isMulticolored;
    }

    public void toggleSymmetrical() {
        // I need a method that will toggle from a symmetrical wall to 
        // a non-symmetrical wall
        isSymmetrical = !isSymmetrical;
    }

    //public void toggleMortarGaps() {
        //isGapped = !isGapped;
    //}

    public void eraseWall() {
        // add a brick to the list of bricks in order for this method to work
        // make sure you do this before moving to part 3+
        Canvas canvas = Canvas.getCanvas();
        for(int i = 0; i < bricks.size(); ++i) {
            canvas.erase(bricks.get(i));
        }
        bricks = new ArrayList<Rectangle>();
    }

    /**
     * Accessor for the bricks array
     */
    public int getNumberOfBricks() {
        return bricks.size();
    }

    /**
     * Accessor for the colors array
     */
    public String[] getColors(){
        return colors;
    }

    public int getXPosition() {
        //return X position of a given brick
        return brickPositionX;
    }

    public int getYPosition() {
        return brickPositionY;
    }

    public Rectangle findFirstBrickByColour (String color) {
        // This method will return the first brick it will find of the color input
        for (int i = 0; i < bricks.size(); i++) {
            if (bricks.get(i).getColor().contains(color)) {
                return bricks.get(i);
            }
        }
        System.out.println("No bricks found, please search a different color.");
        return null;
    }

    public ArrayList<Rectangle> findBricksByColour (String color) {
        ArrayList<Rectangle> brickOfSpecColor = new ArrayList<Rectangle>();
        //brickOfSpecColor.add(bricks.get(i));
        for (int i = 0; i < bricks.size(); i++) {
            if (bricks.get(i).getColor().contains(color)) {
                brickOfSpecColor.add(bricks.get(i));
            } else {
                System.out.println("No bricks found, please search a different color.");
                return null;
            }
        }
        return brickOfSpecColor;
    }

    public Rectangle findBrickAt (int givenX, int givenY) {
        for (int i = 0; i < bricks.size(); ++i) {
            //This method will find a brick at given coordinates and will return it
            if (bricks.get(i).getXPosition() == givenX) {
                if (bricks.get(i).getYPosition() == givenY) {
                    return bricks.get(i);
                }
            }
        }
        System.out.println("No brick found with those coordinates, please search a different brick.");
        return null;
    }

}
