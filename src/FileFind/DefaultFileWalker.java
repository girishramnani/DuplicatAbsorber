package FileFind;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Girish on 09-03-2015.
 */
public class DefaultFileWalker extends AbstractFileWalker {
    private FileEvent fileEvent;
    private FileEventListener fileEventListener;
    private ConcurrentLinkedDeque<FileEvent> events;
    public DefaultFileWalker(){
        super();
        events = new ConcurrentLinkedDeque<>();

    }

    public void setFileEventListener(FileEventListener fileEventListener){
        this.fileEventListener = fileEventListener;
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        fileEvent = new FileEvent(file);
        events.add(fileEvent);
        System.out.println(file);
        return FileVisitResult.CONTINUE;
    }

    public ConcurrentLinkedDeque<FileEvent> getFileEvents(){
        return events;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        //use logging here in the future
        return FileVisitResult.CONTINUE;
    }
}
