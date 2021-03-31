import java.util.ArrayList;
import java.util.List;

public class ShapeNodeImpl implements ShapeNode {
  private final Shape shape;
  private float appears;
  private float disappears;
  private List<Transformation> transformations;
  
  
  
  public ShapeNodeImpl(Shape shape /*, float appears, float disappears*/) {
    this.shape = shape;
    this.appears = 0.0f;
    this.disappears = 0.0f;
    this.transformations = new ArrayList<>();
  
  }
  
  @Override
  public Shape getShape() {
    return this.shape;
  }
  
  @Override
  public float getAppears() {
    return this.appears;
  }
  
  @Override
  public float getDisappears(){
    return this.disappears;
  }
  
  @Override
  public void setDisappears(float d) {
    this.disappears = d;
  }
  
  @Override
  public void setAppears(float a) {
    this.appears = a;
  }
  
  @Override
  public List<Transformation> getTransformations() {
    return this.transformations;
  }
  
  @Override
  public String toString() {
    return this.shape.toString()
            + "Appears: " + this.appears + "\n"
            + "Disappears: " + this.disappears + "\n";
  }
  
 
  
}
