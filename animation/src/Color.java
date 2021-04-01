public class Color {
  private int r;
  private int g;
  private int b;

  public Color (int r, int g, int b) {
    if (r < 0 || g < 0 || b < 0
            || r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("RGB values must be between 0 - 255");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  public int getR() {
    return this.r;
  }

  public int getG() {
    return this.g;
  }

  public int getB() {
    return this.b;
  }

  public Color getColor() {
    return this;
  }
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public String toString() {
    return "(" + this.r + ", " + this.g + ", " + this.b + ")";
  }
}
