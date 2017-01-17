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
        //Determines if filled or not
        g.setColor( super.getColor() );
        if (super.getFill() == true){
          g.fillRect( super.getX1(), super.getY1(), super.getX2()- super.getX1(), super.getY2()-super.getY1() );
        }
        else {
            g.drawRect( super.getX1(), super.getY1(), super.getX2()-super.getX1(), super.getY2()-super.getY1() );
        }
        
    } // end method draw
    
} // end class MyLine

