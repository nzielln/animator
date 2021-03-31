public class ChangeColor extends AbstractTransformation {
  private Color toColor;
  private int timeStart;
  private int timeEnd;
  private String type;
  
  public ChangeColor(ShapeNode s, int timeStart, int timeEnd) {
    super(s);
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "Change Color";
  }
  
  @Override
  public ShapeNode changeColor(Color toColor, int timeStart, int timeEnd) {
    return null;
  }
  
  public String getTransformType() {
    return this.type;
  }
  
}
