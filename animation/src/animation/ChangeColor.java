package animation;

import java.util.Objects;

/**
 * Represents a ChangeColor transformation, extends methods from the AbstractTransformation.
 */
public class ChangeColor extends AbstractTransformation {
  final Color toColor;
  Color intialColor;
  
  /**
   * Constructor calls the AbstractTransformation super class, takes in the color to change to.
   * @param toColor (Color) to change to
   * @param timeStart (int) start time for the transformation
   * @param timeEnd (int) start time for the transformation
   */
  public ChangeColor(String tid, Color toColor, int timeStart, int timeEnd) {
    super(tid, timeStart, timeEnd);
    Objects.requireNonNull(toColor, "Color object can't be null.");
    
    this.toColor = toColor;
    this.intialColor = null;
    super.type = "Color";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public Color getToColor() {
    return this.toColor;
  }
  
  @Override
  public Color getInitialColor() {
    return this.intialColor;
  }
  
  @Override
  public void setInitialColor(Color c) {
    this.intialColor = c;
  }
  
  
  @Override
  public boolean sameObject(Transformation other) {
    return (this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toColor == other.getToColor() && this.tID.equals(other.getID()));
  }
  
}
