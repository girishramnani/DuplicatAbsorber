package tests;

import FileIO.DefaultFileWalker;
import FileIO.FileEvent;
import FileIO.FileEventListener;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class DefaultFileWalkerTest {
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