package FileIO;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Couldnt wrap my head around so created a FileEvent which can be used by the eventListener
 */
public class FileEvent {

    private Path path;

    public FileEvent(Path path){
        this.path =path;
    }
    public File getFile(){
        return this.path.toFile();
    }
    public Path getPath(){
        return this.path;
    }



}
