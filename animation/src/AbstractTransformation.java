
public abstract class AbstractTransformation implements Transformation {
  final Shape shape;
  
  /**
   *
   * @param s
   */
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

  //Are users required to input this when adding a transformation? If so, keep here.
  //Otherwise, should probably remove.
  @Override
  public int getTimeStart() {
    return 0;
  }
  
  @Override
  public int getTimeEnd() {
    return 0;
  }

}
