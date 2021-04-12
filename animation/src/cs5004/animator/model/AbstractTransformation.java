package cs5004.animator.model;

/**
 * AbstractTransformation implements the Transformation interface and represents methods that
 * are common to all transformation classes.
 */
public abstract class AbstractTransformation implements Transformation {
  final int timeStart;
  final int timeEnd;
  final String tID;
  Shape endState;
  Shape startState;
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
    this.endState = null;
    this.startState = null;
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
  public Shape getEndState() {
    return this.endState;
    
  }
  
  @Override
  public Shape getStartState() {
    return this.startState;
    
  }
  
  @Override
  public void setEndState(Shape s) {
    this.endState = s;
  }
  
  @Override
  public void setStartState(Shape s) {
    this.startState = s;
    
  }

}
