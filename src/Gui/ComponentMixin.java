package Gui;

import FileFind.FileEventListener;

/**
 * Created by Girish on 19-03-2015.
 */
public interface ComponentMixin {

    public void start();
    public void addFileListener(FileEventListener fileEventListener);
}
