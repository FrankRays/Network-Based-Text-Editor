package mygui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class BottomPanel extends JPanel {

        private static final Icon RESIZE_ICON = new ImageIcon(
                TitlePanel.class.getResource(
                        "Images/resize_corner_dark.png"));

        private final Window bottomWindow;
        private final JLabel resizeCorner = new JLabel(RESIZE_ICON);
        private final JLabel justCorner = new JLabel(RESIZE_ICON);
        private int fXOffsetToWindowEdge;
        private int fYOffsetToWidnowEdge;
        private int flag;

        public BottomPanel(Window window) {
            super(new FlowLayout(SwingConstants.RIGHT));
            bottomWindow = window;
            setOpaque(false);
            setBackground(Color.BLACK);
            add(resizeCorner);
            resizeCorner.addMouseListener(createMouseListener());
            resizeCorner.addMouseMotionListener(createMouseMotionListener());
            resizeCorner.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
        }
        
        void setUnresizable() {
            remove(resizeCorner);
            add(justCorner);
            flag = 1;
        }
        
        final void setResizable() {
            remove(justCorner);
            add(resizeCorner);
            flag = 0;
        }
        
        boolean isResizableNow() {
            if(flag == 0) return true;
            return false;
        }

        private MouseAdapter createMouseListener() {
            return new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Point windowPoint =
                            SwingUtilities.convertPoint(resizeCorner, e.getPoint(), bottomWindow);
                    fXOffsetToWindowEdge = bottomWindow.getWidth() - windowPoint.x;
                    fYOffsetToWidnowEdge = bottomWindow.getHeight() - windowPoint.y;
                }
            };
        }

        private MouseMotionListener createMouseMotionListener() {
            return new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    Point windowPoint = SwingUtilities.convertPoint(resizeCorner, e.getPoint(), bottomWindow);
                    bottomWindow.setSize(windowPoint.x + fXOffsetToWindowEdge,
                            windowPoint.y + fYOffsetToWidnowEdge);

                    bottomWindow.invalidate();
                    bottomWindow.validate();
                }
            };
        }

    }