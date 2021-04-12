package animation;

import java.util.HashMap;
import java.util.List;

import javax.swing.*;

public class GraphicView extends JFrame implements View {
  private GraphicsPanel panel;

  public GraphicView(int x, int y, int width, int height, List<Shape> model) {
    super("Animation");
    setSize(width, height);
    setLocation(x, y);
    this.panel = new GraphicsPanel(model, x, y, width, height);
  }

  public void updateModel(List<Shape> model) {
    this.panel.updateModel(model);
    this.repaint();
  }

  @Override
  public HashMap<String, String> readInputs(Readable readable) {
    return null;
  }

  @Override
  public void readBuild(HashMap<String, String> inputs, Animation model) {

  }

  @Override
  public void animate(Animation model, HashMap<String, String> inputs) {

  }
}
