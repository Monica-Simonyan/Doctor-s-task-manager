package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AddButton extends JButton {
    public AddButton() {
        setPreferredSize(new Dimension(100, 100));
        setFont(new Font("Arial", Font.BOLD, 24));
        addActionListener(e -> {
            // Add your action here
            JOptionPane.showMessageDialog(this, "Button clicked!");
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        Ellipse2D circle = new Ellipse2D.Double(x, y, diameter, diameter);
        g2d.setColor(Color.BLUE);
        g2d.fill(circle);
        g2d.dispose();
    }
}
