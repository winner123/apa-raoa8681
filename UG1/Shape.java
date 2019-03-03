
import java.awt.Color;
import java.awt.Graphics;

public class Shape
{
    //instance variables
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;

    public Shape(int x, int y, int wid, int ht, Color col)
    {
        xPos = x; yPos = y; width = wid; height = ht; color = col;
    }

    public void draw(Graphics window)
    {

        window.setColor(color);
        window.fillRect(xPos, yPos, width, height);
        window.fillOval(xPos, yPos + height, width, width);
        window.fillOval(xPos, yPos + height+width, width, width);
        window.fillRect(xPos, yPos + 2*height, width, width);
        window.fillOval(xPos, yPos + 2*height+width, width, width);
    }

    public String toString()
    {
        return xPos+" "+yPos+" "+width+" "+height+" "+color;
    }
}