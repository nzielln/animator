package cs5004.animator;

import java.util.Scanner;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ViewController;


/**
 * Entry class for the animation program, parse CLI argument and renders appropriate view.
 */
public class EasyAnimator {
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
 
  }
}

//test text: -in smalldemo.txt -view text -speed 2
//test svg: -in smalldemo.txt -view svg -speed 2 -out s.svg
//test visual: -in smalldemo.txt -view visual -speed 20
    

