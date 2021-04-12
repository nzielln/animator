package cs5004.animator.view;

import java.util.HashMap;

import cs5004.animator.model.Animation;

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
