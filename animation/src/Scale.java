public class Scale extends AbstractTransformation {
  private int toX;
  private int toY;
  private int timeStart;
  private int timeEnd;
  private String type;
  
  public Scale(ShapeNode s, int toX, int toY, int timeStart, int timeEnd) {
    super(s);
    this.toX = toX;
    this.toY = toY;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "Scales";
  }
  
  @Override
  public ShapeNode scaleShape(float toX, float toY, int timeStart, int timeEnd) {
    return null;
  }
  
  public String getTransformType() {
    return this.type;
  }
}
