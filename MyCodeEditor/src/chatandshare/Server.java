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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import mygui.GuiWindow;

/**
 *
 * @author User
 */
public class Server{

    /**
     * Creates new form Server
     */

    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private int count = 0;
    private JTabbedPane shareTab,chatTab;
    private ChatPanel chatPanel ;
    private runtimeSharingPanel sharingPanel;
    private GuiWindow njtp;
    private String username,name,line,str;
    private int len, start = 0,c1,c2;

    public Server(Socket socket,GuiWindow njtp,String username) throws IOException {
        this.socket = socket;
        this.njtp = njtp;
        this.username = username;             
        sharingPanel = njtp.setTab1();
        chatPanel = njtp.setTab2();
        shareTab = njtp.getObject1();
        chatTab = njtp.getObject2();                        
        c1 = njtp.tabCount;
        c2 = njtp.chatTabCount;
    
        Thread t = new Thread(new connect(socket));
        t.start();
    }

    private class connect extends Thread{

	private Socket sckt;        

        public connect(Socket sckt){
            this.sckt = sckt;

            
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
            
            sharingPanel.jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });
            
            sharingPanel.coder.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    sjTextArea1KeyReleased(evt);
                }
            });
        }
        
        
        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
            System.out.println(c1);
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
            String s = sharingPanel.coder.getText();   
            System.out.println("start: "+s+" :end");
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

        private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
            int key = evt.getKeyCode();
            if(key == evt.VK_ENTER){	
                String text = chatPanel.jTextArea1.getText();                
                try{
                    if(text.compareTo("")!=0){
                        System.out.println(text);
                        out.println(2+text);
                	chatPanel.jTextArea2.append("me : "+text+"\n");                        
                	chatPanel.jTextArea1.setText(null);                	
                    }                	
                }catch(Exception e){
			System.out.println("server : sending failed");
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

        public void run() {
            try{
                in = new BufferedReader(new InputStreamReader(sckt.getInputStream()));
                out = new PrintWriter(sckt.getOutputStream(), true);                
            }catch(IOException ioe){
                JOptionPane.showMessageDialog(null, "server : no I/O");
            }
            
            try{                
                name = in.readLine();                
                shareTab.setTitleAt(c1, name);
                chatTab.setTitleAt(c2, name);                         
                out.println(username);
            }catch(Exception e){}                                    

            int c = 0;
            try{
                while(true){    
                    System.out.println("C s:"+c++);                    
                    try {
                        System.out.println("server : received");
                        line = in.readLine();    
//                        if(line.substring(0, 1).compareTo("2")==0)
//                        chatTab.setBackgroundAt(c2, Color.white);  
//                        else
//                        shareTab.setBackgroundAt(c1, Color.white);      
                        System.out.println("line is"+line);
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }        
                    
                    if(line.compareTo("")==0){
                        System.out.println("null");
                        sharingPanel.coder.append("\n");
                        int length = sharingPanel.coder.getText().length();
                        sharingPanel.coder.setCaretPosition(length);
                    }
                    else if(line.substring(0, 1).compareTo("1")==0){                                                
                        sharingPanel.coder.setText(line.substring(1, line.length()));
                        int length = sharingPanel.coder.getText().length();
                        sharingPanel.coder.setCaretPosition(length);
                    }
                    else if(line.substring(0, 1).compareTo("2")==0){
                        System.out.println("2");
                        line = line.substring(1, line.length());
                        str = name +" : "+ line;
                        System.out.println(str+"  "+str.length());
                        chatPanel.jTextArea2.append(str + "\n");
                        int length = chatPanel.jTextArea2.getText().length();
                        chatPanel.jTextArea2.setCaretPosition(length);                        
                                             
                    }
                    else{
                        sharingPanel.coder.append("\n"+line);
                        int length = sharingPanel.coder.getText().length();
                        sharingPanel.coder.setCaretPosition(length);
                    }
                    
                }                                    
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "server : receiving failed");
            }
        }
    }
}
