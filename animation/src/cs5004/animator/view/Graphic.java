package cs5004.animator.view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;

public interface Graphic {

  void animate(Animation model);
}
