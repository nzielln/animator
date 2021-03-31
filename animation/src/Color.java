public class Color {
  private int r;
  private int g;
  private int b;

  public Color (int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

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

  @Override
  public String toString() {
    return "(" + this.r + ", " + this.g + ", " + this.b + ")";
  }
}
