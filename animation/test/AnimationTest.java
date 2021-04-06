import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import animation.Animation;
import animation.AnimationImpl;
import animation.ChangeColor;
import animation.Color;
import animation.Move;
import animation.Oval;
import animation.Rectangle;
import animation.Scale;
import animation.Shape;
import animation.Transformation;

import static org.junit.Assert.*;

public class AnimationTest {
  private Animation ani;
  private Shape ovalNull;
  private Shape oval;
  private Shape rect2;
  private Transformation move;
  private Transformation move2;
  private Transformation scale;
  private Transformation scale2;
  private Transformation scale3;
  private Transformation color;
  
  @Before
  public void setUp() throws Exception {
    ani = new AnimationImpl();
    oval = new Oval("oval", 34, 34, 4, 5, 122, 122, 122);
    Shape rect = new Rectangle("rect", 12, 34, 8, 11, 1, 22, 89);
    rect2 = new Rectangle("rect 2", 45, 50.5f,
            12, 12, 0, 125, 255);
    oval.setAppears(1);
    oval.setDisappears(15);
  
    rect.setAppears(1);
    rect.setDisappears(10);
  
    rect2.setAppears(7);
    rect2.setDisappears(15);
    
    //for oval
    move = new Move("move", 45, 45, 3, 7);
    scale = new Scale("scale", 8, 5, 7, 15);
    
    //for rect
    move2 = new Move("move2", 45, 70, 2, 7);
    scale2 = new Scale("scale2",11, 11, 4, 7);
  
    //for rect2
    Transformation move3 = new Move("move3", 45, 70, 2, 7);
    scale3 = new Scale("scale3",24, 24, 8, 14);
    
    color = new ChangeColor("color", new Color(1, 12, 122), 7, 10);
    
    try {
      ani.addShape(oval, new ArrayList<>());
    } catch (Exception e) {
      fail("No exception should be thrown.");
    }
  
    try {
      ani.addShape(rect, new ArrayList<>());
    } catch (Exception e) {
      fail("No exception should be thrown.");
    }
  
    try {
      ani.addShape(rect2, new ArrayList<>());
    } catch (Exception e) {
      fail("No exception should be thrown.");
    }
  }
  
  @Test
  public void getSize() {
    Animation ani2 = new AnimationImpl();

    assertEquals(0, ani2.getSize());
    assertEquals(3, ani.getSize());
  }
  
  @Test
  public void getSizeTransformations() {
    assertEquals(0, ani.getSizeTransformations("oval"));
    ani.addTransformation("oval", move);
    ani.addTransformation("oval", scale);
    assertEquals(2, ani.getSizeTransformations("oval"));
  }
  
