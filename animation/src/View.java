import java.util.HashMap;

import animation.Animation;

public interface View {

  /*
  "in" :
  "view" :
  "out" :
  "speed" :
   */
  HashMap<String, String> readInputs(Readable readable);
  
  void readBuild(HashMap<String, String> inputs, Animation model);
  
  void animate(Animation model, HashMap<String, String> inputs);

  
}
