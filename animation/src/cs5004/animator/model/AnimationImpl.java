package cs5004.animator.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Represents an AnimationImpl class for the animation program, implements Animation interface.
 */
public class AnimationImpl implements Animation {
  LinkedHashMap<Shape, List<Transformation>> hashmap;
  LinkedHashMap<String, Shape> lastest;
  int x;
  int y;
  int width;
  int height;
  
  /**
   * Constructor for the AnimationImpl, create a hashmap of Shapes and list of Transformations.
   */
  public AnimationImpl() {
    hashmap = new LinkedHashMap<>();
    lastest = new LinkedHashMap<>();
    this.x = 0;
    this.y = 0;
    this.width = 0;
    this.height = 0;
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public int getSize() {
    return hashmap.size();
  }
  
  @Override
  public int getCanvasWidth() {
    return this.width;
  }
  
  @Override
  public int getCanvasHeight() {
    return this.height;
  }
  
  @Override
  public int getCanvasX() {
    return this.x;
  }
  
  @Override
  public int getCanvasY() {
    return this.y;
  }
  
  @Override
  public int getSizeTransformations(String id) {
    if (id.equals("")) {
      throw new IllegalArgumentException("Id can't be empty string");
    }
    Objects.requireNonNull(id, "Id can't be null");
    
    for (Shape s : hashmap.keySet()) {
      if (s.getName().equals(id)) {
        return hashmap.get(s).size();
      }
      
    }
    return 0;
  }
  
  @Override
  public Shape getById(String id) {
    if (id.equals("")) {
      throw new IllegalArgumentException("Id can't be empty string");
    }
    Objects.requireNonNull(id, "Id can't be null");
    
    for (Shape s : hashmap.keySet()) {
      if (s.getName().equals(id)) {
        return s;
      }
    }
    throw new NoSuchElementException("Shape not found");
  }
  
  @Override
  public List<Shape> getByTime(int t) {
    if (t < 0) {
      throw new IllegalArgumentException("Time must be positive");
    }
    
    List<Shape> shapesAtTick = new LinkedList<>();
    
    for (Shape s : hashmap.keySet()) {
      
      List<Transformation> atTime = new LinkedList<>();
      for (Transformation tr : hashmap.get(s)) {
        if (tr.getTimeStart() <= t && t <= tr.getTimeEnd() ) {
          atTime.add(tr);
          
        }
      }
      
      if (atTime.size() > 0) {
        Shape n = getOneShape(lastest.get(s.getName()).copy(), atTime, t);
        shapesAtTick.add(n);
        lastest.put(n.getName(), n);
      } else if (s.getAppears() <= t && t <= s.getDisappears()) {
        shapesAtTick.add(lastest.get(s.getName()));
      }
    }
    
    return shapesAtTick;
  }
  
  /**
   * Applys tweening formula to provided property at provided time.
   * @param t time to tween for
   * @param a the starting property (position, size ro color)
   * @param b the ending property
   * @param ta the starting time for the property
   * @param tb the ending time for the property
   * @return int, the result of the tweening
   */
  private int tween(double t, double a, double b, double ta, double tb) {
    return (int) ((a * ((tb - t) / (tb - ta))) + (b * ((t - ta) / (tb - ta))));
  }
  
  /**
   * Generates one shape from tweening results, returns shape to getByTime.
   * @param shape a shape to apply transformation to
   * @param l a list of transformation for a shape
   * @param time the time to tween for
   * @return a shape
   */
  private Shape getOneShape(Shape shape, List<Transformation> l, int time) {
    for (Transformation t: l) {
      if (t.getTransformationType().equals("Moves")) {
        int cx = tween(time, t.getInitialX(), t.getToX(),
                t.getTimeStart(), t.getTimeEnd());
        
        int cy = tween(time, t.getInitialY(), t.getToY(),
                t.getTimeStart(), t.getTimeEnd());
        
        shape.changePosition(cx, cy);
        shape.setAppearsDisappears(time, time + 1);
      } else if (t.getTransformationType().equals("Scales")) {
        int w = tween(time, t.getInitialWidth(), t.getToWidth(),
                t.getTimeStart(), t.getTimeEnd());
        
        int h = tween(time, t.getInitialHeight(), t.getToHeight(),
                t.getTimeStart(), t.getTimeEnd());
        
        shape.changeSize(w, h);
        shape.setAppearsDisappears(time, time + 1);
      } else if (t.getTransformationType().equals("Color")) {
        Color i = t.getInitialColor();
        Color f = t.getToColor();
        int r = tween(time, i.getR(), f.getR(), t.getTimeStart(), t.getTimeEnd());
        int g = tween(time, i.getG(), f.getG(), t.getTimeStart(), t.getTimeEnd());
        int b = tween(time, i.getB(), f.getB(), t.getTimeStart(), t.getTimeEnd());
        shape.changeColor(r, g, b);
        shape.setAppearsDisappears(time, time + 1);
        
      }
    }
    
    return shape;
  }
  
  @Override
  public List<Transformation> getTransformations(String id) {
    if (id.equals("")) {
      throw new IllegalArgumentException("Id can't be empty string");
    }
    Objects.requireNonNull(id, "Id can't be null");
    
    for (Shape s : hashmap.keySet()) {
      if (s.getName().equals(id)) {
        return hashmap.get(s);
      }
    }
    throw new NoSuchElementException("Id not found");
  }
  
  @Override
  public List<Shape> getShapes() {
    return new ArrayList<>(hashmap.keySet());
  }
  
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public void canvas(int x, int y, int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Invalid inputs for canvas size.");
    }
    
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    
  }
  
