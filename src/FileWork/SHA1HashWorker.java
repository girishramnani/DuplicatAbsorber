package FileWork;

import FileIO.FileEvent;

import java.nio.file.Path;
import java.security.MessageDigest;

/**
 * Created by Girish on 10-03-2015.
 */
public class SHA1HashWorker implements HashWorker {

    private MessageDigest messageDigest;
    public SHA1HashWorker(Algorithm algo){


    }


    @Override
    public String hash(Path file) {
        return null;
    }

    @Override
    public String transform(FileEvent fileEvent) {
        return null;
    }
}
