package controller;

import FileFind.FileEvent;
import FileWork.Worker;
import Gui.Interactor;
import Model.FileModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Deleter interacts with the file model and the frame to work on the files
 * activates the Delete button
 *
 */
public class Deleter implements Worker {
    private JButton deleteButton;
    private FileModel fileModel;
    private Interactor interactor;



    public Deleter(JButton deleteButton,FileModel fileModel){
        this.deleteButton = deleteButton;
        this.fileModel =fileModel;

    }

    public void initialize(){
        fileModel.setInteractor(new Interactor() {
            @Override
            public void interact(String... work) {
                if(Integer.parseInt(work[0])==0){
                    deleteButton.setEnabled(false);
                }
                else{
                    deleteButton.setEnabled(true);
                }
            }
             });

    }

    @Override
    public String transform(FileEvent fileEvent) throws IOException {
        return null;
    }
    public void addlistner(){
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileModel.get
            }
        });

    }
}
