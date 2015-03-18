package tests;

import Gui.MainFrame;
import sun.applet.Main;

import javax.swing.*;

/**
 * Created by Girish on 18-03-2015.
 */
public class guiTest1 {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame("girish");
            }
        });


    }
}
