package cs5004.animator.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Transformation;
import cs5004.animator.view.Reader;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

public class ViewController implements Controller {
  private Reader r;
  private String argsStr;
  private View view;
  ViewFactory factory;
  HashMap<String, String> data;
  
  
  public ViewController(String argsStr) {
    this.argsStr = argsStr;
    this.factory = new ViewFactory();
    this.r = new Reader();
    this.data = new HashMap<>();
  }
  
  @Override
  public void go() {
    Scanner scan = new Scanner(this.argsStr.toString());
    
    //Parse Inputs
    String in = scan.nextLine();
    callView(in);
    
  }
  
  @Override
  public void callView(String in) {
    factory = new ViewFactory();
    r = new Reader();
    
    view = factory.create(in);
    r.readIn(in);
    //Get readbale and generate model
    r.makeModel(r.getInputs(), view);
    for (String k: r.getInputs().keySet()) {
      this.data.put(k, r.getInputs().get(k));
    }
    
    //Animate
    if (view.getViewType().equals("Visual")) {
      int x = r.getModel().getCanvasX();
      int y = r.getModel().getCanvasY();
      int w = r.getModel().getCanvasWidth();
      int h = r.getModel().getCanvasHeight();
      view.buildModel(x, y, w, h);
      sendVisual();
    } else if (view.getViewType().equals("Text")) {
      String str = sendText();
      this.data.put("output", str);
      view.animate(this.data);
    } else {
      String str = sendSVG();
      this.data.put("output", str);
      view.animate(this.data);
    }
    
  }
  
  private String sendText() {
    StringBuilder str = new StringBuilder();
    System.out.println("Text View of the Animation:________________________________________________"
            + "\n");
    for (Shape s : r.getModel().getShapes()) {
      if (s.getType().equals("RECTANGLE")) {
        String desc = "Create " + s.getType().toLowerCase() + " " + s.getName() + " of color "
                + s.getColor() + " with corner at (" + s.getPositionX() + "," + s.getPositionY()
                + "), width " + s.getWidth() + " height " + s.getHeight() + ".";
        str.append(desc).append("\n");
      } else if (s.getType().equals("ELLIPSE")) {
        String desc = "Create " + s.getType().toLowerCase() + " " + s.getName() + " of color "
                + s.getColor() + " with center at (" + s.getPositionX() + "," + s.getPositionY()
                + "), radius " + s.getWidth() + " and " + s.getHeight() + ".";
        str.append(desc).append("\n");
      }
    }
    
    str.append("\n");
    
    for (Shape s : r.getModel().getShapes()) {
      String timeDesc = s.getName() + " appears at t=" + s.getAppears() + " and disappears at t="
              + s.getDisappears();
      str.append(timeDesc).append("\n");
    }
    
    str.append("\n");
    
    for (Shape s : r.getModel().getShapes()) {
      str.append(r.getModel().tranformationString(s).replace("Shape ", ""));
    }
    
    return str.toString();
    
  }
  
