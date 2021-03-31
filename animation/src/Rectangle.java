/**
 *
 */
public class Rectangle extends ShapeImpl {
  private double height;
  private double width;
  private String shapeType;

  /**
   *
   * @param name
   * @param r
   * @param g
   * @param b
   * @param positionX
   * @param positionY
   * @param appears
   * @param disappears
   * @param height
   * @param width
   */
  public Rectangle(String name, int r, int g, int b, double positionX,
                   double positionY, double appears,
                   double disappears, double height, double width) {
    super(name, r, g, b, positionX, positionY, appears, disappears);
    this.shapeType = "RECTANGLE";
    this.height = height;
    this.width = width;
  }

  @Override
  public String getType() {
    return this.shapeType;
  }

  /**
   *
   * @return
   */
  public double getHeight() {
    return this.height;
  }

  /**
   *
   * @return
   */
  public double getWidth() {
    return this.width;
  }
}
