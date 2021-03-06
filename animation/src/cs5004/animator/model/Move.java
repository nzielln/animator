package cs5004.animator.model;

/**
 * Represents a Move transformation, extends methods from the AbstractTransformation.
 */
public class Move extends AbstractTransformation {
  final int toX;
  final int toY;
  
  /**
   * Constructor calls the AbstractTransformation super class, takes in the color to change to.
   * @param toX (float) x positon to move to
   * @param toY (float) y position to move to
   * @param timeStart (int) start time for the transformation
   * @param timeEnd (int) start time for the transformation
   */
  public Move(int toX, int toY, int timeStart, int timeEnd) {
    super(timeStart, timeEnd);
    
    this.toX = toX;
    this.toY = toY;
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
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public boolean sameObject(Transformation other) {
    return (this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toX == other.getToX() && this.toY == other.getToY());
  }
}
