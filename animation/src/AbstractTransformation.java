import java.util.Objects;

public abstract class AbstractTransformation implements Transformation {
  final int timeStart;
  final int timeEnd;
  String type;
  
  /**
   *
   * @param timeStart
   * @param timeEnd
   */
  public AbstractTransformation(int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Time must be a positive integer.");
    }
    
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.type = null;
  }
  
  //GETTER-----------------------------------------------------------------------------------------
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
  public Shape moveShape(Shape shape, float toX, float toY, int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Start and end time must be positive");
    }
  
    if (shape.getType().equals("OVAL")) {
      Shape s = new Oval(shape.getName(), toX,
              toY, shape.getX(), shape.getY(),
              shape.getColor().getR(), shape.getColor().getG(), shape.getColor().getB());
      s.setAppears(timeStart);
      s.setDisappears(timeEnd);
      return s;
    } else if (shape.getType().equals("RECTANGLE")) {
      Shape s = new Rectangle(shape.getName(), toX,
              toY, shape.getX(), shape.getY(),
              shape.getColor().getR(), shape.getColor().getG(), shape.getColor().getB());
      s.setAppears(timeStart);
      s.setDisappears(timeEnd);
      return s;
    }
  
    return null;
  }
  
  @Override
  public Shape scaleShape(Shape shape, int toX, int toY, int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Start and end time must be positive");
    }
    if (shape.getType().equals("OVAL")) {
      Shape s = new Oval(shape.getName(), shape.getPositionX(),
              shape.getPositionY(), toX, toY,
              shape.getColor().getR(), shape.getColor().getG(), shape.getColor().getB());
      s.setAppears(timeStart);
      s.setDisappears(timeEnd);
      return s;
    } else if (shape.getType().equals("RECTANGLE")) {
      Shape s = new Rectangle(shape.getName(), shape.getPositionX(),
              shape.getPositionY(), toX, toY,
              shape.getColor().getR(), shape.getColor().getG(), shape.getColor().getB());
      s.setAppears(timeStart);
      s.setDisappears(timeEnd);
      return s;
    }
    return null;
  }
  
  
  @Override
  public Shape changeColor(Shape shape, Color toColor, int timeStart, int timeEnd) {
    return null;
  }
  
  
}
