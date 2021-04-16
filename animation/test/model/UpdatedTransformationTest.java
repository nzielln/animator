package model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.Color;
import cs5004.animator.model.Move;
import cs5004.animator.model.Scale;
import cs5004.animator.model.Transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Test class for the Transformation Interface and its subtypes.
 */
public class UpdatedTransformationTest {
  private Transformation move;
  private Transformation scale;
  private Transformation color;
  //Other transformation methods have been tested in model.TransformationTest.java
  //This file test new methods added to the Trasnformation interface
  @Before
  public void setUp() throws Exception {
    //**
    try {
      move = new Move("move", 23, 34, 3, 11);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
    //**
    try {
      scale = new Scale("scale",8, 12, 2, 7);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
    
  }
  
  @Test
  public void testSetGetInitials() {
    
    try {
      move.setInitialX(23);
      move.setInitialY(0);
  
      assertEquals(23, move.getInitialX());
      assertEquals(0, move.getInitialY());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    
    try {
      scale.setInitialWidth(22);
      scale.setInitialHeight(45);
  
      assertEquals(22, scale.getInitialWidth());
      assertEquals(45, scale.getInitialHeight());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    /*
    try {
      color.setInitialColor(new Color(12, 46, 9));
  
      assertEquals(12, move.getInitialColor().getR());
      assertEquals(46, move.getInitialColor().getG());
      assertEquals(9, move.getInitialColor().getB());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    
     */
  
    //BAD Inputs
  
    try {
      scale.setInitialWidth(-22);
      fail("Exception should be thrown.");
    } catch (Exception ignored) {
    }
  
    try {
      scale.setInitialWidth(0);
      fail("Exception should be thrown.");
    } catch (Exception ignored) {
    }
  
    try {
      move.setInitialX(-22);
      fail("Exception should be thrown.");
    } catch (Exception ignored) {
    }
  }
  
  @Test
  public void testPropertyHashmap() {
    try {
      move.populateHashmap(23, 32, 6, 7, 2, 12, 123, 234,245);
      HashMap<String, Integer> h = move.getState();
      assertEquals(12, h.get("disappears").intValue());
      assertEquals(23, h.get("x").intValue());
      assertEquals(7, h.get("h").intValue());
      
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }
  
    try {
      scale.populateHashmap(3, 12, 3, 3, -2, 12, 0, 234,245);
      HashMap<String, Integer> h = move.getState();
      assertEquals(12, h.get("disappears").intValue());
      assertEquals(23, h.get("x").intValue());
      assertEquals(7, h.get("h").intValue());
      fail("Exception should be thrown");
    
    } catch (Exception ignored) {
    }
  }
  
}