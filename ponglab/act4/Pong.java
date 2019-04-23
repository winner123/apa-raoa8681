//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import static java.lang.Character.toUpperCase;

public class Pong extends Canvas implements KeyListener, Runnable {
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;
    private BufferedImage back;
    private int leftScore;
  	private int rightScore;
    private int width;
    private int height;

    public Pong(int w, int h) {
        ball = new Ball();
         width = w;
         height = h;
        int paddleX = (int) (width * 0.01);
       	int paddleY = (int) (height * 0.5);
       	int paddleWidth = (int) (0.0125 * width);
       	int paddleHeight = (int) (0.15 * height);
       	int paddleSpeed = (int) (0.01 * height);


      //  wall = new Wall(0,10000, -10, 550);

        keys = new boolean[4];

        leftScore = 0;
    		rightScore = 0;


        setBackground(Color.WHITE);
        setVisible(true);
        leftPaddle = new Paddle(paddleX, paddleY, paddleWidth, paddleHeight, paddleSpeed);
       	rightPaddle = new Paddle(width - paddleX - paddleWidth, paddleY, paddleWidth, paddleHeight, paddleSpeed);

        new Thread(this).start();
        addKeyListener(this);        //starts the key thread to log key strokes
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;




        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null)
            back = (BufferedImage) (createImage(getWidth(), getHeight()));

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();


        ball.moveAndDraw(graphToBack);
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);
        graphToBack.setColor(Color.BLACK);


        //see if ball hits left wall or right wall
        if (!(ball.getX() >= 10 && ball.getX() <= width)) {
          ball.setXSpeed(-ball.getXSpeed());

        }
        if(ball.getX()<=10){
          rightScore++;
        }
        if(ball.getX()>=width){
          leftScore++;
        }


        if(!(ball.getY() >= 10 && ball.getY() <= height)){
            ball.setYSpeed(-ball.getYSpeed());

        }


        if (ball.didCollideLeft(leftPaddle) && (ball.didCollideTop(leftPaddle) || ball.didCollideBottom(leftPaddle))) {
            if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth())
                ball.setYSpeed(-ball.getYSpeed());
            else
                ball.setXSpeed(-ball.getXSpeed());

        }

        if (ball.didCollideRight(rightPaddle) && (ball.didCollideTop(rightPaddle) || ball.didCollideBottom(rightPaddle))) {
            if (ball.getX() >= rightPaddle.getX() + rightPaddle.getWidth())
                ball.setYSpeed(-ball.getYSpeed());
            else
                ball.setXSpeed(-ball.getXSpeed());


        }
        //see if the paddles need to be moved
        if (keys[0]) {
          if(leftPaddle.getY() >= 0){
            leftPaddle.moveUpAndDraw(graphToBack);
          }
        }

        if (keys[1]) {
          if(leftPaddle.getY() <= height-50){
            leftPaddle.moveDownAndDraw(graphToBack);
          }
        }

        if (keys[2]) {
          if(rightPaddle.getY() >= 0){
            rightPaddle.moveUpAndDraw(graphToBack);
          }
        }

        if (keys[3]) {
          if(rightPaddle.getY() <= height-50){
            rightPaddle.moveDownAndDraw(graphToBack);
          }        }

        twoDGraph.drawImage(back, null, 0, 0);
        twoDGraph.drawString("Leftscore: " + Integer.toString(leftScore), width/40, height-30);
twoDGraph.drawString("Rightscore: " + Integer.toString(rightScore), width/40, height-50);

    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = true;
                break;
            case 'Z':
                keys[1] = true;
                break;
            case 'I':
                keys[2] = true;
                break;
            case 'M':
                keys[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = false;
                break;
            case 'Z':
                keys[1] = false;
                break;
            case 'I':
                keys[2] = false;
                break;
            case 'M':
                keys[3] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
