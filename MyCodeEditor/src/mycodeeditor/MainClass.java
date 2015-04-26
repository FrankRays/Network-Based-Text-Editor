package mycodeeditor;

import chatandshare.IpCollector;
import javax.swing.SwingUtilities;
import mygui.GuiWindow;

public class MainClass {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {             
                    
                    FrontFrame ff = new FrontFrame();
            }
        });
    }
}