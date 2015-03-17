package tests;
import FileWork.Algorithm;
import FileWork.DefaultHashWorker;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class HashWorkerTests {
    private DefaultHashWorker hashWorker;

    @Test
    public void working() {
        hashWorker = new DefaultHashWorker(Algorithm.SHA1);
        try {
            String x = hashWorker.hash(Paths.get("C:\\Users\\Girish\\IdeaProjects\\DuplicatAbsorber\\src\\tests\\EnumTest.java"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
