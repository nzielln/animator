/**
 *
 */
public class Oval extends ShapeImpl {
  private double radiusX;
  private double radiusY;
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
   * @param radiusX
   * @param radiusY
   */
  public Oval(String name, int r, int g, int b, double positionX, double positionY,
              double appears, double disappears, double radiusX, double radiusY) {
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
  public double getRadiusX() {
    return this.radiusX;
  }

  /**
   *
   * @return
   */
  public double getRadiusY() {
    return this.radiusY;
  }
}
