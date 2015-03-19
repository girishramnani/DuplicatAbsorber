package Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Girish on 17-03-2015.
 */
public class BottomPanel extends JPanel implements Interactor
{
    private ComponentMixin toppanel;
    private JButton startButton;
    private LayoutManager layoutManager;
    private JButton deleteButton;
    public BottomPanel(){

        deleteButton = new JButton("Delete");
        startButton = new JButton("Start");
        startButton.setEnabled(false);
        deleteButton.setEnabled(false);

        layoutManager = new FlowLayout(FlowLayout.RIGHT,10,10);
        setLayout(layoutManager);
        startButton.addActionListener(new startButtonEventlistener());

        add(startButton);
        add(deleteButton);
    }

    @Override
    public void interact() {
        startButton.setEnabled(true);
    }
}
