package Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Girish on 17-03-2015.
 */
public class TopPanel extends JPanel {
    private JLabel label ;
    private JTextField directoryField;
    private JButton BrowseButton;
    private LayoutManager layoutManager;

    public TopPanel(){
        layoutManager = new BoxLayout(this,BoxLayout.X_AXIS);
        label = new JLabel("The directory:-");
        directoryField = new JTextField(40);
        BrowseButton = new JButton("Browse");

        add(label);
        add(Box.createHorizontalStrut(10));
        add(directoryField);
        add(Box.createHorizontalStrut(10));
        add(BrowseButton);




    }
}
