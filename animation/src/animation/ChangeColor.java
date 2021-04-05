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
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public Shape changeColor(Shape shape, Color toColor, int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Start and end times must be positive");
    }
    
    if (shape.getType().equals("RECTANGLE")) {
      return new Rectangle(shape.getName(), shape.getPositionX(),
              shape.getPositionY(), shape.getX(), shape.getY(),
              this.toColor.getR(), this.toColor.getG(), this.toColor.getB());
    } else if (shape.getType().equals("OVAL")) {
      return new Oval(shape.getName(), shape.getPositionX(),
              shape.getPositionY(), shape.getX(), shape.getY(),
              this.toColor.getR(), this.toColor.getG(), this.toColor.getB());
    }
    return null;
  }
  
  @Override
  public boolean equals(Transformation other) {
    return (this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toColor == other.getToColor());
  }
  
}
