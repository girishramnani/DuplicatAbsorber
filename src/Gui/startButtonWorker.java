package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class startButtonWorker implements ActionListener {
    private MainWorker mainWorker;
    public MainWorker getMainWorker() {
        return mainWorker;
    }

    public void setMainWorker(MainWorker mainWorker) {
        this.mainWorker = mainWorker;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        mainWorker.show();

        new Thread(()->mainWorker.runFiler() ).start();
        mainWorker.execute();


    }


}
