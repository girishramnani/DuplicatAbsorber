package FileIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Girish on 09-03-2015.
 */
public class DefaultFileWalker extends AbstractFileWalker {

    public DefaultFileWalker(){
        super();

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        //use logging here in the future
        return null;
    }
}
