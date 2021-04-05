package animation;

import java.util.Objects;

public class ChangeColor extends AbstractTransformation {
  final Color toColor;

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
  public boolean equals(Transformation other) {
    return (this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toColor == other.getToColor());
  }
  
}
