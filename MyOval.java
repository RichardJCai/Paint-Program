import java.awt.Color;
import java.awt.Graphics;

/**
 * Drawing with Polymorphism - MyOval Class
 * 
 * @author Richard Cai
 * @version  3.1 01/15/2016
 */
 
//


public class MyOval extends MyBoundedShape
{    
    //No parameter constructor, calls super
    public MyOval(){
        super();
    }
    
    //Constructor with parameters including x1,y1,x2,y2 as coordinates, color, and fill value
    public MyOval( int x1, int y1, int x2, int y2, Color color, boolean fill){
        super(x1,y1,x2,y2,color,fill);
    } 
   
    
    //Draws the actual oval, calls super.getFill() to retrieve fill value
    public void draw( Graphics g )
    {
        //Determines if the shape is filled
        g.setColor( super.getColor() );
        if (super.getFill() == true){
          g.fillOval( super.getX1(), super.getY1(), super.getX2() - super.getX1(), super.getY2() - super.getY1());
        }
        else {
            g.drawOval( super.getX1(), super.getY1(), super.getX2()- super.getX1(), super.getY2()- super.getY1());
        }
    } // end method draw
}
