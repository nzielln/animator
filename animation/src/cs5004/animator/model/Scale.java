package cs5004.animator.model;

/**
 * Represents a Scale transformation, extends methods from the AbstractTransformation.
 */
public class Scale extends AbstractTransformation {
  final int toX;
  final int toY;
  int initialX;
  int initialY;
  
  /**
   * Constructor calls the AbstractTransformation super class, takes in the color to change to.
   * @param toX (int) x-radius or width to change into
   * @param toY (int) y-radius or length to change into
   * @param timeStart (int) start time for the transformation
   * @param timeEnd (int) start time for the transformation
   */
  public Scale(String tid, int toX, int toY, int timeStart, int timeEnd) {
    super(tid, timeStart, timeEnd);
    if (toX <= 0 || toY <= 0) {
      throw new IllegalArgumentException("Length must be positive integer or 0.");
    }
    
    this.toX = toX;
    this.toY = toY;
    this.initialX = 0;
    this.initialY = 0;
    super.type = "Scales";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public int getToX() {
    return this.toX;
  }
  
  @Override
  public int getToY() {
    return this.toY;
  }
  
  public int getInitialX() {
    return this.initialX;
  }
  
  public int getInitialY() {
    return this.initialY;
  }
  
  public void setInitialX(int x) {
    this.initialX = x;
  }
  
  public void setInitialY(int y) {
    this.initialY = y;
  }
  
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public boolean sameObject(Transformation other) {
    return (this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toX == other.getToX() && this.toY == other.getToY()
            && this.tID.equals(other.getID()));
  }
  
}
