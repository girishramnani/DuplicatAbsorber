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
    private startButtonWorker startButtonWorker;
    private FileProgressBar fileProgressBar;
    public BottomPanel(ComponentMixin toppanel){

        deleteButton = new JButton("Delete");
        startButton = new JButton("Start");
        startButton.setEnabled(false);
        deleteButton.setEnabled(false);

        startButtonWorker=new startButtonWorker(toppanel);
        startButton.addActionListener(startButtonWorker);

        layoutManager = new FlowLayout(FlowLayout.RIGHT,10,10);
        setLayout(layoutManager);

        add(startButton);
        add(deleteButton);
    }

    @Override
    public void interact(String... work) {
        startButton.setEnabled(true);
    }
}
