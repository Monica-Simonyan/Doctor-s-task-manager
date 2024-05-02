package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class DatePicker {
    public static void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(0, 2, 5, 5));
        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy");
        dateSpinner.setEditor(dateEditor);
        panel.add(dateSpinner);
        setDateToCurrent(dateSpinner);
    }
    private static void setDateToCurrent(JSpinner dateSpinner) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        dateSpinner.setValue(currentDate);
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
    }
}
