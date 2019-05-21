import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;
public class OuterSpace extends Canvas implements KeyListener, Runnable
{
  private Ship ship;
  private Alien alienOne;
  private Alien alienTwo;
  private int size = 40;
  private int speed = 1;
  private int i = 0;

  private int hordeCleared = 0;
  private AlienHorde horde;
  private Bullets shots;


  private boolean[] keys;
  private BufferedImage back;

  public OuterSpace()
  {

    setBackground(Color.black);

    keys = new boolean[5];



    ship = new Ship(400, 500, 70, 70, 2);

    horde = new AlienHorde(size,1);
    shots = new Bullets();


    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint( Graphics window )
  {
     Graphics2D twoDGraph = (Graphics2D)window;

     if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

     Graphics graphToBack = back.createGraphics();

    graphToBack.setColor(Color.BLUE);
    graphToBack.drawString("StarFighter ", 25, 50 );

    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,800,600);

    ship.draw(graphToBack);

    if(keys[0] == true)
    {
      ship.move("LEFT");
    }


    if(keys[1] == true){
      ship.move("RIGHT");
    }

    if(keys[2] == true){
      ship.move("UP");
    }

    if(keys[3] == true){
      ship.move("DOWN");
    }

    if (keys[4] == true){
      if(i > 0){
      shots.add(new Ammo(ship.getX(),ship.getY(),1));
      i--;

    }
      keys[4] = false;
    }



    horde.removeDeadOnes(shots.getList());
    horde.moveEmAll();
    horde.drawEmAll(graphToBack);
    shots.drawEmAll(graphToBack);
    if(horde.getSize() == 0 && hordeCleared < 3) {
      size = size + 2;
      speed = speed + 1;
      horde = new AlienHorde(size,speed);
      hordeCleared++;

  }
  if(hordeCleared == 2){
    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,800,600);
    graphToBack.setColor(Color.BLUE);
    graphToBack.setFont(new Font("serif", Font.ITALIC, 20));
    graphToBack.drawString("Game Over", 400, 300);

  }


    twoDGraph.drawImage(back, null, 0, 0);
  }


  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = true;

    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = false;
      i = 1;

    }
    repaint();
  }

  public void keyTyped(KeyEvent e)
  {
   }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }
}
