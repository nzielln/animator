import java.util.Objects;

public class Move extends AbstractTransformation {
  final float toX;
  final float toY;
  final int timeStart;
  final int timeEnd;
  
  public Move(Shape s, float toX, float toY, int timeStart, int timeEnd) {
    super(s, timeStart, timeEnd);

    if (toX < 0 || toY < 0) {
      throw new IllegalArgumentException("Coordinates points must be greater than or equal to 0.");
    }
    
    this.toX = toX;
    this.toY = toY;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    super.type = "Moves";
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
  
  //Should we return a Transformation or should we return a new Shape?
  @Override
  public Transformation copy() {
    return new Move(this.getShape().copy(), this.toX, this.toY, this.timeStart, this.timeEnd);
  }
  
  @Override
  public boolean equals(Transformation other) {
    return (this.shape.equals(other.getShape())
            && this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toX == other.getToX() && this.toY == other.getToY());
  }
  
  @Override
  public String toString() {
    return "Shape " + this.getShape().getName() + " moves from (" + this.getShape().getPositionX()
            + "," + this.getShape().getPositionY() + ") to (" + this.toX + ","
            + this.toY + ") from " + this.timeStart + " to " + this.timeEnd + ".";
  }
}
