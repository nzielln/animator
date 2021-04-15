package cs5004.animator.model;

import java.util.HashMap;

import jdk.jshell.spi.ExecutionControl;

/**
 * Animation interface, represents methods implemented by the {@link AbstractTransformation} class.
 */
public interface Transformation {
  
  //GETTERS----------------------------------------------------------------------------------------
  /**
   * Returns the {@link Transformation}(s).
   * @return a transformations
   */
  Transformation getTransformation();
  
  /**
   * Returns the Transformation's ID.
   * @return (String) Tranformastion's ID
   */
  String getID();
  
  /**
   * Returns the type of the {@link Transformation}.
   * @return a string, type of transformation
   */
  String getTransformationType();
  
  /**
   * Returns the time the transformation starts.
   * @return int, time
   */
  int getTimeStart();
  
  /**
   * Returns the time the transformation ends.
   * @return int, time
   */
  int getTimeEnd();
  
  /**
   * Returns the x-position/width the new shape should have.
   * @return float, time
   */
  int getToX();
  
  /**
   * Returns the y-position/length the new shape should have.
   * @return float, time
   */
  int getToY();
  
  
  /**
   * Returns the color the new shape should have.
   * @return {@link Color}, color of new shape
   */
  Color getToColor();
  
  int getInitialX();
  
  int getInitialY();
  
  Color getInitialColor();
  HashMap<String, Integer> getState();
  
  
  //OTHER------------------------------------------------------------------------------------------
  /**
   * Determines if two Transformation objects are identical.
   * @param other (Transformation) another Transformation object
   * @return true if the two objects are identical
   */
  boolean sameObject(Transformation other);
  
  void setInitialX(int x);
  void setInitialY(int y);
  void setInitialColor(Color c);
  void populateHashmap(int x, int y, int w, int h, int app, int dis, int r, int g, int b);
  
  /**
   * Returns a string representation of the {@link Transformation} object.
   * @return a string, decription of the transformation
   */
  String toString();
  
}
