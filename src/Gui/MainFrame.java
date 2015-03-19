package Gui;


import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Created by Girish on 17-03-2015.
 */
public class MainFrame extends JFrame {
    private BottomPanel bottomPanel;
    private TopPanel topPanel;
    private FileTable fileTable;
    private TableModel tableModel;



    public MainFrame(String name){

        super(name);
        SetupUI();
        setLayout(new BorderLayout(10, 10));

        topPanel = new TopPanel();
        bottomPanel=new BottomPanel(topPanel);

        topPanel.setInteractor(bottomPanel);
        fileTable =new FileTable();
        add(bottomPanel, BorderLayout.SOUTH);
        add(topPanel,BorderLayout.NORTH);
        add(new JScrollPane(fileTable),BorderLayout.CENTER);
        setVisible(true);

    }

    private void SetupUI(){
        try {
            this.setResizable(false);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(640,480);
            setPreferredSize(new Dimension(640,480));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

}
