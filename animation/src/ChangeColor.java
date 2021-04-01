import java.util.Objects;

public class ChangeColor extends AbstractTransformation {
  private Color toColor;
  private int timeStart;
  private int timeEnd;
  private String type;

  public ChangeColor(Shape s, Color toColor, int timeStart, int timeEnd) {
    super(s);
    //do we need null checks here if we check in abstract?
    Objects.requireNonNull(s, "Shape can't be null");
    Objects.requireNonNull(toColor, "BiFunction can't be null.");
    this.toColor = toColor;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "Change Color";
  }
  
  @Override
  public Shape changeColor(Color toColor, int timeStart, int timeEnd) {
    Objects.requireNonNull(toColor, "toColor can't be null.");
    return null;
  }
  
  public String getTransformType() {
    return this.type;
  }
  
  @Override
  public Transformation copy() {
    return new ChangeColor(this.getShape(), this.toColor, this.timeStart, this.timeEnd);
  }
  
  public int getTimeStart() {
    return this.timeStart;
  }
  
  public int getTimeEnd() {
    return this.timeEnd;
  }
  
  @Override
  public String toString() {
    return "Shape" + this.getShape().getName() + "changes color from "
            + this.getShape().getColor().toString() + "to " + this.toColor.toString() + "from "
            + this.timeStart + "to " + this.timeEnd + ".\n";
  }
  
}
