package cs5004.animator.model;

import java.util.Objects;

/**
 * Represents a ChangeColor transformation, extends methods from the AbstractTransformation.
 */
public class ChangeColor extends AbstractTransformation {
  final Color toColor;
  
  /**
   * Constructor calls the AbstractTransformation super class, takes in the color to change to.
   * @param toColor (Color) to change to
   * @param timeStart (int) start time for the transformation
   * @param timeEnd (int) start time for the transformation
   */
  public ChangeColor(Color toColor, int timeStart, int timeEnd) {
    super(timeStart, timeEnd);
    Objects.requireNonNull(toColor, "Color object can't be null.");
    
    this.toColor = toColor;
    super.type = "Color";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public Color getToColor() {
    return this.toColor;
  }
  
  @Override
  public boolean sameObject(Transformation other) {
    return (this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toColor == other.getToColor());
  }
  
}
