package FileWork;

import FileFind.FileEvent;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Girish on 10-03-2015.
 */
public class DefaultHashWorker implements HashWorker {

    private MessageDigest messageDigest;
    private int SIZE_BUFFER;
    private byte[] buffer;
    public DefaultHashWorker(Algorithm algo){
        SIZE_BUFFER=4096;
        // never a exception would be throw as I m controlling the constructor itself
        try {
            messageDigest = MessageDigest.getInstance(algo.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public DefaultHashWorker(Algorithm algo, int SIZE_OF_BUFFER){
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

    @Override
    public String toString() {
        return String.format("Buffer size : %d , ALgorithm used : %s ", SIZE_BUFFER,messageDigest.getAlgorithm());
    }
}
