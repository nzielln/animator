package model;

import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.Ellipse;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;

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
  //TODO: Merge Shape
  @Before
  public void setUp() {
    //Valid shape inputs
    try {
      oval = new Ellipse("oval", "Ellipse");
      oval.setProperties(-34, 45, 4, 5, 24, 35, 123);
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    
    try {
      oval = new Ellipse("oval", "Ellipse");
      oval.setProperties(23, 45, 4, 5, 24, 35, 123);
    } catch (Exception e) {
      fail("Exception should not have been thrown.");
    }
    
    
    try {
      rect = new Rectangle("rect", "RECTANGLE");
      rect.setProperties(17, 9, 8, 8, 122, 122, 122);
    } catch (Exception e) {
      fail("Exception should not have been thrown.");
    }
    
    try {
      rect = new Rectangle("rect", "RECTANGLE");
      rect.setProperties(67, 89, 8, 8, 122, 122, 122);
    } catch (Exception e) {
      fail("Exception should not have been thrown.");
    }
    
    
    Shape bad;
    //Invalid Length/Width
    try {
      bad = new Ellipse("oval", "Ellipse");
      bad.setProperties(34, 23, 0, 5, 24, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Ellipse("oval", "Ellipse");
      bad.setProperties(34, 23, 0, 0, 24, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Ellipse("oval", "Ellipse");
      bad.setProperties(34, 23, -4, 5, 24, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Ellipse("oval", "Ellipse");
      bad.setProperties(34, 23, -4, -5, 24, 35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    //Invalid RGB values
    try {
      bad = new Ellipse("oval", "Ellipse");
      bad.setProperties(34, 23, -4, 5, 256, 35, 12);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Ellipse("oval", "Ellipse");
      bad.setProperties(34, 23, -4, 5, 24, 35, -123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Ellipse("oval", "Ellipse");
      bad.setProperties(34, 23, -4, 5, 263, -35, 123);
      fail("Exception should have been thrown.");
    } catch (Exception ignored) {
    }
  }
  
  @Test
  public void getShape() {
    assertEquals("oval", oval.getShape().getName());
    assertEquals("ELLIPSE", oval.getShape().getType());
    
    assertEquals("rect", rect.getShape().getName());
    assertEquals("RECTANGLE", rect.getShape().getType());
    
  }
  
  @Test
  public void getType() {
    assertEquals("ELLIPSE", oval.getType());
    assertEquals("RECTANGLE", rect.getType());
  }
  
  @Test
  public void getName() {
    assertEquals("oval", oval.getName());
    assertEquals("rect", rect.getName());
  }
  
  @Test
  public void getColor() {
    assertEquals(24, oval.getColor().getR(), 0.001);
    assertEquals(35, oval.getColor().getG(), 0.001);
    assertEquals(123, oval.getColor().getB(), 0.001);
    assertEquals(122, rect.getColor().getR(), 0.001);
    
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
    assertEquals(4, oval.getWidth(), 0.001);
    assertEquals(8, rect.getWidth(), 0.001);
    
    assertEquals(5, oval.getHeight(), 0.001);
    assertEquals(8, rect.getHeight(), 0.001);
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
  public void testChangePosition() {

    // valid oval
    try {
      assertEquals(23, oval.getPositionX());
      assertEquals(45, oval.getPositionY());
      oval.changePosition(43, 12);
      assertEquals(43, oval.getPositionX());
      assertEquals(12, oval.getPositionY());
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    //valid rectangle
    try {
      assertEquals(67, rect.getPositionX());
      assertEquals(89, rect.getPositionY());
      rect.changePosition(5, 10);
      assertEquals(5, rect.getPositionX());
      assertEquals(10, rect.getPositionY());
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    //valid negative
    try {
      assertEquals(5, rect.getPositionX());
      assertEquals(10, rect.getPositionY());
      rect.changePosition(-5, -10);
      assertEquals(-5, rect.getPositionX());
      assertEquals(-10, rect.getPositionY());
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    //valid zero
    try {
      assertEquals(43, oval.getPositionX());
      assertEquals(12, oval.getPositionY());
      oval.changePosition(0, 0);
      assertEquals(0, oval.getPositionX());
      assertEquals(0, oval.getPositionY());
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }
  }

  @Test
  public void testChangeSize() {

    // valid
    try {
      assertEquals(4 ,oval.getWidth());
      assertEquals(5, oval.getHeight());
      oval.changeSize(3, 3);
      assertEquals(3 ,oval.getWidth());
      assertEquals(3, oval.getHeight());
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    try {
      assertEquals(8, rect.getWidth());
      assertEquals(8, rect.getHeight());
      rect.changeSize(10, 12);
      assertEquals(10, rect.getWidth());
      assertEquals(12, rect.getHeight());
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    // width 0
    try {
      assertEquals(3 ,oval.getWidth());
      assertEquals(3, oval.getHeight());
      oval.changeSize(0, 4);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    // height 0
    try {
      assertEquals(10, rect.getWidth());
      assertEquals(12, rect.getHeight());
      rect.changeSize(8, 0);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    // width negative
    try {
      assertEquals(10, rect.getWidth());
      assertEquals(12, rect.getHeight());
      rect.changeSize(-8, 8);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    //height negative
    try {
      assertEquals(3 ,oval.getWidth());
      assertEquals(3, oval.getHeight());
      oval.changeSize(5, -10);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }

  @Test
  public void testChangeColor() {
    // Valid RGB
    try {
      assertEquals(24, oval.getColor().getR());
      assertEquals(35, oval.getColor().getG());
      assertEquals(123, oval.getColor().getB());

      oval.changeColor(26, 26, 26);

      assertEquals(26, oval.getColor().getR());
      assertEquals(26, oval.getColor().getG());
      assertEquals(26, oval.getColor().getB());

    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    try {
      assertEquals(122, rect.getColor().getR());
      assertEquals(122, rect.getColor().getG());
      assertEquals(122, rect.getColor().getB());

      rect.changeColor(100, 100, 100);

      assertEquals(100, rect.getColor().getR());
      assertEquals(100, rect.getColor().getG());
      assertEquals(100, rect.getColor().getB());
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }

    // negative RGB
    try {
      assertEquals(26, oval.getColor().getR());
      assertEquals(26, oval.getColor().getG());
      assertEquals(26, oval.getColor().getB());
      oval.changeColor(-122, -122, -122);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    try {
      assertEquals(100, rect.getColor().getR());
      assertEquals(100, rect.getColor().getG());
      assertEquals(100, rect.getColor().getB());
      rect.changeColor(255, -100, 255);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    // Greater than 255 RGB
    try {
      assertEquals(26, oval.getColor().getR());
      assertEquals(26, oval.getColor().getG());
      assertEquals(26, oval.getColor().getB());
      oval.changeColor(256, 0, 256);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    try {
      assertEquals(100  , rect.getColor().getR());
      assertEquals(100, rect.getColor().getG());
      assertEquals(100, rect.getColor().getB());
      rect.changeColor(255, 300, 255);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }
  
  
  @Test
  public void copy() {
    oval.setAppears(2);
    oval.setDisappears(12);
    Shape ovalCp = oval.copy();
    
    assertEquals("oval", ovalCp.getName());
    assertEquals("ELLIPSE", ovalCp.getType());
    assertEquals(24, ovalCp.getColor().getR(), 0.001 );
    assertEquals(35, ovalCp.getColor().getG(), 0.001);
    assertEquals(123, ovalCp.getColor().getB(), 0.001);
    
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
            + "Min corner: (67.0,89.0), Width: 8.0, Length: 8.0, Color: (122.0, 122.0, 122.0)\n"
            + "Appears at t=2\n"
            + "Disappears at t=11\n";
    
    String ov = "Name: oval\n"
            + "Type: ELLIPSE\n"
            + "Center: (23.0,45.0), X radius: 4.0, Y radius: 5.0, Color: (24.0, 35.0, 123.0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=10\n";
    System.out.println(rect.toString());
    System.out.println(oval.toString());
    
    assertEquals(re, rect.toString());
    assertEquals(ov, oval.toString());
    
  }
  
  @Test
  public void testSame() {
    try {
      Shape rect2 = new Rectangle("rect", "RECTANGLE");
      rect2.setProperties(67, 89, 8,
              8, 122, 122, 122);
      assertTrue(rect.sameObject(rect2));
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    //Different name
    try {
      Shape rect2 = new Rectangle("rect2", "RECTANGLE");
      rect2.setProperties(67, 89, 8,
              8, 122, 122, 122);
      assertFalse(rect.sameObject(rect2));
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    //Different point
    try {
      Shape rect2 = new Rectangle("rect", "RECTANGLE");
      rect2.setProperties(50, 75, 8,
              8, 122, 122, 122);
      assertFalse(rect.sameObject(rect2));
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    //Different XY
    try {
      Shape rect2 = new Rectangle("rect", "RECTANGLE");
      rect2.setProperties(67, 89, 5,
              5, 122, 122, 122);
      assertFalse(rect.sameObject(rect2));
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    //Different RBG
    try {
      Shape rect2 = new Rectangle("rect", "RECTANGLE");
      rect2.setProperties(67, 89, 8,
              8, 255, 0, 255);
      assertFalse(rect.sameObject(rect2));
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    //Null object
    try {
      Shape rect2 = null;
      rect.sameObject(rect2);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    try {
      Shape rect2 = null;
      rect2.sameObject(rect);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }
}