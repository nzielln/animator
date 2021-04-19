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
      move = new Move(23, 34, 3, 11);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
  
    //**
    try {
      scale = new Scale(8, 12, 2, 7);
    } catch (Exception ignored) {
      fail("Exception should not be thrown");
    }
  }
  
}