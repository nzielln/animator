import java.util.Objects;

public class Scale extends AbstractTransformation {
  private int toX;
  private int toY;
  private int timeStart;
  private int timeEnd;
  private String type;
  
  public Scale(Shape s, int toX, int toY, int timeStart, int timeEnd) {
    super(s);
    //do we need null checks here if we check in abstract?
    Objects.requireNonNull(s, "Shape can't be null");
    this.toX = toX;
    this.toY = toY;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "Scales";
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
  
  @Override
  public float getToX() {
    return this.toX;
  }
  
  @Override
  public float getToY() {
    return this.toY;
  }
  
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public Transformation copy() {
    return new Scale(this.getShape().copy(), this.toX, this.toY, this.timeStart, this.timeEnd);
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
