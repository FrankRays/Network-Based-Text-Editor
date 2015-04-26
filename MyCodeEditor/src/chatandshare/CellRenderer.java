/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatandshare;


import java.awt.Component;
import java.awt.Graphics;
import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import org.fife.ui.autocomplete.Completion;
import org.fife.ui.autocomplete.CompletionCellRenderer;
import org.fife.ui.autocomplete.FunctionCompletion;
import org.fife.ui.autocomplete.VariableCompletion;

class CellRenderer extends CompletionCellRenderer {

    private Icon variableIcon;
    private Icon functionIcon;
    private Icon emptyIcon;

    /**
     * Constructor.
     */
    public CellRenderer() {
        variableIcon = getIcon("lang/img/var.png");
        functionIcon = getIcon("lang/img/function.png");
        emptyIcon = new chatandshare.CellRenderer.EmptyIcon(16);
    }

    /**
     * Returns an icon.
     *
     * @param resource The icon to retrieve. This should either be a file, or a
     * resource loadable by the current ClassLoader.
     * @return The icon.
     */
    private Icon getIcon(String resource) {
        ClassLoader cl = getClass().getClassLoader();
        URL url = cl.getResource(resource);
        if (url == null) {
            File file = new File(resource);
            try {
                url = file.toURI().toURL();
            } catch (MalformedURLException mue) {
            }
        }
        return url != null ? new ImageIcon(url) : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareForOtherCompletion(JList list,
            Completion c, int index, boolean selected, boolean hasFocus) {
        super.prepareForOtherCompletion(list, c, index, selected, hasFocus);
        setIcon(emptyIcon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareForVariableCompletion(JList list,
            VariableCompletion vc, int index, boolean selected,
            boolean hasFocus) {
        super.prepareForVariableCompletion(list, vc, index, selected,
                hasFocus);
        setIcon(variableIcon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareForFunctionCompletion(JList list,
            FunctionCompletion fc, int index, boolean selected,
            boolean hasFocus) {
        super.prepareForFunctionCompletion(list, fc, index, selected,
                hasFocus);
        setIcon(functionIcon);
    }

    /**
     * An standard icon that doesn't paint anything. This can be used to take up
     * an icon's space when no icon is specified.
     *
     * @author Robert Futrell
     * @version 1.0
     */
    private static class EmptyIcon implements Icon, Serializable {

        private int size;

        public EmptyIcon(int size) {
            this.size = size;
        }

        @Override
        public int getIconHeight() {
            return size;
        }

        @Override
        public int getIconWidth() {
            return size;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
        }
    }
}