package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Girish on 04-04-2015.
 */
public class lambda {

    public static void main(String[] args) {
        List<String> coreModules = new ArrayList<String>(Arrays.asList("A","B","C"));
        for(int a=0;a<coreModules.size();a++){
            coreModules.stream().skip(a+1).forEach(item -> System.out.println(item));
        }
    }
}
