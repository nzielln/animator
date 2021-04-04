import java.util.Objects;

public class ChangeColor extends AbstractTransformation {
  final Color toColor;
  final int timeStart;
  final int timeEnd;

  public ChangeColor(Shape s, Color toColor, int timeStart, int timeEnd) {
    super(s, timeStart, timeEnd);
    //do we need null checks here if we check in abstract?
    Objects.requireNonNull(s, "Shape can't be null");
    Objects.requireNonNull(toColor, "BiFunction can't be null.");
    this.toColor = toColor;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    super.type = "Change Color";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
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
  public boolean equals(Transformation other) {
    return (this.shape.equals(other.getShape())
            && this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toColor == other.getToColor());
  }
  
  @Override
  public String toString() {
    return "Shape " + this.getShape().getName() + " changes color from "
            + this.getShape().getColor().toString() + " to " + this.toColor.toString() + " from "
            + this.timeStart + " to " + this.timeEnd + ".";
  }
  
}
