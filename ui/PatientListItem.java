package ui;

import model.patient.PersonalInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientListItem extends JPanel {
    private static final int HEIGHT = 100;
    private static final Color color = new Color(252, 217, 217);

    public PatientListItem(PersonalInformation info) {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(4, 2));
        infoPanel.setBackground(color);
        JButton closeBtn = new JButton("x");
        closeBtn.setForeground(Color.RED);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeBtn.setBackground(color);
        infoPanel.add(closeBtn);
        //    boolean isInList = true;
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container parent = getParent();
                if (parent != null) {
                    // Remove this panel from its parent
                    parent.remove(PatientListItem.this);
                    // Repaint the parent to reflect the change
                    parent.revalidate();
                    parent.repaint();
                }
            }
        });
        JLabel fullNameTxt = new JLabel(info.getName() + " " + info.getLastName());
        JLabel ageTxt = new JLabel("Age: " + info.getAge());
        JLabel genderTxt = new JLabel("Gender: " + info.getGender().toString().toLowerCase());
        ImageIcon profileImage = new ImageIcon("src/ui/149071.png");
        Image resizedImage = profileImage.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel img = new JLabel(resizedImageIcon);

        infoPanel.add(fullNameTxt);
        infoPanel.add(ageTxt);
        infoPanel.add(genderTxt);
        add(infoPanel);
        add(img);
        setSize(new Dimension(PatientList.WIDTH, 200));
        setBackground(color);

    }
}
