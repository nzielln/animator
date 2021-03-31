import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class AnimationImpl implements Animation {
  private List<ShapeNode> shapes;
  
  public AnimationImpl() {
    shapes = new ArrayList<>();
  }
  
  public void addShape(ShapeNode s) {
    shapes.add(s);
  }
  
  public void removeShape(ShapeNode s) {
    shapes.remove(s);
  }
  
  public ShapeNode getById(String id) {
    return null;
  }
  
  public ShapeNode getByTime(int t) {
    return null;
  }
  
  public List<ShapeNode> filter(Predicate<ShapeNode> p) {
    return null;
  }
  
  public List<ShapeNode> sort(Comparator<ShapeNode> comp) {
    return null;
  }
  
  public <R> R fold(BiFunction<ShapeNode, R, R> bf, R seed) {
    return null;
  }
  
}
