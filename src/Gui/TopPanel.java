package Gui;

import javax.swing.*;

/**
 * Created by Girish on 17-03-2015.
 */
public class TopPanel extends JPanel {
    private JLabel label ;
    private JTextField directoryField;
    private JButton BrowseButton;

    public TopPanel(){
        label = new JLabel("The directory:-");
        directoryField = new JTextField(20);


    }
}
