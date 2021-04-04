import java.util.Objects;

public abstract class AbstractTransformation implements Transformation {
  final Shape shape;
  final int timeStart;
  final int timeEnd;
  String type;
  
  /**
   *
   * @param s
   */
  public AbstractTransformation(Shape s, int timeStart, int timeEnd) {
    Objects.requireNonNull(s, "Shape can't be null");
    
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Time must be a positive integer.");
    } else if (timeStart < s.getAppears() || timeStart > s.getDisappears()
            || timeEnd < s.getAppears() || timeEnd > s.getDisappears()) {
      throw new IllegalArgumentException("Time provided not within acceptable range.");
    }
    
    this.shape = s;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = "";
  }
  
  //GETTER-----------------------------------------------------------------------------------------
  @Override
  public Shape getShape() {
    return this.shape;
  }
  
  @Override
  public Transformation getTransformation() {
    return this;
  }
  
  @Override
  public String getTransformationType() {
    return this.type;
  }
  
  @Override
  public float getToX() {
    return 0;
  }
  
  @Override
  public float getToY() {
    return 0;
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
  
  @Override
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
  public Shape changeColor(Color toColor, int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Start and end time must be positive");
    }
    return null;
  }
  
  
}
