//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.*;

class BallTestTwo extends Canvas implements Runnable {
    private Ball ball;

    public BallTestTwo() {
        setBackground(Color.WHITE);
        setVisible(true);

        ball = new Ball();


        //test the Ball thoroughly


        //test all constructors


        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        ball.moveAndDraw(window);

        if (!(ball.getX() >= 10 && ball.getX() <= 550)) {
            ball.setXSpeed(-ball.getXSpeed());
        }

        if (!(ball.getY() >= 10 && ball.getY() <= 450)) {
            ball.setYSpeed(-ball.getYSpeed());
        }
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(19);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
