package FileWork;

import FileIO.FileEvent;

/**
 * Created by Girish on 10-03-2015.
 */
public interface Worker {

    public String transform(FileEvent fileEvent);
}
