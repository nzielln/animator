import java.util.Objects;

public class Scale extends AbstractTransformation {
  final int toX;
  final int toY;
  final int timeStart;
  final int timeEnd;
  final String type;
  
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

  /**
   * Returns the new width/x-radius length the new shape should have.
   * @return (float) the new width/x-radius.
   */
  public float getToX() {
    return this.toX;
  }

  /**
   * Returns the new height/y-radius length the new shape should have.
   * @return (float) the new height/y-radius.
   */
  public float getToY() {
    return this.toY;
  }
  
  
  //OTHER------------------------------------------------------------------------------------------

  /**
   * Returns a new {@link Shape} with provided x and y positions.
   * @param toX width of the new shape object
   * @param toY length of the new shape object
   * @param timeStart time transformation starts
   * @param timeEnd time transformation ends
   * @return a new shape object
   */
  public Shape scaleShape(int toX, int toY, int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Start and end time must be positive");
    }

    if (this.getShape().getType().equals("OVAL")) {
      Shape s = new Oval(this.getShape().getName(), this.getShape().getPositionX(),
              this.getShape().getPositionY(), toX, toY,
              this.getShape().getColor().getR(), this.getShape().getColor().getG(), this.getShape().getColor().getB());
      s.setAppears(timeStart);
      s.setDisappears(timeEnd);
      return s;
    } else if (this.getShape().getType().equals("RECTANGLE")) {
      Shape s = new Rectangle(this.getShape().getName(), this.getShape().getPositionX(),
              this.getShape().getPositionY(), toX, toY,
              this.getShape().getColor().getR(), this.getShape().getColor().getG(), this.getShape().getColor().getB());
      s.setAppears(timeStart);
      s.setDisappears(timeEnd);
      return s;
    }
    return null;
  }
  
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
