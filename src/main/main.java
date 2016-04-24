package main;

import Gui.MainFrame;

import javax.swing.*;

/**
 * Created by Girish on 14-04-2015.
 */
public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame("DuPlIcAtE");
            }
        });

    }
}
