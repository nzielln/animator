package views;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TextTest {
  ViewFactory factory = new ViewFactory();

  @Test
  public void testSmallDemo() {
    try {
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
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }
  }

  @Test
  public void testToh3() {
    try {
      String in = "-in toh-3.txt -view text";
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
      assertEquals("Text View of the Animation:___________________________________" +
              "_____________\n\n"
              + "Create rectangle disk1 of color (0.0, 49.0, 90.0) with corner at (190,180), "
              + "width 20 height 30.\n"
              + "Create rectangle disk2 of color (6.0, 247.0, 41.0) with corner at (167,210), "
              + "width 65 height 30.\n"
              + "Create rectangle disk3 of color (11.0, 45.0, 175.0) with corner at (145,240), "
              + "width 110 height 30.\n\n"
              + "disk1 appears at t=1 and disappears at t=302\n"
              + "disk2 appears at t=1 and disappears at t=302\n"
              + "disk3 appears at t=1 and disappears at t=302\n\n"
              + "disk1 moves from (190.0,180.0) to (190.0,50.0) from t=25 to t=35.\n"
              + "disk1 moves from (190.0,50.0) to (490.0,50.0) from t=36 to t=46.\n"
              + "disk1 moves from (490.0,50.0) to (490.0,240.0) from t=47 to t=57.\n"
              + "disk1 moves from (490.0,240.0) to (490.0,50.0) from t=89 to t=99.\n"
              + "disk1 moves from (490.0,50.0) to (340.0,50.0) from t=100 to t=110.\n"
              + "disk1 moves from (340.0,50.0) to (340.0,210.0) from t=111 to t=121.\n"
              + "disk1 moves from (340.0,210.0) to (340.0,50.0) from t=153 to t=163.\n"
              + "disk1 moves from (340.0,50.0) to (190.0,50.0) from t=164 to t=174.\n"
              + "disk1 moves from (190.0,50.0) to (190.0,240.0) from t=175 to t=185.\n"
              + "disk1 moves from (190.0,240.0) to (190.0,50.0) from t=217 to t=227.\n"
              + "disk1 moves from (190.0,50.0) to (490.0,50.0) from t=228 to t=238.\n"
              + "disk1 moves from (490.0,50.0) to (490.0,180.0) from t=239 to t=249.\n"
              + "disk1 changes color from (0.0, 49.0, 90.0) to (0.0, 255.0, 0.0) from "
              + "t=249 to t=257.\n"
              + "disk2 moves from (167.0,210.0) to (167.0,50.0) from t=57 to t=67.\n"
              + "disk2 moves from (167.0,50.0) to (317.0,50.0) from t=68 to t=78.\n"
              + "disk2 moves from (317.0,50.0) to (317.0,240.0) from t=79 to t=89.\n"
              + "disk2 moves from (317.0,240.0) to (317.0,50.0) from t=185 to t=195.\n"
              + "disk2 moves from (317.0,50.0) to (467.0,50.0) from t=196 to t=206.\n"
              + "disk2 moves from (467.0,50.0) to (467.0,210.0) from t=207 to t=217.\n"
              + "disk2 changes color from (6.0, 247.0, 41.0) to (0.0, 255.0, 0.0) from "
              + "t=217 to t=225.\n"
              + "disk3 moves from (145.0,240.0) to (145.0,50.0) from t=121 to t=131.\n"
              + "disk3 moves from (145.0,50.0) to (445.0,50.0) from t=132 to t=142.\n"
              + "disk3 moves from (445.0,50.0) to (445.0,240.0) from t=143 to t=153.\n"
              + "disk3 changes color from (11.0, 45.0, 175.0) to (0.0, 255.0, 0.0) "
              + "from t=153 to t=161.\n\n", by.toString());
    } catch (Exception e) {
      fail("Exception should not have been throw");
    }
  }

  @Test
  public void testTextWithSpeed() {
    try {
      String in = "-in smalldemo.txt -view text -speed 2";
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
                      + "Create rectangle R of color (255.0, 0.0, 0.0) with corner at (200,200), "
                      + "width 50 height 100.\n"
                      + "Create ellipse C of color (0.0, 0.0, 255.0) with center at (440,70), "
                      + "radius 120 and 60.\n\n"
                      + "R appears at t=1 and disappears at t=100\n"
                      + "C appears at t=6 and disappears at t=100\n\n"
                      + "R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50.\n"
                      + "R scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: "
                      + "100.0 from t=51 to t=70.\n"
                      + "R moves from (300.0,300.0) to (200.0,200.0) from t=70 to t=100.\n"
                      + "C moves from (440.0,70.0) to (440.0,250.0) from t=20 to t=50.\n"
                      + "C moves from (440.0,250.0) to (440.0,370.0) from t=50 to t=70.\n"
                      + "C changes color from (0.0, 0.0, 255.0) to (0.0, 170.0, 85.0) from "
                      + "t=50 to t=70.\n"
                      + "C changes color from (0.0, 170.0, 85.0) to (0.0, 255.0, 0.0) from "
                      + "t=70 to t=80.\n\n",
              by.toString());
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }
  }

  @Test
  public void testTextWithOut() {
    try {
      String in = "-in smalldemo.txt -out small.txt -view text";
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
      String filepath = "./small.txt";
      String fileOut = new String(Files.readAllBytes(Paths.get(filepath)));
      assertEquals("Create rectangle R of color (255.0, 0.0, 0.0) with corner at "
              + "(200,200), width 50 height 100.\n"
              + "Create ellipse C of color (0.0, 0.0, 255.0) with center at (440,70), " +
              "radius 120 and 60.\n\n"
              + "R appears at t=1 and disappears at t=100\n"
              + "C appears at t=6 and disappears at t=100\n\n"
              + "R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50.\n"
              + "R scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: "
              + "100.0 from t=51 to t=70.\n"
              + "R moves from (300.0,300.0) to (200.0,200.0) from t=70 to t=100.\n"
              + "C moves from (440.0,70.0) to (440.0,250.0) from t=20 to t=50.\n"
              + "C moves from (440.0,250.0) to (440.0,370.0) from t=50 to t=70.\n"
              + "C changes color from (0.0, 0.0, 255.0) to (0.0, 170.0, 85.0) from t=50 to t=70.\n"
              + "C changes color from (0.0, 170.0, 85.0) to (0.0, 255.0, 0.0) from t=70 to t=80.",
              fileOut);
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }
  }

  @Test
  public void testDifferentOrder() {
    try {
      String in = "-speed 3 -in smalldemo.txt -view text";
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
    } catch (Exception e) {
      fail("Exception should not have been thrown");
    }
  }

  @Test
  public void testNoFileFound() {
    try {
      String in = "-in smalldeo.txt -view text";
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
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }

  @Test
  public void testNoViewSpecified() {
    try {
      String in = "-in smalldemo.txt";
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
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }

  @Test
  public void testWithViewMisspelled() {
    try {
      String in = "-in smalldemo.txt -view txt";
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
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }

  @Test
  public void testNoFileOrView() {
    try {
      String in = "-out text-test.txt -speed 3";
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
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }

  @Test
  public void testEmptyFile() {
    try {
      String in = "-in empty.txt";
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
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }

}
