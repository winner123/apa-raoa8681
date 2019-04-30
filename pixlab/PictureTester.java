/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods.  Uncomment the methods and the code
 * in the main to test.
 *
 * @author Barbara Ericson
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  public static void testBlur(int x, int y, int w, int h, int n)
  {
     Picture redMoto = new Picture("redMotorcycle.jpg");
     for (int i = 0; i<n; i++){
        redMoto.blur(x,y,w,h);
      }
      redMoto.explore();
  }

  public static void testMirrorArms(){
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();

  }
  public static void testMirrorGull(){
    Picture seagull = new Picture("seagull.jpg");
    seagull.explore();
    seagull.mirrorGull();
    seagull.explore();

  }
  public static void testMyCollage() {
     Picture canvas = new Picture("640x480.jpg");
     canvas.myCollage();
     canvas.explore();
}
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  public static void testMirrorVerticalRightToLeft(){
    Picture temple = new Picture("caterpillar.jpg");
    temple.explore();
    temple.mirrorVerticalRightToLeft();
    temple.explore();

  }

  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  public static void testFixUnderwater()

{
  Picture water = new Picture("water.jpg");
  water.explore();
  water.fixUnderwater();
  water.explore();
}
  public static void testKeepOnlyBlue()
  {
  Picture water = new Picture("water.jpg");
  water.explore();
  water.KeepOnlyBlue();
  water.explore();
  }
public static void testGrayscale()
{
  Picture snowman = new Picture("snowman.jpg");
  snowman.explore();
  snowman.grayscaleAverage();
  snowman.explore();
  snowman = new Picture("snowman.jpg");
  snowman.grayscaleLightness();
  snowman.explore();
  snowman = new Picture("snowman.jpg");
  snowman.grayscaleLuminosity();
  snowman.explore();
}

  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection2(10);
    swan.explore();
  }

  public static void testNegate()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
    //testMirrorTemple();
    //testMirrorArms();
    //testMyCollage();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    testBlur(0, 0 , 638, 479, 10);
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}
