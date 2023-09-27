package init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MovingCircle extends JPanel implements ActionListener {
	private int x = 160;
	private int y = 0;
	private int ySpeed = 1;
	
	public MovingCircle() {
		Timer timer = new Timer(10, this);
		timer.start();
		
		addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	boolean insideCircle = false;
                int mouseX = e.getX();
                int mouseY = e.getY();

                // Check if the mouse click is inside the circle
                if (isInsideCircle(mouseX, mouseY)) {
                    insideCircle = true;
                    System.out.println("Inside of the circle");
                } else {
                    insideCircle = false;
                    System.out.println("Not inside of the circle");
                }

                repaint();
            }
        });
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawCircle(g);
	}
	
	public void drawCircle(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, 50, 50);
	}
	
	private boolean isInsideCircle(int mouseX, int mouseY) {
        int centerX = x + 25; // X coordinate of the center of the circle
        int centerY = y + 25; // Y coordinate of the center of the circle
        int radius = 25; // Radius of the circle

        // Use the Pythagorean theorem to check if cursor is inside the circle
        int mx = mouseX - centerX;
        int my = mouseY - centerY;
        return (mx * mx + my * my) <= (radius * radius);
    }
	
	public void actionPerformed(ActionEvent e) {
		y += ySpeed;
		
		if (y <= 0 || y >= getHeight() - 50) {
			ySpeed = -ySpeed;
		}
		
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Moving circle");
		MovingCircle bouncingCircle = new MovingCircle();
		frame.add(bouncingCircle);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}