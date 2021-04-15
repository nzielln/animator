package cs5004.animator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Color;
import cs5004.animator.model.Shape;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.Graphic;
import cs5004.animator.view.GraphicView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextView;
import cs5004.animator.view.View;


public class EasyAnimator {
  
  
  public static void main(String[] args) throws FileNotFoundException {
    View text = new TextView();
    View svg = new SVGView();
    //Graphic visual = new GraphicView();
    Animation m = new AnimationImpl(); //Model
    Scanner scan = new Scanner(System.in);
    
    System.out.println("What kind of animaton would you like to see?\n");
    System.out.println("Provide an \"-in\" file, \"-out\" the type of \"-view\" "
            + "you would like to see, and \"-speed\" if applicable.");
    String inputStr = scan.nextLine();
    
    //Controller for what animation to call
    if (inputStr.contains("text")) {
      text.readInputs(inputStr);
      FileReader f = text.getReadable();
      
      AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
      AnimationReader.parseFile(f, b);
      
      text.animate(m);
    } else if (inputStr.contains("svg")) {
      svg.readInputs(inputStr);
      FileReader f = svg.getReadable();
  
      AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
      AnimationReader.parseFile(f, b);
  
      svg.animate(m);
    
    } else if (inputStr.contains("visual")) {
      HashMap<String, String> inputs = new HashMap<>();
      Scanner s = new Scanner(inputStr);
  
      while (s.hasNext()) {
        String next = s.next();
        if (next.equals("-in")) {
          inputs.put("in", s.next());
        } else if (next.equals("-out")) {
          inputs.put("out", s.next());
        } else if (next.equals("-view")) {
          inputs.put("view", s.next());
        } else if (next.equals("-speed")) {
          inputs.put("speed", s.next());
      
        }
      }
  
      String fileInput = inputs.get("in").replace("\"", ""); //from the CLI - should have a method for this??
      String filename = "src/cs5004/animator/files/" + fileInput;
      File demo = new File(filename);
      FileReader f = new FileReader(demo);
  
      AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
      AnimationReader.parseFile(f, b);
  
      //visual.animate(m);

      //Model initialization?
      List<Shape> model = new ArrayList<>();
      model.addAll(m.getShapes());

      //Frame initialization
      GraphicView newAnimation = new GraphicView(m.getCanvasX(), m.getCanvaY(),
              m.getCanvasWidth(), m.getCanvasHeight(), model);
      newAnimation.updateModel(model);
      int tick = Integer.parseInt(inputs.get("speed")); //not sure if this is how to correctly rep speed + figure out how to use timer class
      if (tick <= 0) {
        throw new IllegalArgumentException("Speed needs to be positive integer");
      }

      int count = 0;
      int lengthAnimation = 0;

      //get the total length of the animation
      for(Shape shape: model) {
        if (shape.getDisappears() > lengthAnimation) {
          lengthAnimation = shape.getDisappears();
        }
      }

      //do we get how long the animation is from the user at all? Does this need to be <= or <?
      while(count < lengthAnimation) {
        List<Shape> newModel =  m.getByTime(count);

        //update the animation and model to newModel
        //update count
        newAnimation.updateModel(newModel);
        model = newModel;
        count += tick;

        //Timer to let user see changes
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }

      }
    }
  }
}
    
    //Will need to deal with what to do with resize/reshape
    //Would is be better to have custom methods in each view??
