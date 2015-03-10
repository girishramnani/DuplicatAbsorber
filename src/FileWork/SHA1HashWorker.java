package FileWork;

import FileIO.FileEvent;
import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Girish on 10-03-2015.
 */
public class SHA1HashWorker implements HashWorker {

    private MessageDigest messageDigest;
    private int SIZE_BUFFER;
    private byte[] buffer;
    public SHA1HashWorker(Algorithm algo){
        SIZE_BUFFER=2048;
        // never a exception would be throw as I m controlling the constructor itself
        try {
            messageDigest = MessageDigest.getInstance(algo.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }

    public SHA1HashWorker(Algorithm algo,int SIZE_OF_BUFFER){
        this(algo);
        SIZE_BUFFER = SIZE_OF_BUFFER;
    }


    @Override
    public String hash(Path file) throws IOException {

        buffer = new byte[SIZE_BUFFER];
       return null;
    }

    @Override
    public String transform(FileEvent fileEvent) throws IOException {

    return hash(fileEvent.getPath());

    }
}
