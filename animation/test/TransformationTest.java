import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.Color;
import cs5004.animator.model.Move;
import cs5004.animator.model.Scale;
import cs5004.animator.model.Transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Test class for the Transformation Interface and its subtypes.
 */
public class TransformationTest {
  private Transformation move;
  private Transformation scale;
  private Transformation color;
  
  @Before
  public void setUp() throws Exception {
    try {
      move = new Move("move", 0, 0, 3, 11);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    try {
      move = new Move("move", 23, 34, 0, 0);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    //**
    try {
      move = new Move("move", 23, 34, 3, 11);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    try {
      scale = new Scale("scale", 1, 1, 2, 7);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    try {
      scale = new Scale("scale",1, 1, 0, 0);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    //**
    try {
      scale = new Scale("scale",8, 12, 2, 7);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    try {
      color = new ChangeColor("color", new Color(122, 122, 122), 2, 7);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    try {
      color = new ChangeColor("color", new Color(122, 122, 122), 0, 7);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    //Invalid inputs
    Transformation bad;
    try {
      bad = new Move("move",-23, 33, 2, 7); //negative position
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Move("move",23, 33, -2, 7); //negative time
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Move("move",-2, -4, 2, 7); //both positions negative
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    try {
      scale = new Scale("scale",-4, 1, 2, 7); //negative length/width
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    try {
      scale = new Scale("scale",0, 1, 2, 7); //length of 0
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    try {
      move = new Move("", 0, 1, 5, 10);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    try {
      scale = new Scale(null, 10, 20, 1, 5);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
  }
  
  @Test
  public void getTransformation() {
    assertEquals("Moves", move.getTransformation().getTransformationType());
    assertEquals(11, move.getTransformation().getTimeEnd());
    
    assertEquals("Color", color.getTransformation().getTransformationType());
    assertEquals(122, color.getTransformation().getToColor().getB(), 0.001);
  }
  
  @Test
  public void testGetTID() {
    assertEquals("move", move.getID());
    assertEquals("scale", scale.getID());
    assertEquals("color", color.getID());
  }
  
  @Test
  public void getTransformationType() {
    assertEquals("Moves", move.getTransformationType());
    assertEquals("Color", color.getTransformationType());
    assertEquals("Scales", scale.getTransformationType());
  }
  
  @Test
  public void getTime() {
    assertEquals(3, move.getTimeStart());
    assertEquals(0, color.getTimeStart());
    assertEquals(2, scale.getTimeStart());
    
    assertEquals(11, move.getTimeEnd());
    assertEquals(7, color.getTimeEnd());
    assertEquals(7, scale.getTimeEnd());
  }
  
  @Test
  public void getXY() {
    assertEquals(23, move.getToX(), 0.001);
    assertEquals(34, move.getToY(), 0.001);
    
    assertEquals(8, scale.getToWidth(), 0.001);
    assertEquals(12, scale.getToHeight(), 0.001);
  }
  
  @Test
  public void getToColor() {
    assertEquals(122, color.getToColor().getR(), 0.001);
    assertEquals(122, color.getToColor().getG(), 0.001);
    assertEquals(122, color.getToColor().getB(), 0.001);
  }
  
  @Test
  public void testSame() {
    Transformation n = new Move("move", 23, 34, 3, 11);
    assertTrue(move.sameObject(n));
  
    Transformation sa = new Scale("scale",8, 12, 2, 7);
    assertTrue(scale.sameObject(sa));
  
    Transformation nn = new Move("moves", 23, 34, 3, 11);
    assertFalse(move.sameObject(nn));
  
    Transformation diffp = new Move("move", 22, 34, 3, 11);
    assertFalse(move.sameObject(diffp));
  
    Transformation s = new Scale("scale", 23, 34, 3, 11);
    assertFalse(move.sameObject(s));
  }
  
}