package Gui;

import FileFind.FileEvent;
import FileFind.FileEventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Girish on 19-03-2015.
 */
public class startButtonEventlistener implements ActionListener, FileEventListener {

    private ComponentMixin topPanel;


    public startButtonEventlistener(ComponentMixin topPanel){
        this.topPanel = topPanel;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        topPanel.addFileListener(this);
        topPanel.start();

    }

    @Override
    public void apply(FileEvent fileEvent) {
        System.out.println(fileEvent.getFile().toString());

    }
}
