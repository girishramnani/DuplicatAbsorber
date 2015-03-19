package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Girish on 19-03-2015.
 */
public class startButtonEventlistener implements ActionListener {

    private BottomPanel bottomPanel;
    private TopPanel topPanel;


    public startButtonEventlistener(){

    }

    public BottomPanel getBottomPanel() {
        return bottomPanel;
    }

    public void setBottomPanel(BottomPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }

    public TopPanel getTopPanel() {
        return topPanel;
    }

    public void setTopPanel(TopPanel topPanel) {
        this.topPanel = topPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileProgressBar fpb = new FileProgressBar();
    }
}
