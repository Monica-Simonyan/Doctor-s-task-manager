package ui.PopupItems;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenderRadioButtons extends ButtonGroup {
    public JRadioButton maleRadioButton;
    public JRadioButton femaleRadioButton;
    private String selectedGender;
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

    public String getSelectedGender(){
        return selectedGender;
    }
}
