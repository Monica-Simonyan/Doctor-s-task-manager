package ui.Menus;

import ui.HomePage;

import javax.swing.*;

/**
 * Represents the dropdown manu for sorting the patients by name, age, and date
 */
public class SortDropDownMenu extends JMenuBar {
    public SortDropDownMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu sortMenu = new JMenu("Sort");
        JMenuItem sortByNameItem = new JMenuItem("By Name");
        JMenuItem sortByAgeItem = new JMenuItem("By Age");
        JMenuItem sortByDateItem = new JMenuItem("By Date");
        JMenuItem sortByDefault = new JMenuItem("By Default");

        sortByNameItem.addActionListener(e -> {
            HomePage.sortPatientsByName();
        });

        sortByAgeItem.addActionListener(e -> {
            HomePage.sortPatientsByAge();
        });

        sortByDateItem.addActionListener(e -> {
            HomePage.sortPatientsByDate();
        });
        sortByDefault.addActionListener(e -> {
            HomePage.sortPatientsByDefault();
        });

        sortMenu.add(sortByNameItem);
        sortMenu.add(sortByAgeItem);
        sortMenu.add(sortByDateItem);
        sortMenu.add(sortByDefault);
        setBounds(0, 30, 70, 20);
        menuBar.add(sortMenu);
        add(menuBar);
    }
}
