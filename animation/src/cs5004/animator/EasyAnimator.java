package cs5004.animator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
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
    
    
    //Will need to deal with what to do with resize/reshape
    //Would is be better to have custom methods in each view??
    
  }
  
}
