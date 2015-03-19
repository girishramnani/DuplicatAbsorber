package Gui;


import Model.FileModel;

import javax.swing.*;

/**
 * the controller File Jtable that shows the files which are duplicate.
 */
public class FileTable extends JTable {
    private FileModel fileModel;
    public FileTable(){
        super();
        fileModel = new FileModel();

        setModel(fileModel);
        setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        setEnabled(true);



    }
}
