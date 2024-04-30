package ui.gfx;

import ui.PatientList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TimePickerWindow extends JFrame{
    public TimePickerWindow(){
        setTitle("Pick a Date");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu hourMenu=new JMenu("Hour");
        JMenu minuteMenu = new JMenu("Minute");
        JMenu PMAM = new JMenu("PM/AM");
        JMenuItem hourItem=null;
        JMenuItem minuteItem=null;
        JMenuItem AMItem=new JMenuItem("AM");
        JMenuItem PMItem=new JMenuItem("PM");
        PMAM.add(AMItem);
        PMAM.add(PMItem);
        for (int i = 1; i <=12; i++) {
                 hourItem = new JMenuItem(""+i);
                 hourMenu.add(hourItem);
                 minuteItem = new JMenuItem(" : " + (i*5));
                 minuteMenu.add(minuteItem);
        }

        menuBar.add(hourMenu);
        menuBar.add(minuteMenu);
        menuBar.add(PMAM);
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
}
