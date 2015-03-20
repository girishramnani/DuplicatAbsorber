package Gui;

import FileFind.FileEvent;
import FileWork.Algorithm;
import FileWork.DefaultHashWorker;
import FileWork.HashWorker;
import Model.Backend;
import Model.FileModel;
import Model.HashRepository;
import Model.HashRepositoryFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Girish on 19-03-2015.
 */
public class MainWorker extends SwingWorker<Void,String> {
    private FileProgressBar fileProgressBar;
    private HashRepository hashRepository;
    private HashWorker hashWorker;
    private ComponentMixin componentMixin;
    private ConcurrentLinkedDeque<FileEvent> fileEvents;
    private AtomicInteger count=new AtomicInteger(0);
    private List<FileEvent> duplicatefileList;
    private int size;
    private  FileModel fileModel;
    public ComponentMixin getComponentMixin() {
        return componentMixin;
    }

    public void setComponentMixin(ComponentMixin componentMixin) {
        this.componentMixin = componentMixin;
    }

    public MainWorker(FileProgressBar fileProgressBar){
        duplicatefileList  =new ArrayList<>();
        this.fileProgressBar = fileProgressBar;
        hashRepository = HashRepositoryFactory.getInstance(Backend.HashSet);
        hashWorker = new DefaultHashWorker(Algorithm.SHA1);
        fileEvents = new ConcurrentLinkedDeque<>();


    }
    public void setFileModel(FileModel fileModel){
        this.fileModel = fileModel;
    }
    public void show(){
        fileProgressBar.setVisi(true);
    }

    @Override
    protected void process(List<String> chunks) {
        System.out.println(chunks.get(chunks.size()-1));
        fileProgressBar.setProgressValue((int) ((Integer.parseInt(chunks.get(chunks.size() - 1)) / (float) size) * 100));
        fileProgressBar.setFileName(chunks.get(chunks.size()-2));
    }

    @Override
    protected void done() {


        fileProgressBar.close();
        System.out.println(hashRepository);
    }

    @Override
    protected Void doInBackground() throws Exception {
        synchronized (fileEvents){
            for(int i=0;i<size;i++){


                FileEvent testevent=fileEvents.pop();
                String temp_hash = hashWorker.transform(testevent);
                if(hashRepository.present(temp_hash)){
                    fileModel.addData(testevent);
                }
                else {
                    hashRepository.addData(temp_hash);
                }
                publish(testevent.getFile().getName(),i+"");

            }

            return null;
        }

    }

    public void runFiler() {
        synchronized (fileEvents){
            fileProgressBar.setFileName("Indexing ...");
            fileEvents = componentMixin.start();
            size = fileEvents.size();
            System.out.println(size);
            fileProgressBar.setIndeterminate(false);
        }


    }


}
