
package ui.Menus;

import model.patient.Patient;
import model.patientCategories.*;

import javax.swing.*;

/**
 * The PatientCategoryMenu class represents a menu bar for selecting patient categories.
 * It provides functionality for choosing between different patient categories, such as pregnant, minor, and adult.
 */
public class PatientCategoryMenu extends JMenuBar {
    private Patient category = new AdultPatient();
    String chosen;

    /**
     * Constructs a new PatientCategoryMenu object.
     */
    public PatientCategoryMenu() {

        JMenu menu = new JMenu("Categories");

        JMenuItem item1 = new JMenuItem("Pregnant");
        JMenuItem item2 = new JMenuItem("Minor");
        JMenuItem item3 = new JMenuItem("Adult");
        //String chosen;

        item1.addActionListener(e -> {
            chosen = "Pregnant";
            menu.setText(item1.getText());
            category = new PregnantPatient();
        });
        item2.addActionListener(e -> {
            chosen = "Minor";
            menu.setText(item2.getText());
            category = new MinorPatient();
        });
        item3.addActionListener(e -> {
            chosen = "Adult";
            menu.setText(item3.getText());
            category = new AdultPatient();
        });

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        add(menu);
    }

    public String getChosen() {
        return this.chosen;
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
