
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

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
    aliens = new ArrayList<Alien>();
    int x = 25, y = 50;
    for (int i = 0; i < size; i++)
    {
      aliens.add(new Alien(y,x,speed));
      y += 75;
      if (y + aliens.get(i).getWidth() >= WIDTH)
      {
        y = 50;
        x += 75;

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
        if(collisionShot(i,j, shots))
        {

            shots.remove(i);
            aliens.remove(j);

        }
      }
    }
  }

  public boolean collisionShot(int i, int j, List<Ammo> shots){
    boolean hi = shots.get(i).getX() >= aliens.get(j).getX() && shots.get(i).getX() <= aliens.get(j).getX()+aliens.get(j).getWidth();
    boolean bye = shots.get(i).getY() >= aliens.get(j).getY() && shots.get(i).getY() <= aliens.get(j).getY()+aliens.get(j).getHeight();
    return (hi && bye);
  }
  public int getSize(){
    return aliens.size();
  }

  public String toString()
  {
    return "" + aliens;
  }
}
