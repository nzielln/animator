package animation;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Animation interface, represents methods implemented by the {@link AnimationImpl} class.
 */
public interface Animation {
  //GETTERS----------------------------------------------------------------------------------------
  /**
   * Returns a the numebr of Shapes in the animation,the size of the hashmap.
   * @return (int) number of items in the hashmap
   */
  int getSize();
  
  /**
   * Returns a the numebr of Transformation in the Shape that matches the id providied.
   * @return (int) number of Transformation objects
   * @throws IllegalArgumentException if id is null or an empty string
   */
  int getSizeTransformations(String id);
  
  
  /**
   * Returns a Shape in the animation that matches the provided ID.
   * @param id (string) ID of the shape to return
   * @return a Shape object
   * @throws IllegalArgumentException if id is null or an empty string
   * @throws NoSuchElementException if id not in the animation's hashmap
   */
  Shape getById(String id);
  
  /**
   * Returns a Shape(s) in the animation at the time/tick provided.
   * @param t (int) time of the shape to return
   * @return a Shape at time t
   */
  Shape getByTime(int t);
  
  /**
   * Returns a list of all the Transformation(s) in the animation for a shape that matches the id.
   * @return a list of transformations in the list
   * @throws IllegalArgumentException if id is null or an empty string
   * @throws NoSuchElementException if id not in the animation's hashmap
   */
  List<Transformation> getTransformations(String id);
  
  /**
   * Returns a list of all the Shape(s) in the animation.
   * @return a list of shapes in the list
   */
  List<Shape> getShapes();
  
  
  //OTHER------------------------------------------------------------------------------------------
  /**
   * Adds a shape to the list of Shape(s) and a new list of Transformation to the animation.
   * @param s (Shape) shape to add to list
   * @param l (Listof Transformation) list of tranformations
   * @throws IllegalArgumentException if id is already in the animation's hashmap
   */
  void addShape(Shape s, List<Transformation> l);
  
  /**
   * Removes a Shape and its list of transformations from the hashmap if it matches the ID provided.
   * @param id (String) id of Shape to remove.
   * @throws NoSuchElementException if id not found in the animaton's hashmap
   * @throws IllegalArgumentException if hashmap has no items, or if id is an empty string
   */
  void removeShape(String id);
  
  /**
   * Determines whether a Transformation can be added to a list, an invalid Transformation overlaps
   * with/or is identical to another Transformation in the list.
   * @param id (String) of shape to add transformation to
   * @param t (Transformation) to add to list
   * @return true if transformation is valid and can be added to hashmap
   */
  public boolean validTransformation(String id, Transformation t);
  
  /**
   * Adds a transformation to the list of Transforms of Shape that matches the id provided.
   * @param id (String) id of Shape to add transformation to
   * @param t (Transformation) a Transformation to add to list
   * @throws IllegalArgumentException if id is an empty string or if start time of the
   *        transformation is not valid
   * @throws IllegalStateException if
   */
  void addTransformation(String id, Transformation t);
  
  /**
   * Removes a transformation from the list of Transformation of a shape that matches the id.
   * @param id (String) id of Shape to remove transformation from
   * @param t (Transformation) a Transformation to remove from list
   * @throws IllegalArgumentException if id is an empty string or if removing from an empty list
   * @throws NoSuchElementException if Tranformation does not exist in the animation
   */
  void removeTransformation(String id, Transformation t);
  
  /**
   * Returns a string representation of the animation.
   * @return a string
   *        "Shape:
   *        //For each shape
   *        "Name:
   *        Type:
   *        Corner/Center:
   *        Width/X-Radius:
   *        Length/Y-Radius:
   *        Appears:
   *        Disappears:
   *
   *
   *        //For each transformation
   *        Description of transformation: Shape, name, changes, times
   */
  String toString();
}
