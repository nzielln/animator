package model;

import org.junit.Test;

import java.util.ArrayList;

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


/**
 * Test class for the Animation Interface and its subtypes, tests a sample of a full animation.
 */
public class AnimationFullTest {

  @Test
  public void animationTest() {
    //Create a new animation
    Animation animation = new AnimationImpl();
    
    Shape ovalOne = new Ellipse("ovalOne","ELLIPSE");
    ovalOne.setProperties(5, 23, 4, 4, 24, 45, 57);
    Shape ovalTwo = new Ellipse("ovalTwo","ELLIPSE");
    ovalTwo.setProperties(5, 3, 4, 5, 2, 5, 7);
    Shape rectangleOne = new Rectangle("rectOne","RECTANGLE");
    rectangleOne.setProperties(5, 23, 4, 7, 244,145, 7);
  
    ovalOne.setAppearsDisappears(0, 10);
    rectangleOne.setAppearsDisappears(2, 10);
  
    //add shapes
    animation.addShape(ovalOne, new ArrayList<>());
    animation.addShape(ovalTwo, new ArrayList<>());
    animation.addShape(rectangleOne, new ArrayList<>());
    
    //create new transformation
    Transformation colorOne = new ChangeColor(new Color(35, 45, 56),
            3, 7);
    colorOne.setInitial("ovalOne",ovalOne.getType(), 5, 23, 4,
            4, 24, 45, 57 );
    Transformation scaleOne = new Scale(12, 7, 2, 7);
    scaleOne.setInitial("rectOne", rectangleOne.getType(), 5, 23, 4,
            7, 244,145, 7);
    Transformation moveOne = new Move(0, 0, 3, 10);
    moveOne.setInitial("ovalOne",ovalOne.getType(), 5, 23, 4,
            4, 35, 45, 56 );
  
    //add transformation
    animation.addTransformation("ovalOne", colorOne);
    animation.addTransformation("ovalOne", moveOne);
    animation.addTransformation("rectOne", scaleOne);
    
    assertEquals(3, animation.getSize());
    assertEquals(2, animation.getSizeTransformations("ovalOne") );
    assertEquals("Shapes: \n"
            + "Name: ovalOne\n"
            + "Type: ELLIPSE\n"
            + "Center: (5.0,23.0), X radius: 4.0, Y radius: 4.0, Color: (24.0, 45.0, 57.0)\n"
            + "Appears at t=0\n"
            + "Disappears at t=10\n\n"
            + "Name: ovalTwo\n"
            + "Type: ELLIPSE\n"
            + "Center: (5.0,3.0), X radius: 4.0, Y radius: 5.0, Color: (2.0, 5.0, 7.0)\n"
            + "Appears at t=0\n"
            + "Disappears at t=0\n\n"
            + "Name: rectOne\n"
            + "Type: RECTANGLE\n"
            + "Min corner: (5.0,23.0), Width: 4.0, Length: 7.0, Color: (244.0, 145.0, 7.0)\n"
            + "Appears at t=2\n"
            + "Disappears at t=10\n\n"
            + "Shape ovalOne changes color from (24.0, 45.0, 57.0) to (35.0, 45.0, 56.0) from t=3 "
            + "to t=7.\n"
            + "Shape ovalOne moves from (5.0,23.0) to (0.0,0.0) from t=3 to t=10.\n"
            + "Shape rectOne scales from Width: 4.0, Height: 7.0 to Width: 12.0, Height: 7.0 from "
            + "t=2 to t=7.", animation.toString());
  
  }
}