package ui;

import javax.swing.*;
import java.awt.*;

public class PatientListItem extends JPanel {
    private int width;
    private String name;
    private String lastName;
    private int age;
    private final int HEIGHT = 100;
    public PatientListItem(int WIDTH){
        JLabel fullNameTxt = new JLabel(name + " " + lastName);
        JLabel ageTxt = new JLabel("Age: " + age);
        //Date
        setSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(255, 208, 208));
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setVisible(true);

        f.add( new PatientListItem(150));
    }
}
