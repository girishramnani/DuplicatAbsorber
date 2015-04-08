package tests;

import Gui.MainFrame;

import javax.swing.*;

/**
 * Created by Girish on 18-03-2015.
 */
public class guiTest{
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame("DuPlIcAtE");
            }
        });


    }
}
