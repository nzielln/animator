public class ChangeColor extends AbstractTransformation {
  private Color toColor;
  private int timeStart;
  private int timeEnd;
  private String type;
  private Color tocolor;
  
  public ChangeColor(Shape s, Color toColor, int timeStart, int timeEnd) {
    super(s);
    this.tocolor = toColor;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "Change Color";
  }
  
  @Override
  public Shape changeColor(Color toColor, int timeStart, int timeEnd) {
    return null;
  }
  
  public String getTransformType() {
    return this.type;
  }
  
  @Override
  public String toString() {
    return "Shape" + this.getShape().getName() + "changes color from "
            + this.getShape().getColor().toString() + "to " + this.toColor.toString() + "from "
            + this.timeStart + "to " + this.timeEnd + ".\n";
  }
  
}
