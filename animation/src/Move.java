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
  
  //weird
  @Override
  public Color getToColor() {
    return null;
  }
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public Shape moveShape(float toX, float toY, int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Start and end time must be positive");
    }
  
    if (this.getShape().getType().equals("OVAL")) {
      Shape s = new Oval(this.getShape().getName(), toX,
              toY, this.getShape().getX(), this.getShape().getY(),
              this.getShape().getColor().getR(), this.getShape().getColor().getG(), this.getShape().getColor().getB());
      s.setAppears(timeStart);
      s.setDisappears(timeEnd);
      return s;
    } else if (this.getShape().getType().equals("RECTANGLE")) {
      Shape s = new Rectangle(this.getShape().getName(), toX,
              toY, this.getShape().getX(), this.getShape().getY(),
              this.getShape().getColor().getR(), this.getShape().getColor().getG(), this.getShape().getColor().getB());
      s.setAppears(timeStart);
      s.setDisappears(timeEnd);
      return s;
    }
    return null;
  }
  
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
