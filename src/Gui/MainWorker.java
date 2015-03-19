package Gui;

import FileFind.FileEvent;
import FileFind.FileEventListener;
import FileWork.Algorithm;
import FileWork.DefaultHashWorker;
import FileWork.HashWorker;
import Model.Backend;
import Model.HashRepository;
import Model.HashRepositoryFactory;

import javax.swing.*;
import java.util.List;

/**
 * Created by Girish on 19-03-2015.
 */
public class MainWorker extends SwingWorker<Void,String> implements FileEventListener{
    private FileProgressBar fileProgressBar;
    private HashRepository hashRepository;
    private HashWorker hashWorker;
    public MainWorker(FileProgressBar fileProgressBar){
        this.fileProgressBar = fileProgressBar;
        hashRepository = HashRepositoryFactory.getInstance(Backend.HashSet);
        hashWorker = new DefaultHashWorker(Algorithm.SHA1);
    }
    public void show(){
        fileProgressBar.setVisi(true);
    }

    @Override
    protected void process(List<String> chunks) {
        fileProgressBar.setFileName(chunks.get(chunks.size()-1));
    }

    @Override
    protected void done() {
        fileProgressBar.close();
    }

    @Override
    protected Void doInBackground() throws Exception {
        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            publish("Worker "+i);

        }

        return null;
    }

    @Override
    public void apply(FileEvent fileEvent) {
        System.out.println(fileEvent.getFile().toString());
    }
}
