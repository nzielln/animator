import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransformationTest {
  private Transformation move;
  private Transformation scale;
  private Transformation color;
  private Transformation bad;
  @Before
  public void setUp() throws Exception {
    try {
      move = new Move(0, 0, 3, 11);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
  
    try {
      move = new Move(23.4f, 34, 0, 0);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    //**
    try {
    move = new Move(23.4f, 34, 3, 11);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
  
    try {
      scale = new Scale(1, 1, 2, 7);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
  
    try {
      scale = new Scale(1, 1, 0, 0);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    //**
    try {
      scale = new Scale(8, 12, 2, 7);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
  
    try {
      color = new ChangeColor(new Color(122, 122, 122), 2, 7);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
  
    try {
      color = new ChangeColor(new Color(122, 122, 122), 0, 7);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    //Invalid inputs
    try {
      bad = new Move(-23, 33, 2, 7); //negative position
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
    try {
      bad = new Move(23, 33, -2, 7); //negative time
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
    try {
      bad = new Move(-2, -4, 2, 7); //both positions negative
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
    try {
      scale = new Scale(-4, 1, 2, 7); //negative length/width
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
    try {
      scale = new Scale(0, 1, 2, 7); //length of 0
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
  }
  
  @Test
  public void getTransformation() {
    assertEquals("Moves", move.getTransformation().getTransformationType());
    assertEquals(11, move.getTransformation().getTimeEnd());
  
    assertEquals("Color", color.getTransformation().getTransformationType());
    assertEquals(122, color.getTransformation().getToColor().getB());
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
    assertEquals(23.4, move.getToX(), 0.001);
    assertEquals(34, move.getToY(), 0.001);
  
    assertEquals(8, scale.getToX(), 0.001);
    assertEquals(12, scale.getToY(), 0.001);
  }
  
  @Test
  public void getToColor() {
    assertEquals(122, color.getToColor().getB());
  }
  
  @Test
  public void copy() {
    Transformation copy = color.copy();
    assertEquals(copy.getTransformationType(), color.getTransformationType());
  }
  
  @Test
  public void moveShape() {
  }
  
  @Test
  public void changeColor() {
  }
  
  @Test
  public void scaleShape() {
  }
  
}