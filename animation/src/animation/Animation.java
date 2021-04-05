package animation;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Animation interface, represents methods implemented by the {@link AnimationImpl} class.
 */
public interface Animation {
  //GETTERS----------------------------------------------------------------------------------------
  
  /**
   * Returns a the numebr of {@link Shape} in the animation.
   * @return int, number of {@link Shape} objects
   */
  int getSize();
  
  /**
   * Returns a the numebr of {@link Transformation} in the animation.
   * @return int, number of {@link Transformation} objects
   */
  int getSizeTransformations(String id);
  
  
  /**
   * Returns a {@link Shape} in the animation that matches the provided ID.
   * @param id ID of the shape to return
   * @return a {@link Shape} object
   */
  Shape getById(String id);
  
  /**
   * Returns a {@link Shape}(s)  in the animation at the time provided.
   * @param t time of the shape to return
   * @return a {@link Shape} at time t
   */
  Shape getByTime(int t);
  
  /**
   * Returns a list of all the {@link Transformation}(s) in the animation.
   * @return a list of transformations in the list
   */
  List<Transformation> getTransformations(String id);
  
  /**
   * Returns a list of all the {@link Shape}(s)  in the animation.
   * @return a list of shapes in the list
   */
  List<Shape> getShapes();
  
  
  //OTHER------------------------------------------------------------------------------------------
  
  /**
   * Adds a shape to the list of {@link Shape}(s) in the animation.
   * @param s a {@link Shape} to add to list
   */
  void addShape(Shape s, List<Transformation> l);
  
  /**
   * Removes a shape from the list of {@link Shape}(s), if it matches the ID provided.
   * @param id of {@link Shape} to remove.
   */
  void removeShape(String id);
  
  /**
   * Adds a transformation to the list of {@link Transformation}(s) in the animation.
   * @param t a {@link Transformation} to add to list
   */
  void addTransformation(String id, Transformation t);
  
  /**
   * Removes a transformation from the list of {@link Transformation}(s).
   * @param t a {@link Transformation} to remove from the list
   */
  void removeTransformation(String id, Transformation t);
  
  /**
   * Filters the list of {@link Shape}(s) based on the predicate provided.
   * @param p {@link Predicate} provided
   * @return a new list that is filtered
   */
  //List<Shape> filterShapes(Predicate<Shape> p);
  
  /**
   * Sorts the list of {@link Shape}(s) based on the comparator provided.
   * @param comp {@link Comparator} provided
   */
  //void sortShapes(Comparator<Shape> comp);
  
  /**
   * Fold the list of {@link Shape}(s) based on the arguments provided.
   * @param bf bi-function
   * @param seed seed to fold into
   * @param <R> return type
   * @return folded resulted
   */
  //<R> R foldShapes(BiFunction<Shape, R, R> bf, R seed);
  
  /**
   * Filters the list of {@link Transformation}(s) based on the predicate provided.
   * @param p {@link Predicate} provided
   * @return a new list that is filtered
   */
  //List<Transformation> filterTransformations(Predicate<Transformation> p);
  
  /**
   * Sorts the list of {@link Transformation}(s) based on the comparator provided.
   * @param comp {@link Comparator} provided
   */
  //void sortTransformations(Comparator<Transformation> comp);
  
  /**
   * Fold the list of {@link Transformation}(s) based on the arguments provided.
   * @param bf bi-function
   * @param seed seed to fold into
   * @param <R> return type
   * @return folded resulted
   */
  //<R> R foldTransformations(BiFunction<Transformation, R, R> bf, R seed);
  
  /**
   * Returns a string representation of the animation.
   * @return a string
   * "Shape:
   * //For each shape
   * "Name:
   *  Type:
   *  Corner/Center:
   *  Width/X-Radius:
   *  Length/Y-Radius:
   *  Appears:
   *  Disappears:
   *
   *
   *  //For each transformation
   *  Description of transformation: Shape, name, changes, times
   */
  String toString();
}
