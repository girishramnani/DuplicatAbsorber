package Gui;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Girish on 18-03-2015.
 */
public class FileProgressBar extends JDialog implements Interactor{
    private JTextField filelabel;
    private JProgressBar progressBar;
    final int MAXIMUM = 100;
    private JPanel panel;


    public FileProgressBar(){
        super();


        progressBar = new JProgressBar(0, MAXIMUM);
        progressBar.setIndeterminate(true);
        filelabel = new JTextField();
        filelabel.setEditable(false);

        panel = new JPanel(new BorderLayout(5, 5));
        panel.add(filelabel, BorderLayout.PAGE_START);
        panel.add(progressBar, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(11, 11, 11, 11));

        this.getContentPane().add(panel);
        this.setResizable(false);
        this.pack();
        this.setSize(500, this.getHeight());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(false);
        filelabel.setBackground(panel.getBackground());

    }
    public void setVisible(boolean bool){
        this.setVisible(bool);
    }
    public void setFileName(String name){
        filelabel.setText(name);
        repaint();
    }
    public void close(){
        this.close();
    }


    @Override
    public void interact(String... work) {
        setFileName(work[0]);
    }
}
