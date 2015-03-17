/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author internet_2
 */
public class test_swingWorker {

    public static void main(String[] args) {
        new test_swingWorker().doJob();
    }

    public void doJob() {

        JTextArea msgLabel;
        JProgressBar progressBar;
        final int MAXIMUM = 100;
        JPanel panel;

        progressBar = new JProgressBar(0, MAXIMUM);
        progressBar.setIndeterminate(true);
        msgLabel = new JTextArea("deneme");
        msgLabel.setEditable(false);

        panel = new JPanel(new BorderLayout(5, 5));
        panel.add(msgLabel, BorderLayout.PAGE_START);
        panel.add(progressBar, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        final JDialog dialog = new JDialog();
        dialog.getContentPane().add(panel);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setSize(500, dialog.getHeight());
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setAlwaysOnTop(false);
        dialog.setVisible(true);
        msgLabel.setBackground(panel.getBackground());



    }
}