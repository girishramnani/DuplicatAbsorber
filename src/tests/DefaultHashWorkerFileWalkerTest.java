package tests;

import FileFind.DefaultFileWalker;
import FileFind.FileEvent;
import FileFind.FileEventListener;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DefaultHashWorkerFileWalkerTest {
    DefaultFileWalker df;

    @Before
    public void setUp() throws Exception {
        df = new DefaultFileWalker();
        df.setFileEventListener(new FileEventListener() {
            @Override
            public void apply(FileEvent fileEvent) {
                System.out.println(fileEvent.getPath().getFileName());
            }
        });


    }


    @Test
    public void test_name() {
        try {
            Files.walkFileTree(Paths.get("../"), df);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}