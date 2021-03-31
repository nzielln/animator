public class Move extends AbstractTransformation {
  private float toX;
  private float toY;
  private int timeStart;
  private int timeEnd;
  private String type;
  
  
  public Move(ShapeNode s, float toX, float toY, int timeStart, int timeEnd) {
    super(s);
    this.toX = toX;
    this.toY = toY;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "Moves";
  }
  
  @Override
  public ShapeNode moveShape(float toX, float toY, int timeStart, int timeEnd) {
    return null;
  }
  
  public String getTransformType() {
    return this.type;
  }
}
