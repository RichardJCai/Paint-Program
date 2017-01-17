import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Graphics; 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class DrawPanel extends JPanel
{
    //Dynamic datastructure
    
    ArrayList<MyShape> shapeObjects = new ArrayList<MyShape>();
    int currentShapeType;
    MyShape currentShapeObject;
    Color currentShapeColor;
    boolean currentShapeFilled;
    JLabel statusLabel;
    MyShape lastShape;
    
    int numShapes = 0;
    
    public DrawPanel(JLabel label)
    {
        
        currentShapeType = 0;
        statusLabel = label;
        currentShapeObject = new MyLine();
        currentShapeColor = Color.BLACK;
        currentShapeFilled = false;
        
        MouseClickHandler handler = new MouseClickHandler(); 
        addMouseListener( handler ); 
        addMouseMotionListener( handler );
        
    }
    
    
    //Mutator methods
    public void currentShapeType(int type){
        currentShapeType = type;
    }
    
    public void currentShapeColor(Color color){
        currentShapeColor = color;
    }
    
    public void currentShapeFilled(boolean filled){
        currentShapeFilled = filled;
    }
    
    //Clear the last shape, if there is one
    public void clearLastShape(){
        if (shapeObjects.size() != 0){
            lastShape = shapeObjects.remove(numShapes-1);
            numShapes -= 1;
        }
        
        repaint();
    }
    
    //Redraw the last cleared shape, if there is one
    public void redoLastShape(){
        if (lastShape != null){
            shapeObjects.add(lastShape);
            numShapes++;
            lastShape = null;   
        }
        
        repaint();

    }
    
    //Remove all shapes in the current drawing - not possible to redo
    public void clearDrawing(){
        shapeObjects.clear();
        numShapes = 0;
        repaint();
    }
        
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        
        if (shapeObjects.isEmpty() == false){
            
            for (int i = 0; i < shapeObjects.size();i++){
                shapeObjects.get(i).draw(g);
            }
        }
        
    }

    //Class MouseClickHandler handles mouse actions in DrawPanel - Extends MouseAdapter
    private class MouseClickHandler extends MouseAdapter 
    {
        //MouseListener event handlers
        //
        public void mousePressed(MouseEvent event)
        {
            int x1 = event.getX(); // get x position of mouse
            int y1 = event.getY(); // get y position of mouse
        
            if (currentShapeType == 0){
                currentShapeObject = new MyLine( x1, y1,y1,y1,currentShapeColor);
            }
            else if (currentShapeType == 1){
                currentShapeObject = new MyRectangle(x1,y1,x1,y1,currentShapeColor,currentShapeFilled );
            }
            else if (currentShapeType == 2){
                currentShapeObject = new MyOval(x1,y1,x1,y1,currentShapeColor,currentShapeFilled);
            }
            
            shapeObjects.add(numShapes,currentShapeObject);
            
        }
        
        //Finish drawing the current shape and adds it to the shapeObjects data structure.
        //Then sets currentShapeObject to null and calls repaint()
        public void mouseReleased(MouseEvent event)
        {
            
            currentShapeObject.setX2(event.getX());
            currentShapeObject.setY2(event.getY());
            
            shapeObjects.set(numShapes,currentShapeObject);
            numShapes++;
            
            currentShapeObject = null;
                   
            repaint();
            
        }
        
        //Updates the mouse coordinates when the user moves but does not drag the mouse
        public void mouseMoved(MouseEvent event)
        {
            int xPos = event.getX(); // get x position of mouse
            int yPos = event.getY(); // get y position of mouse
            
            statusLabel.setText("Mouse at " + xPos + "," + yPos);
        }
        
        
        //Sets the second point of the currentShapeObject to the current mouse position and calls method repaint()
        public void mouseDragged(MouseEvent event)
        {
            int xDrag = event.getX(); // get x position of mouse
            int yDrag = event.getY(); // get y position of mouse
            
            statusLabel.setText("Mouse dragged at " + xDrag + "," + yDrag);
            
            currentShapeObject.setX2(xDrag);
            currentShapeObject.setY2(yDrag); 
            
            repaint();
        }
       
     
        
    }
     
}