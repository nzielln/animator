import java.util.Objects;

public class Move extends AbstractTransformation {
  private float toX;
  private float toY;
  private int timeStart;
  private int timeEnd;
  private String type;
  
  public Move(Shape s, float toX, float toY, int timeStart, int timeEnd) {
    super(s);
    //do we need null checks here if we check in abstract?
    Objects.requireNonNull(s, "Shape can't be null");
    this.toX = toX;
    this.toY = toY;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "Moves";
  }

//GETTERS----------------------------------------------------------------------------------------
@Override
public String getTransformationType() {
    return this.type;
  }
  
  @Override
  public float getToX() {
    return this.toX;
  }
  
  @Override
  public float getToY() {
    return this.toY;
  }
  
  @Override
  public int getTimeStart() {
    return this.timeStart;
  }
  
  @Override
  public int getTimeEnd() {
    return this.timeEnd;
  }
  
  //OTHER------------------------------------------------------------------------------------------
  //Should we return a Transformation or should we return a new Shape?
  @Override
  public Transformation copy() {
    return new Move(this.getShape().copy(), this.toX, this.toY, this.timeStart, this.timeEnd);
  }
  
  @Override
  public String toString() {
    return "Shape" + this.getShape().getName() + "moves from (" + this.getShape().getPositionX()
            + "," + this.getShape().getPositionY() + ") to (" + this.toX + ","
            + this.toY + ") from " + this.timeStart + "to " + this.timeEnd + ".\n";
  }
}
