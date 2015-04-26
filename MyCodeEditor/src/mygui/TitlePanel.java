package mygui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public final class TitlePanel extends JPanel {

    private static final int ROUNDED_RECT_DIAMETER = 16;
    private static final Color HIGHLIGHT = new Color(255, 255, 255, 25);
    private static final Color TOP_BACKGROUND_TOP = new Color(255, 255, 255, 59);
    private static final Color TOP_BACKGROUND_BOTTOM = new Color(196, 196, 196, 59);
    private static final Color BOTTOM_BACKGROUND = new Color(255, 255, 255, 30);
    private static final Color UNFOCUSED_BACKGROUND = new Color(0, 0, 0, 10);
    private String title;
    
    private javax.swing.JLabel label;

    private final WindowButtons windowbuttons;

    TitlePanel(String title, ActionListener closeButtonActionListener,
               ActionListener minimizeButtonActionListener,
               ActionListener maximizeButtonActionListener) {
        
        windowbuttons = new WindowButtons(
                closeButtonActionListener, minimizeButtonActionListener, maximizeButtonActionListener);

        this.title = title;
        label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 11.0f));


        setOpaque(false);
        setPreferredSize(new Dimension(-1, 20));

        setLayout(new BorderLayout());
        add(windowbuttons, BorderLayout.WEST);
        add(label, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g.create();
        graphics2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int midPointY = ROUNDED_RECT_DIAMETER / 2 + 3;

        if (WindowUtils.isParentWindowFocused(this)) {
            GradientPaint paint =
                    new GradientPaint(0, 0, TOP_BACKGROUND_TOP, 0, midPointY, TOP_BACKGROUND_BOTTOM);
            graphics2d.setPaint(paint);
            

            Area titleArea = new Area(new Area(new RoundRectangle2D.Double(
                    0, 0, getWidth(), getHeight(), ROUNDED_RECT_DIAMETER, ROUNDED_RECT_DIAMETER)));
            titleArea.subtract(new Area(new Rectangle(0, midPointY, getWidth(), midPointY)));
            graphics2d.fill(titleArea);

            int bottomHeight = getHeight() - midPointY;
            graphics2d.setColor(BOTTOM_BACKGROUND);
            graphics2d.fillRect(0, midPointY, getWidth(), bottomHeight);
        } else {
            graphics2d.setColor(UNFOCUSED_BACKGROUND);
            Area titleArea = new Area(new Area(new RoundRectangle2D.Double(
                    0, 0, getWidth(), getHeight(), ROUNDED_RECT_DIAMETER, ROUNDED_RECT_DIAMETER)));
            titleArea.subtract(new Area(
                    new Rectangle(0, midPointY, getWidth(), midPointY)));
            graphics2d.fill(titleArea);
            graphics2d.setColor(HIGHLIGHT);
            graphics2d.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        }

        graphics2d.dispose();
    }
}