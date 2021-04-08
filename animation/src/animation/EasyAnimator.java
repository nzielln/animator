package animation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import animation.code.cs5004.animator.util.AnimationBuilder;
import animation.code.cs5004.animator.util.AnimationBuilderImpl;
import animation.code.cs5004.animator.util.AnimationReader;

public class EasyAnimator {
  
  public static void main(String[] args) throws FileNotFoundException {
    FileReader demo = new FileReader(
            "/Users/nzielln/IdeaProjects/animator/animation/src/animation/code/smalldemo.txt");
    Animation m = new AnimationImpl();
    AnimationBuilder<Animation> b = new AnimationBuilderImpl<Animation>(m);
    AnimationReader.parseFile(demo, b);
    System.out.println(m.toString());
  
  
  }
}
