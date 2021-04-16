package cs5004.animator.view;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Objects;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Transformation;



public class SVGView extends AbstractView {
  
  @Override
  public void animate(Animation m, HashMap<String, String> in) {
    Objects.requireNonNull(m, "Animation can't be null");
    Objects.requireNonNull(in, "Inputs can't be null");
    
    int speed = 1;
    if (in.get("speed") != null) {
      speed = Integer.parseInt(in.get("speed").replace("\"",""));
    }
    
    // -in "smalldemo.txt" -out "out.svg" -view "svg"
    try {
      
      FileWriter f = new FileWriter(in.get("out").replace("\"", ""));
      String canvas = "<svg width=\"" + m.getCanvasWidth() + "\" height=\"" + m.getCanvasHeight()
              + "\" version=\"1.1\" \n\t xmlns=\"http://www.w3.org/2000/svg\">\n\n";
      f.write(canvas);
      
      
      for (Shape s : m.getShapes()) {
        StringBuilder str = new StringBuilder();
        String tag = "";
        if (s.getType().equals("ELLIPSE")) {
          String sh = "<ellipse id=\"" + s.getName() + "\" cx=\"" + s.getPositionX() + "\" cy=\""
                  + s.getPositionY() + "\" rx=\"" + s.getWidth() + "\" ry=\"" + s.getHeight()
                  + "\" fill=\"rgb(" + s.getColor().getR() + "," + s.getColor().getG() + ","
                  + s.getColor().getB() + ")\" visibility=\"visible\" >\n";
          str.append(sh);
        } else if (s.getType().equals("RECTANGLE")) {
          String sh = "<rect id=\"" + s.getName() + "\" x=\"" + s.getPositionX() + "\" y=\""
                  + s.getPositionY() + "\" width=\"" + s.getWidth() + "\" height=\"" + s.getHeight()
                  + "\" fill=\"rgb(" + s.getColor().getR() + "," + s.getColor().getG() + ","
                  + s.getColor().getB() + ")\" visibility=\"visible\" >\n";
          str.append(sh);
        }
        
        
        for (Transformation t : m.getTransformations(s.getName())) {
          String tr = "";
          if (t.getTransformationType().equals("Moves")) {
            if (s.getType().equals("RECTANGLE")) {
              
              tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"x" + "\" from=\"" + t.getInitialX() + "\" to=\""
                      + t.getToX() + "\" fill=\"freeze\" />\n";
              str.append(tr);
              
              tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"y" + "\" from=\"" + t.getInitialY() + "\" to=\""
                      + t.getToY() + "\" fill=\"freeze\" />\n";
              str.append(tr);
              
            } else {
              tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"cx" + "\" from=\"" + t.getInitialX() + "\" to=\""
                      + t.getToX() + "\" fill=\"freeze\" />\n";
              str.append(tr);
              tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"cy" + "\" from=\"" + t.getInitialY() + "\" to=\""
                      + t.getToY() + "\" fill=\"freeze\" />\n";
              str.append(tr);
            }
            
          } else if (t.getTransformationType().equals("Scales")) {
            if (s.getType().equals("ELLIPSE")) {
              tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"rx" + "\" from=\"" + t.getInitialWidth() + "\" to=\""
                      + t.getToWidth() + "\" fill=\"freeze\" />\n";
              str.append(tr);
              tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"ry" + "\" from=\"" + t.getInitialHeight() + "\" to=\""
                      + t.getToHeight() + "\" fill=\"freeze\" />\n";
              str.append(tr);
              
            } else {
              tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"width" + "\" from=\"" + t.getInitialWidth() + "\" to=\""
                      + t.getToWidth() + "\" fill=\"freeze\" />\n";
              str.append(tr);
              tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"height" + "\" from=\"" + t.getInitialHeight() + "\" to=\""
                      + t.getToHeight() + "\" fill=\"freeze\" />\n";
              str.append(tr);
              
              
            }
          } else if (t.getTransformationType().equals("Color")) {
            tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                    + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                    + "s\" attributeName=\"fill" + "\" from=\"rgb(" + t.getInitialColor().getR()
                    + "," + t.getInitialColor().getG() + "," + t.getInitialColor().getB()
                    + ")\" to=\"rgb(" + t.getToColor().getR()
                    + "," + t.getToColor().getG() + "," + t.getToColor().getB()
                    + ")\" fill=\"freeze\" />\n";
          }
          
          str.append(tr);
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
  
}

