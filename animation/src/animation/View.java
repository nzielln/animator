package animation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;

import animation.Animation;

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
