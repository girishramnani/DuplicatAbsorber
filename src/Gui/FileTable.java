package Gui;


import FileFind.FileEvent;
import Model.FileModel;

import javax.swing.*;
import java.io.File;
import java.util.List;

/**
 * the main File Jtable that shows the files which are duplicate.
 */
public class FileTable extends JTable {

    public FileTable(){
        super();
        setModel(new FileModel());


    }
}
