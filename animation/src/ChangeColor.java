import java.util.Objects;

public class ChangeColor extends AbstractTransformation {
  final Color toColor;
  final int timeStart;
  final int timeEnd;
  final String type;

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

  /**
   * Returns the color the new shape should have.
   * @return {@link Color}, color of new shape
   */
  public Color getToColor() {
    return this.toColor;
  }
  
  //OTHER------------------------------------------------------------------------------------------

  /**
   * Returns a new {@link Shape} with provided color.
   * @param toColor {@link Color} of the new shape
   * @param timeStart time transformation starts
   * @param timeEnd time transformation ends
   * @return a new shape object
   */
  public Shape changeColor(Color toColor, int timeStart, int timeEnd) {
    Objects.requireNonNull(toColor);
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Start and end times must be positive");
    }

    if (this.shape.getType().equals("RECTANGLE")) {
      return new Rectangle(this.shape.getName(), this.shape.getPositionX(),
              this.shape.getPositionY(), this.shape.getX(), this.shape.getY(),
              this.toColor.getR(), this.toColor.getG(), this.toColor.getB());
    } else if (this.shape.getType().equals("OVAL")) {
      return new Oval(this.shape.getName(), this.shape.getPositionX(),
              this.shape.getPositionY(), this.shape.getX(), this.shape.getY(),
              this.toColor.getR(), this.toColor.getG(), this.toColor.getB());
    }
    return null;
  }

  @Override
  public Transformation copy() {
    return new ChangeColor(this.getShape().copy(), this.toColor, this.timeStart, this.timeEnd);
  }

  /*
  @Override
  public boolean equals(Transformation other) {
    Objects.requireNonNull(other);

    if (this.shape.equals(other.getShape())
            && this.getToColor().equals(other.getToColor())) {
      return true;
    }
    return false;
  }*/


  @Override
  public String toString() {
    return "Shape " + this.getShape().getName() + " changes color from "
            + this.getShape().getColor().toString() + " to " + this.toColor.toString() + " from "
            + this.timeStart + " to " + this.timeEnd + ".";
  }
  
}
