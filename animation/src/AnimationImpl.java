import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AnimationImpl implements Animation {
  HashMap<Shape, List<Transformation>> hashmap;

  public AnimationImpl() {
    hashmap = new HashMap<>();
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  public int getSize() {
    return hashmap.size();
  }
  
  public int getSizeTransformations(String id) {
    for (Shape s : hashmap.keySet()) {
      if (s.getName().equals(id)) {
        return hashmap.get(s).size();
      }
      
    }
    return 0;
  }
  
  public Shape getById(String id) {
    
    for (Shape s : hashmap.keySet()) {
      if(s.getName().equals(id)) {
        return s;
      }
    }
    return null;
  }
  
  public Shape getByTime(int t) {
    return null;
  }
  
  
  public List<Transformation> getTransformations(String id) {
    for (Shape s : hashmap.keySet()) {
      if(s.getName().equals(id)) {
        return hashmap.get(s);
      }
    }
    return null;
  }
  
  
  public List<Shape> getShapes() {
    return new ArrayList<>(hashmap.keySet());
  }
  
  
  //OTHER------------------------------------------------------------------------------------------
  
  public void addShape(Shape s, List<Transformation> l) {
    Objects.requireNonNull(s, "Object can't be null.");
    
    hashmap.put(s, l);
  }
  
  public void removeShape(String id) {
    if (id == null || id.equals("")) {
      throw new IllegalArgumentException("Invalid id provided");
    }
    for (Shape s : hashmap.keySet()) {
      if(s.getName().equals(id)) {
        hashmap.remove(s);
      }
    }
  }
  
  
  public void addTransformation(String id, Transformation t) {
    Objects.requireNonNull(t, "Object can't be null.");
    
    for (Shape s : hashmap.keySet()) {
      if(s.getName().equals(id)) {
        if (t.getTimeStart() < s.getAppears() || t.getTimeStart() > s.getDisappears()
                || t.getTimeEnd() < s.getAppears() || t.getTimeEnd() > s.getDisappears()) {
          throw new IllegalArgumentException("Time provided not within acceptable range.");
        }
        hashmap.get(s).add(t);
      }
    }
  }
  
  
  public void removeTransformation(String id, Transformation t) {
    Objects.requireNonNull(t, "Object can't be null.");
    //How do we want to remove this? by shape ID or should we have an ID for each transformation?
    //maybe create an ID for each transformation, i'm just not sure what type of id to use
    for (Shape s : hashmap.keySet()) {
      if(s.getName().equals(id)) {
        hashmap.get(s).remove(t);
      }
    }
  }
  
  
  public List<Shape> filterShapes(Predicate<Shape> p) {
    if (this.hashmap.size() == 0) {
      throw new IllegalStateException("Shapes list is empty");
    }
    Objects.requireNonNull(p, "Predicate can't be null.");
    
    List<Shape> filtered = new ArrayList<>();
    for (Shape s : hashmap.keySet()) {
      if (p.test(s.getShape())) {
        Shape sh = s.getShape().copy();
        filtered.add(sh);
      }
    }
    
    return filtered;
  }
  
  
  public void sortShapes(Comparator<Shape> comp) {
    if (this.hashmap.size() == 0) {
      throw new IllegalStateException("Shapes list is empty");
    }
    
    //TreeMap<Shape, List<Transformation>> sort = new TreeMap<>(hashmap);
    List<Shape> shapes = new ArrayList<>(hashmap.keySet());
    shapes.sort((shapeA, shapeB) -> comp.compare(shapeA.getShape(), shapeB.getShape()));
  }
  
  
  public <R> R foldShapes(BiFunction<Shape, R, R> bf, R seed) {
    if (this.hashmap.size() == 0) {
      throw new IllegalStateException("Shapes list is empty");
    }
    Objects.requireNonNull(bf, "BiFunction is null.");
    Objects.requireNonNull(seed, "Seed is null.");
    
    for (Shape t : hashmap.keySet()) {
      seed = bf.apply(t.getShape(), seed);
    }
    return seed;
  }
  
  
  public List<Transformation> filterTransformations(Predicate<Transformation> p) {
    if (this.hashmap.size() == 0) {
      throw new IllegalStateException("Transformations list is empty");
    }
    Objects.requireNonNull(p, "Predicate can't be null.");
    
    List<Transformation> filtered = new ArrayList<>();
    
    for (Shape s : hashmap.keySet()) {
      for (Transformation t : hashmap.get(s)) {
        if (p.test(t.getTransformation())) {
          Transformation tr = t.getTransformation().copy();
          filtered.add(tr);
        }
      }
    }
    
    return filtered;
  }
  
  
  //Not sure if we still need this method because each shape has it's own list of transformations
  public void sortTransformations(Comparator<Transformation> comp) {
    if (this.hashmap.size() == 0) {
      throw new IllegalStateException("Transformations list is empty");
    }
    Objects.requireNonNull(comp, "Comparator can't be null.");
    List<List<Transformation>> transformations = new ArrayList<>(hashmap.values());

  }
  
  
  
  public <R> R foldTransformations(BiFunction<Transformation, R, R> bf, R seed) {
    if (this.hashmap.size() == 0) {
      throw new IllegalStateException("Transformations list is empty");
    }
    Objects.requireNonNull(bf, "BiFunction can't be null.");
    Objects.requireNonNull(seed, "Seed can't be null.");
    
    for (Shape s : hashmap.keySet()) {
      for (Transformation t : hashmap.get(s)) {
        seed = bf.apply(t.getTransformation(), seed);
      }
    }
    return seed;
  }
  
  
  public String toString() {
    StringBuilder str = new StringBuilder();
    for (Shape s : hashmap.keySet()) {
      str.append(s.toString()).append("\n");
    }
    
    for (Shape s : hashmap.keySet()) {
      for (Transformation t : hashmap.get(s)) {
        //If change color transformation
        if (t.getTransformationType().equals("Color")) {
          String desc = "Shape " + s.getName() + " changes color from "
                  + s.getColor().toString() + " to " + t.getToColor().toString() + " from "
                  + t.getTimeStart() + " to " + t.getTimeEnd() + ".";
          str.append(desc).append("\n");
          //if move transformation
        } else if (t.getTransformationType().equals("Moves")) {
          String desc = "Shape " + s.getName() + " moves from (" + s.getPositionX()
                  + "," + s.getPositionY() + ") to (" + t.getToX()+ ","
                  + t.getToY() + ") from " + t.getTimeStart()+ " to " + t.getTimeEnd() + ".";
          str.append(desc).append("\n");
          //if scale tranformation
        } else {
          if (s.getType().equals("RECTANGLE")) {
            String desc =  "Shape " + s.getName() + " scales from Width: " + s.getX()
                    + " Height: " + s.getY() + " to Width: " + t.getToX() + " and Height: "
                    + t.getToY() + " from " + t.getTimeStart() + " to " + t.getTimeEnd() + ".";
            str.append(desc).append("\n");
          } else {
            String desc = "Shape" + s.getName() + " scales from X-Radius: " + s.getX()
                    + " Y-Radius: " + s.getY() + " to X-Radius: " + t.getToX() + " and Y-Radius: "
                    + t.getToY() + " from " + t.getTimeStart() + " to " + t.getTimeEnd() + ".";
            str.append(desc).append("\n");
          }
        }
        
      }
    }
    return "Shapes: \n\n" + str.toString().trim();
  }
  
}
