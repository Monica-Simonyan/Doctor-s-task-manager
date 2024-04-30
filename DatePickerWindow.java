package ui.gfx;
import ui.PatientList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class DatePickerWindow extends JFrame {
        public DatePickerWindow(int day, String month, int year) {
            setTitle("Pick a Date");
            setSize(400, 300);
            setLocationRelativeTo(null); // Center the window
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);
            JMenu dayMenu=new JMenu("Day");
            JMenu monthMenu = new JMenu("Month");
            JMenu yearMenu = new JMenu("Year");

            JMenuItem dayItem=null;
            for (int i = 1; i <= 31; i++) {
                dayItem = new JMenuItem("" + i);
                dayMenu.add(dayItem);
            }
            JMenuItem monthItem=null;
            JMenuItem yearItem=null;
            for (int i = 1; i <=12; i++) {
                monthItem=new JMenuItem(monthString(i));
                monthMenu.add(monthItem);
                yearItem=new JMenuItem(""+(2020+i));
                yearMenu.add(yearItem);
            }
            dayItem.setLayout(new BoxLayout(dayItem, BoxLayout.Y_AXIS));
            dayItem.setLayout(new FlowLayout());
            JScrollPane dayScrollPane = new JScrollPane(dayItem);
            dayScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            dayMenu.add(dayScrollPane);
            menuBar.add(dayMenu);
            menuBar.add(monthMenu);
            menuBar.add(yearMenu);
            JButton nextButton = new JButton("Next");
            JButton backButton = new JButton("Back");
            JPanel buttonPanel = new JPanel(new BorderLayout());
            add(buttonPanel, BorderLayout.SOUTH);
            nextButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new TimePickerWindow();
                }
            });
            buttonPanel.add(backButton,BorderLayout.WEST);
            buttonPanel.add(nextButton, BorderLayout.EAST);
            setVisible(true);
        }
        public String monthString(int i) {
            return switch (i) {
                case 1 -> "January";
                case 2 -> "February";
                case 3 -> "March";
                case 4 -> "April";
                case 5 -> "May";
                case 6 -> "June";
                case 7 -> "July";
                case 8 -> "August";
                case 9 -> "September";
                case 10 -> "October";
                case 11 -> "November";
                case 12 -> "December";
                default -> "Invalid month";
            };
        }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DatePickerWindow(1, "January", 2024));
    }

}
