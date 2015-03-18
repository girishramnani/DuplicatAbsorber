package Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Girish on 17-03-2015.
 */
public class BottomPanel extends JPanel {

    private JButton startButton;
    private LayoutManager layoutManager;

    public BottomPanel(){
        startButton = new JButton("Start");
        layoutManager = new FlowLayout(FlowLayout.RIGHT,10,10);
        setLayout(layoutManager);
        add(startButton);
    }
}