  @Override
  public void addShape(Shape s, List<Transformation> l) {
    Objects.requireNonNull(s, "Shape can't be null.");
    Objects.requireNonNull(l, "Transformation list can't be null.");
    
    ArrayList<String> ids = new ArrayList<>();
    
    for (Shape sh: hashmap.keySet()) {
      ids.add(sh.getName());
    }
    
    if (ids.contains(s.getName())) {
      throw new IllegalArgumentException("ID already exists.");
    } else {
      
      hashmap.put(s, l);
      lastest.put(s.getName(), s);
    }
  }
  
  @Override
  public void removeShape(String id) {
    Objects.requireNonNull(id, "Id can't be null");
    if (hashmap.size() == 0) {
      throw new IllegalStateException("Can't remove from empty hashmap");
    } else if (id.equals("")) {
      throw new IllegalArgumentException("Invalid id provided");
    }
    
    ArrayList<String> ids = new ArrayList<>();
    
    for (Shape s: hashmap.keySet()) {
      ids.add(s.getName());
    }
    
    if (!ids.contains(id)) {
      throw new NoSuchElementException("Shape not found");
    } else {
      
      for (Shape s : hashmap.keySet()) {
        if (s.getName().equals(id)) {
          hashmap.remove(s);
          return;
        }
      }
    }
  }
  
  @Override
  public boolean validTransformation(String id, Transformation t) {
    List<Transformation> tlist = new ArrayList<>();
    for (Shape s: hashmap.keySet()) {
      if (s.getName().equals(id)) {
        tlist = hashmap.get(s);
      }
    }
    
    for (Transformation ts : tlist) {
      if (ts.sameObject(t)) {
        return false;
      } else if (ts.getTransformationType().equals(t.getTransformationType())
              && t.getTimeStart() < ts.getTimeEnd()) {
        return false;
      }
    }
    
    return true;
  }
  
  @Override
  public void addTransformation(String id, Transformation t) {
    Objects.requireNonNull(id, "Id can't be null.");
    Objects.requireNonNull(t, "Transformation can't be null.");
    
    if (id.equals("")) {
      throw new IllegalArgumentException("Id can't be empty string");
    }
    
    if (!validTransformation(id, t)) {
      throw new IllegalArgumentException("Transformation not valid.");
    }
    
    for (Shape s : hashmap.keySet()) {
      if (s.getName().equals(id)) {
        if (t.getTimeStart() < s.getAppears() || t.getTimeStart() > s.getDisappears()
                || t.getTimeEnd() < s.getAppears() || t.getTimeEnd() > s.getDisappears()) {
          throw new IllegalArgumentException("Time provided not within acceptable range.");
        }
        hashmap.get(s).add(t);
        
      }
    }
  }
  
