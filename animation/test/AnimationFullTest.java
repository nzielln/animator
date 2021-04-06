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

import static org.junit.Assert.assertEquals;


/**
 * Test class for the Animation Interface and its subtypes, tests a sample of a full animation.
 */
public class AnimationFullTest {

  @Test
  public void animationTest() {
    //Create a new animation
    Animation animation = new AnimationImpl();
    
    Shape ovalOne = new Oval("ovalOne",5, 23, 4, 4, 24, 45, 57);
    Shape ovalTwo = new Oval("ovalTwo",5, 3, 4, 5, 2, 5, 7);
    Shape rectangleOne = new Rectangle("rectOne",5, 23, 4, 7, 244, 145, 7);
  
    ovalOne.setAppears(0);
    ovalOne.setDisappears(10);
  
    rectangleOne.setAppears(2);
    rectangleOne.setDisappears(10);
  
    //add shapes
    animation.addShape(ovalOne, new ArrayList<>());
    animation.addShape(ovalTwo, new ArrayList<>());
    animation.addShape(rectangleOne, new ArrayList<>());
    
    //create new transformation
    Transformation colorOne = new ChangeColor("change_color", new Color(35, 45, 56), 3, 7);
    Transformation scaleOne = new Scale("scaleOne", 12, 7, 2, 7);
    Transformation moveOne = new Move("moveOne", 0, 0, 3, 10);
  
    //add transformation
    animation.addTransformation("ovalOne", colorOne);
    animation.addTransformation("ovalOne", moveOne);
    animation.addTransformation("rectOne", scaleOne);
    
    assertEquals(3, animation.getSize());
    assertEquals(2, animation.getSizeTransformations("ovalOne") );
    assertEquals("Shapes: \n"
            + "Name: ovalOne\n"
            + "Type: OVAL\n"
            + "Center: (5.0,23.0)\n"
            + "X-Radius: 4.0\n"
            + "Y-Radius: 4.0\n"
            + "Color: (24.0, 45.0, 57.0)\n"
            + "Appears: 0\n"
            + "Disappears: 10\n\n"
            + "Name: ovalTwo\n"
            + "Type: OVAL\n"
            + "Center: (5.0,3.0)\n"
            +  "X-Radius: 4.0\n"
            + "Y-Radius: 5.0\n"
            + "Color: (2.0, 5.0, 7.0)\n"
            + "Appears: 0\n"
            + "Disappears: 0\n\n"
            + "Name: rectOne\n"
            + "Type: RECTANGLE\n"
            + "Corner: (5.0,23.0)\n"
            + "Width: 4.0\n"
            + "Length: 7.0\n"
            + "Color: (244.0, 145.0, 7.0)\n"
            + "Appears: 2\n"
            + "Disappears: 10\n\n"
            +  "Shape ovalOne changes color from (24.0, 45.0, 57.0) to (35.0, 45.0, 56.0) from 3 to 7.\n"
            + "Shape ovalOne moves from (5.0,23.0) to (0.0,0.0) from 3 to 10.\n"
            + "Shape rectOne scales from Width: 4.0 Height: 7.0 to Width: 12.0 and Height: 7.0 from 2 to 7.", animation.toString());
  
  }
}