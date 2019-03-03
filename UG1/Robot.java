//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
  public Robot()    //constructor method - sets up the class
  {
    setSize(800,600);
    setBackground(Color.WHITE);   	
    setVisible(true);
  }
  
  public void paint( Graphics window )
  {
    window.setColor(Color.BLUE);
    
    window.drawString("Robot LAB ", 35, 35 );
    
   head(window);
   upperBody(window);
   lowerBody(window);
    
    //call other methods
    
  }
  
  public void head( Graphics window )
  {

    window.setColor(Color.YELLOW);
    window.fillOval( 210, 100, 400, 400 );

    window.setColor(Color.BLUE);
    window.fillOval( 260, 220, 100, 50 );
    window.setColor(Color.GREEN);

    window.fillOval( 460, 220, 100, 50 );
    window.setColor(Color.red);
    window.drawArc(300,320,220,100,0,-180);

    //add more code here
    
  }

  public void upperBody( Graphics window )
  {

    window.drawLine(410,500,410,550);

  }

  public void lowerBody( Graphics window )
  {

    window.drawLine(410,550,440,570);
    window.drawLine(410,550,380,570);



  }
}
