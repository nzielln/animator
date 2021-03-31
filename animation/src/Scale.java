public class Scale extends AbstractTransformation {
  private int toX;
  private int toY;
  private int timeStart;
  private int timeEnd;
  private String type;
  
  public Scale(Shape s, int toX, int toY, int timeStart, int timeEnd) {
    super(s);
    this.toX = toX;
    this.toY = toY;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "Scales";
  }
  
  @Override
  public Shape scaleShape(float toX, float toY, int timeStart, int timeEnd) {
    return null;
  }
  
  public String getTransformType() {
    return this.type;
  }
  
  @Override
  public String toString() {
    if (this.getShape().getType().equals("RECTANGLE")) {
      return "Shape" + this.getShape().getName() + "scales from Width: " + this.getShape().getX()
              + "Height: " + this.getShape().getY() + "to Width: " + this.toX + "and Height: "
              + this.toY + "from " + this.timeStart + "to " + this.timeEnd + ".\n";
    } else {
      return "Shape" + this.getShape().getName() + "scales from X-Radius: " + this.getShape().getX()
              + "Y-Radius: " + this.getShape().getY() + "to X-Radius: " + this.toX + "and Y-Radius: "
              + this.toY + "from " + this.timeStart + "to " + this.timeEnd + ".\n";
    }
  
  }
}
