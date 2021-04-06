import org.junit.Before;
import org.junit.Test;

import animation.Oval;
import animation.Rectangle;
import animation.Shape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Test class for the Shape Interface and its subtypes.
 */
public class ShapeTest {
  private Shape oval;
  private Shape rect;
  
  @Before
  public void setUp() throws Exception {
    //Valid shape inputs
    try {
      oval = new Oval("oval", 23, 45, 4, 5, 24, 35, 123);
    } catch (Exception e) {
      fail("Exception should not have been thrown.");
    }
    
    try {
      rect = new Rectangle("rect", 17.5f, 9.12f, 8, 8, 122, 122, 122);
    } catch (Exception e) {
      fail("Exception should not have been thrown.");
    }
    
    try {
      rect = new Rectangle("rect", 67, 89, 8, 8, 122, 122, 122);
    } catch (Exception e) {
      fail("Exception should not have been thrown.");
    }
    
    
    //Invalid Points
    Shape bad;
    try {
      bad = new Oval("oval", -34, 45, 4, 5, 24, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Oval("oval", 34, -23, 4, 5, 24, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Oval("oval", -34, -23, 4, 5, 24, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    //Invalid Length/Width
    try {
      bad = new Oval("oval", 34, 23, 0, 5, 24, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Oval("oval", 34, 23, 0, 0, 24, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Oval("oval", 34, 23, -4, 5, 24, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Oval("oval", 34, 23, -4, -5, 24, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    //Invalid RGB values
    try {
      bad = new Oval("oval", 34, 23, -4, 5, 256, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Oval("oval", 34, 23, -4, 5, 24, 35, -123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Oval("oval", 34, 23, -4, 5, 263, -35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
  }
  
  @Test
  public void getShape() {
    assertEquals("oval", oval.getShape().getName());
    assertEquals("OVAL", oval.getShape().getType());
    
    assertEquals("rect", rect.getShape().getName());
    assertEquals("RECTANGLE", rect.getShape().getType());
    
  }
  
  @Test
  public void getType() {
    assertEquals("OVAL", oval.getType());
    assertEquals("RECTANGLE", rect.getType());
  }
  
  @Test
  public void getName() {
    assertEquals("oval", oval.getName());
    assertEquals("rect", rect.getName());
  }
  
  @Test
  public void getColor() {
    assertEquals(24, oval.getColor().getR());
    assertEquals(35, oval.getColor().getG());
    assertEquals(123, oval.getColor().getB());
    assertEquals(122, rect.getColor().getR());
    
  }
  
  @Test
  public void getPositions() {
    
    assertEquals(23, oval.getPositionX(), 0.001);
    assertEquals(67, rect.getPositionX(), 0.001);
    
    assertEquals(45, oval.getPositionY(), 0.001);
    assertEquals(89, rect.getPositionY(), 0.001);
  }
  
  @Test
  public void getLengthWidth() {
    assertEquals(4, oval.getX(), 0.001);
    assertEquals(8, rect.getX(), 0.001);
    
    assertEquals(5, oval.getY(), 0.001);
    assertEquals(8, rect.getY(), 0.001);
  }
  
  @Test
  public void AppearsDisappears() {
    try {
      oval.setAppears(1);
    } catch (Exception ignored) {
      fail("No exception should be thrown.");
    }
    
    try {
      oval.setAppears(0);
    } catch (Exception ignored) {
      fail("No exception should be thrown.");
    }
    
    try {
      oval.setDisappears(10);
    } catch (Exception ignored) {
      fail("No exception should be thrown.");
    }
    
    //Invalid inputs - negative time
    try {
      rect.setAppears(-2);
      fail("Exception should be thrown.");
    } catch (Exception ignored) {
    }
    
    rect.setAppears(2);
    
    //Invalid - disappears less than appears
    try {
      rect.setDisappears(1);
      fail("Exception should be thrown.");
    } catch (Exception ignored) {
    }
    
    rect.setDisappears(13);
    
    //Invalid - appears more than appears
    try {
      rect.setAppears(24);
      fail("Exception should be thrown.");
    } catch (Exception ignored) {
    }
    
  }
  
  
  @Test
  public void copy() {
    oval.setAppears(2);
    oval.setDisappears(12);
    Shape ovalCp = oval.copy();
    
    assertEquals("oval", ovalCp.getName());
    assertEquals("OVAL", ovalCp.getType());
    assertEquals(24, ovalCp.getColor().getR());
    assertEquals(35, ovalCp.getColor().getG());
    assertEquals(123, ovalCp.getColor().getB());
    
    assertEquals(23, ovalCp.getPositionX(), 0.001);
    assertEquals(45, ovalCp.getPositionY(), 0.001);
    
    //original shape not mutated
    ovalCp.setDisappears(24);
    assertEquals(12, oval.getDisappears());
    assertEquals(24, ovalCp.getDisappears());
    
  }
  
  @Test
  public void testToString() {
    rect.setAppears(2);
    rect.setDisappears(11);
    
    oval.setAppears(1);
    oval.setDisappears(10);
    
    String re = "Name: rect\n"
            + "Type: RECTANGLE\n"
            + "Corner: (67.0,89.0)\n"
            + "Width: 8\n"
            + "Length: 8\n"
            + "Color: (122, 122, 122)\n"
            + "Appears: 2\n"
            + "Disappears: 11\n";
    
    String ov = "Name: oval\n"
            + "Type: OVAL\n"
            + "Center: (23.0,45.0)\n"
            + "X-Radius: 4\n"
            + "Y-Radius: 5\n"
            + "Color: (24, 35, 123)\n"
            + "Appears: 1\n"
            + "Disappears: 10\n";
    
    assertEquals(re, rect.toString());
    assertEquals(ov, oval.toString());
    
  }
  
  @Test
  public void testEquals() {
    try {
      Shape rect2 = new Rectangle("rect", 67, 89, 8,
              8, 122, 122, 122);
      assertTrue(rect.equals(rect2));
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    //Different name
    try {
      Shape rect2 = new Rectangle("rect2", 67, 89, 8,
              8, 122, 122, 122);
      assertFalse(rect.equals(rect2));
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    //Different point
    try {
      Shape rect2 = new Rectangle("rect", 50, 75, 8,
              8, 122, 122, 122);
      assertFalse(rect.equals(rect2));
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    //Different XY
    try {
      Shape rect2 = new Rectangle("rect", 67, 89, 5,
              5, 122, 122, 122);
      assertFalse(rect.equals(rect2));
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    //Different RBG
    try {
      Shape rect2 = new Rectangle("rect", 67, 89, 8,
              8, 255, 0, 255);
      assertFalse(rect.equals(rect2));
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    //Null object
    try {
      Shape rect2 = null;
      rect.equals(rect2);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    try {
      Shape rect2 = null;
      rect2.equals(rect);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }
}