import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
  private int speed;

  public Ammo()
  {
    this(0,0,0);
  }

  public Ammo(int x, int y)
  {
    this(x, y, 5);
  }

  public Ammo(int x, int y, int s)
  {
    super(x, y);
    this.speed = s;
  }

  public void setSpeed(int s)
  {
    this.speed = s;
  }

  public int getSpeed()
  {
    return 5;
  }

  public void draw( Graphics window )
  {

    window.setColor(Color.yellow);
    window.fillRect(super.getX()+18, super.getY(), 10, 10);
    move("UP");
  }


  public void move( String direction )
  {
    setY(getY() - getSpeed());
  }

  public String toString()
  {
    return super.toString() + " " + getSpeed();
  }
}
