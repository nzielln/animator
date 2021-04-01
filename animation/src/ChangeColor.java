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
  
  //This is weird, it's forcing me to call these methods but I don't think i need to
  @Override
  public float getToX() {
    return 0;
  }
  
  @Override
  public float getToY() {
    return 0;
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
  public Shape changeColor(Color toColor, int timeStart, int timeEnd) {
    Objects.requireNonNull(toColor, "toColor can't be null.");
    return null;
  }
  
  @Override
  public String toString() {
    return "Shape" + this.getShape().getName() + "changes color from "
            + this.getShape().getColor().toString() + "to " + this.toColor.toString() + "from "
            + this.timeStart + "to " + this.timeEnd + ".\n";
  }
  
}
