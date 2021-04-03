import java.util.Objects;

public class Scale extends AbstractTransformation {
  final int toX;
  final int toY;
  final int timeStart;
  final int timeEnd;
  
  public Scale(Shape s, int toX, int toY, int timeStart, int timeEnd) {
    super(s, timeStart, timeEnd);
    //do we need null checks here if we check in abstract?
    Objects.requireNonNull(s, "Shape can't be null");
    this.toX = toX;
    this.toY = toY;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    super.type = "Scales";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
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
  
  /*@Override
  public boolean equals(Transformation other) {
    return false;
  }*/
  
  
  @Override
  public String toString() {
    if (this.getShape().getType().equals("RECTANGLE")) {
      return "Shape " + this.getShape().getName() + " scales from Width: " + this.getShape().getX()
              + " Height: " + this.getShape().getY() + " to Width: " + this.toX + " and Height: "
              + this.toY + " from " + this.timeStart + " to " + this.timeEnd + ".\n";
    } else {
      return "Shape" + this.getShape().getName() + " scales from X-Radius: " + this.getShape().getX()
              + " Y-Radius: " + this.getShape().getY() + " to X-Radius: " + this.toX + " and Y-Radius: "
              + this.toY + " from " + this.timeStart + " to " + this.timeEnd + ".";
    }
    
  }
}
