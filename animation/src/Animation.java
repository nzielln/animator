import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public interface Animation {
  //GETTERS----------------------------------------------------------------------------------------
  
  /**
   *
   * @param id
   * @return
   */
  Shape getById(String id);
  
  /**
   *
   * @param t
   * @return
   */
  Shape getByTime(int t);
  
  /**
   *
   * @return
   */
  List<Transformation> getTransformations();
  
  /**
   *
   * @return
   */
  List<Shape> getShapes();
  
  
  //OTHER------------------------------------------------------------------------------------------
  
  /**
   *
   * @param s
   */
  void addShape(Shape s);
  
  /**
   *
   * @param id
   */
  void removeShape(String id);
  
  /**
   *
   * @param t
   */
  void addTransformation(Transformation t);
  
  /**
   *
   * @param t
   */
  void removeTransformation(Transformation t);
  
  /**
   *
   * @param p
   * @return
   */
  List<Shape> filterShapes(Predicate<Shape> p);
  
  /**
   *
   * @param comp
   * @return
   */
  void sortShapes(Comparator<Shape> comp);
  
  /**
   *
   * @param bf
   * @param seed
   * @param <R>
   * @return
   */
  <R> R foldShapes(BiFunction<Shape, R, R> bf, R seed);
  
  /**
   *
   * @param p
   * @return
   */
  List<Transformation> filterTransformations(Predicate<Transformation> p);
  
  /**
   *
   * @param comp
   * @return
   */
  void sortTransformations(Comparator<Transformation> comp);
  
  /**
   *
   * @param bf
   * @param seed
   * @param <R>
   * @return
   */
  <R> R foldTransformations(BiFunction<Transformation, R, R> bf, R seed);
  
  /**
   *
   * @return
   */
  String toString();
}
