package views;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringReader;

import cs5004.animator.EasyAnimator;
import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.view.AbstractView;
import cs5004.animator.view.TextView;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

import static org.junit.Assert.assertEquals;

public class TextTest {
  ViewFactory factory = new ViewFactory();

  @Test
  public void testSmallDemo() throws FileNotFoundException {
    String in = "-in smalldemo.txt -view text";
    ByteArrayOutputStream by = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(by);
    PrintStream sys = System.out;
    System.setOut(out);
    View view = factory.create(in);
    view.readInputs(in);
    view.getReadable();
    view.animate();
    System.out.flush();
    System.setOut(sys);
    assertEquals("Text View of the Animation:__________________________________________"
            + "______\n\n"
            + "Create rectangle R of color (255.0, 0.0, 0.0) with corner at (200,200), width 50 "
            + "height 100.\n" +
            "Create ellipse C of color (0.0, 0.0, 255.0) with center at (440,70), radius 120 "
            + "and 60.\n\n"
            + "R appears at t=1 and disappears at t=100\n"
            + "C appears at t=6 and disappears at t=100\n\n"
            + "R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50.\n"
            + "R scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: 100.0 from t=51 "
            + "to t=70.\n"
            + "R moves from (300.0,300.0) to (200.0,200.0) from t=70 to t=100.\n"
            + "C moves from (440.0,70.0) to (440.0,250.0) from t=20 to t=50.\n"
            + "C moves from (440.0,250.0) to (440.0,370.0) from t=50 to t=70.\n"
            + "C changes color from (0.0, 0.0, 255.0) to (0.0, 170.0, 85.0) from t=50 to t=70.\n"
            + "C changes color from (0.0, 170.0, 85.0) to (0.0, 255.0, 0.0) from t=70 to t=80.\n\n",
            by.toString());
  }
}
