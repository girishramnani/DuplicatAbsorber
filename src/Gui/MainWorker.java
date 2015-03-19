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
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Girish on 19-03-2015.
 */
public class MainWorker extends SwingWorker<Void,String> implements FileEventListener{
    private FileProgressBar fileProgressBar;
    private HashRepository hashRepository;
    private HashWorker hashWorker;
    private ComponentMixin componentMixin;
    private ConcurrentLinkedDeque<FileEvent> fileEvents;

    public ComponentMixin getComponentMixin() {
        return componentMixin;
    }

    public void setComponentMixin(ComponentMixin componentMixin) {
        this.componentMixin = componentMixin;
        this.componentMixin.addFileListener(this);
    }

    public MainWorker(FileProgressBar fileProgressBar){
        this.fileProgressBar = fileProgressBar;
        hashRepository = HashRepositoryFactory.getInstance(Backend.HashSet);
        hashWorker = new DefaultHashWorker(Algorithm.SHA1);
        fileEvents = new ConcurrentLinkedDeque<>();

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

    public void runFiler() {
        componentMixin.start();
    }

    @Override
    public void apply(FileEvent fileEvent) {
        System.out.println(fileEvent.getFile().toString());
    }
}
