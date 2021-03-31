public class ChangeColor extends AbstractTransformation {
  private Color toColor;
  private int timeStart;
  private int timeEnd;
  
  public ChangeColor(ShapeNode s, int timeStart, int timeEnd) {
    super(s);
    this.timeStart = timeStart;
    this.timeEnd = timeStart;
  }
  
  public void changeColor(Color toColor, int timeStart, int timeEnd) {
    
    
    //add to List<Transformation> after making transformation
    this.getShape().getTransformations().add(this);
  }
  
  
}
