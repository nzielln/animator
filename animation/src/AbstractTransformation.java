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
    return null;
  }
  
  @Override
  public Transformation copy() {
    return null;
  }
  
  @Override
  public Shape moveShape(float toX, float toY, int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Start and end time must be positive");
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
  
  @Override
  public Shape scaleShape(float toX, float toY, int timeStart, int timeEnd) {
    if (timeStart < 0 || timeEnd < 0) {
      throw new IllegalArgumentException("Start and end time must be positive");
    }
    return null;
  }
  
  
  
}
