package FileIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Girish on 09-03-2015.
 */
public class DefaultFileWalker extends AbstractFileWalker {
    private FileEvent fileEvent;
    private FileEventListener fileEventListener;

    public DefaultFileWalker(){
        super();

    }

    public void setFileEventListener(FileEventListener fileEventListener){
        this.fileEventListener = fileEventListener;
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        fileEvent = new FileEvent(file);
        fileEventListener.apply(fileEvent);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        //use logging here in the future
        return null;
    }
}
