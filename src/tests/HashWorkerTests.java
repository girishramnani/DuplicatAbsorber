package tests;
import FileWork.Algorithm;
import FileWork.SHA1HashWorker;
import org.junit.Before;
import org.junit.Test;

import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;
public class HashWorkerTests {
    private SHA1HashWorker hashWorker;

    @Test
    public void working() {
        hashWorker = new SHA1HashWorker(Algorithm.SHA1);
        try {
            String x = hashWorker.hash(Paths.get("C:\\Users\\Girish\\IdeaProjects\\DuplicatAbsorber\\src\\tests\\EnumTest.java"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
