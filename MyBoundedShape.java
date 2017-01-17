import java.awt.Color;
import java.awt.Graphics;

/**
 * Drawing with Polymorphism - MyBoundedShape (Abstract Class)
 * 
 * @author Richard Cai
 * @version  3.1 01/15/2016
 */
 
//

abstract class MyBoundedShape extends MyShape{
    
    private boolean fill;
    
    //No parameter constructor, sets all values to default (null or 0)
    public MyBoundedShape(){
        super(); //Calls super, constructor from MyShape
    }
    
    //Parameter constructor, sets all values to parameters (Sets coordinates, color, and fill value)
    public MyBoundedShape( int x1, int y1, int x2, int y2, Color color,boolean fill){
        super(x1,y1,x2,y2,color);
        this.fill = fill; 
    } 

    //Calculates which x value is greater and returns the value
    public int getUpperLeftX(){
        if (super.getX1() > super.getX2()){
            return super.getX2();
        }
        else {
            return super.getX1();
        }
    }
     
    //Calculates which y value is greater and returns the value
    public int getUpperLeftY(){
        if (super.getY1() > super.getY2()){
            return super.getY2();
        }
        else {
            return super.getY1();
        }
    }
    
    //Returns the width (absolute x1-x2)
     public int getWidth(){
        return Math.abs(super.getX1()-super.getX2());
    }
        
     //Returns the height (absolute y1-y2)
    public int getHeight(){
        return Math.abs(super.getY1()-super.getY2());
    }   
    
    //Returns if the shape is filled
    public boolean getFill(){
        return fill;
    }
    
}
