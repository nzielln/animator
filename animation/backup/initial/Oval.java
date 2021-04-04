package backup.initial;

/**
 *
 */
public class Oval extends ShapeImpl {
  private float radiusX;
  private float radiusY;
  private String shapeType;

  /**
   *
   * @param name
   * @param color
   * @param positionX
   * @param positionY
   * @param appears
   * @param disappears
   * @param radiusX
   * @param radiusY
   */
  public Oval(String name, String color, float positionX, float positionY,
              int appears, int disappears, float radiusX, float radiusY) {
    super(name, color, positionX, positionY, appears, disappears);
    this.shapeType = "OVAL";
    this.radiusX = radiusX;
    this.radiusY = radiusY;
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
   * @param radiusX
   * @param radiusY
   */
  public Oval(String name, int r, int g, int b, float positionX, float positionY,
              int appears, int disappears, float radiusX, float radiusY) {
    super(name, r, g, b, positionX, positionY, appears, disappears);
    this.shapeType = "OVAL";
    this.radiusX = radiusX;
    this.radiusY = radiusY;
  }

  @Override
  public String getType() {
    return this.shapeType;
  }

  /**
   *
   * @return
   */
  public float getRadiusX() {
    return this.radiusX;
  }

  /**
   *
   * @return
   */
  public float getRadiusY() {
    return this.radiusY;
  }
}
