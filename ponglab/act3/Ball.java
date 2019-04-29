//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.*;

public class Ball extends Block {
    private int xSpeed;
    private int ySpeed;

    public Ball() {
        super(200, 200);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y) {
        super(x, y);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Ball(int x, int y, int width, int height, Color col) {
        super(x, y, width, height, col);
    }

    public Ball(int x, int y, int width, int height, Color col, int xspd, int yspd) {
        super(x, y, width, height, col);
        xSpeed = xspd;
        ySpeed = yspd;
    }


    public void moveAndDraw(Graphics window) {
        draw(window, Color.white);

        setX(getX() + xSpeed);
        setY(getY() + ySpeed);

        draw(window, getColor());

    }

    public boolean equals(Object obj) {
        Ball tb = (Ball) obj;
        return super.equals(obj) && (getYSpeed() == tb.getYSpeed() && getXSpeed() == tb.getXSpeed());
    }

    

    public int getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(int yspd) {
        ySpeed = yspd;
    }

    public int getXSpeed() {
        return xSpeed;
    }


    public void setXSpeed(int xspd) {
        xSpeed = xspd;
    }

    public String toString() {
        return super.toString() + "\tSpeed: [" + xSpeed + " " + ySpeed + "]";
    }
}
