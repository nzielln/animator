package cs5004.animator.model;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Represents an AnimationImpl class for the animation program, implements Animation interface.
 */
public class AnimationImpl implements Animation {
  LinkedHashMap<Shape, List<Transformation>> hashmap;
  int x;
  int y;
  int width;
  int height;
  
  /**
   * Constructor for the AnimationImpl, create a hashmap of Shapes and list of Transformations.
   */
  public AnimationImpl() {
    hashmap = new LinkedHashMap<>();
    this.x = 0;
    this.y = 0;
    this.width = 0;
    this.height = 0;
  }
  
  public static void main(String[] args) {
    Color ra = new Color(234, 44, 56);
    ra.getRGB();
    System.out.println(ra.getRGB());
    
    Color r = new Color(ra.getRGB());
    System.out.println(r.getRed());
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
    
    List<Shape> currentShapesAtTick = new ArrayList<>();
    List<Shape> shapes = new ArrayList<>();
    
    for (Shape s: hashmap.keySet()) {
      if (t >= s.getAppears() && t <= s.getDisappears()) {
        shapes.add(s);
      }
    }
    
    for (Shape s: shapes) {
      String name = s.getName();
      String type = s.getType();
      int positionX = s.getPositionX();
      int positionY = s.getPositionY();
      int width = s.getX();
      int height = s.getY();
      cs5004.animator.model.Color color = s.getColor();
      
      for (Transformation tr : hashmap.get(s)) {
        if (t >= tr.getTimeStart() && t <= tr.getTimeEnd()) {
          if (tr.getTransformationType().equals("Moves")) {
            int x = tr.getInitialX();
            int y = tr.getInitialY();
            int finalX = tr.getToX();
            int finalY = tr.getToY();
            
            int newX = x * ((tr.getTimeEnd() - t) / (tr.getTimeEnd() - tr.getTimeStart()))
                    + finalX * ((t - tr.getTimeStart()) / (tr.getTimeEnd() - tr.getTimeStart()));
            
            int newY = y * ((tr.getTimeEnd() - t) / (tr.getTimeEnd() - tr.getTimeStart()))
                    + finalY * ((t - tr.getTimeStart()) / (tr.getTimeEnd() - tr.getTimeStart()));
            
            positionX = newX;
            positionY = newY;
            
          } else if (tr.getTransformationType().equals("Scales")) {
            
            int x = tr.getInitialX();
            int y = tr.getInitialY();
            int finalX = tr.getToX();
            int finalY = tr.getToY();
            
            int newX = x * ((tr.getTimeEnd() - t) / (tr.getTimeEnd() - tr.getTimeStart()))
                    + finalX * ((t - tr.getTimeStart()) / (tr.getTimeEnd() - tr.getTimeStart()));
            
            int newY = y * ((tr.getTimeEnd() - t) / (tr.getTimeEnd() - tr.getTimeStart()))
                    + finalY * ((t - tr.getTimeStart()) / (tr.getTimeEnd() - tr.getTimeStart()));
            
            width = newX;
            height = newY;
            
          } else {
            Color initialColor = new Color(tr.getInitialColor().getR(), tr.getInitialColor().getG(),
                    tr.getInitialColor().getB());
            Color finalColor = new Color(tr.getToColor().getR(), tr.getToColor().getG(),
                    tr.getToColor().getB());
            
            int newColor = initialColor.getRGB() * ((tr.getTimeEnd() - t)
                    / (tr.getTimeEnd() - tr.getTimeStart()))
                    + finalColor.getRGB() * ((t - tr.getTimeStart())
                    / (tr.getTimeEnd() - tr.getTimeStart()));
            
            Color nc = new Color(newColor);
            
            color = new cs5004.animator.model.Color(nc.getRed(),
                    nc.getGreen(), nc.getBlue());
          }
        }
      }
      
      if (type.equals("RECTANGLE")) {
        Shape newRect = new Rectangle(name, type);
        newRect.setProperties(positionX, positionY, width, height, color.getR(), color.getG(), color.getB());
        currentShapesAtTick.add(newRect);
      } else if (type.equals("OVAL")) {
        Shape newOval = new Oval(name, type);
        newOval.setProperties(positionX, positionY, width, height, color.getR(), color.getG(), color.getB());
        currentShapesAtTick.add(newOval);
      }
      
    }
    
    return currentShapesAtTick;
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
    if (x < 0 || y < 0 || width <= 0 || height <= 0) {
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
      if (ts.equals(t)) {
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
      throw new IllegalArgumentException("Transformation not vaid.");
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
        
        ArrayList<String>  tids = new ArrayList<>();
        for (Transformation tr: hashmap.get(s)) {
          tids.add(tr.getID());
        }
        
        if (!tids.contains(t.getID())) {
          throw new NoSuchElementException("Transformation not found");
        }
        
        hashmap.get(s).remove(t);
      }
    }
  }
  
  private  HashMap<String, Shape> filterTransformations(Predicate<Shape> p, HashMap<String, Shape> l) {
    Objects.requireNonNull(p, "Predicate can't be null.");
    
    HashMap<String, Shape> filtered = new HashMap<>();
    
    for (Shape s : l.values()) {
      if (p.test(s)) {
        for (Map.Entry<String, Shape> e : l.entrySet()) {
          if (e.getValue().equals(s)) {
            filtered.put(e.getKey(), s);
          }
        }
      }
      
    }
    
    return filtered;
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
    StringBuilder str = new StringBuilder();
    DecimalFormat f = new DecimalFormat("0.0");
    
    for (Transformation t : hashmap.get(s)) {
      //If change color transformation
      if (t.getTransformationType().equals("Color")) {
        String desc = "Shape " + s.getName() + " changes color from "
                + s.getColor().toString() + " to " + t.getToColor().toString() + " from t="
                + t.getTimeStart() + " to t=" + t.getTimeEnd() + ".";
        str.append(desc).append("\n");
        //if move transformation
      } else if (t.getTransformationType().equals("Moves")) {
        String desc = "Shape " + s.getName() + " moves from (" + f.format(s.getPositionX())
                + "," + f.format(s.getPositionY()) + ") to (" + f.format(t.getToX()) + ","
                + f.format(t.getToY()) + ") from t=" + t.getTimeStart() + " to t=" + t.getTimeEnd() + ".";
        str.append(desc).append("\n");
        //if scale tranformation
      } else {
        if (s.getType().equals("RECTANGLE")) {
          String desc =  "Shape " + s.getName() + " scales from Width: " + f.format(s.getX())
                  + ", Height: " + f.format(s.getY()) + " to Width: " + f.format(t.getToX()) + ", Height: "
                  + f.format(t.getToY()) + " from t=" + t.getTimeStart() + " to t=" + t.getTimeEnd() + ".";
          str.append(desc).append("\n");
        } else {
          String desc = "Shape" + s.getName() + " scales from X radius: " + f.format(s.getX())
                  + ", Y radius: " + f.format(s.getY()) + " to X radius: " + f.format(t.getToX()) + ", Y radius: "
                  + f.format(t.getToY()) + " from t=" + t.getTimeStart() + " to t=" + t.getTimeEnd() + ".";
          str.append(desc).append("\n");
        }
      }
    }
    
    return str.toString();
  }
  
}
