import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.CharArrayReader;
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
  private Shape rect;
  private Shape rect2;
  private Transformation move;
  private Transformation move2;
  private Transformation move3;
  private Transformation scale;
  private Transformation scale2;
  private Transformation scale3;
  private Transformation color;
  
  @Before
  public void setUp() throws Exception {
    ani = new AnimationImpl();
    oval = new Oval("oval", 34, 34, 4, 5, 122, 122, 122);
    rect = new Rectangle("rect", 12, 34, 8, 11, 1, 22, 89);
    rect2 = new Rectangle("rect 2", 45, 50.5f, 12, 12, 0, 125, 255);
    oval.setAppears(1);
    oval.setDisappears(15);
  
    rect.setAppears(1);
    rect.setDisappears(10);
  
    rect2.setAppears(7);
    rect2.setDisappears(15);
    
    //for oval
    move = new Move(45, 45, 3, 7);
    scale = new Scale(8, 5, 7, 15);
    
    //for rect
    move2 = new Move(45, 70, 2, 7);
    scale2 = new Scale(11, 11, 4, 7);
  
    //for rect2
    move3 = new Move(45, 70, 2, 7);
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
    assertEquals("OVAL", ani.getById("oval").getType());
    assertEquals(122, ani.getById("oval").getColor().getR());
  }
  
  @Test
  public void getByTime() {
  }
  
  @Test
  public void getTransformations() {
    ani.addTransformation("oval", move);
    ani.addTransformation("oval", scale);
    assertEquals(2, ani.getTransformations("oval").size());
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
    //Can't add null object
    try {
      ani.addShape(ovalNull, new ArrayList<>());
      fail("Exception should be thrown.");
    } catch (Exception ignored) {
    }
    
  }
  
  @Test
  public void removeShape() {
    ani.removeShape("rect2");
    assertEquals(2, ani.getShapes().size());
    assertFalse(ani.getShapes().contains(rect2));
  }
  
  @Test
  public void addTransformation() {
    //should not add if start time and end time are not within range
    Transformation bad = new Move(3, 4, 15, 19);
    try {
      ani.addTransformation("oval", bad);
      fail("Exception should be thrown.");
    } catch (Exception ignore) {
    }
  /*
    //should not add if transformation already in list TODO
    try {
      ani.addTransformation("oval", move);
      fail("Exception should be thrown.");
    } catch (Exception ignore) {
    }
    
   */
  
  
    try {
      ani.addTransformation("oval", move2);
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
  }
  
  @Test
  public void removeTransformation() {
  }

  @Test
  public void testToString() {
  }
}