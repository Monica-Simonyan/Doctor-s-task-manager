package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AddButton extends JButton {
    int diameter;
    public AddButton(int diameter) {
        this.diameter = diameter;
        setPreferredSize(new Dimension(diameter, diameter));
        setFont(new Font("Arial", Font.BOLD, 24));
        setBackground(new Color(5, 5, 5, 0));
        setBorder(new EmptyBorder(1,1,1,1));
        setFocusable(false);
        addActionListener(e -> {
            // Add your action here
            new AddPatientPopup();
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
        g2d.setColor(new Color(225, 172, 172));
        g2d.fill(circle);;
        // Draw the resized plus sign image at the center of the button
        int plusX = getWidth() / 2;
        int plusY = getWidth()/ 2;
        g2d.setFont(new Font("Arial", Font.CENTER_BASELINE, diameter/3)); // Example font and size
        g2d.setColor(Color.BLACK);
        String btnText = "Add";
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(btnText);
        int textHeight = fm.getAscent();

        // Calculate text position to center it horizontally and vertically
        int textX = (getWidth() - textWidth) / 2;
        int textY = (getHeight() - textHeight) / 2 + fm.getAscent();

        // Draw text at calculated position
        g2d.drawString(btnText, textX, textY);
        g2d.dispose();
    }
}
