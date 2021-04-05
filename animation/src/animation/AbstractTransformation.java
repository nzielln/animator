package animation;
public abstract class AbstractTransformation implements Transformation {
  final int timeStart;
  final int timeEnd;
  String type;
  
  /**
   *
   * @param timeStart
   * @param timeEnd
   */
  public AbstractTransformation(int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Time must be a positive integer.");
    }
    
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
  public String getTransformationType() {
    return this.type;
  }
  
  @Override
  public float getToX() {
    return 0;
  }
  
  @Override
  public float getToY() {
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
  
  
  
}
