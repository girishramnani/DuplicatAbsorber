package tests;

import Gui.FileProgressBar;

/**
 * Created by Girish on 18-03-2015.
 */
public class ProgressDialogTest {
    public static void main(String[] args) {
        FileProgressBar fpb = new FileProgressBar();
        try {
            for(int i=0;i<10;i++){
                Thread.sleep(1000);
                fpb.setFileName("the "+i+" th second");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
