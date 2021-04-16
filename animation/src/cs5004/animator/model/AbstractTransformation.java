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
  Shape initialshape;
  Shape finalshape;
  
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
    this.initialshape = null;
    this.finalshape = null;
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
    return this.initialshape.getColor();
  }
  
  @Override
  public int getInitialX() {
    return this.initialshape.getPositionX();
  }
  
  @Override
  public int getInitialY() {
    return this.initialshape.getPositionY();
  }
  
  @Override
  public int getInitialWidth() {
    return this.initialshape.getWidth();
  }
  
  @Override
  public int getInitialHeight() {
    return this.initialshape.getHeight();
  }
  
  @Override
  public Shape getInitialshape() {
    return this.initialshape;
  }
  
  @Override
  public Shape getFinalshape() {
    return this.finalshape;
  }
  
  
  //SETTERS----------------------------------------------------------------------------------------
  
  @Override
  public void setFinal(String name, String type, int x, int y, int w, int h, int r, int g, int b) {
    if (type.equals("Ellipse")) {
      Shape sh = new Ellipse(name, type.toUpperCase());
      sh.setProperties(x, y, w, h, r, g, b);
      sh.setAppears(this.timeStart);
      sh.setDisappears(this.timeEnd);
      this.finalshape = sh;
    } else {
      Shape sh = new Rectangle(name, type.toUpperCase());
      sh.setProperties(x, y, w, h, r, g, b);
      sh.setAppears(this.timeStart);
      sh.setDisappears(this.timeEnd);
      this.finalshape = sh;
      
    }
    
  }
  
  @Override
  public void setInitial(String name, String type, int x, int y, int w, int h, int r, int g, int b) {
    if (type.equalsIgnoreCase("Ellipse")) {
      Shape sh = new Ellipse(name, type.toUpperCase());
      sh.setProperties(x, y, w, h, r, g, b);
      sh.setAppears(this.timeStart);
      sh.setDisappears(this.timeEnd);
      this.initialshape = sh;
    } else {
      Shape sh = new Rectangle(name, type.toUpperCase());
      sh.setProperties(x, y, w, h, r, g, b);
      sh.setAppears(this.timeStart);
      sh.setDisappears(this.timeEnd);
      this.initialshape = sh;
      
    }
    
  }

}
