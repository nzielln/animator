import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Shape;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.View;

public abstract class AbstractView implements View {
  
  @Override
  public void animate(Animation m, HashMap<String, String> inputs) {
    throw new UnsupportedOperationException("AbstractView does not support animate method");
  }
  
  @Override
  public void currentView(List<Shape> shapes) {
    throw new UnsupportedOperationException("AbstractView does not support currentView method");
  }
  
  @Override
  public View getView() {
    throw new UnsupportedOperationException("This operation isn't supported by this class.");
  }
 
}
