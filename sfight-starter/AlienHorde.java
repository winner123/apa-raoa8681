
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private List<Alien> aliens;
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;

  public AlienHorde(int size)
  {
    aliens = new ArrayList<>(size);
  }

  public AlienHorde(int size, int speed)
  {
    //initalize ArrayList
    aliens = new ArrayList<Alien>();
    //and fill with size amount of aliens (75 pixels apart)
    int c = 25, r = 50;
    for (int i = 0; i < size; i++)
    {
      aliens.add(new Alien(r,c,speed));
      r += 75;
      if (r + aliens.get(i).getWidth() >= WIDTH)
      {
        r = 50;
        c += 75;
      }
    }
  }

  public void add(Alien al)
  {
    aliens.add(al);
  }

  public void drawEmAll( Graphics window )
  {
    for (Alien a : aliens)
    {
      a.draw(window);
    }
  }

  public void moveEmAll()
  {
    for (Alien a : aliens)
    {
      a.move("DOWN");
    }
  }

  public void removeDeadOnes(List<Ammo> shots)
  {
    for(int i = 0; i < shots.size(); i++)
    {
      for(int j = 0; j < aliens.size(); j++)
      {
        if(shots.get(i).getX() >= aliens.get(j).getX() && shots.get(i).getX() <= aliens.get(j).getX()+aliens.get(j).getWidth())
        {
          if(shots.get(i).getY() >= aliens.get(j).getY() && shots.get(i).getY() <= aliens.get(j).getY()+aliens.get(j).getHeight())
          {
            shots.remove(i);
            aliens.remove(j);
          }
        }
      }
    }
  }

  public String toString()
  {
    return "" + aliens;
  }
}
