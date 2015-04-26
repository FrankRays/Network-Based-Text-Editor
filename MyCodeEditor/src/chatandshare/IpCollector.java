/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatandshare;

import mygui.GuiWindow;

/**
 *
 * @author Admin
 */
public class IpCollector {

    public GuiWindow njftp1;
    private String name;

    public IpCollector(String name, GuiWindow njftp1) {
        this.njftp1 = njftp1;
        this.name = name;
        Thread mt = new Thread(new ClientHandler(njftp1, name));
        mt.start();
    }
}
