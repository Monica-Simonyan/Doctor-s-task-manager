package ui;

import model.patient.PersonalInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientListItem extends JPanel {
    private String name;
    private String lastName;
    private int age;
    private PersonalInformation.Gender gender;
    private static final int HEIGHT = 100;

    public PatientListItem( String name, String lastName, int age, PersonalInformation.Gender gender) {
        JButton closeBtn = new JButton("x");
    //    boolean isInList = true;
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container parent = getParent();
                if (parent != null) {
                    // Remove this panel from its parent
                    parent.remove(PatientListItem.this);
                    // Repaint the parent to reflect the change
                    parent.revalidate();
                    parent.repaint();
                }
            }
        });
        JLabel fullNameTxt = new JLabel(name + " " + lastName);
        JLabel ageTxt = new JLabel("Age: " + age);
        setLayout(new GridLayout(3, 1));
        add(fullNameTxt);
        add(ageTxt);
        //Date
        setSize(new Dimension(PatientList.WIDTH, HEIGHT));
        setBackground(new Color(252, 217, 217));

    }
}
