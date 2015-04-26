/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatandshare;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import mygui.GuiWindow;

/**
 *
 * @author User
 */
public class ClientHandler extends Thread {

    /**
     * @param args the command line arguments
     */

    private ServerSocket socket;
    private Socket client;
    private GuiWindow n2;
    private String name;


	public ClientHandler(GuiWindow n2, String uname){
            this.n2 = n2;                
            this.name = uname;
            System.out.println(name);
	}

    @Override
	public void run(){            
        try{
            socket = new ServerSocket(6666);
            while(true){
		System.out.println("waiting for connection..........");
                Server nj = new Server(socket.accept(),n2,name);
                System.out.println("connected");
            }
        }catch(Exception e){
			System.out.println("server : connection failed");
            JOptionPane.showMessageDialog(null, "server : connection failed");
        }
    }
}