  @Override
  public void removeTransformation(String id, Transformation t) {
    Objects.requireNonNull(id, "Id can't be null.");
    Objects.requireNonNull(t, "Transformation can't be null.");
    
    if (id.equals("")) {
      throw new IllegalArgumentException("Id can't be empty string");
    }
    
    ArrayList<String> ids = new ArrayList<>();
    
    for (Shape s: hashmap.keySet()) {
      ids.add(s.getName());
    }
    
    if (!ids.contains(id)) {
      throw new NoSuchElementException("Shape not found");
    }
    
    for (Shape s : hashmap.keySet()) {
      if (s.getName().equals(id)) {
        if (hashmap.get(s).size() == 0) {
          throw new IllegalArgumentException("Can't remove transformation from empty list");
        }
        
        if (!hashmap.get(s).contains(t)) {
          throw new NoSuchElementException("Transformation not found");
        }
        
        hashmap.get(s).remove(t);
      }
    }
  }
  
  @Override
  public String toString() {
    if (hashmap.size() == 0) {
      return "";
    }
    StringBuilder str = new StringBuilder();
    for (Shape s : hashmap.keySet()) {
      str.append(s.toString()).append("\n");
    }
    
    for (Shape s : hashmap.keySet()) {
      str.append(tranformationString(s));
    }
    return "Shapes: \n" + str.toString().trim();
  }
  
  @Override
  public String tranformationString(Shape s) {
    
    Objects.requireNonNull(s, "Shape can't be null");
    
    if (hashmap.size() == 0) {
      throw new IllegalStateException("Animation can't be empty");
    }
    
    StringBuilder str = new StringBuilder();
    DecimalFormat f = new DecimalFormat("0.0");
    
    for (Transformation t : hashmap.get(s)) {
      //If change color transformation
      if (t.getTransformationType().equals("Color")) {
        String desc = "Shape " + s.getName() + " changes color from "
                + t.getInitialColor().toString() + " to "
                + t.getToColor().toString() + " from t="
                + t.getTimeStart() + " to t=" + t.getTimeEnd() + ".";
        str.append(desc).append("\n");
        //if move transformation
      } else if (t.getTransformationType().equals("Moves")) {
        String desc = "Shape " + s.getName() + " moves from (" + f.format(t.getInitialX())
                + "," + f.format(t.getInitialY()) + ") to (" + f.format(t.getToX()) + ","
                + f.format(t.getToY()) + ") from t=" + t.getTimeStart()
                + " to t=" + t.getTimeEnd() + ".";
        str.append(desc).append("\n");
        //if scale tranformation
      } else {
        if (s.getType().equals("RECTANGLE")) {
          String desc =  "Shape " + s.getName() + " scales from Width: "
                  + f.format(t.getInitialWidth())
                  + ", Height: " + f.format(t.getInitialHeight()) + " to Width: "
                  + f.format(t.getToWidth()) + ", Height: "
                  + f.format(t.getToHeight()) + " from t=" + t.getTimeStart()
                  + " to t=" + t.getTimeEnd() + ".";
          str.append(desc).append("\n");
        } else {
          String desc = "Shape" + s.getName() + " scales from X radius: "
                  + f.format(t.getInitialWidth())
                  + ", Y radius: " + f.format(t.getInitialHeight()) + " to X radius: "
                  + f.format(t.getToWidth()) + ", Y radius: "
                  + f.format(t.getToHeight()) + " from t=" + t.getTimeStart()
                  + " to t=" + t.getTimeEnd() + ".";
          str.append(desc).append("\n");
        }
      }
    }
    
    return str.toString();
  }
  
}
