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
                int outCome =JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the files?","Delete conformation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (outCome==JOptionPane.YES_OPTION) {


                    fileModel.getDuplicateFiles().forEach(new Consumer<FileEvent>() {
                        @Override
                        public void accept(FileEvent fileEvent) {
                            System.out.println(fileEvent.getFile().getAbsolutePath());


                            fileModel.removeData(fileEvent);
                            fileEvent.getFile().delete();


                        }
                    });
                    fileModel.getDuplicateFiles().clear();
                }
            }

        });

    }
}
