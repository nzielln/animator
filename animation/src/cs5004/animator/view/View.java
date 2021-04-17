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
  
  void animate();
  
  void readInputs(String in);
  
  void buildModel(FileReader f);
  
  void getReadable() throws FileNotFoundException;
  
  void currentView(List<Shape> shapes);
  

  
}
