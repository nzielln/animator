package animation;

import java.util.HashMap;
import java.util.List;

import javax.swing.*;

public class GraphicView extends JFrame implements View {
  private GraphicsPannel pannel;

  public GraphicView(int x, int y, int width, int height, List<Shape> model) {
    super("animation");
    setSize(width, height);
    setLocation(x, y);
    this.pannel = new GraphicsPannel(model, x, y, width, height);
  }

  public void updateModel(List<Shape> model) {
    this.pannel.updateModel(model);
    this.repaint();
  }
}
