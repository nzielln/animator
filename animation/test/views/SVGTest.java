package views;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
      String in = "-in ./resources/files/smalldemo.txt -view visual -speed 2";
      View v = factory.create(in);
      Reader r1 = new Reader();
      r1.readIn(in);
      r1.buildModel(v);
      assertEquals("Visual", v.getViewType());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    
    //different order
    try {
      String in = "-speed 2 -view visual -in ./resources/files/smalldemo.txt";
      View v = factory.create(in);
      Reader r2 = new Reader();
      r2.readIn(in);
      r2.buildModel(v);
      assertEquals("Visual", v.getViewType());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    
    try {
      String in2 = "-in ./resources/files/smalldemo.txt -view text";
      View v2 = factory.create(in2);
      Reader r3 = new Reader();
      r3.readIn(in2);
      r3.buildModel(v2);
      assertEquals("Text", v2.getViewType());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    
    try {
      String in3 = "-in ./resources/files/smalldemo.txt -view svg -out s.svg";
      View v3 = factory.create(in3);
      Reader r4 = new Reader();
      r4.readIn(in3);
      r4.buildModel(v3);
      assertEquals("SVG", v3.getViewType());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
    
    
  }
  
  @Test
  public void testViewBadInputs() {
    //in not provided
    try {
      String in = "-view text -speed 3";
      View v = factory.create(in);
      Reader r1 = new Reader();
      r1.readIn(in);
      r1.buildModel(v);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //in and view not provided
    try {
      String in = "-out ./resources/files/text.txt -speed 3";
      View v = factory.create(in);
      Reader r3 = new Reader();
      r3.readIn(in);
      r3.buildModel(v);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //view not provided
    try {
      String ins = "-in ./resources/files/smalldemo.txt -out text.txt -speed 3";
      View vs = factory.create(ins);
      Reader r2 = new Reader();
      r2.readIn(ins);
      r2.buildModel(vs);
      System.out.println(r2.getInputs());
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //File not found - text
    try {
      String in = "-in ./resources/files/smalldmo.txt -view text";
      View v = factory.create(in);
      Reader r4 = new Reader();
      r4.readIn(in);
      r4.buildModel(v);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //File not found - svg
    try {
      String in = "-in ./resources/files/smalldmo.txt -view svg -speed 2";
      View v = factory.create(in);
      Reader r5 = new Reader();
      r5.readIn(in);
      r5.buildModel(v);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //svg mispelled
    try {
      String in = "-in ./resources/files/smalldemo.txt -view swg -speed 2";
      View v = factory.create(in);
      Reader r6 = new Reader();
      r6.readIn(in);
      r6.buildModel(v);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //File not found - visual
    try {
      String in = "-in ./resources/files/smalldmo.txt -view visual -speed 2";
      View v = factory.create(in);
      Reader r7 = new Reader();
      r7.readIn(in);
      r7.buildModel(v);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //no in file
    try {
      String in = "-speed 2 -view text";
      View v = factory.create(in);
      Reader r7 = new Reader();
      r7.readIn(in);
      r7.buildModel(v);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    //no out file - svg
    try {
      String in = "-in ./resources/files/smalldemo.txt -view svg";
      View v = factory.create(in);
      Reader r8 = new Reader();
      r8.readIn(in);
      r8.buildModel(v);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
  }
  
  @Test
  public void emptyFile() throws FileNotFoundException {
    String in = "-in ./resources/files/empty.txt -view svg -speed 2 -out empty.svg";
    View v = factory.create(in);
    Reader r = new Reader();
    r.readIn(in);
    r.buildModel(v);
    v.animate(r.getModel(), r.getInputs());
    StringBuilder s = new StringBuilder();
    File demo = new File("./resources/outputs/empty.svg");
    FileReader f = new FileReader(demo);
    Scanner scan = new Scanner(f).useDelimiter("\n");
    
    while (scan.hasNext()) {
      s.append(scan.next()).append("\n");
    }
    
    //Empty file should only print this, no animation information
    assertEquals("<svg width=\"100%\" height=\"100%\" version=\"1.1\""
            + " \n\txmlns=\"http://www.w3.org/2000/svg\">\n\n\n\n</svg>", s.toString().trim());
    
  }
  
  
  @Test
  public void smalldemoSvg() throws FileNotFoundException {
    String in = "-in ./resources/files/smalldemo.txt -view svg -speed 2 -out outs.svg";
    View v = factory.create(in);
    Reader r = new Reader();
    r.readIn(in);
    r.buildModel(v);
    v.animate(r.getModel(), r.getInputs());
    StringBuilder s = new StringBuilder();
    File demo = new File("./resources/outputs/outs.svg");
    FileReader f = new FileReader(demo);
    Scanner scan = new Scanner(f).useDelimiter("\n");
    
    while (scan.hasNext()) {
      s.append(scan.next()).append("\n");
    }
    
    assertEquals("<svg width=\"100%\" height=\"100%\" version=\"1.1\" \n\t"
            + "xmlns=\"http://www.w3.org/2000/svg\">\n\n"
            + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" "
            + "fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
            + "\t<animate attributeType=\"xml\" begin=\"5000ms\" dur=\"20000ms\" "
            + "attributeName=\"x\" from=\"200\" to=\"300\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"5000ms\" dur=\"20000ms\" "
            + "attributeName=\"y\" from=\"200\" to=\"300\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25000ms\" dur=\"9500ms\" "
            + "attributeName=\"width\" from=\"50\" to=\"25\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25000ms\" dur=\"9500ms\" "
            + "attributeName=\"height\" from=\"100\" to=\"100\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"35000ms\" dur=\"15000ms\" "
            + "attributeName=\"x\" from=\"300\" to=\"200\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"35000ms\" dur=\"15000ms\" "
            + "attributeName=\"y\" from=\"300\" to=\"200\" fill=\"freeze\" />\n"
            + "</rect>\n\n"
            + "<ellipse id=\"C\" cx=\"440\" cy=\"70\" rx=\"60\" ry=\"30\" "
            + "fill=\"rgb(0,0,255)\" visibility=\"hidden\" >\n"
            + "<set attributeName=\"visibility\" attributeType=\"CSS\" to=\"visible\""
            + " begin=\"2500ms\" dur=\"500ms\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"10000ms\" dur=\"15000ms\" "
            + "attributeName=\"cx\" from=\"440\" to=\"440\" fill=\"freeze\" />\n"
            +  "\t<animate attributeType=\"xml\" begin=\"10000ms\" dur=\"15000ms\" "
            + "attributeName=\"cy\" from=\"70\" to=\"250\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25000ms\" dur=\"10000ms\" "
            + "attributeName=\"cx\" from=\"440\" to=\"440\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25000ms\" dur=\"10000ms\" "
            + "attributeName=\"cy\" from=\"250\" to=\"370\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"CSS\" begin=\"25000ms\" dur=\"10000ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,0,255)\" to=\"rgb(0,170,85)\" "
            + "fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"CSS\" begin=\"35000ms\" dur=\"5000ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,170,85)\" to=\"rgb(0,255,0)\" "
            + "fill=\"freeze\" />\n"
            + "</ellipse>\n\n"
            + "\n\n</svg>", s.toString().trim());
    
  }
  
}