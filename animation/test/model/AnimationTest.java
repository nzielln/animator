package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.Color;
import cs5004.animator.model.Ellipse;
import cs5004.animator.model.Move;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Scale;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Test class for the Animation Interface and its subtypes.
 */
public class AnimationTest {
  private Animation ani;
  private Shape ovalNull;
  private Shape oval;
  private Shape rect2;
  private Shape rect;
  private Transformation move;
  private Transformation move2;
  private Transformation scale;
  private Transformation scale2;
  private Transformation scale3;
  private Transformation color;
  
  @Before
  public void setUp() throws Exception {
    ani = new AnimationImpl();
    
    oval = new Ellipse("oval", "Ellipse");
    oval.setProperties(34, 34, 4, 5, 122, 122, 122);
    
    rect = new Rectangle("rect", "RECTANGLE");
    rect.setProperties(12, 34, 8, 11, 1, 22, 89);
    
    rect2 = new Rectangle("rect 2", "RECTANGLE");
    rect2.setProperties(45, 50, 12, 12, 0, 125, 255);
    
    oval.setAppearsDisappears(1, 15);
    
    rect.setAppearsDisappears(1, 10);
    
    rect2.setAppearsDisappears(7, 15);
    
    //for oval
    move = new Move(45, 45, 3, 7);
    scale = new Scale(8, 5, 7, 15);
    
    //for rect
    move2 = new Move(45, 70, 2, 7);
    scale2 = new Scale(11, 11, 4, 7);
    
    //for rect2
    Transformation move3 = new Move( 45, 70, 2, 7);
    scale3 = new Scale(24, 24, 8, 14);
    
    color = new ChangeColor(new Color(1, 12, 122), 7, 10);
    
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
  public void testGetCanvasWidth() {
    Animation ani2 = new AnimationImpl();

    assertEquals(0, ani2.getCanvasWidth());
    assertEquals(0, ani.getCanvasWidth());
  }

  @Test
  public void testGetCanvasHeight() {
    Animation ani2 = new AnimationImpl();

    assertEquals(0, ani2.getCanvasHeight());
    assertEquals(0, ani.getCanvasHeight());
  }

  @Test
  public void testGetCanvasX() {
    Animation ani2 = new AnimationImpl();

    assertEquals(0, ani2.getCanvasX());
    assertEquals(0, ani.getCanvasX());
  }

  @Test
  public void testGetCanvasY() {
    Animation ani2 = new AnimationImpl();

    assertEquals(0, ani2.getCanvasY());
    assertEquals(0, ani.getCanvasY());
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
    assertEquals("ELLIPSE", ani.getById("oval").getType());
    assertEquals(122, ani.getById("oval").getColor().getR(), 0.001);
    
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
    } catch (Exception ignored) {
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
  public void testGetByTime() {
    // empty animation
    try {
      Animation ani2 = new AnimationImpl();
      List<Shape> result = ani2.getByTime(1);
      assertEquals("[]", result.toString());
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    //no transformations
    try {
      Animation ani2 = new AnimationImpl();

      Rectangle rect4 = new Rectangle("rect4", "RECTANGLE");
      rect4.setProperties(10, 10, 12, 12, 0, 0 ,0);
      rect4.setAppearsDisappears(1, 10);

      Ellipse o = new Ellipse("O", "Ellipse");
      o.setProperties(5, 5, 15, 15, 255, 255, 255);
      o.setAppearsDisappears(3,10);

      ani2.addShape(rect4, new ArrayList<>());
      ani2.addShape(o, new ArrayList<>());

      List<Shape> result = ani2.getByTime(4);
      assertEquals("[Name: rect4\n"
              + "Type: RECTANGLE\n"
              + "Min corner: (10.0,10.0), Width: 12.0, Length: 12.0, Color: (0.0, 0.0, 0.0)\n"
              + "Appears at t=1\n"
              + "Disappears at t=10\n"
              + ", Name: O\n"
              + "Type: ELLIPSE\n"
              + "Center: (5.0,5.0), X radius: 15.0, Y radius: 15.0, Color: (255.0, 255.0, 255.0)\n"
              + "Appears at t=3\n"
              + "Disappears at t=10\n"
              + "]", result.toString());
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    //with transformations
    
      Transformation move4 = new Move(12, 12, 7, 10);
      move4.setInitial("rect", rect.getType(), 12, 34, 8, 11, 1, 22, 89);
      Transformation scale4 = new Scale(25, 25, 7, 10);
      scale4.setInitial("oval", oval.getType(), 34, 34, 4, 5, 122, 122, 122);
      Transformation color2 = new ChangeColor(new Color(255, 255, 255), 8, 10);
      color2.setInitial("rect 2", rect2.getType(), 45, 50, 12, 12, 0, 125, 255);
      
      ani.addTransformation("oval", scale4);
      ani.addTransformation("rect", move4);
      ani.addTransformation("rect 2", color2);

      List<Shape> result = ani.getByTime(8);
      assertEquals("[Name: oval\n"
              + "Type: ELLIPSE\n"
              + "Center: (34.0,34.0), X radius: 10.0, Y radius: 11.0, Color: (122.0, 122.0, 122.0)\n"
              + "Appears at t=8\n"
              + "Disappears at t=9\n"
              + ", Name: rect\n"
              + "Type: RECTANGLE\n"
              + "Min corner: (12.0,26.0), Width: 8.0, Length: 11.0, Color: (1.0, 22.0, 89.0)\n"
              + "Appears at t=8\n"
              + "Disappears at t=9\n"
              + ", Name: rect 2\n"
              + "Type: RECTANGLE\n"
              + "Min corner: (45.0,50.0), Width: 12.0, Length: 12.0, Color: (0.0, 125.0, 255.0)\n"
              + "Appears at t=8\n"
              + "Disappears at t=9\n"
              + "]", result.toString());
    

    // negative time
    try {
      List<Shape> res = ani.getByTime(-3);
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
    } catch (Exception ignored) {
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
    Shape rect4 = new Rectangle("rect4", "RECTANGLE");
    rect4.setProperties(3, 3,
            5, 10, 255, 0, 255);
    ani2.addShape(rect4, new ArrayList<>());
    
    //add oval
    Shape oval4 = new Ellipse("oval4", "Ellipse");
    oval4.setProperties(5, 5, 2, 4, 0, 0, 0);
    
    ani2.addShape(oval4, new ArrayList<>());
    
    //Check that shapes were correctly added
    assertEquals(2, ani2.getSize());
    assertEquals("[Name: rect4\n"
            + "Type: RECTANGLE\n"
            + "Min corner: (3.0,3.0), Width: 5.0, Length: 10.0, Color: (255.0, 0.0, 255.0)\n"
            + "Appears at t=0\n"
            + "Disappears at t=0\n"
            + ", Name: oval4\n"
            + "Type: ELLIPSE\n"
            + "Center: (5.0,5.0), X radius: 2.0, Y radius: 4.0, Color: (0.0, 0.0, 0.0)\n"
            + "Appears at t=0\n"
            + "Disappears at t=0\n]", ani2.getShapes().toString());
    
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
      Shape rect5 = new Rectangle("rect4", "RECTANGLE");
      rect5.setProperties(3, 3, 5, 10, 255, 0, 255);
      
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
      Shape oval2 = new Ellipse("oval 2", "Ellipse");
      oval2.setProperties(3, 3, 6, 10, 0, 255, 0);
      oval2.setAppearsDisappears(1, 15);
      
      ani.addShape(oval2, new ArrayList<>());
      ani.addTransformation("oval 2", scale);
      assertEquals("Scales",
              ani.getTransformations("oval 2").get(0).getTransformationType());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }
    
    //should not add if start time and end time are not within range
    Transformation bad = new Move(3, 4, 15, 19);
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
      Transformation color2 = new ChangeColor(new Color(255, 255, 255),
              2, 6);
      ani.removeTransformation("rect", color2);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
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
      
      Shape rect3 = new Rectangle("rect3", "RECTANGLE");
      rect3.setProperties(3, 3, 4, 5,0, 255, 0);
      rect3.setAppearsDisappears(1, 15);
      
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
      
      Shape rect3 = new Rectangle("rect3", "RECTANGLE");
      rect3.setProperties(3, 3, 50, 25, 255, 255, 255);
      ani2.addShape(rect3, new ArrayList<>());
      
      assertEquals("Shapes: \n"
              + "Name: rect3\n"
              + "Type: RECTANGLE\n"
              + "Min corner: (3.0,3.0), Width: 50.0, Length: 25.0, Color: (255.0, 255.0, 255.0)\n"
              + "Appears at t=0\n"
              + "Disappears at t=0", ani2.toString());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }
    
    //With transformations
    try {
      AnimationImpl ani2 = new AnimationImpl();
      
      Shape rect3 = new Rectangle("rect3", "RECTANGLE");
      rect3.setProperties(3, 3, 50,   25, 255, 255, 255);
      rect3.setAppearsDisappears(1,200);
      ani2.addShape(rect3, new ArrayList<>());
      
      Transformation move4 = new Move(9, 9, 10, 100);
      move4.setInitial("rect3",  rect3.getType(),3, 3, 50, 25, 255, 255, 255);
      ani2.addTransformation("rect3", move4);
      
      assertEquals("Shapes: \n"
              + "Name: rect3\n"
              + "Type: RECTANGLE\n"
              + "Min corner: (3.0,3.0), Width: 50.0, Length: 25.0, Color: (255.0, 255.0, 255.0)\n"
              + "Appears at t=1\n"
              + "Disappears at t=200\n"
              + "\n"
              + "Shape rect3 moves from (3.0,3.0) to (9.0,9.0) from t=10 to t=100.",
              ani2.toString());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }
  }

  @Test
  public void testTransformationString() {

    //no transformations
    try {
      assertEquals("", ani.tranformationString(oval));
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    //added transformation: move
    try {
      move.setInitial("oval", oval.getType(), 34, 34, 4, 5, 122, 122, 122);
      ani.addTransformation("oval", move);
      
      assertEquals("Shape oval moves from (34.0,34.0) to (45.0,45.0) from t=3 to t=7.\n", ani.tranformationString(oval));
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    //added transformation: scale
    try {
      ani.addTransformation("rect 2", scale3);
      scale3.setInitial("rect 2", rect2.getType(),45, 50, 12, 12, 0, 125, 255 );
      assertEquals("Shape rect 2 scales from Width: 12.0, Height: 12.0 to Width: 24.0, Height: 24.0 from t=8 to t=14.\n", ani.tranformationString(rect2));
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    //added transformation: change color
    try {
      ani.addTransformation("rect 2", color);
      color.setInitial("rect 2", rect2.getType(),45, 50, 12, 12, 0, 125, 255);
      assertEquals("Shape rect 2 scales from Width: 12.0, Height: 12.0 to Width: 24.0, Height: 24.0 from t=8 to t=14.\n"
              + "Shape rect 2 changes color from (0.0, 125.0, 255.0) to (1.0, 12.0, 122.0) from t=7 to t=10.\n", ani.tranformationString(rect2));
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    //empty animation
    try {
      Animation ani2 = new AnimationImpl();
      assertEquals("", ani2.tranformationString(oval));
      fail("Exception should have been thrown");
    } catch (Exception ignored) {
    }

    // null shape
    try {
      ani.tranformationString(null);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }
}