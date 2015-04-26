package mygui;

import java.awt.*;
import javax.swing.JPanel;

public class CodePanel extends JPanel {

    private static final int ROUNDED_RECT_DIAMETER = 16;
    
    private static final Color HIGHLIGHT = new Color(255, 255, 255, 59);
    private static final Color HIGHLIGHT_BOTTOM = new Color(255, 255, 255, 25);
    private static final Color BACKGROUND = new Color(30, 30, 30, 216);

    CodePanel() {
        setLayout(new BorderLayout());
        setOpaque(false);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g.create();
        graphics2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint paint = new GradientPaint(0, 0, HIGHLIGHT, 0, getHeight(), HIGHLIGHT_BOTTOM);
        graphics2d.setPaint(paint);
        graphics2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ROUNDED_RECT_DIAMETER,
                ROUNDED_RECT_DIAMETER);

        graphics2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g.create();
        graphics2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2d.setComposite(AlphaComposite.Src);

        graphics2d.setColor(BACKGROUND);
        graphics2d.fillRoundRect(0, 0, getWidth(), getHeight(),
                ROUNDED_RECT_DIAMETER, ROUNDED_RECT_DIAMETER);

        graphics2d.dispose();
    }
}
