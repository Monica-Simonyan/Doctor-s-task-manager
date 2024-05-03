package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Represents a custom circular JButton with 'Add' text.
 */
public class AddButton extends JButton {
    private final int diameter;
    private final Color color = new Color(225, 172, 172);

    /**
     * Constructs an AddButton with the specified diameter.
     *
     * @param diameter The diameter of the circular button.
     */
    public AddButton(int diameter) {
        this.diameter = diameter;
        setSize(new Dimension(diameter, diameter));
        setBackground(Color.LIGHT_GRAY); //setting background transparent
        setBorder(null); //get rid of default the border
        setFocusable(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * Overrides the paintComponent method to customize the appearance of the button.
     *
     * @param g The Graphics context used for painting.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        Ellipse2D circle = new Ellipse2D.Double(x, y, diameter, diameter);

        g2d.setColor(color);
        g2d.fill(circle);
        g2d.setFont(new Font("Arial", Font.PLAIN, diameter / 3));
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
