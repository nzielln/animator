package cs5004.animator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.Graphic;
import cs5004.animator.view.GraphicView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextView;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

public class EasyAnimator {
  
  
  public static void main(String[] args) throws FileNotFoundException {
    ViewFactory factory = new ViewFactory();

    Animation m = new AnimationImpl(); //Model
    Scanner scan = new Scanner(System.in);
    
    System.out.println("What kind of animaton would you like to see?\n");
    System.out.println("Provide an \"-in\" file, \"-out\" the type of \"-view\" "
            + "you would like to see, and \"-speed\" if applicable.");
    String inputStr = scan.nextLine();
    
    View view = factory.create(inputStr, m);
    view.readInputs(inputStr);
    FileReader f = view.getReadable();
  
    AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
    AnimationReader.parseFile(f, b);
  
    view.animate(m);
    
    //Controller for what animation to call
    /*
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
      visual.readInputs(inputStr);
      FileReader f = visual.getReadable();
  
      AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
      AnimationReader.parseFile(f, b);
  
      //visual.animate(m);
      
    }
    
     */
    
    //Will need to deal with what to do with resize/reshape
    //Would is be better to have custom methods in each view??
    
  }
  
}
