package cs5004.animator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Shape;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

public class EasyAnimator {
  
  public static void main(String[] args) throws FileNotFoundException {
    ViewFactory factory = new ViewFactory();
    
    Animation m = new AnimationImpl(); //Model
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Provide an \"-in\" file, \"-out\" the type of \"-view\" "
            + "you would like to see, and \"-speed\" if applicable.");
    String inputStr = scan.nextLine();
    HashMap<String, String> inputs = new HashMap<>();
    scan.close();
    
    //ReadInputs
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
    s.close();
    
    //GetReadable
    String fileInput = inputs.get("in").replace("\"", ""); //from the CLI - should have a method for this??
    String filename = "./src/cs5004/animator/files/" + fileInput;
    File demo = new File(filename);
    FileReader f = new FileReader(demo);

    //Build Model
    AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
    AnimationReader.parseFile(f, b);
    //List<Shape> h = new ArrayList<>(m.getByTime(20));
    //System.out.println(h);
    int width = m.getCanvasWidth();
    int height = m.getCanvasHeight();
    int x = m.getCanvasX();
    int y = m.getCanvasY();
    
    //Factory depending on "view"
    View view = factory.create(inputs, m.getByTime(0), width, height, x, y);
    //System.out.println(m.toString());
    view.animate(m, inputs);
    
    if (inputs.get("view").equals("visual")) {
      List<Shape> model = new ArrayList<>(m.getShapes());
      int tick = Integer.parseInt(inputs.get("speed")); //not sure if this is how to correctly rep speed + figure out how to use timer class
      if (tick <= 0) {
        throw new IllegalArgumentException("Speed needs to be positive integer");
      }
      
      int count = 0;
      int lengthAnimation = 0;
      
      //get the total length of the animation
      for (Shape shape : model) {
        if (shape.getDisappears() > lengthAnimation) {
          lengthAnimation = shape.getDisappears();
        }
      }
      
      //do we get how long the animation is from the user at all? Does this need to be <= or <?
      while (count < lengthAnimation) {
        List<Shape> modified = m.getByTime(count);
        
        //update the animation and model to newModel
        //update count
        view.currentView(modified);
        count += 1;
        
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

//test text: -in smalldemo.txt -view text -speed 2
//test svg: -in smalldemo.txt -view svg -speed 2
//test visual: -in smalldemo.txt -view visual -speed 2
    

