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
  
  public void removeShape(String id) {
    shapes.removeIf(s -> s.getName().equals(id));
    
  }
  
  @Override
  public void addTransformation(Transformation t) {
    Objects.requireNonNull(t, "Object can't be null.");
    
    transformations.add(t);
  }
  
  @Override
  public void removeTransformation(Transformation t) {
    Objects.requireNonNull(t, "Object can't be null.");
    //How do we want to remove this? by shape ID or should we have an ID for each transformation?
    //maybe create an ID for each transformation, i'm just not sure what type
    
  }
  
  public Shape getById(String id) {
    
    for (Shape s : shapes) {
      if (s.getName().equals(id)) {
        return s;
      }
    }
    return null;
  }
  
  public Shape getByTime(int t) {
    for (Transformation tr : transformations) {
      if ( t >= tr.getTransformation().getTimeStart() && t < tr.getTransformation().getTimeEnd()) {
        return tr.getShape();
      }
    }
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
    Objects.requireNonNull(seed, "Argument provided not valid.");
  
    for (Shape t : shapes) {
      seed = bf.apply(t.getShape(), seed);
    }
    return seed;
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
    Objects.requireNonNull(seed, "Argument provided not valid.");
    
    for (Transformation t : transformations) {
      seed = bf.apply(t.getTransformation(), seed);
    }
    return seed;
  }
  
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    for (Shape s : shapes) {
      str.append(s.toString()).append("\n\n");
    }
  
    for (Transformation t : transformations) {
      str.append(t.toString()).append("\n");
    }
    return "Shapes: \n" + str.toString().trim();
  }
  
}
