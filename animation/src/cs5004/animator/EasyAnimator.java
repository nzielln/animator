package cs5004.animator;

import java.util.Scanner;

import cs5004.animator.view.Reader;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

/**
 * Entry class for the animation program, parse CLI argument and renders appropriate view.
 */
public class EasyAnimator {
  
  /**
   * Main class that renders CLI argument and renders view based on inputs.
   * @param args, CLI arguments.
   */
  public static void main(String[] args) {
    ViewFactory factory = new ViewFactory();
    Reader r = new Reader();
    System.out.println("Provide an \"-in\" file, \"-out\" the type of \"-view\" "
            + "you would like to see, and \"-speed\" if applicable.");
    
    //Read inputs
    Scanner scan = new Scanner(System.in);
    
    //Parse Inputs
    String in = scan.nextLine();
    View view = factory.create(in);
    r.readIn(in);
    //Get readbale and generate model
    r.makeModel(r.getInputs(), view);
    
    //Animate
    view.animate(r.getModel(), r.getInputs());
 
  }
}

//test text: -in smalldemo.txt -view text -speed 2
//test svg: -in smalldemo.txt -view svg -speed 2 -out s.svg
//test visual: -in smalldemo.txt -view visual -speed 20
    

