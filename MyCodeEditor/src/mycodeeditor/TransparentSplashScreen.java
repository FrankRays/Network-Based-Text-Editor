/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycodeeditor;

import javax.swing.JWindow;
import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class TransparentSplashScreen extends JWindow
{
    Image bi=Toolkit.getDefaultToolkit().getImage("batman.png");
    ImageIcon ii=new ImageIcon(bi);

    public TransparentSplashScreen()
    {
        try
        {
            setSize(ii.getIconWidth(),ii.getIconHeight());
            setLocationRelativeTo(null);
            show();
            Thread.sleep(7000);
            dispose();
        }
        catch(Exception exception)
        {
        }
    }

    public void paint(Graphics g)
    {
        g.drawImage(bi,0,0,this);
    }

    public static void main(String[]args)
    {
        TransparentSplashScreen tss = new TransparentSplashScreen();
        tss.setAlwaysOnTop(true);
        //tss.setOpacity(0);
    }
}
