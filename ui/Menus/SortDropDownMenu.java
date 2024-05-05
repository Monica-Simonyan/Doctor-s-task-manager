package ui.Menus;

import javax.swing.*;

public class SortDropDownMenu extends JMenuBar {
    public SortDropDownMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu sortMenu = new JMenu("Sort");
        JMenuItem sortByNameItem = new JMenuItem("By Name");
        JMenuItem sortByAgeItem = new JMenuItem("By Age");
        JMenuItem sortByDateItem = new JMenuItem("By Date");
        JMenuItem sortByDefault = new JMenuItem("By Default");

//        sortByNameItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {}
//        });

//        sortByAgeItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {}
//        });
//
//        sortByDateItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {}
//        });
//

        sortMenu.add(sortByNameItem);
        sortMenu.add(sortByAgeItem);
        sortMenu.add(sortByDateItem);
        sortMenu.add(sortByDefault);
        setBounds(0, 30, 70, 20);
        menuBar.add(sortMenu);
        add(menuBar);
    }
}
