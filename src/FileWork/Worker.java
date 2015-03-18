package FileWork;

import FileFind.FileEvent;

import java.io.IOException;

/**
 * Created by Girish on 10-03-2015.
 */
public interface Worker {


    public String transform(FileEvent fileEvent) throws IOException;
}
