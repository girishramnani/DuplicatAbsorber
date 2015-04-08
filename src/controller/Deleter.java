package controller;

import FileFind.FileEvent;
import FileWork.Worker;
import Gui.Interactor;
import Model.FileModel;

import javax.swing.*;
import java.io.IOException;

/**
 * Deleter interacts with the file model and the frame to work on the files
 * activates the Delete button
 *
 */
public class Deleter implements Worker {
    private JButton deleteButton;
    private FileModel fileModel;



    public Deleter(JButton deleteButton,FileModel fileModel){
        this.deleteButton = deleteButton;
        this.fileModel =fileModel;

    }

    public void initialize(){
        fileModel.setInteractor(createInteractor());

    }

    public Interactor createInteractor(){
    Interactor interactor = new Interactor() {
            @Override
            public void interact(String... work) {
                if(Integer.parseInt(work[0])==0){
                    deleteButton.setEnabled(false);
                }
                else{
                    deleteButton.setEnabled(true);
                }
            }
        };
        return interactor;
    }




    @Override
    public String transform(FileEvent fileEvent) throws IOException {
        return null;
    }
}
