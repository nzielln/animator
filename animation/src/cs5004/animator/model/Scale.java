package cs5004.animator.model;

/**
 * Represents a Scale transformation, extends methods from the AbstractTransformation.
 */
public class Scale extends AbstractTransformation {
  final int toWidth;
  final int toHeight;

  
  /**
   * Constructor calls the AbstractTransformation super class, takes in the color to change to.
   * @param toX (int) x-radius or width to change into
   * @param toY (int) y-radius or length to change into
   * @param timeStart (int) start time for the transformation
   * @param timeEnd (int) start time for the transformation
   */
  public Scale(int toX, int toY, int timeStart, int timeEnd) {
    super(timeStart, timeEnd);
    if (toX <= 0 || toY <= 0) {
      throw new IllegalArgumentException("Length must be positive integer or 0.");
    }
    
    this.toWidth = toX;
    this.toHeight = toY;
    super.type = "Scales";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public int getToWidth() {
    return this.toWidth;
  }
  
  @Override
  public int getToHeight() {
    return this.toHeight;
  }

  
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public boolean sameObject(Transformation other) {
    return (this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toWidth == other.getToWidth() && this.toHeight == other.getToHeight());
           
  }
  
}