  @Test
  public void getById() {
    //Get oval
    assertEquals("OVAL", ani.getById("oval").getType());
    assertEquals(122, ani.getById("oval").getColor().getR());

    //Get rectangle
    assertEquals("RECTANGLE", ani.getById("rect").getType());
    assertEquals(1, ani.getById("rect").getAppears());


    //Empty string id
    try {
      ani.getTransformations("");
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //Null id
    try {
      ani.getTransformations(null);
      fail("Exception should be thrown");
    } catch (Exception ignored){
    }

    //Get from empty hashmap
    try {
      Animation ani2 = new AnimationImpl();
      ani2.getById("rect");
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //Id not found
    try {
      ani.getById("rect 4");
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }
  
  @Test
  public void getTransformations() {
    //Empty string id
    try {
      ani.getTransformations("");
      fail("Exception should be thrown");
    } catch (Exception ignored){
    }

    //Null id
    try {
      ani.getTransformations(null);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //Id not found
    try {
      ani.getTransformations("rect 4");
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //With valid transformations
    ani.addTransformation("oval", move);
    ani.addTransformation("oval", scale);
    assertEquals(2, ani.getTransformations("oval").size());
    assertEquals("Moves",
            ani.getTransformations("oval").get(0).getTransformationType());
    assertEquals("Scales",
            ani.getTransformations("oval").get(1).getTransformationType());
  }
  
  @Test
  public void getShapes() {
   assertEquals(3, ani.getShapes().size());
   assertEquals("RECTANGLE", ani.getShapes().get(1).getType());
  }
  
  @Test
  public void addShape() {
    Animation ani2 = new AnimationImpl();

    //Add rectangle
    Shape rect4 = new Rectangle("rect4", 3, 3,
            5, 10, 255, 0, 255);
    ani2.addShape(rect4, new ArrayList<>());

    //add oval
    Shape oval4 = new Oval("oval4", 5, 5, 2, 4, 0, 0, 0);
    ani2.addShape(oval4, new ArrayList<>());

    //Check that shapes were correctly added
    assertEquals(2, ani2.getSize());
    assertEquals("[Name: rect4\n" +
            "Type: RECTANGLE\n" +
            "Corner: (3.0,3.0)\n" +
            "Width: 5\n" +
            "Length: 10\n" +
            "Color: (255, 0, 255)\n" +
            "Appears: 0\n" +
            "Disappears: 0\n" +
            ", Name: oval4\n" +
            "Type: OVAL\n" +
            "Center: (5.0,5.0)\n" +
            "X-Radius: 2\n" +
            "Y-Radius: 4\n" +
            "Color: (0, 0, 0)\n" +
            "Appears: 0\n" +
            "Disappears: 0\n]", ani2.getShapes().toString());

    //add null object
    try {
      ani.addShape(ovalNull, new ArrayList<>());
      fail("Exception should be thrown.");
    } catch (Exception ignored) {
    }

    //add to a null hashmap
    try {
      Animation ani3 = null;
      ani3.addShape(oval, new ArrayList<>());
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //add identical shape
    try {
      Shape rect5 = new Rectangle("rect4", 3, 3,
              5, 10, 255, 0, 255);
      ani2.addShape(rect5, new ArrayList<>());
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
  }
  
  @Test
  public void removeShape() {
    try {
      assertEquals(3, ani.getShapes().size());
      ani.removeShape("rect 2");
      assertEquals(2, ani.getShapes().size());
      assertFalse(ani.getShapes().contains(rect2));
    } catch (Exception e) {
      fail("Exception shouldn't be thrown");
    }

    //trying to remove null
    try {
      assertEquals(2, ani.getShapes().size());
      ani.removeShape(null);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //trying to remove from empty hashmap
    try {
      Animation ani2 = new AnimationImpl();
      assertEquals(0, ani2.getShapes().size());
      ani2.removeShape("rect");
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //shape not found
    try {
      assertEquals(2, ani.getShapes().size());
      ani.removeShape("rect4");
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }
  
  @Test
  public void addTransformation() {
    //valid add transformation: move, scale, changeColor
    try {
      ani.addTransformation("oval", move2);
      assertEquals(1, ani.getTransformations("oval").size());
      assertEquals("Moves",
              ani.getTransformations("oval").get(0).getTransformationType());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }

    try {
      ani.addTransformation("rect", color);
      assertEquals("Color",
              ani.getTransformations("rect").get(0).getTransformationType());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }

    try {
      Shape oval2 = new Oval("oval 2", 3, 3, 6, 10, 0, 255, 0);
      oval2.setAppears(1);
      oval2.setDisappears(15);
      ani.addShape(oval2, new ArrayList<>());
      ani.addTransformation("oval 2", scale);
      assertEquals("Scales",
              ani.getTransformations("oval 2").get(0).getTransformationType());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }

    //should not add if start time and end time are not within range
    Transformation bad = new Move("bad", 3, 4, 15, 19);
    try {
      ani.addTransformation("oval", bad);
      fail("Exception should be thrown.");
    } catch (Exception ignored) {
    }

  
    try {
      ani.addTransformation("oval", move);
      fail("Exception should be thrown.");
    } catch (Exception ignored) {
    }
    

    //adding to null hashmap
    try {
      ani.addTransformation("oval", null);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //add empty string + transformation
    try {
      ani.addTransformation("", move);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //add null + transformation
    try {
      ani.addTransformation(null, color);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }


  }
  
  @Test
  public void removeTransformation() {
    //add transformations to animation
    ani.addTransformation("oval", move);
    ani.addTransformation("oval", scale);
    ani.addTransformation("rect", move2);
    ani.addTransformation("rect", scale2);
    ani.addTransformation("rect 2", scale3);
    ani.addTransformation("rect 2", color);

    //valid remove cases: scale, move, changeColor
    try {
      assertEquals(2, ani.getTransformations("oval").size());
      ani.removeTransformation("oval", move);
      assertEquals(1, ani.getTransformations("oval").size());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }

    try {
      assertEquals(2, ani.getTransformations("rect").size());
      ani.removeTransformation("rect", scale2);
      assertEquals(1, ani.getTransformations("rect").size());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }

    try {
      assertEquals(2, ani.getTransformations("rect 2").size());
      ani.removeTransformation("rect 2", color);
      assertEquals(1, ani.getTransformations("rect 2").size());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }

    //remove id not found
    try {
      ani.removeTransformation("oval 3", move);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //empty string id
    try {
      ani.removeTransformation("", scale);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //null id
    try {
      ani.removeTransformation(null, color);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //remove transformation not found
    try {
      Transformation color2 = new ChangeColor("color2", new Color(255, 255, 255),
              2, 6);
      ani.removeTransformation("rect", color2);
      fail("Exception should be thrown");
    } catch (Exception ignored){
    }

    //try to remove null transformation
    try {
      ani.removeTransformation("rect", null);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //remove from empty transformation list
    try {
      Animation ani2 = new AnimationImpl();
      Shape rect3 = new Rectangle("rect3", 3, 3, 4, 5,
              0, 255, 0);
      rect3.setAppears(1);
      rect3.setDisappears(15);

      ani2.addShape(rect3, new ArrayList<>());
      ani2.removeTransformation("rect3", move);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }

  @Test
  public void testToString() {
    //empty hashmap
    try {
      Animation ani2 = new AnimationImpl();
      assertEquals("", ani2.toString());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }

    //No transformations
    try {
      AnimationImpl ani2 = new AnimationImpl();
      Shape rect3 = new Rectangle("rect3", 3, 3, 50,
              25, 255, 255, 255);
      ani2.addShape(rect3, new ArrayList<>());
      assertEquals("Shapes: \n"
              + "\n"
              + "Name: rect3\n"
              + "Type: RECTANGLE\n"
              + "Corner: (3.0,3.0)\n"
              + "Width: 50\n"
              + "Length: 25\n"
              + "Color: (255, 255, 255)\n"
              + "Appears: 0\n"
              + "Disappears: 0", ani2.toString());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }

    //With transformations
    try {
      AnimationImpl ani2 = new AnimationImpl();
      Shape rect3 = new Rectangle("rect3", 3, 3, 50,
              25, 255, 255, 255);
      rect3.setAppears(1);
      rect3.setDisappears(200);
      ani2.addShape(rect3, new ArrayList<>());

      Transformation move4 = new Move("move4", 9, 9, 10, 100);
      ani2.addTransformation("rect3", move4);

      assertEquals("Shapes: \n"
              + "\n"
              + "Name: rect3\n"
              + "Type: RECTANGLE\n"
              + "Corner: (3.0,3.0)\n"
              + "Width: 50\n"
              + "Length: 25\n"
              + "Color: (255, 255, 255)\n"
              + "Appears: 1\n"
              + "Disappears: 200\n"
              + "\n"
              + "Shape rect3 moves from (3.0,3.0) to (9.0,9.0) from 10 to 100.", ani2.toString());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }
  }
}