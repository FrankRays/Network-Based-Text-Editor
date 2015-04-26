package mygui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.SwingUtilities;

public class WindowUtils {

	public static void makeWindowNonOpaque(Window window) {
		window.setBackground(new Color(0, 0, 0, 0));
	}

	/**
	 * Creates and installs a WindowFocusListener on the given Window
         * which calls it's repaint() method on focus state changes.
	 */

        @Deprecated
	public static WindowFocusListener createAndInstallRepaintWindowFocusListener(
			Window window) {
		WindowFocusListener windowFocusListener = new WindowFocusListener() {
            @Override
			public void windowGainedFocus(WindowEvent e) {
				e.getWindow().repaint();
			}

            @Override
			public void windowLostFocus(WindowEvent e) {
				e.getWindow().repaint();
			}
		};
		window.addWindowFocusListener(windowFocusListener);
		return windowFocusListener;
	}

	public static boolean isParentWindowFocused(Component component) {
		Window window = SwingUtilities.getWindowAncestor(component);
		return window != null && window.isFocused();
	}
}