package ui.Elements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the gender radio button for the doctor to choose the
 * patient's gender
 */
public class GenderRadioButtons extends ButtonGroup {
    public JRadioButton maleRadioButton;
    public JRadioButton femaleRadioButton;
    private String selectedGender;


    /**
     * Implements the gender radio buttons
     */
    public GenderRadioButtons() {
        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selected = (JRadioButton) e.getSource();
                selectedGender = selected.getText();
            }
        });
        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selected = (JRadioButton) e.getSource();
                selectedGender = selected.getText();
            }
        });
        add(maleRadioButton);
        add(femaleRadioButton);
    }


    /**
     * Returns the selected gender
     * @return     <code>String</code> gender
     */
    public String getSelectedGender() {
        return selectedGender;
    }
}
