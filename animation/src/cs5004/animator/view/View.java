package cs5004.animator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;

public interface View {
  String getViewType();
  
  View getView();
  
  void animate(Animation m, HashMap<String, String> inputs);
  /*
  void readInputs(String in);
  void getReadable() throws FileNotFoundException;
  */
  void buildModel(Animation f);
  
  
  void currentView(List<Shape> shapes);
  

  
}
