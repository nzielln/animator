package animation;

import java.util.ArrayList;

/**
 * To test out  our model.
 */
public class Main {
  
  public static void main(String[] args) {
    //Create a new oval and rectangle shape
  
    Shape ov = new Oval("oval",5, 23, 4, 4, 24, 45, 57);
    Shape ova = new Oval("oval",5, 23, 4, 4, 24, 45, 57);
    Shape rect = new Rectangle("rectangle",5, 23, 4, 7, 244, 145, 7);
    
    ov.setAppears(0);
    ov.setDisappears(10);
  
    rect.setAppears(2);
    rect.setDisappears(10);
    
    //System.out.println("Shapes to string:");
    //System.out.println(ov.toString());
    //System.out.println(rect.toString());
    
    //Create a new animation
    Animation ani = new AnimationImpl();
    //add shapes
    ani.addShape(ov, new ArrayList<Transformation>());
    ani.addShape(rect, new ArrayList<Transformation>());
    //System.out.println(ani.toString());
  
    //create new move transformation
    Transformation color = new ChangeColor(new Color(35, 45, 56), 3, 7);
    Transformation scale = new Scale(12, 7, 2, 7);
  
    ani.addTransformation("oval", color);
    ani.addTransformation("rectangle", scale);
  
    System.out.println("Animation to string:");
    System.out.println(ani.toString());
    
    Color n = new Color(122, 122, 122);
    Color m = new Color(122, 122, 122);
    
    System.out.println(n.equals(m));
   
  
  
  }
}
