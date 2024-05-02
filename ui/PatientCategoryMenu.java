/**
 * The PatientCategoryMenu class represents a menu bar for selecting patient categories.
 * It provides functionality for choosing between different patient categories, such as pregnant, minor, and adult.
 */
package ui;

import model.patient.Patient;
import model.patientCategories.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientCategoryMenu extends JMenuBar {
    private Patient category = new AdultPatient();

    /**
     * Constructs a new PatientCategoryMenu object.
     */
    public PatientCategoryMenu() {

        JMenu menu = new JMenu("Categories");

        JMenuItem item1 = new JMenuItem("Pregnant");
        JMenuItem item2 = new JMenuItem("Minor");
        JMenuItem item3 = new JMenuItem("Adult");

        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.setText(item1.getText());
                category = new PregnantPatient();
            }
        });
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.setText(item2.getText());
                category = new MinorPatient();
            }
        });
        item3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.setText(item3.getText());
                category = new AdultPatient();
            }
        });

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        add(menu);
    }

    /**
     * Retrieves the selected patient category.
     *
     * @return The selected patient category.
     */
    public Patient accessCategory() {
        return category;
    }

}
