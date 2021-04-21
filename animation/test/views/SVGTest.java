package views;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ViewController;
import cs5004.animator.view.Reader;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test class for the SVGView.
 */
public class SVGTest {
  private final ViewFactory factory = new ViewFactory();
  
  @Test
  public void testViewReader() {
    try {
      String in = "-in smalldemo.txt -view visual -speed 2";
      Controller con = new ViewController(in);
      con.go();
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    
    //different order
    try {
      String in = "-speed 2 -view visual -in smalldemo.txt";
      Controller con = new ViewController(in);
      con.go();
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    
    try {
      String in2 = "-in smalldemo.txt -view text";
      Controller con = new ViewController(in2);
      con.go();
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    
    try {
      String in3 = "-in smalldemo.txt -view svg -out s.svg";
      Controller con = new ViewController(in3);
      con.go();
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    
    
  }
  
  @Test
  public void testViewBadInputs() {
    //in not provided
    try {
      String in = "-view text -speed 3";
      Controller con = new ViewController(in);
      con.go();
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //in and view not provided
    try {
      String in = "-out text.txt -speed 3";
      Controller con = new ViewController(in);
      con.go();
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //view not provided
    try {
      String ins = "-in smalldemo.txt -out text.txt -speed 3";
      Controller con = new ViewController(ins);
      con.go();
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //File not found - text
    try {
      String in = "-in smalldmo.txt -view text";
      Controller con = new ViewController(in);
      con.go();
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //File not found - svg
    try {
      String in = "-in smalldmo.txt -view svg -speed 2";
      Controller con = new ViewController(in);
      con.go();
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //svg mispelled
    try {
      String in = "-in smalldemo.txt -view swg -speed 2";
      Controller con = new ViewController(in);
      con.go();
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //File not found - visual
    try {
      String in = "-in smalldmo.txt -view visual -speed 2";
      Controller con = new ViewController(in);
      con.go();
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //no in file
    try {
      String in = "-speed 2 -view text";
      Controller con = new ViewController(in);
      con.go();
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //no out file - svg
    try {
      String in = "-in smalldemo.txt -view svg";
      Controller con = new ViewController(in);
      con.go();
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
  }
  
  @Test
  public void emptyFile() throws FileNotFoundException {
    String in = "-in empty.txt -view svg -speed 2 -out out.svg";
    Controller con = new ViewController(in);
    con.go();
    StringBuilder s = new StringBuilder();
    File demo = new File("./resources/outputs/out.svg");
    FileReader f = new FileReader(demo);
    Scanner scan = new Scanner(f).useDelimiter("\n");
    
    while (scan.hasNext()) {
      s.append(scan.next()).append("\n");
    }
    
    //Empty file should only print this, not animation information
    assertEquals("<svg width=\"0\" height=\"0\" version=\"1.1\""
            + " \n\txmlns=\"http://www.w3.org/2000/svg\">\n\n\n\n</svg>", s.toString().trim());
    
  }
  
  
  @Test
  public void smalldemoSvg() throws FileNotFoundException {
    String in = "-in smalldemo.txt -view svg -speed 2 -out out.svg";
    Controller con = new ViewController(in);
    con.go();
    StringBuilder s = new StringBuilder();
    File demo = new File("./resources/outputs/out.svg");
    FileReader f = new FileReader(demo);
    Scanner scan = new Scanner(f).useDelimiter("\n");
    
    while (scan.hasNext()) {
      s.append(scan.next()).append("\n");
    }
    
    assertEquals("<svg width=\"360\" height=\"360\" version=\"1.1\" \n\t"
            + "xmlns=\"http://www.w3.org/2000/svg\">\n\n"
            + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" "
            + "fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
            + "\t<animate attributeType=\"xml\" begin=\"5s\" dur=\"20s\" "
            + "attributeName=\"x\" from=\"200\" to=\"300\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"5s\" dur=\"20s\" "
            + "attributeName=\"y\" from=\"200\" to=\"300\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25s\" dur=\"9s\" "
            + "attributeName=\"width\" from=\"50\" to=\"25\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25s\" dur=\"9s\" "
            + "attributeName=\"height\" from=\"100\" to=\"100\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"35s\" dur=\"15s\" "
            + "attributeName=\"x\" from=\"300\" to=\"200\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"35s\" dur=\"15s\" "
            + "attributeName=\"y\" from=\"300\" to=\"200\" fill=\"freeze\" />\n"
            + "</rect>\n\n"
            + "<ellipse id=\"C\" cx=\"440\" cy=\"70\" rx=\"60\" ry=\"30\" "
            + "fill=\"rgb(0,0,255)\" visibility=\"visible\" >\n"
            + "\t<animate attributeType=\"xml\" begin=\"10s\" dur=\"15s\" "
            + "attributeName=\"cx\" from=\"440\" to=\"440\" fill=\"freeze\" />\n"
            +  "\t<animate attributeType=\"xml\" begin=\"10s\" dur=\"15s\" "
            + "attributeName=\"cy\" from=\"70\" to=\"250\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25s\" dur=\"10s\" "
            + "attributeName=\"cx\" from=\"440\" to=\"440\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25s\" dur=\"10s\" "
            + "attributeName=\"cy\" from=\"250\" to=\"370\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25s\" dur=\"10s\" "
            + "attributeName=\"fill\" from=\"rgb(0,0,255)\" to=\"rgb(0,170,85)\" "
            + "fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"35s\" dur=\"5s\" "
            + "attributeName=\"fill\" from=\"rgb(0,170,85)\" to=\"rgb(0,255,0)\" "
            + "fill=\"freeze\" />\n"
            + "</ellipse>\n\n"
            + "\n\n</svg>", s.toString().trim());
    
  }
  
}
