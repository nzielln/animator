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
    Objects.requireNonNull(p, "Predicate can't be null.");
    
    List<Shape> filtered = new ArrayList<>();
    for (Shape s : shapes) {
      if (p.test(s.getShape())) {
        Shape sh = s.getShape().copy();
        filtered.add(sh);
      }
    }
    
    return filtered;
  }
  
  @Override
  public void sortShapes(Comparator<Shape> comp) {
    Objects.requireNonNull(comp, "Comparator can't be null.");
    
    shapes.sort((shapea, shapeb) -> comp.compare(shapea.getShape(), shapeb.getShape()));
  }
  
  @Override
  public <R> R foldShapes(BiFunction<Shape, R, R> bf, R seed) {
    return null;
  }
  
  @Override
  public List<Transformation> filterTransformations(Predicate<Transformation> p) {
    Objects.requireNonNull(p, "Predicate can't be null.");
  
    List<Transformation> filtered = new ArrayList<>();
    for (Transformation t : transformations) {
      if (p.test(t.getTransformation())) {
        Transformation tr = t.getTransformation().copy();
        filtered.add(tr);
      }
    }
  
    return filtered;
  }
  
  @Override
  public void sortTransformations(Comparator<Transformation> comp) {
    Objects.requireNonNull(comp, "Comparator can't be null.");
  
    transformations.sort((ta, tb) -> comp.compare(ta.getTransformation(), tb.getTransformation()));
  }
  
  @Override
  public <R> R foldTransformations(BiFunction<Transformation, R, R> bf, R seed) {
    return null;
  }
  
}
