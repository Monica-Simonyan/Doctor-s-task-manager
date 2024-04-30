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
    private final int HEIGHT = 100;

    public PatientListItem( String name, String lastName, int age, PersonalInformation.Gender gender) {
        JButton closeBtn = new JButton("x");
        boolean isInList = true;
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
        setSize(new Dimension(PatientList.WIDTH, PatientList.HEIGHT));
        setBackground(new Color(255, 208, 208));

    }

//    public static void main(String[] args) {
//        JFrame f = new JFrame();
//        f.setSize(300,600);
//        f.setVisible(true);
//f.setLayout(new GridLayout(6,1));
//        f.add( new PatientListItem(150, "M", "L", 16, PersonalInformation.Gender.FEMALE));
//        f.add( new PatientListItem(150, "AAAA", "L", 16, PersonalInformation.Gender.FEMALE));
    // }
}
