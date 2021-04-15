package cs5004.animator.view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import cs5004.animator.model.Animation;

public interface View {

  /*
  "in" :
  "view" :
  "out" :
  "speed" :
   */
  HashMap<String, String> readInputs(String inputs);
  
  
  
  FileReader getReadable() throws FileNotFoundException;
  
  void animate(Animation model);

  
}
