public class Move extends AbstractTransformation {
  private float toX;
  private float toY;
  private int timeStart;
  private int timeEnd;
  private String type;
  
  
  public Move(Shape s, float toX, float toY, int timeStart, int timeEnd) {
    super(s);
    this.toX = toX;
    this.toY = toY;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "Moves";
  }
  
  @Override
  public Shape moveShape(float toX, float toY, int timeStart, int timeEnd) {
    return null;
  }
  
  public String getTransformType() {
    return this.type;
  }
  
  @Override
  public String toString() {
    return "Shape" + this.getShape().getName() + "moves from (" + this.getShape().getPositionX()
            + "," + this.getShape().getPositionY() + ") to (" + this.toX + ","
            + this.toY + ") from " + this.timeStart + "to " + this.timeEnd + ".\n";
    
    
  }
}
