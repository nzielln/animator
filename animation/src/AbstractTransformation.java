import java.util.List;
import java.util.Objects;

public abstract class AbstractTransformation implements Transformation {
  private Shape shape;
  
  public AbstractTransformation(Shape s) {
    if (s == null) {
      throw new NullPointerException("Shape can't be null");
    }
    this.shape = s;
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
  
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public Shape moveShape(float toX, float toY, int timeStart, int timeEnd) {
    return move(toX, toY, timeStart, timeEnd);
  }
  
  @Override
  public Shape changeColor(Color toColor, int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Start and end time must be positive");
    }
    return null;
  }
  
  @Override
  public Shape scaleShape(float toX, float toY, int timeStart, int timeEnd) {
    return move(toX, toY, timeStart, timeEnd);
  }
  
  private Shape move(float toX, float toY, int timeStart, int timeEnd) {
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
  
  
}