  private String sendSVG() {
    int speed = 1;
    if (r.getInputs().get("speed") != null) {
      speed = Integer.parseInt(r.getInputs().get("speed").replace("\"",""));
    }
    StringBuilder str = new StringBuilder();
    String canvas = "<svg width=\"" + 100 + "%\" height=\"" + 100
            + "%\" version=\"1.1\" \n\txmlns=\"http://www.w3.org/2000/svg\">\n\n";
    
    str.append(canvas);
    
    for (Shape s : r.getModel().getShapes()) {
      if (s.getType().equals("ELLIPSE")) {
        String sh = "<ellipse id=\"" + s.getName() + "\" cx=\"" + s.getPositionX() + "\" cy=\""
                + s.getPositionY() + "\" rx=\"" + s.getWidth() / 2 + "\" ry=\""
                + s.getHeight() / 2 + "\" fill=\"rgb(" + s.getColor().getR() + ","
                + s.getColor().getG() + "," + s.getColor().getB()
                + ")\" visibility=\"visible\" >\n";
        str.append(sh);
      } else if (s.getType().equals("RECTANGLE")) {
        String sh = "<rect id=\"" + s.getName() + "\" x=\"" + s.getPositionX() + "\" y=\""
                + s.getPositionY() + "\" width=\"" + s.getWidth() + "\" height=\"" + s.getHeight()
                + "\" fill=\"rgb(" + s.getColor().getR() + "," + s.getColor().getG() + ","
                + s.getColor().getB() + ")\" visibility=\"visible\" >\n";
        str.append(sh);
      }
      
      
      for (Transformation t : r.getModel().getTransformations(s.getName())) {
        String tx = "";
        String ty = "";
        if (t.getTransformationType().equals("Moves")) {
          if (s.getType().equals("RECTANGLE")) {
            
            tx = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                    + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                    + "s\" attributeName=\"x" + "\" from=\"" + t.getInitialX() + "\" to=\""
                    + t.getToX() + "\" fill=\"freeze\" />\n";
            
            ty = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                    + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                    + "s\" attributeName=\"y" + "\" from=\"" + t.getInitialY() + "\" to=\""
                    + t.getToY() + "\" fill=\"freeze\" />\n";
            str.append(tx);
            str.append(ty);
            
          } else {
            tx = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                    + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                    + "s\" attributeName=\"cx" + "\" from=\"" + t.getInitialX() + "\" to=\""
                    + t.getToX() + "\" fill=\"freeze\" />\n";
            ty = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                    + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                    + "s\" attributeName=\"cy" + "\" from=\"" + t.getInitialY() + "\" to=\""
                    + t.getToY() + "\" fill=\"freeze\" />\n";
            str.append(tx);
            str.append(ty);
          }
          
        } else if (t.getTransformationType().equals("Scales")) {
          if (s.getType().equals("ELLIPSE")) {
            tx = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                    + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                    + "s\" attributeName=\"rx" + "\" from=\"" + t.getInitialWidth() + "\" to=\""
                    + t.getToWidth() + "\" fill=\"freeze\" />\n";
            ty = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                    + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                    + "s\" attributeName=\"ry" + "\" from=\"" + t.getInitialHeight() + "\" to=\""
                    + t.getToHeight() + "\" fill=\"freeze\" />\n";
            str.append(tx);
            str.append(ty);
            
          } else {
            tx = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                    + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                    + "s\" attributeName=\"width" + "\" from=\"" + t.getInitialWidth()
                    + "\" to=\""
                    + t.getToWidth() + "\" fill=\"freeze\" />\n";
            ty = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                    + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                    + "s\" attributeName=\"height" + "\" from=\"" + t.getInitialHeight()
                    + "\" to=\""
                    + t.getToHeight() + "\" fill=\"freeze\" />\n";
            str.append(tx);
            str.append(ty);
            
          }
        } else if (t.getTransformationType().equals("Color")) {
          ty = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                  + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                  + "s\" attributeName=\"fill" + "\" from=\"rgb(" + t.getInitialColor().getR()
                  + "," + t.getInitialColor().getG() + "," + t.getInitialColor().getB()
                  + ")\" to=\"rgb(" + t.getToColor().getR()
                  + "," + t.getToColor().getG() + "," + t.getToColor().getB()
                  + ")\" fill=\"freeze\" />\n";
          str.append(ty);
        }
        
      }
      str.append("</" + s.getType().toLowerCase().replace("angle", "") + ">\n\n");
    }
    str.append("\n\n</svg>");
    
    return str.toString();
    
  }
  
  private void sendVisual() {
    List<Shape> model = new ArrayList<>(r.getModel().getShapes());
    
    int tick = 1;
    
    if (r.getInputs().get("speed") != null) {
      tick = Integer.parseInt(r.getInputs().get("speed"));
      if (tick <= 0) {
        throw new IllegalArgumentException("Speed needs to be positive integer");
      }
    }
    
    int count = 0;
    int lengthAnimation = 0;
    
    //get the total length of the animation
    for (Shape shape : model) {
      if (shape.getDisappears() > lengthAnimation) {
        lengthAnimation = shape.getDisappears();
      }
    }
    view.animateVisual(r.getModel().getByTime(0));
    
    //do we get how long the animation is from the user at all? Does this need to be <= or <?
    while (count < lengthAnimation) {
      List<Shape> modified = r.getModel().getByTime(count);
      
      //update the animation and model to newModel
      //update count
      view.animateVisual(modified);
      count += 1;
      
      //Timer to let user see changes
      try {
        Thread.sleep(1000 / tick);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    
    
  }
}
