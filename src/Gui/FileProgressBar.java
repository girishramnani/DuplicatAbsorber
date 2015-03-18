package Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Girish on 18-03-2015.
 */
public class FileProgressBar extends JDialog {

    JTextField msgLabel;
    JProgressBar progressBar;
    final int MAXIMUM = 100;
    JPanel panel;

    public FileProgressBar(){
        super();


        progressBar = new JProgressBar(0, MAXIMUM);
        progressBar.setIndeterminate(true);
        msgLabel = new JTextField();
        msgLabel.setEditable(false);

        panel = new JPanel(new BorderLayout(5, 5));
        panel.add(msgLabel, BorderLayout.PAGE_START);
        panel.add(progressBar, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        this.getContentPane().add(panel);
        this.setResizable(false);
        this.pack();
        this.setSize(500, this.getHeight());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(false);
        this.setVisible(true);
        msgLabel.setBackground(panel.getBackground());

    }
    public void setFileName(String name){

    }
}
