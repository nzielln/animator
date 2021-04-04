import java.util.Objects;

public class Scale extends AbstractTransformation {
  final int toX;
  final int toY;
  final int timeStart;
  final int timeEnd;
  
  public Scale(int toX, int toY, int timeStart, int timeEnd) {
    super(timeStart, timeEnd);

    if (toX <= 0 || toY <= 0) {
      throw new IllegalArgumentException("Length must be positive integer or 0.");
    }
    
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
    return new Scale(this.toX, this.toY, this.timeStart, this.timeEnd);
  }
  
  
  @Override
  public boolean equals(Transformation other) {
    return (this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toX == other.getToX() && this.toY == other.getToY());
  }
  
}
