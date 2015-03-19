package Gui;

import FileFind.FileEvent;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Girish on 19-03-2015.
 */
public interface ComponentMixin {

    public ConcurrentLinkedDeque<FileEvent> start();

}
