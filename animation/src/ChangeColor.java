import java.util.Objects;

public class ChangeColor extends AbstractTransformation {
  final Color toColor;
  final int timeStart;
  final int timeEnd;

  public ChangeColor(Color toColor, int timeStart, int timeEnd) {
    super(timeStart, timeEnd);
    //do we need null checks here if we check in abstract?
    Objects.requireNonNull(toColor, "BiFunction can't be null.");
    this.toColor = toColor;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    super.type = "Color";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public Color getToColor() {
    return this.toColor;
  }
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public Transformation copy() {
    return new ChangeColor(this.toColor, this.timeStart, this.timeEnd);
  }
  
  @Override
  public boolean equals(Transformation other) {
    return (this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toColor == other.getToColor());
  }
  
}
