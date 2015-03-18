package Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Girish on 17-03-2015.
 */
public class BottomPanel extends JPanel {

    private JButton startButton;
    private LayoutManager layoutManager;
    private JButton deleteButton;
    public BottomPanel(){

        deleteButton = new JButton("Delete");
        startButton = new JButton("Start");
        layoutManager = new FlowLayout(FlowLayout.RIGHT,10,10);
        setLayout(layoutManager);
        add(startButton);
    }
}
