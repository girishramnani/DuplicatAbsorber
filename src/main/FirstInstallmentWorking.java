package main;

import Model.Backend;
import Model.HashRepositoryFactory;
import Model.SetHashRepository;
import FileFind.DefaultFileWalker;
import FileFind.FileEvent;
import FileFind.FileEventListener;
import FileWork.Algorithm;
import FileWork.DefaultHashWorker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Girish on 10-03-2015.
 */
public class FirstInstallmentWorking {


    public static void main(String[] args) throws IOException {
        final ArrayList<String> fortest = new ArrayList<>();
        final SetHashRepository setHashRepository =(SetHashRepository) HashRepositoryFactory.getInstance(Backend.HashSet);
        DefaultFileWalker fileWalker = new DefaultFileWalker();
        final DefaultHashWorker aDefaultHashWorker = new DefaultHashWorker(Algorithm.SHA1);
        fileWalker.setFileEventListener(new FileEventListener() {


            @Override
            public void apply(FileEvent fileEvent) {
                try{
                    String st = aDefaultHashWorker.transform(fileEvent);
                    if (!setHashRepository.present(st)){
                        setHashRepository.addData(st);
                    }
                    else{
                        fortest.add(fileEvent.getFile().getAbsolutePath());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Files.walkFileTree(Paths.get("E:\\webprojects"),fileWalker);
        System.out.println(aDefaultHashWorker);
        System.out.println(fortest);
    }
}
