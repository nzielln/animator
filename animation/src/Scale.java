public class Scale extends AbstractTransformation {
  private int toX;
  private int toY;
  private int timeStart;
  private int timeEnd;
  
  
  public Scale(ShapeNode s, int toX, int toY, int timeStart, int timeEnd) {
    super(s);
    this.toX = toX;
    this.toY = toY;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
  }
  
  public void scaleShape(int toX, int toY, int timeStart, int timeEnd) {
  
    //add to List<Transformation> after making transformation
    this.getShape().getTransformations().add(this);
    
  }
}
