import java.awt.Color;
import java.awt.Graphics;

/**
 * Drawing with Polymorphism - MyShape (Abstract Class)
 * 
 * @author Richard Cai
 * @version  3.1 01/15/2016
 */
 
//


abstract class MyShape 
{
    private int x1 = 0; // x coordinate of first endpoint
    private int y1 = 0; // y coordinate of first endpoint
    private int x2 = 0; // x coordinate of second endpoint
    private int y2 = 0; // y coordinate of second endpoint
    private Color myColor = Color.BLACK; // set colour to black

    
    /**
     * No-parameter constructor, sets all variables to default. 
     */
    public MyShape(){
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        myColor = Color.BLACK;
    }
    
    /**
     * Default constructor for lines, takes in x1,y1,x2,y2(points) and color as parameters.
     * Initializies the coordinates and colours to parameter values
     */
    public MyShape( int x1, int y1, int x2, int y2, Color color){
        this.x1 = x1; // set x coordinate of first endpoint
        this.y1 = y1; // set y coordinate of first endpoint
        this.x2 = x2; // set x coordinate of second endpoint
        this.y2 = y2; // set y coordinate of second endpoint
        myColor = color; // set the color
    }
    
     /**
     * Default constructor for lines, takes in x1,y1,x2,y2(points), color  and fill as parameters.
     * Initializies the coordinates, colours and fill to parameter values
     */
    public MyShape( int x1, int y1, int x2, int y2, Color color,boolean fill){
        this.x1 = x1; // set x coordinate of first endpoint
        this.y1 = y1; // set y coordinate of first endpoint
        this.x2 = x2; // set x coordinate of second endpoint
        this.y2 = y2; // set y coordinate of second endpoint
        fill = false;
        myColor = color; // set the color
    }
    
    
    //Mutator method for changing indidivudal pieces of data
    
    //Sets x1 coordinate to parameter value
    public void setX1(int x1){
        this.x1 = x1;
    }
    
    //Sets x2 coordinate to parameter value
    public void setX2(int x2){
        this.x2 = x2;
    }
    
    //Sets y1 coordinate to parameter value
    public void setY1(int y1){
        this.y1 = y1;
    }
    
   
    //Sets y2 coordinate to parameter value
    public void setY2(int y2){
        this.y2 = y2;
    }
    
    
    //Sets colour value to parameter value
    public void setColor(Color color){
       myColor = color;
    }
    
    //Accessor method for indidivudal pieces of data
    
    //Returns x1 coordinate of a shape
    public int getX1(){
        return x1;
    }
    
    //Returns x2 coordinate of a shape
    public int getX2(){
       return x2;
    }
    
    //Returns y1 coordinate of a shape
    public int getY1(){
        return y1;
    }
    
    //Returns y2 coordinate of a shape
    public int getY2(){
       return y2;
    }
    
    //Returns color value of a shape
    public Color getColor(){
       return myColor;
    }
    
    
    public abstract void draw( Graphics g );
    //Abstract Draw method, no body. MyShape draw method.

}