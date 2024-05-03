package ui;

import javax.swing.*;

public class SortDropDownMenu extends JPanel{
    public SortDropDownMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu sortMenu = new JMenu("Sort");
        JMenuItem sortByNameItem = new JMenuItem("By Name");
        JMenuItem sortByAgeItem = new JMenuItem("By Age");
        JMenuItem sortByDateItem = new JMenuItem("By Date");

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
        sortMenu.setBounds(0,25,70,20);
        menuBar.add(sortMenu);
        add(menuBar);
    }

//    public static void main(String[] args) {
//        JFrame f = new JFrame();
//        f.setSize(300,300);
//        f.add((new SortDropDownMenu()));
//        f.setVisible(true);
//    }
}
