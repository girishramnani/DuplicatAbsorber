package Gui;

import FileFind.FileEvent;
import FileFind.FileEventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class startButtonWorker implements ActionListener, FileEventListener {
    private Interactor interactor;
    private ComponentMixin topPanel;
    private FileProgressBar fileProgressBar;

    public startButtonWorker(ComponentMixin topPanel,FileProgressBar fileProgressBar){
        this.topPanel = topPanel;
        this.fileProgressBar = fileProgressBar;

    }

    public void setInteractor(Interactor interactor){
        this.interactor = interactor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        topPanel.addFileListener(this);
        fileProgressBar.setVisible(true);
        topPanel.start();

    }

    @Override
    public void apply(FileEvent fileEvent) {
        System.out.println(fileEvent.getFile().toString());
        interactor.interact(fileEvent.getFile().getName());

    }
}
