/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatandshare;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import mygui.GuiWindow;

/**
 *
 * @author User
 */
public class Client extends javax.swing.JFrame {

    /**
     * Creates new form Client
     */

    private String ip;
    private Socket socket;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private JTabbedPane shareTab,chatTab;
    private ChatPanel chatPanel ;
    private runtimeSharingPanel sharePanel;
    private int count = 0;
    private String username,name;
    private GuiWindow njtp;
    private int len, start = 0,c1,c2;
    
    public Client(String ip, GuiWindow njtp, String name) throws IOException {        
        this.ip = ip;
        this.njtp = njtp;
        this.username = name;                
        sharePanel = njtp.setTab1();
        chatPanel = njtp.setTab2();        
        shareTab = njtp.getObject1();
        chatTab = njtp.getObject2();
        c1 = njtp.tabCount;
        c2 = njtp.chatTabCount;
        
        if(ip.compareTo("-1")!=0){
            System.out.println("ip:-1");
            Thread t = new Thread(new connect(ip));
            t.start();
        }        
    }
  
    /**
     * @param args the command line arguments
     */

    private class connect extends Thread{

        private String ip;
        public connect(String ip){
            this.ip = ip;
            
            chatPanel.jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });
            
            chatPanel.jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jTextArea1KeyPressed(evt);
                }
            });
            
            chatPanel.jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    jTextArea1KeyReleased(evt);
                }
            });
            
            sharePanel.jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });
            
            sharePanel.coder.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    sjTextArea1KeyReleased(evt);
                }
            });
        }
        
        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
            int index1 = chatTab.getSelectedIndex();
            chatTab.remove(index1);
        }
        
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
            int index2 = shareTab.getSelectedIndex();
            shareTab.remove(index2);            
        }
        
        private void sjTextArea1KeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:            
            String s = sharePanel.coder.getText();        
            int key = evt.getKeyCode();        
            if(s.length()>0||key==KeyEvent.VK_BACK_SPACE){                        
                System.out.println(s);                
                try{                    
                    out.println(""+1+s);                    
                }catch(Exception e){}                                  
            }
            else
                    out.println(1+"");
        }

        private void jTextArea1KeyPressed(KeyEvent evt) {
            int key = evt.getKeyCode();
            if(key == evt.VK_ENTER){
                String text = chatPanel.jTextArea1.getText();
                try{
                    if(text.compareTo("")!=0){
                        System.out.println("sending:"+text);
                        out.println(2+text);
                	chatPanel.jTextArea2.append("me : "+text+"\n");                        
                	chatPanel.jTextArea1.setText(null);
                    }                                        
                }catch(Exception ioe){
                    JOptionPane.showMessageDialog(null, "client : sending failed");
                }
            }
        }
        
        private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
            int key = evt.getKeyCode();
                if(key == evt.VK_ENTER){
                    int length = chatPanel.jTextArea2.getText().length();
                    chatPanel.jTextArea2.setCaretPosition(length);
                    chatPanel.jTextArea1.setCaretPosition(0);                   
	    }
	}

        public void run(){
            try{
		InetAddress ipAddress = InetAddress.getByName(ip);
                socket = new Socket(ipAddress, 6666);
            }catch(IOException ioe){
                JOptionPane.showMessageDialog(null, "client : connection failed");
            }

            try{
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            }catch(IOException ioe){
                JOptionPane.showMessageDialog(null, "client : no I/O");
            }
                        
            try{                                
                out.println(username);                
                name = in.readLine();
                shareTab.setTitleAt(c1, name);
                chatTab.setTitleAt(c2, name);                                
            }catch(Exception e){}                                    

            int c = 0;
            while(true){
                try{
                    System.out.println("C c:"+c++);
                    String line = in.readLine(); 
                    System.out.println("client:" +line);
                    
                    if(line.compareTo("")==0){
                        System.out.println("null");
                        sharePanel.coder.append("\n");
                        int length = sharePanel.coder.getText().length();
                        sharePanel.coder.setCaretPosition(length);
                    }
                    else if(line.substring(0, 1).compareTo("1")==0){    
                        //shareTab.setBackgroundAt(c1, Color.white);
                        sharePanel.coder.setText(line.substring(1, line.length()));
                        int length = sharePanel.coder.getText().length();
                        sharePanel.coder.setCaretPosition(length);
                    }
                    else if(line.substring(0, 1).compareTo("2")==0){
                        //chatTab.setBackgroundAt(c2, Color.white);
                        line = line.substring(1, line.length());
                        String str = name +" : "+ line;
                        chatPanel.jTextArea2.append(str + "\n");
                        int length = chatPanel.jTextArea2.getText().length();
                        chatPanel.jTextArea2.setCaretPosition(length);                                                                    
                    }                          
                    else{
                        sharePanel.coder.append("\n"+line);
                        int length = sharePanel.coder.getText().length();
                        sharePanel.coder.setCaretPosition(length);
                    }
                }catch(IOException ioe){
                    JOptionPane.showMessageDialog(null, "client : receiving failed");
                    break;
                }
            }
        }
    }
}
