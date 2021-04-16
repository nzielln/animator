package cs5004.animator.model;

import java.util.HashMap;

/**
 * AbstractTransformation implements the Transformation interface and represents methods that
 * are common to all transformation classes.
 */
public abstract class AbstractTransformation implements Transformation {
  final int timeStart;
  final int timeEnd;
  final String tID;
  String type;
  HashMap<String, Integer> currentState;
  Shape shape;
  
  /**
   * The constructor takes the start and end time for the transformation, initializes type to null.
   * @param timeStart (int) transformation start time
   * @param timeEnd (int) transformation end time
   * @param tID (String) Transformation id
   * @throws IllegalArgumentException is timeStart or timeEnd are less than 0.
   * @throws IllegalArgumentException if tID is null or empty string
   */
  public AbstractTransformation(String tID, int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Time must be a positive integer.");
    } else if (tID == null || tID.equals("")) {
      throw new IllegalArgumentException("Transformation id can't be null or empty string");
    }
    
    this.tID = tID;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = null;
    this.currentState = new HashMap<>();
    this.shape = null;
  }
  
  //GETTER-----------------------------------------------------------------------------------------
  @Override
  public Transformation getTransformation() {
    return this;
  }
  
  @Override
  public String getID() {
    return this.tID;
  }
  
  @Override
  public String getTransformationType() {
    return this.type;
  }
  
  @Override
  public int getToX() {
    return 0;
  }
  
  @Override
  public int getToY() {
    return 0;
  }
  
  @Override
  public int getToWidth() {
    return 0;
  }
  
  @Override
  public int getToHeight() {
    return 0;
  }
  
  @Override
  public int getTimeStart() {
    return this.timeStart;
  }
  
  @Override
  public int getTimeEnd() {
    return this.timeEnd;
  }
  
  @Override
  public Color getToColor() {
    return null;
  }
  
  @Override
  public Color getInitialColor() {
    return null;
  }
  
  @Override
  public int getInitialX() {
    return 0;
  }
  
  @Override
  public int getInitialY() {
    return 0;
  }
  
  @Override
  public int getInitialWidth() {
    return 0;
  }
  
  @Override
  public int getInitialHeight() {
    return 0;
  }
  
  @Override
  public Shape getShape() {
    return this.shape;
  }
  
  //SETTERS----------------------------------------------------------------------------------------
  @Override
  public void setInitialX(int x) {
  }
  
  @Override
  public void setInitialY(int y) {
  }
  
  @Override
  public void setInitialWidth(int w) {
  }
  
  @Override
  public void setInitialHeight(int h) {
  }
  
  @Override
  public void setInitialColor(Color c) {
  }
  
  @Override
  public void populateHashmap(int x, int y, int w, int h, int app, int dis, int r, int g, int b) {
    if (w <= 0 || h <= 0) {
      throw new IllegalArgumentException("Length must be positive integer or 0.");
    } else if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Coordinates points must be greater than or equal to 0.");
    } else if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("Color values must be withing the range of 0 and 255.");
    } else if (app < 0 || dis < 0 || app > dis) {
      throw new IllegalArgumentException("Time values must be greater than 0, "
              + "disappear can't be less than appear.");
    }
    
    this.currentState.put("x", x);
    this.currentState.put("y", y);
    this.currentState.put("w", w);
    this.currentState.put("h", h);
    this.currentState.put("appears", app);
    this.currentState.put("disappears", dis);
    this.currentState.put("r", r);
    this.currentState.put("g", g);
    this.currentState.put("b", b);
  
  }
  
  @Override
  public void setShape(String name, String type, int x, int y, int w, int h, int r, int g, int b) {
    if (type.equals("Ellipse")) {
      Shape sh = new Ellipse(name, type.toUpperCase());
      sh.setProperties(x, y, w, h, r, g, b);
      sh.setAppears(this.timeStart);
      sh.setDisappears(this.timeEnd);
      this.shape = sh;
    } else {
      Shape sh = new Rectangle(name, type.toUpperCase());
      sh.setProperties(x, y, w, h, r, g, b);
      sh.setAppears(this.timeStart);
      sh.setDisappears(this.timeEnd);
      this.shape = sh;
      
    }
    
  }
  
  @Override
  public HashMap<String, Integer> getState() {
    return this.currentState;
  }
  

}
