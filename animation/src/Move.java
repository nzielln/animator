public class Move extends AbstractTransformation {
  private float toX;
  private float toY;
  private int timeStart;
  private int timeEnd;
  
  
  public Move(ShapeNode s, float toX, float toY, int timeStart, int timeEnd) {
    super(s);
    this.toX = toX;
    this.toY = toY;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
  }
  
  public void moveShape(float toX, float toY, int timeStart, int timeEnd) {
    
    //add to List<Transformation> after making transformation
    this.getShape().getTransformations().add(this);
  }
}
