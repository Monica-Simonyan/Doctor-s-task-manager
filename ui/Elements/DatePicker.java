
package ui.Elements;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

/**
 * A utility class for creating a date picker component.
 */
public class DatePicker {
    Date selectedDate;
    JSpinner dateSpinner;

    /**
     * Places a date picker component on the specified JPanel.
     *
     * @param panel The JPanel on which the date picker component will be placed.
     */
    public void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(0, 2, 5, 5));
        dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy");
        dateSpinner.setEditor(dateEditor);
        panel.add(dateSpinner);
        setDateToCurrent(dateSpinner);

    }

    /**
     * Sets the date of the specified JSpinner to the current date and time.
     *
     * @param dateSpinner The JSpinner to set the date for.
     */
    private void setDateToCurrent(JSpinner dateSpinner) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        dateSpinner.setValue(currentDate);
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
    }

    public Date getSelectedDate() {
        return (Date) dateSpinner.getValue();
    }
}
