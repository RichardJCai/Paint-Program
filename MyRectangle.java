import java.awt.Color;
import java.awt.Graphics;

/**
 * Drawing with Polymorphism - MyRectangle Class
 * 
 * @author Richard Cai
 * @version  3.1 01/15/2016
 */
 
//


public class MyRectangle extends MyBoundedShape
{
    
    //No parameter constructor, calls super
    public MyRectangle(){
         super();
    }
    
    //Constructor with parameters including x1,y1,x2,y2 as coordinates, color, and fill value
    public MyRectangle( int x1, int y1, int x2, int y2, Color color,boolean fill ){
        super(x1,y1,x2,y2,color,fill);
    } 
    
    //Draws the actual rectangle, calls super.getFill() to retrieve fill value
    public void draw( Graphics g )
    {
        int[] coordinates = super.coordinates();
        //Determines if filled or not
        g.setColor( super.getColor() );
        if (super.getFill() == true){
          g.fillRect(coordinates[0], coordinates[1],coordinates[2], coordinates[3]);
        }
        else {
            g.drawRect(coordinates[0], coordinates[1],coordinates[2], coordinates[3]);
        }
        
    } // end method draw
    
} // end class MyLine

