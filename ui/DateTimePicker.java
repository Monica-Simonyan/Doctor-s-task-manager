package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimePicker {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Date and Time Picker Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(2, 2, 5, 5));

        // Date Picker
        JLabel dateLabel = new JLabel("Date:");
        panel.add(dateLabel);

        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy");
        dateSpinner.setEditor(dateEditor);
        panel.add(dateSpinner);

        // Time Picker
        JLabel timeLabel = new JLabel("Time:");
        panel.add(timeLabel);

        JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);
        panel.add(timeSpinner);

        // Set current date and time
        setDateTimeToCurrent(dateSpinner, timeSpinner);
    }

    private static void setDateTimeToCurrent(JSpinner dateSpinner, JSpinner timeSpinner) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        dateSpinner.setValue(currentDate);
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        Date nextSecond = calendar.getTime();
        timeSpinner.setValue(nextSecond);
    }
}
