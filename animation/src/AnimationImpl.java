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
  
  //GETTERS----------------------------------------------------------------------------------------
  
  @Override
  public int getSizeShapes() {
    return shapes.size();
  }
  
  @Override
  public int getSizeTransformations() {
    return transformations.size();
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
  
  
  //OTHER------------------------------------------------------------------------------------------
  
  public void addShape(Shape s) {
    Objects.requireNonNull(s, "Object can't be null.");
    
    shapes.add(s);
  }
  
  public void removeShape(String id) {
    if (id == null || id.equals("")) {
      throw new IllegalArgumentException("Invalid id provided");
    }
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
    //maybe create an ID for each transformation, i'm just not sure what type of id to use
    
  }
  
  @Override
  public List<Shape> filterShapes(Predicate<Shape> p) {
    if (this.shapes.size() == 0) {
      throw new IllegalStateException("Shapes list is empty");
    }
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
    if (this.shapes.size() == 0) {
      throw new IllegalStateException("Shapes list is empty");
    }
    Objects.requireNonNull(comp, "Comparator can't be null.");
    
    shapes.sort((shapeA, shapeB) -> comp.compare(shapeA.getShape(), shapeB.getShape()));
  }
  
  @Override
  public <R> R foldShapes(BiFunction<Shape, R, R> bf, R seed) {
    if (this.shapes.size() == 0) {
      throw new IllegalStateException("Shapes list is empty");
    }
    Objects.requireNonNull(bf, "BiFunction is null.");
    Objects.requireNonNull(seed, "Seed is null.");
  
    for (Shape t : shapes) {
      seed = bf.apply(t.getShape(), seed);
    }
    return seed;
  }
  
  @Override
  public List<Transformation> filterTransformations(Predicate<Transformation> p) {
    if (this.transformations.size() == 0) {
      throw new IllegalStateException("Transformations list is empty");
    }
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
    if (this.transformations.size() == 0) {
      throw new IllegalStateException("Transformations list is empty");
    }
    Objects.requireNonNull(comp, "Comparator can't be null.");
  
    transformations.sort((ta, tb) -> comp.compare(ta.getTransformation(), tb.getTransformation()));
  }

  @Override
  public <R> R foldTransformations(BiFunction<Transformation, R, R> bf, R seed) {
    if (this.transformations.size() == 0) {
      throw new IllegalStateException("Transformations list is empty");
    }
    Objects.requireNonNull(bf, "BiFunction can't be null.");
    Objects.requireNonNull(seed, "Seed can't be null.");
    
    for (Transformation t : transformations) {
      seed = bf.apply(t.getTransformation(), seed);
    }
    return seed;
  }
  
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    for (Shape s : shapes) {
      str.append(s.toString()).append("\n");
    }
  
    for (Transformation t : transformations) {
      str.append(t.toString()).append("\n");
    }
    return "Shapes: \n\n" + str.toString().trim();
  }
  
}
