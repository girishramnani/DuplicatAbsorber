package tests;

import DatabaseIO.*;
import org.junit.Test;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

public class HashRepositoryFactoryTest{
    HashRepository hashRepository;
    @org.junit.Before
    public void setUp() throws Exception {
        hashRepository =HashRepositoryFactory.getInstance(Backend.HashSet);

    }

    @Test
    public void DifferentInterfaceTrials(){
        HashRepository s= HashRepositoryFactory.getInstance();
        assertTrue(s instanceof SetHashRepository);
    }

    @Test
    public void checkSingleton(){
        assertTrue(hashRepository == HashRepositoryFactory.getInstance());
    }
    @Test
    public void checkHash(){
    hashRepository.addData("girish".getBytes());
    assertEquals(hashRepository.toString(), "[girish]");
}
    @Test
    public void checkPresence(){
        assertTrue(hashRepository.present("girish".getBytes()));
    }

}