public class ShapeNodeImpl implements ShapeNode {
  private Shape shape;
  private float appears;
  private float disappears;
  
  public ShapeNodeImpl(Shape shape, float appears, float disappears) {
    this.shape = shape;
    this.appears = appears;
    this.disappears = disappears;
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
  
  
  
}
