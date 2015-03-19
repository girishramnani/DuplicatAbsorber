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

    public BottomPanel(ComponentMixin toppanel,FileProgressBar fileProgressBar){

        deleteButton = new JButton("Delete");
        startButton = new JButton("Start");
        startButton.setEnabled(false);
        deleteButton.setEnabled(false);

        startButtonWorker=new startButtonWorker(toppanel,fileProgressBar);
        startButton.addActionListener(startButtonWorker);




        layoutManager = new FlowLayout(FlowLayout.RIGHT,10,10);
        setLayout(layoutManager);

        add(startButton);
        add(deleteButton);
    }

    public void addInteractor(Interactor interactor){
        startButtonWorker.setInteractor(interactor);
    }
    public void attachlistener(FileProgressBar fileProgressBar){
//        ActionListener act = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                fileProgressBar.setVisible(true);
//                startButton.removeActionListener(this);
//            }
//        };
//        startButton.addActionListener(act);
    }

    @Override
    public void interact(String... work) {
        startButton.setEnabled(true);
    }
}
