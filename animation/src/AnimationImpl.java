import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class AnimationImpl implements Animation {
  private List<Shape> shapes;
  private List<Transformation> transformations;
  
  public AnimationImpl() {
    shapes = new ArrayList<>();
    transformations = new ArrayList<>();
  }
  
  public void addShape(Shape s) {
    shapes.add(s);
  }
  
  public void removeShape(Shape s) {
    shapes.remove(s);
  }
  
  @Override
  public void addTransformation(Transformation t) {
    Objects.requireNonNull(t, "Object can't be null.");
  }
  
  @Override
  public void removeTransformation(Transformation t) {
    Objects.requireNonNull(t, "Object can't be null.");
  }
  
  public Shape getById(String id) {
    return null;
  }
  
  public Shape getByTime(int t) {
    return null;
  }
  
  @Override
  public List<Transformation> getTransformations() {
    return this.transformations;
  }
  
  @Override
  public List<Shape> getShapes() {
    return this.shapes;
  }
  
  @Override
  public List<Shape> filterShapes(Predicate<Shape> p) {
    return null;
  }
  
  @Override
  public List<Shape> sortShapes(Comparator<Shape> comp) {
    return null;
  }
  
  @Override
  public <R> R foldShapes(BiFunction<Shape, R, R> bf, R seed) {
    return null;
  }
  
  @Override
  public List<Transformation> filterTransformations(Predicate<Shape> p) {
    return null;
  }
  
  @Override
  public List<Transformation> sortTransformations(Comparator<Shape> comp) {
    return null;
  }
  
  @Override
  public <R> R foldTransformations(BiFunction<Transformation, R, R> bf, R seed) {
    return null;
  }
  
}
