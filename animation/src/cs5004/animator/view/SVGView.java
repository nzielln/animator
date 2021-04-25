package cs5004.animator.view;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Transformation;


/**
 * Represents a class for an SVGView, implements the View interface.
 */
public class SVGView implements View {
  private String view;
  private Animation model;
  
  /**
   * SVGView constructor that takes in no argument, define the type of view.
   */
  public SVGView() {
    this.view = "SVG";
    this.model = new AnimationImpl();
    
  }
  
  
  @Override
  public String getViewType() {
    return this.view;
  }
  
  @Override
  public void animate(Animation m, HashMap<String, String> in) {
    Objects.requireNonNull(m, "Animation can't be null");
    Objects.requireNonNull(in, "Inputs can't be null");
    
    int speed = 1;
    if (in.get("speed") != null) {
      speed = Integer.parseInt(in.get("speed").replace("\"",""));
    }
    
    /*
     * The dimensions provided in each .txt file were too small to display the full animation
     * For example, for the smalldemo.txt, the dimensions are 360by 360, but, the ellipse is
     * drawn at positions between (440, 70) and (440, 370), making it unviewable in the space
     * allocated for the animation. To solve this problem, we decided to set a default dimensions
     * to make sure everything is seen.
     * Width: 100%
     * Height: 100%
     */
    try {
      String filename = "";
      if (in.get("in").contains("/")) {
        filename = "./resources/outputs/" + in.get("out").replace("\"", "");
      } else {
        filename = "../outputs/" + in.get("out").replace("\"", "");
      }
      
      
      FileWriter f = new FileWriter(filename);
      String canvas = "<svg width=\"" + 100 + "%\" height=\"" + 100
              + "%\" version=\"1.1\" \n\txmlns=\"http://www.w3.org/2000/svg\">\n\n";
      f.write(canvas);
      
      
      for (Shape s : m.getShapes()) {
        StringBuilder str = new StringBuilder();
        String sh;
        
        if (s.getType().equals("ELLIPSE")) {
          if (s.getAppears() > 1) {
            sh = "<ellipse id=\"" + s.getName() + "\" cx=\"" + s.getPositionX() + "\" cy=\""
                    + s.getPositionY() + "\" rx=\"" + s.getWidth() / 2 + "\" ry=\""
                    + s.getHeight() / 2 + "\" fill=\"rgb(" + s.getColor().getR() + ","
                    + s.getColor().getG() + "," + s.getColor().getB()
                    + ")\" visibility=\"hidden\" >\n";
          } else {
            sh = "<ellipse id=\"" + s.getName() + "\" cx=\"" + s.getPositionX() + "\" cy=\""
                    + s.getPositionY() + "\" rx=\"" + s.getWidth() / 2 + "\" ry=\""
                    + s.getHeight() / 2 + "\" fill=\"rgb(" + s.getColor().getR() + ","
                    + s.getColor().getG() + "," + s.getColor().getB()
                    + ")\" visibility=\"visible\" >\n";
          }
          str.append(sh);
          
        } else if (s.getType().equals("RECTANGLE")) {
          if (s.getAppears() > 1) {
            sh = "<rect id=\"" + s.getName() + "\" x=\"" + s.getPositionX() + "\" y=\""
                    + s.getPositionY() + "\" width=\"" + s.getWidth() + "\" height=\"" + s.getHeight()
                    + "\" fill=\"rgb(" + s.getColor().getR() + "," + s.getColor().getG() + ","
                    + s.getColor().getB() + ")\" visibility=\"hidden\" >\n";
          } else {
            sh = "<rect id=\"" + s.getName() + "\" x=\"" + s.getPositionX() + "\" y=\""
                    + s.getPositionY() + "\" width=\"" + s.getWidth() + "\" height=\"" + s.getHeight()
                    + "\" fill=\"rgb(" + s.getColor().getR() + "," + s.getColor().getG() + ","
                    + s.getColor().getB() + ")\" visibility=\"visible\" >\n";
          }
          str.append(sh);
        }
        
        if (s.getAppears() > 1) {
          String visibility = "<set attributeName=\"visibility\" attributeType=\"CSS\" "
                  + "to=\"visible\" begin=\"" + ((s.getAppears() - 1) * 1000) / speed
                  + "ms\" dur=\"" + 1000 / speed + "ms\" fill=\"freeze\" />\n";
          str.append(visibility);
        }
        
        
        
        for (Transformation t : m.getTransformations(s.getName())) {
          String tx;
          String ty;
          
          if (t.getTransformationType().equals("Moves")) {
            if (s.getType().equals("RECTANGLE")) {
              
              tx = "\t<animate attributeType=\"xml\" begin=\"" + (t.getTimeStart() / speed) * 1000
                      + "ms\" dur=\"" + ((t.getTimeEnd() - t.getTimeStart()) * 1000) / speed
                      + "ms\" attributeName=\"x" + "\" from=\"" + t.getInitialX() + "\" to=\""
                      + t.getToX() + "\" fill=\"freeze\" />\n";
              
              ty = "\t<animate attributeType=\"xml\" begin=\"" + (t.getTimeStart() / speed) * 1000
                      + "ms\" dur=\"" + ((t.getTimeEnd() - t.getTimeStart()) * 1000) / speed
                      + "ms\" attributeName=\"y" + "\" from=\"" + t.getInitialY() + "\" to=\""
                      + t.getToY() + "\" fill=\"freeze\" />\n";
              
            } else {
              tx = "\t<animate attributeType=\"xml\" begin=\"" + (t.getTimeStart() / speed) * 1000
                      + "ms\" dur=\"" + ((t.getTimeEnd() - t.getTimeStart()) * 1000) / speed
                      + "ms\" attributeName=\"cx" + "\" from=\"" + t.getInitialX() + "\" to=\""
                      + t.getToX() + "\" fill=\"freeze\" />\n";
              ty = "\t<animate attributeType=\"xml\" begin=\"" + (t.getTimeStart() / speed) * 1000
                      + "ms\" dur=\"" + ((t.getTimeEnd() - t.getTimeStart()) * 1000) / speed
                      + "ms\" attributeName=\"cy" + "\" from=\"" + t.getInitialY() + "\" to=\""
                      + t.getToY() + "\" fill=\"freeze\" />\n";
            }
            str.append(tx).append(ty);
            
          } else if (t.getTransformationType().equals("Scales")) {
            if (s.getType().equals("ELLIPSE")) {
              tx = "\t<animate attributeType=\"xml\" begin=\"" + (t.getTimeStart() / speed) * 1000
                      + "ms\" dur=\"" + ((t.getTimeEnd() - t.getTimeStart()) * 1000) / speed
                      + "ms\" attributeName=\"rx" + "\" from=\"" + t.getInitialWidth() + "\" to=\""
                      + t.getToWidth() + "\" fill=\"freeze\" />\n";
              ty = "\t<animate attributeType=\"xml\" begin=\"" + (t.getTimeStart() / speed) * 1000
                      + "ms\" dur=\"" + ((t.getTimeEnd() - t.getTimeStart()) * 1000) / speed
                      + "ms\" attributeName=\"ry" + "\" from=\"" + t.getInitialHeight() + "\" to=\""
                      + t.getToHeight() + "\" fill=\"freeze\" />\n";
              
            } else {
              tx = "\t<animate attributeType=\"xml\" begin=\"" + (t.getTimeStart() / speed) * 1000
                      + "ms\" dur=\"" + ((t.getTimeEnd() - t.getTimeStart()) * 1000) / speed
                      + "ms\" attributeName=\"width" + "\" from=\"" + t.getInitialWidth()
                      + "\" to=\""
                      + t.getToWidth() + "\" fill=\"freeze\" />\n";
              ty = "\t<animate attributeType=\"xml\" begin=\"" + (t.getTimeStart() / speed) * 1000
                      + "ms\" dur=\"" + ((t.getTimeEnd() - t.getTimeStart()) * 1000) / speed
                      + "ms\" attributeName=\"height" + "\" from=\"" + t.getInitialHeight()
                      + "\" to=\""
                      + t.getToHeight() + "\" fill=\"freeze\" />\n";
              
            }
            str.append(tx).append(ty);
          } else if (t.getTransformationType().equals("Color")) {
            ty = "\t<animate attributeType=\"CSS\" begin=\"" + (t.getTimeStart() / speed) * 1000
                    + "ms\" dur=\"" + ((t.getTimeEnd() - t.getTimeStart()) * 1000) / speed
                    + "ms\" attributeName=\"fill" + "\" from=\"rgb(" + t.getInitialColor().getR()
                    + "," + t.getInitialColor().getG() + "," + t.getInitialColor().getB()
                    + ")\" to=\"rgb(" + t.getToColor().getR()
                    + "," + t.getToColor().getG() + "," + t.getToColor().getB()
                    + ")\" fill=\"freeze\" />\n";
            str.append(ty);
          }
          
        }
        f.write(str.toString());
        f.write("</" + s.getType().toLowerCase().replace("angle", "") + ">\n\n");
      }
      
      f.write("\n\n</svg>");
      f.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void buildModel(Animation m) {
    this.model = m;
    
  }
  
  @Override
  public void currentView(List<Shape> shapes) {
    throw new UnsupportedOperationException("This operation is not supported by this class.");
    
  }
  
  @Override
  public View getView() {
    return this;
  }
  
  @Override
  public void exitView() {
    throw new UnsupportedOperationException("This operation is not supported by this class.");
  }
  
}