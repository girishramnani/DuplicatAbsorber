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
        try(BufferedInputStream br = new BufferedInputStream(Files.newInputStream(file))){
            buffer = new byte[SIZE_BUFFER];
            int t=0;
            do{
                t =br.read(buffer);
                messageDigest.update(buffer);
            }
            while (t !=-1);
        }


       return new String(messageDigest.digest());
    }

    @Override
    public String transform(FileEvent fileEvent) throws IOException {
    return hash(fileEvent.getPath());

    }
}
