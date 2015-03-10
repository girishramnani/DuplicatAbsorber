package tests;

import FileWork.Algorithm;
import org.junit.Before;
import org.junit.Test;

import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


/**
 * Created by Girish on 10-03-2015.
 */
public class EnumTest {
    Algorithm algorithm;
    
    @Test
    public void test1(){
        algorithm = Algorithm.MD5;
        assertEquals(algorithm.toString(),"MD5");
        
    }

    @Test
    public void test2(){
        algorithm = Algorithm.SHA1;
        assertEquals(algorithm.toString(),"SHA-1");
    }
    
}
