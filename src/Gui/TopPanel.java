package Gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

/**
 * Created by Girish on 17-03-2015.
 */
public class TopPanel extends JPanel {
    private JLabel label ;
    private File selectedDirectory;
    private JTextField directoryField;
    private JButton BrowseButton;
    private LayoutManager layoutManager;
    private String Filename;
    private Interactor interactor;
    public String getFilename() {
        return Filename;
    }

    public void setInteractor(Interactor interactor) {
        this.interactor = interactor;
    }

    public TopPanel(){
        layoutManager = new BoxLayout(this,BoxLayout.X_AXIS);
        label = new JLabel("The directory:-");
        directoryField = new JTextField(40);
        BrowseButton = new JButton("Browse");

        add(label);
        add(Box.createHorizontalStrut(10));
        add(directoryField);
        add(Box.createHorizontalStrut(10));
        add(BrowseButton);




    }
    public void FileSelection(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int a=fileChooser.showOpenDialog(this);
        if(a ==JFileChooser.APPROVE_OPTION){
            selectedDirectory=fileChooser.getSelectedFile();
            //check for the directory permissions
            if(interactor !=null){
                interactor.interact();
            }
        }





    }

    private boolean _validate(){
        return false;
    }


}
