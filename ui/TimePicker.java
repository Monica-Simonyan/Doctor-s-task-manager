package ui;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class TimePicker {
    public static void placeTimeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(0, 2, 5, 5));
        JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);
        panel.add(timeSpinner);
        setTimeToCurrent(timeSpinner);
    }
    private static void setTimeToCurrent(JSpinner timeSpinner) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        Date nextSecond = calendar.getTime();
        timeSpinner.setValue(nextSecond);
    }
}
