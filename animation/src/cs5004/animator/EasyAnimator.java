package cs5004.animator;

import java.util.Scanner;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ViewController;
import cs5004.animator.model.Color;
import cs5004.animator.view.Reader;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

/**
 * Entry class for the animation program, parse CLI argument and renders appropriate view.
 */
public class EasyAnimator {
  //java -jar animation.jar -in smalldemo.txt -view playback -speed 15
  /**
   Main class that renders CLI argument and renders view based on inputs.
   * @param args the CLI arguments
   */
  public static void main(String[] args) {
    StringBuilder instr = new StringBuilder();
    
    for (String s : args) {
      instr.append(s).append(" ");
    }
    
    
    Controller controller = new ViewController(instr.toString());
    controller.go();
    
    /*
    //Read inputs
    Scanner scan = new Scanner(instr.toString());
    
    //Parse Inputs
    String in = scan.nextLine();
    
    ViewFactory factory = new ViewFactory();
    Reader r = new Reader();
    
    View view = factory.create(in);
    r.readIn(in);
    //Get readbale and generate model
    r.makeModel(r.getInputs(), view);
    
    //Animate
    view.animate(r.getModel(), r.getInputs());
    
     */
    
  }
}

//test text: -in smalldemo.txt -view text -speed 2
//test svg: -in smalldemo.txt -view svg -speed 2 -out s.svg
//test visual: -in smalldemo.txt -view visual -speed 20

