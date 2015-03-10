package FileWork;

import FileIO.FileEvent;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;

/**
 * Created by Girish on 10-03-2015.
 */
public interface HashWorker extends Worker {

    public String hash(Path file) throws IOException;
}
