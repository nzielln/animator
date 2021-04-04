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
  
    ova.setAppears(0);
    ova.setDisappears(10);
    System.out.println(ov.toString());
    System.out.println(ova.toString());
    System.out.println("Are these equal: \n" + ov.equals(ova) + "\n");
    /*
    rect.setAppears(2);
    rect.setDisappears(10);
    
    System.out.println("Shapes to string:");
    System.out.println(ov.toString());
    System.out.println(rect.toString());
    
    //Create a new animation
    Animation ani = new AnimationImpl();
    //add shapes
    ani.addShape(ov);
    ani.addShape(rect);
    
    //create new move transformation
    Transformation color = new ChangeColor(ov, new Color(35, 45, 56), 3, 7);
    Transformation scale = new Scale(rect, 12, 7, 3, 7);
    System.out.println("Transformations to string:");
    System.out.println(color.toString());
    System.out.println(scale.toString());
    
    ani.addTransformation(color);
    ani.addTransformation(scale);
  
    System.out.println("Animation to string:");
    System.out.println(ani.toString());
    
    
    
     */
  }
}
