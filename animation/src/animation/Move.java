package animation;

/**
 * Represents a Move transformation, extends methods from the AbstractTransformation.
 */
public class Move extends AbstractTransformation {
  final float toX;
  final float toY;
  
  /**
   * Constructor calls the AbstractTransformation super class, takes in the color to change to.
   * @param toX (float) x positon to move to
   * @param toY (float) y position to move to
   * @param timeStart (int) start time for the transformation
   * @param timeEnd (int) start time for the transformation
   */
  public Move(String tid, float toX, float toY, int timeStart, int timeEnd) {
    super(tid, timeStart, timeEnd);
    if (toX < 0 || toY < 0) {
      throw new IllegalArgumentException("Coordinates points must be greater than or equal to 0.");
    }
    
    this.toX = toX;
    this.toY = toY;
    super.type = "Moves";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public float getToX() {
    return this.toX;
  }
  
  @Override
  public float getToY() {
    return this.toY;
  }
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public boolean equals(Transformation other) {
    return (this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toX == other.getToX() && this.toY == other.getToY());
  }
}
