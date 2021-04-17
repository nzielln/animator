package cs5004.animator.view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;

public interface View {
  
  void animate(Animation model, HashMap<String, String> in);
  
  void currentView(List<Shape> shapes);
  

  
}
