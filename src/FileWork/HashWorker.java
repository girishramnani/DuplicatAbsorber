package FileWork;

import FileIO.FileEvent;

/**
 * Created by Girish on 10-03-2015.
 */
public interface HashWorker extends Worker {

    public String hash(FileEvent fileEvent);
}
