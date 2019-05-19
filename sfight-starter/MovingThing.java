//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Moveable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  public MovingThing()
  {
    xPos = 10;
    yPos = 10;
    width = 10;
    height = 10;
  }

  public MovingThing(int x, int y)
  {
    xPos = x;
    yPos = y;
    width = 10;
    height = 10;
  }

  public MovingThing(int x, int y, int w, int h)
  {
    xPos = x;
    yPos = y;
    width = w;
    height = h;
  }

  public void setPos( int x, int y)
  {
    xPos = x;
    yPos = y;
    width = 10;
    height = 10;
  }

  public void setX(int x)
  {
    xPos = x;
    yPos = 10;
    width = 10;
    height = 10;
  }

  public void setY(int y)
  {
    xPos = 10;
    yPos = y;
    width = 10;
    height = 10;
  }

  public int getX()
  {
    return xPos;   //finish this method
  }

  public int getY()
  {
    return yPos;  //finish this method
  }

  public void setWidth(int w)
  {
    xPos = 10;
    yPos = 10;
    width = w;
    height = 10;

  }

  public void setHeight(int h)
  {
    xPos = 10;
    yPos = 10;
    width = 10;
    height = h;
  }

  public int getWidth()
  {
    return width;  //finish this method
  }

  public int getHeight()
  {
    return height;  //finish this method
  }

  public abstract void move(String direction);
  public abstract void draw(Graphics window);

  public String toString()
  {
    return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
  }
}
