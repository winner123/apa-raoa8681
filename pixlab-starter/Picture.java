import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  public void KeepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  public void grayscaleAverage()
{
  Pixel[][] pixels = this.getPixels2D();
  for (Pixel[] rowArray : pixels)
  {
    for (Pixel pixelObj : rowArray)
    {
      pixelObj.setGrayAverage();
    }
  }
}
public void grayscaleLightness()
{
  Pixel[][] pixels = this.getPixels2D();
  for (Pixel[] rowArray : pixels)
  {
    for (Pixel pixelObj : rowArray)
    {
      pixelObj.setGrayLightness();
    }
  }
}
public void grayscaleLuminosity()
{
  Pixel[][] pixels = this.getPixels2D();
  for (Pixel[] rowArray : pixels)
  {
    for (Pixel pixelObj : rowArray)
    {
      pixelObj.setGrayLuminosity();
    }
  }
}

  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setBlue(255-pixelObj.getBlue());

      }
    }
  }



  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int average = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
        pixelObj.setRed(average);
        pixelObj.setGreen(average);
        pixelObj.setBlue(average);
      }
    }
  }



  /** Method that mirrors the picture around a
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  public void mirrorDiagonal() {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel blPixel = null;
	    Pixel trPixel = null;
	    int height = pixels.length;
	    int width = pixels[0].length;
	    int side = Math.min(height, width);


	    for (int row = side - 1; row >= 0; row--)
	    {
	      for (int col = side - 1; col >= 0; col--)
	      {
	        trPixel = pixels[row][col];
	        blPixel = pixels[col][row];
	        blPixel.setColor(trPixel.getColor());
	      }
	    }
  }
  public void mirrorArms()
  {
    /**
    int mirrorPoint = 195;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();

    // Left arm
    for (int row = 158; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 103; col < 170; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }

    int mirrorPoint2 = 198;
    Pixel topPixel2 = null;
    Pixel bottomPixel2 = null;

    // Right arm
    for (int row = 169; row < mirrorPoint2; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 239; col < 294; col++)
      {
        topPixel2 = pixels[row][col];
        bottomPixel2 = pixels[mirrorPoint2 - row + mirrorPoint2][col];
        bottomPixel2.setColor(topPixel2.getColor());
      }
    }
    **/
    mirrorRectangle(158, 103, 195, 170, false);
    mirrorRectangle(169, 239, 198, 294, false);

  }
  public void mirrorGull()
  {

    mirrorRectangle(234, 236, 320, 370, true);

  }
  public void mirrorRectangle(int x1, int y1, int x2, int y2, boolean vertical){
      Pixel[][] pixels = this.getPixels2D();
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel topPixel = null;
      Pixel bottomPixel = null;

      int width = pixels[0].length;

     if(vertical){
       for (int row = x1; row < x2; row++)
       {
         for (int col = y1; col < y2; col++)
         {
           leftPixel = pixels[row][col];
           rightPixel = pixels[row][width - 1 - col];
           rightPixel.setColor(leftPixel.getColor());
         }
       }
     }

     else{
       for (int row = x1; row < x2; row++)
       {
         // loop from 13 to just before the mirror point
         for (int col = y1; col < y2; col++)
         {
           topPixel = pixels[row][col];
           bottomPixel = pixels[x2 - row + x2][col];
           bottomPixel.setColor(topPixel.getColor());
         }
       }
     }



  }
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  public void mirrorHorizontal()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel botPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height / 2; row++)
		{
			for (int col = 0; col < pixels[0].length; col++)
			{
				topPixel = pixels[row][col];
				botPixel = pixels[height - row - 1][col];
				botPixel.setColor(topPixel.getColor());
			}
		}
	}

  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        botPixel = pixels[height - row - 1][col];
        topPixel.setColor(botPixel.getColor());
      }
    }
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    int count = 0;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();

    for (int row = 27; row < 97; row++)
    {
      for (int col = 13; col < mirrorPoint; col++)
      {
        count ++;
        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic,
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow;
         fromRow < fromPixels.length &&
         toRow < toPixels.length;
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol;
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }
  public void copy2(Picture fromPic, int startRow, int endRow, int startCol, int endCol)
    {
      Pixel fromPixel = null;
      Pixel toPixel = null;
      Pixel[][] toPixels = this.getPixels2D();
      Pixel[][] fromPixels = fromPic.getPixels2D();
      for (int fromRow = 0, toRow = startRow;
           fromRow < fromPixels.length &&
           toRow < endRow;
           fromRow++, toRow++)
      {
        for (int fromCol = 0, toCol = startCol;
             fromCol < fromPixels[0].length &&
             toCol < endCol;
             fromCol++, toCol++)
        {
          fromPixel = fromPixels[fromRow][fromCol];
          toPixel = toPixels[toRow][toCol];
          toPixel.setColor(fromPixel.getColor());
        }
      }
    }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  public void fixUnderwater() {
	  Pixel[][] pixels = this.getPixels2D();
	  int bluerange = 0;
	  int bluemax = 0;
	  for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {

	    	  if (pixelObj.getBlue() > bluemax) {
	    		  bluemax = pixelObj.getBlue();
	    	  }

	    	  int bluemin = Integer.MAX_VALUE;
	    	  if (pixelObj.getBlue() < bluemin) {
	    		  bluemin = pixelObj.getBlue();
	    	  }

	    	  bluerange = bluemax - bluemin;
	      }
	    }

	  for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	  if (pixelObj.getBlue() > bluemax - (bluerange * 0.65) && pixelObj.getBlue() < 255 && pixelObj.getGreen() < 170) {
	    		  pixelObj.setBlue(bluemax + (int) (pixelObj.getBlue() * 1.4));
	    	  }
	      }
	    }
  }
  public void myCollage() {

	    Picture pic1 = new Picture("beach.jpg");
	    Picture pic2 = new Picture("wall.jpg");
	    Picture pic3 = new Picture("whiteFlower.jpg");
	    pic1.mirrorDiagonal();
      pic1.mirrorVertical();
	    pic1.mirrorHorizontal();

      pic2.fixUnderwater();
      pic2.mirrorVertical();
      pic2.mirrorHorizontal();

      pic2.mirrorDiagonal();
      pic2.mirrorVertical();
      pic2.mirrorDiagonal();

	    this.copy2(pic1,0, 636, 0, 477);
	    this.copy2(pic2,0, 300, 0, 320);
	    this.copy2(pic3,0, 200, 20, 200);

  }


  /** Method to show large changes in color
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0;
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) >
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  public void edgeDetection2(int edgeDist)
  	{
  		Pixel rightpixel = null;
  		Pixel leftpixel = null;
  		Pixel[][] pixels = this.getPixels2D();
  		Color color = null;
  		for (int row = 0; row < pixels.length-1; row++)
  		{
  			for (int col = 1; col < pixels[0].length-1; col++)
  			{
          leftpixel = pixels[row+1][col+1];
          color = leftpixel.getColor();
  				rightpixel = pixels[row][col];
  				if (rightpixel.colorDistance(color) > edgeDist)
  				{
  				  rightpixel.setColor(Color.BLACK);

  				  continue;
  				}
  				leftpixel = pixels[row+1][col-1];
  				color = leftpixel.getColor();
  				if (rightpixel.colorDistance(color) > edgeDist)
  				{
  				  rightpixel.setColor(Color.BLACK);

  				  continue;
  				}
  				rightpixel.setColor(Color.WHITE);
  			}
  		}
  	}

  /* Main method for testing - each class in Java can have a main
   * method
   */
  public static void main(String[] args)
  {
  //  Picture beach = new Picture("beach.jpg");
    Picture water = new Picture("water.jpg");
    water.explore();
  //  beach.explore();
  //  beach.zeroBlue();
  //  beach.explore();
  }

} // this } is the end of class Picture, put all new methods before this
