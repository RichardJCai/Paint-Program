import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class DrawFrame extends JFrame
{
    
    private JPanel optionJPanel;
    
    private JButton undo;
    private JButton redo;
    private JButton clear;
    private JComboBox shapeOption;
    private JComboBox colorOption;
    private JCheckBox filled;
    
    
    private final String[] colors = { "Black", "Blue", "Cyan", "Dark Gray","Gray","Green","Light Gray","Magenta","Orange","Pink","Red","White","Yellow"};
    private final String[] shapes = { "Line", "Rectangle","Oval"};
    
    JLabel label = new JLabel("DrawPanel");
    DrawPanel panel = new DrawPanel(label);
    
    
 
    
    
    public DrawFrame()
    {
        super("SuperPaint");
        
        
       
        optionJPanel = new JPanel();
        optionJPanel.setLayout(new GridLayout (2,3));
        
        ItemHandler handler = new ItemHandler();
        
        undo = new JButton("Undo");
        
        
        redo = new JButton("Redo");
        clear = new JButton("Clear");
        
        shapeOption = new JComboBox(shapes);
        shapeOption.setSelectedIndex(0);
        shapeOption.addActionListener(handler);
        
        colorOption = new JComboBox(colors);
        colorOption.setSelectedIndex(0);
        colorOption.addActionListener(handler);
        
        filled = new JCheckBox("Filled");
        filled.addActionListener(handler);
        
       
        undo.addActionListener( handler );
        redo.addActionListener( handler );
        clear.addActionListener( handler );
        

        
        
        optionJPanel.add(undo);
        optionJPanel.add(redo);
        optionJPanel.add(clear);
        optionJPanel.add(shapeOption);
        optionJPanel.add(colorOption);
        optionJPanel.add(filled);
        
        add(optionJPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(label,BorderLayout.SOUTH);
        
    
    }
    
        
    
    private class ItemHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            
            //Check which shape option is selected, 0 = Line, 1 = Rect, 2 = Oval. Set shape using mutator method from DrawPanel
            if (shapeOption.getSelectedIndex() == 0){
                panel.currentShapeType(0);
                System.out.print("line");
            }
            else if (shapeOption.getSelectedIndex() == 1){
                panel.currentShapeType(1);
                System.out.print("rect");
            }
            else if (shapeOption.getSelectedIndex() == 2){
                panel.currentShapeType(2);
                System.out.print("oval");
            }
            
            
            //Check which Color option is selected
            if (colorOption.getSelectedIndex() == 0){
                panel.currentShapeColor(Color.BLACK);
            }
            else if (colorOption.getSelectedIndex() == 1){
                panel.currentShapeColor(Color.BLUE);
            }
            else if (colorOption.getSelectedIndex() == 2){
                panel.currentShapeColor(Color.CYAN);
            }
            else if (colorOption.getSelectedIndex() == 3){
                panel.currentShapeColor(Color.DARK_GRAY);
            }
            else if (colorOption.getSelectedIndex() == 4){
                panel.currentShapeColor(Color.GRAY);
            }
            else if (colorOption.getSelectedIndex() == 5){
                panel.currentShapeColor(Color.GREEN);
            }
            else if (colorOption.getSelectedIndex() == 6){
                panel.currentShapeColor(Color.LIGHT_GRAY);
            }
            else if (colorOption.getSelectedIndex() == 7){
                panel.currentShapeColor(Color.MAGENTA);
            }
            else if (colorOption.getSelectedIndex() == 8){
                panel.currentShapeColor(Color.ORANGE);
            }
            else if (colorOption.getSelectedIndex() == 9){
                panel.currentShapeColor(Color.PINK);
            }
            else if (colorOption.getSelectedIndex() == 10){
                panel.currentShapeColor(Color.RED);
            }
            else if (colorOption.getSelectedIndex() == 11){
                panel.currentShapeColor(Color.WHITE);
            }
            else if (colorOption.getSelectedIndex() == 12){
                panel.currentShapeColor(Color.YELLOW);
            }
            
            //Check whether the shape is filled or not
            if (filled.isSelected()){
                panel.currentShapeFilled(filled.isSelected());
            }
            else{
                panel.currentShapeFilled(filled.isSelected());
            }
                            
            
            
            //If a button is pressed, call the corresponding method from DrawPanel.
            if (event.getActionCommand() == "Undo"){
                panel.clearLastShape();
            }
            else if(event.getActionCommand() == "Redo"){
                panel.redoLastShape();
            }
            else if(event.getActionCommand() == "Clear"){
                panel.clearDrawing();
            }
        }
        
    }
}

    
    
    
    
    
    
    
