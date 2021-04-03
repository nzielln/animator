import java.util.Objects;

public class Move extends AbstractTransformation {
  final float toX;
  final float toY;
  final int timeStart;
  final int timeEnd;
  
  public Move(Shape s, float toX, float toY, int timeStart, int timeEnd) {
    super(s, timeStart, timeEnd);
    //do we need null checks here if we check in abstract?
    Objects.requireNonNull(s, "Shape can't be null");
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
  
  /*
  @Override
  public boolean equals(Transformation other) {
    if (this.shape.equals(other.getShape())
            && this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toX == other.getToX())
    return false;
  }
  
   */
  
  @Override
  public String toString() {
    return "Shape " + this.getShape().getName() + " moves from (" + this.getShape().getPositionX()
            + "," + this.getShape().getPositionY() + ") to (" + this.toX + ","
            + this.toY + ") from " + this.timeStart + " to " + this.timeEnd + ".";
  }
}
