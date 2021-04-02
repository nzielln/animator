import java.util.Objects;

public class Move extends AbstractTransformation {
  final float toPointX;
  final float toPointY;
  final int timeStart;
  final int timeEnd;
  final String type;
  
  public Move(Shape s, float toPointX, float toPointY, int timeStart, int timeEnd) {
    super(s);
    //do we need null checks here if we check in abstract?
    Objects.requireNonNull(s, "Shape can't be null");
    this.toPointX = toPointX;
    this.toPointY = toPointY;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "Moves";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public String getTransformationType() {
    return this.type;
  }

  /**
   * Returns the new X-coordinate position the new shape should have.
   * @return (float) the new x-coordinate position
   */
  public float getToPointX() {
    return this.toPointX;
  }

  /**
   * Returns the new Y-coordinate position the new shape should have.
   * @return (float) the new y-coordinate position
   */
  public float getToPointY() {
    return this.toPointY;
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

  /**
   * Returns a new {@link Shape} with provided x and y positions.
   * @param toPointX x-position of the new shape object
   * @param toPointY y-position of the new shape object
   * @param timeStart time transformation starts
   * @param timeEnd time transformation ends
   * @return a new shape object
   */
  public Shape moveShape(float toPointX, float toPointY, int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Start and end time must be positive");
    }

    if (this.shape.getType().equals("OVAL")) {
      Shape s = new Oval(this.shape.getName(), toPointX,
              toPointY, this.shape.getX(), this.shape.getY(),
              this.shape.getColor().getR(), this.shape.getColor().getG(),
              this.shape.getColor().getB());
      s.setAppears(timeStart);
      s.setDisappears(timeEnd);
      return s;
    } else if (this.shape.getType().equals("RECTANGLE")) {
      Shape s = new Rectangle(this.shape.getName(), toPointX,
              toPointY, this.shape.getX(), this.shape.getY(),
              this.shape.getColor().getR(), this.shape.getColor().getG(),
              this.shape.getColor().getB());
      s.setAppears(timeStart);
      s.setDisappears(timeEnd);
      return s;
    }
    return null;
  }

  //Should we return a Transformation or should we return a new Shape?
  @Override
  public Transformation copy() {
    return new Move(this.shape.copy(), this.toPointX, this.toPointY, this.timeStart, this.timeEnd);
  }

  /*@Override
  public boolean equals(Transformation other) {
    if (this.shape.equals(other.getShape())
            && this.getTransformationType().equals(other.getTransformationType())
            && this.timeStart == other.getTimeStart() && this.timeEnd == other.getTimeEnd()
            && this.toPointX == other.getShape().ge)
    return false;
  }*/

  @Override
  public String toString() {
    return "Shape " + this.shape.getName() + " moves from (" + this.shape.getPositionX()
            + "," + this.shape.getPositionY() + ") to (" + this.toPointX + ","
            + this.toPointY + ") from " + this.timeStart + " to " + this.timeEnd + ".";
  }
}
