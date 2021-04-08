package animation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import animation.code.cs5004.animator.util.AnimationBuilder;
import animation.code.cs5004.animator.util.AnimationBuilderImpl;
import animation.code.cs5004.animator.util.AnimationReader;

public class EasyAnimator {
  
  public static void main(String[] args) throws FileNotFoundException {
    TextView textView = new TextView();
    String filename = "src/animation/code/smalldemo.txt";
    File demo = new File(filename);
    FileReader f = new FileReader(demo);
    Animation m = new AnimationImpl();
    AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
    AnimationReader.parseFile(f, b);
    System.out.println(m.toString());
  
  }
}
