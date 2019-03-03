import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapePanel extends JPanel
{
	public ShapePanel()
	{
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	/*
	 *All of your test code should be placed in paint.
	 */
	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("CREATE YOUR OWN SHAPE!",40,40);
		//instantiate a Shape
		//tell your shape to draw
		Shape myShape1 = new Shape(100,100,100,200,Color.GRAY);
		myShape1.draw(window);
		window.setColor(Color.BLUE);
		window.drawString(myShape1.toString(), 40, 60);
		//instantiate a Shape
		//tell your shape to draw
		Shape myShape2 = new Shape(250,100,80,160,Color.GRAY);
		myShape2.draw(window);
		//instantiate a Shape
		//tell your shape to draw
		Shape myShape3 = new Shape(380,100,60,120,Color.GREEN);
		myShape3.draw(window);

		Shape myShape4 = new Shape(490,100,40,80,Color.GREEN);
		myShape4.draw(window);
	}
}
