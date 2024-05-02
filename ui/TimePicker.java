
package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

/**
 * A utility class for creating a time picker component.
 */
public class TimePicker {

    /**
     * Places a time picker component on the specified JPanel.
     *
     * @param panel The JPanel on which the time picker component will be placed.
     */
    public static void placeTimeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(0, 2, 5, 5));
        JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);
        panel.add(timeSpinner);
        setTimeToCurrent(timeSpinner);
    }

    /**
     * Sets the time of the specified JSpinner to the current time plus one second.
     *
     * @param timeSpinner The JSpinner to set the time for.
     */
    private static void setTimeToCurrent(JSpinner timeSpinner) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        Date nextSecond = calendar.getTime();
        timeSpinner.setValue(nextSecond);
    }
}
