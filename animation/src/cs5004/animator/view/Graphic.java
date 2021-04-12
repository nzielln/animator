package cs5004.animator.view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import cs5004.animator.model.Animation;

public interface Graphic {

  void animate(Animation model);
}
