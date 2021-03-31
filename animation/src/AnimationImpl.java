import java.util.ArrayList;
import java.util.List;

public class AnimationImpl implements Animation {
  private List<ShapeNode> shapes;
  
  public AnimationImpl() {
    shapes = new ArrayList<>();
  }
  
  public void addShape(ShapeNode s) {
    shapes.add(s);
  }
  
  public void removeShape(ShapeNode s) {
    shapes.remove(s);
  }
  
  public ShapeNode getById(String id) {
    return null;
  }
  
  public ShapeNode getByTime(int t) {
    return null;
  }
  
}
