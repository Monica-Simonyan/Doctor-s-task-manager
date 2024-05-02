package ui;

import model.patient.Patient;
import model.patientCategories.AdultPatient;
import model.patientCategories.MinorPatient;
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
                menu.setText(item1.getText());
                category = new PregnantPatient();
            }
        });
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform actions for Item 1
                menu.setText(item2.getText());
                category = new MinorPatient();
            }
        });
        item3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform actions for Item 1
                menu.setText(item3.getText());
                category = new AdultPatient();
            }
        });
        // Add menu items to the menu
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);

        // Add the menu to the menu bar
        add(menu);
    }

    public Patient accessCategory() {
        return category;
    }

    public void setCategory(Patient category) {
        this.category = category.clone();
    }
}

