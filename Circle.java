package init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Circle extends JPanel {
    private int x = 160;
    private int y = 150;

    public Circle() {
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

        // Check if cursor is inside the circle
        int mx = mouseX - centerX;
        int my = mouseY - centerY;
        return (mx * mx + my * my) <= (radius * radius);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("circle");
        Circle circle = new Circle();
        frame.add(circle);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}