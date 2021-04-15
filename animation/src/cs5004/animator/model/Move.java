package cs5004.animator.model;

/**
 * Represents a Move transformation, extends methods from the AbstractTransformation.
 */
public class Move extends AbstractTransformation {
  final int toX;
  final int toY;
  int initialX;
  int initialY;
  
  /**
   * Constructor calls the AbstractTransformation super class, takes in the color to change to.
   * @param toX (float) x positon to move to
   * @param toY (float) y position to move to
   * @param timeStart (int) start time for the transformation
   * @param timeEnd (int) start time for the transformation
   */
  public Move(String tid, int toX, int toY, int timeStart, int timeEnd) {
    super(tid, timeStart, timeEnd);
    if (toX < 0 || toY < 0) {
      throw new IllegalArgumentException("Coordinates points must be greater than or equal to 0.");
    }
    
    this.toX = toX;
    this.toY = toY;
    this.initialX = 0;
    this.initialY = 0;
    super.type = "Moves";
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
  
  @Override
  public void setInitialX(int x) {
    if (x < 0) {
      throw new IllegalArgumentException("Coordinates points must be greater than or equal to 0.");
    }
    
    this.initialX = x;
  }
  
  @Override
  public void setInitialY(int y) {
    if (y < 0) {
      throw new IllegalArgumentException("Coordinates points must be greater than or equal to 0.");
    }
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
