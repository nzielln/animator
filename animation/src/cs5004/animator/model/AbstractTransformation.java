package cs5004.animator.model;

import jdk.jshell.spi.ExecutionControl;

/**
 * AbstractTransformation implements the Transformation interface and represents methods that
 * are common to all transformation classes.
 */
public abstract class AbstractTransformation implements Transformation {
  final int timeStart;
  final int timeEnd;
  final String tID;
  String type;
  
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
  
  //SETTERS----------------------------------------------------------------------------------------
  @Override
  public void setInitialX(int x) {
  }
  
  @Override
  public void setInitialY(int y) {
  }
  
  @Override
  public void setInitialColor(Color c) {
  }
  
  

}
