package controller;

import org.junit.Before;
import org.junit.Test;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ViewController;
import cs5004.animator.view.View;

import static org.junit.Assert.*;

public class ViewControllerTest {
  Controller controller;
  Controller controllervisual;
  
  
  @Before
  public void setUp() {
    String in = "-in smalldemo.txt -view text -speed 2";
    controller = new ViewController(in);
  
    String inv = "-in smalldemo.txt -view visual -speed 25";
    controllervisual = new ViewController(inv);
  }
  
  @Test
  public void goText() {
    
  }
}