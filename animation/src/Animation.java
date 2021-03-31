import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public interface Animation {
  
  /**
   *
   * @param s
   */
  void addShape(ShapeNode s);
  
  /**
   *
   * @param s
   */
  void removeShape(ShapeNode s);
  
  /**
   *
   * @param id
   * @return
   */
  ShapeNode getById(String id);
  
  /**
   *
   * @param t
   * @return
   */
  ShapeNode getByTime(int t);
  
  /**
   *
   * @param p
   * @return
   */
  List<ShapeNode> filter(Predicate<ShapeNode> p);
  
  /**
   *
   * @param comp
   * @return
   */
  List<ShapeNode> sort(Comparator<ShapeNode> comp);
  
  /**
   *
   * @param bf
   * @param seed
   * @param <R>
   * @return
   */
  <R> R fold(BiFunction<ShapeNode, R, R> bf, R seed);
}
