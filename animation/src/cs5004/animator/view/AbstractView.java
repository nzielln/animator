package cs5004.animator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;

public abstract class AbstractView implements View {
  
  @Override
  public void animate(Animation model, HashMap<String, String> in) {
  
  }
  
  @Override
  public void currentView(List<Shape> shapes) {
  }
  

}
