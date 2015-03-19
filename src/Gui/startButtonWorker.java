package Gui;

import FileFind.FileEvent;
import FileFind.FileEventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class startButtonWorker implements ActionListener, FileEventListener {

    private ComponentMixin topPanel;


    public startButtonWorker(ComponentMixin topPanel){
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
