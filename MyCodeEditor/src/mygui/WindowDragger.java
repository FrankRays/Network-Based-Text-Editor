package mygui;

import java.awt.Component;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingUtilities;


public class WindowDragger {
    
    private Window dragWindow;
    private Component dragComponent;
    private int dX;
    private int dY;
    private int flag = 1;

    public WindowDragger(Window window, Component component) {

        dragWindow = window;
        dragComponent = component;

        dragComponent.addMouseListener(createMouseListener());
        dragComponent.addMouseMotionListener(createMouseMotionListener());
    }

    private MouseListener createMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(flag == 1) {
                    Point clickPoint = new Point(e.getPoint());
                    SwingUtilities.convertPointToScreen(clickPoint, dragComponent);

                    dX = clickPoint.x - dragWindow.getX();
                    dY = clickPoint.y - dragWindow.getY();
                }
            }
        };
    }

    private MouseMotionAdapter createMouseMotionListener() {
        return new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(flag == 1) {
                    Point dragPoint = new Point(e.getPoint());
                    SwingUtilities.convertPointToScreen(dragPoint, dragComponent);

                    dragWindow.setLocation(dragPoint.x - dX, dragPoint.y - dY);
                }
            }
        };
    }
    
    void setUndraggable() {
        flag = 0;
    }
    
    void setDraggable() {
        flag = 1;
    }
}
