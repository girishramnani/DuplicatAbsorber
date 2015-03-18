/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author internet_2
 */
public class SwingWorkerTest {

    public static void main(String[] args) {
        new SwingWorkerTest().doJob();
    }

    public void doJob() {

        JTextField msgLabel;
        JProgressBar progressBar;
        final int MAXIMUM = 100;
        JPanel panel;

        progressBar = new JProgressBar(0, MAXIMUM);
        progressBar.setIndeterminate(true);
        msgLabel = new JTextField("deneme");
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
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setAlwaysOnTop(false);
        dialog.setVisible(true);
        msgLabel.setBackground(panel.getBackground());



    }
}