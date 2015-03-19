
package tests;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JtableTest {
    static Object[] columnNames = new Object[] { "Column 1", "Column 2" };
    static Object[][] rowData = { {1, Boolean.FALSE}, {3, Boolean.FALSE} };

    private JPanel mainPanel = new JPanel();
    private DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);
    private JTable table = new JTable(tableModel);


    public JtableTest() {
        JButton timesTwoBtn = new JButton("Multiply By 2");
        timesTwoBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tableModel.addRow(new Object[]{1,Boolean.FALSE});
            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.add(timesTwoBtn);


        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
    }

    public JPanel getMainPanel() {
        return  mainPanel;
    }

    private static void createAndShowGui() {
        JtableTest testTables = new JtableTest();

        JFrame frame = new JFrame("TableFoo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(testTables.getMainPanel());
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}