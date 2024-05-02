package ui;

import model.patient.Patient;
import model.patientCategories.PregnantPatient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientCategoryMenu extends JMenuBar {
private Patient category;
    public PatientCategoryMenu() {

        // Create a JMenu
        JMenu menu = new JMenu("Categories");
        // Create menu items
        JMenuItem item1 = new JMenuItem("Pregnant");
        JMenuItem item2 = new JMenuItem("Minor");
        JMenuItem item3 = new JMenuItem("Adult");

        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform actions for Item 1
                category = new PregnantPatient();
            }
        });
        // Add menu items to the menu
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);

        // Add the menu to the menu bar
        add(menu);
    }
}

