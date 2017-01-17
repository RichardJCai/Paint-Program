import java.awt.Color;
import java.awt.Graphics;
 
/**
 * Drawing with Polymorphism - MyLine Class
 * 
 * @author Richard Cai
 * @version  3.1 01/15/2016
 */
 
//

public class MyLine extends MyShape
{
  
    // no value constructor, sets all values to default (null or 0)
    public MyLine()
    {
        super();
    } // end MyLine constructor
      
      // constructor with input values, sets coordinates and color to parameters
    public MyLine( int x1, int y1, int x2, int y2, Color color )
    {
        super(x1,y1,x2,y2,color);
    } // end MyLine constructor
    
     
    // Actually draws the line
    public void draw( Graphics g )
    {
        g.setColor( super.getColor() );
        g.drawLine( super.getX1(), super.getY1(), super.getX2(), super.getY2() );
    } // end method draw
     
} // end class MyLine