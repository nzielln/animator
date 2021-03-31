package initial;

/**
 *
 */
public class Rectangle extends ShapeImpl {
  private float height;
  private float width;
  private String shapeType;

  /**
   *
   * @param name
   * @param color
   * @param positionX
   * @param positionY
   * @param appears
   * @param disappears
   * @param height
   * @param width
   */
  public Rectangle(String name, String color, float positionX, float positionY,
                   int appears, int disappears, float height, float width) {
    super(name, color, positionX, positionY, appears, disappears);
    this.shapeType = "RECTANGLE";
    this.height = height;
    this.width = width;
  }

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
  public Rectangle(String name, int r, int g, int b, float positionX,
                   float positionY, int appears,
                   int disappears, float height, float width) {
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
  public float getHeight() {
    return this.height;
  }

  /**
   *
   * @return
   */
  public float getWidth() {
    return this.width;
  }
}
