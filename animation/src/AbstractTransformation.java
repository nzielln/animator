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
  
}
