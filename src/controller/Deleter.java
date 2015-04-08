package controller;

import FileFind.FileEvent;
import Gui.Interactor;
import Model.FileModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

/**
 * Deleter interacts with the file model and the frame to work on the files
 * activates the Delete button
 *
 */
public class Deleter  {
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
        addlistner();

    }

    public void addlistner(){
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileModel.getDuplicateFiles().forEach(new Consumer<FileEvent>() {
                    @Override
                    public void accept(FileEvent fileEvent) {
                        System.out.println(fileEvent.getFile().getAbsolutePath());
                        fileEvent.getFile().delete();
                        
                    }
                });
            }
        });

    }
}
