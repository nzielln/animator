import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public interface Animation {
  
  /**
   *
   * @param s
   */
  void addShape(Shape s);
  
  /**
   *
   * @param s
   */
  void removeShape(Shape s);
  
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
  List<Shape> sortShapes(Comparator<Shape> comp);
  
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
  List<Transformation> filterTransformations(Predicate<Shape> p);
  
  /**
   *
   * @param comp
   * @return
   */
  List<Transformation> sortTransformations(Comparator<Shape> comp);
  
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
