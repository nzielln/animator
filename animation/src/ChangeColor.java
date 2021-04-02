import java.util.Objects;

public class ChangeColor extends AbstractTransformation {
  private final Color toColor;
  private final int timeStart;
  private final int timeEnd;
  private final String type;

  public ChangeColor(Shape s, Color toColor, int timeStart, int timeEnd) {
    super(s);
    //do we need null checks here if we check in abstract?
    Objects.requireNonNull(s, "Shape can't be null");
    Objects.requireNonNull(toColor, "New color can't be null.");

    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Time start and end must be positive");
    }

    this.toColor = toColor;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "Change Color";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public String getTransformationType() {
    return this.type;
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
    return this.toColor;
  }
  
  //OTHER------------------------------------------------------------------------------------------

  @Override
  public Transformation copy() {
    return new ChangeColor(this.getShape().copy(), this.toColor, this.timeStart, this.timeEnd);
  }
  
  
  @Override
  public String toString() {
    return "Shape " + this.getShape().getName() + " changes color from "
            + this.getShape().getColor().toString() + " to " + this.toColor.toString() + " from "
            + this.timeStart + " to " + this.timeEnd + ".";
  }
  
}
