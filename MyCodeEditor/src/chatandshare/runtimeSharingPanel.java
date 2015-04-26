/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatandshare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import mygui.GuiWindow;
import org.fife.ui.autocomplete.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.ToolTipSupplier;

/**
 *
 * @author User
 */
public class runtimeSharingPanel extends javax.swing.JPanel {

    public GuiWindow mf;
    public javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    public RSyntaxTextArea coder;
    private AutoCompletion ac;
    private CompletionProvider provider;
    private RTextScrollPane scrollPane;
    private int style = 0;
    
    public runtimeSharingPanel(GuiWindow mf) throws FileNotFoundException {
        this.mf = mf;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws FileNotFoundException {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        
        coder = createTextArea();
        provider = createCompletionProvider("c");
        setSynStyle(style);
        
        ac = new AutoCompletion(provider);
        ac.setListCellRenderer(new CellRenderer());
        ac.setShowDescWindow(true);
        ac.setParameterAssistanceEnabled(true);
        ac.install(coder);
        
        scrollPane = new RTextScrollPane(coder, true);

        jPanel1.setBackground(new java.awt.Color(70, 70, 70));

        coder.setColumns(20);
        coder.setRows(5);
        scrollPane.setViewportView(coder);
        
                coder.setToolTipSupplier((ToolTipSupplier) provider);
        ToolTipManager.sharedInstance().registerComponent(coder);


        // Put the focus into the text area, not the "label" JEditorPane.
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                coder.requestFocusInWindow();
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatandshare/images/close.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/chatandshare/images/close_hover.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/chatandshare/images/close_hover.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }            
    
    private RSyntaxTextArea createTextArea() {
        RSyntaxTextArea textarea = new RSyntaxTextArea(25, 70);
        textarea.setCaretPosition(0);
        textarea.requestFocusInWindow();
        textarea.setMarkOccurrences(true);
        textarea.setCodeFoldingEnabled(true);
        textarea.setClearWhitespaceLinesEnabled(false);

        return textarea;
    }
    
    public void setSynStyle (int i) throws FileNotFoundException {
        System.out.println(i);
        switch (i)
        {            
            case 0 : coder.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C); setTheme("themes/dark.xml"); style = 0; break;
            case 1 : coder.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA); setTheme("themes/default.xml"); style = 1; break;
            case 2 : coder.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_HTML); setTheme("themes/eclipse.xml"); style = 2; break;
            case 3 : coder.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PHP); setTheme("themes/vs.xml"); style = 3; break;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        mf.removeTab();
    }
    /**
     * Returns the provider to use when editing code.
     *
     * @return The provider.
     * @see #createCommentCompletionProvider()
     */
    private CompletionProvider createCodeCompletionProvider(String type) {

        String path = "lang/" + type + ".xml";

        // Add completions for the C standard library.
        DefaultCompletionProvider cp = new DefaultCompletionProvider();

        // First try loading resource (running from demo jar), then try
        // accessing file (debugging in Eclipse).
        ClassLoader cl = getClass().getClassLoader();
        InputStream in = cl.getResourceAsStream(path);
        try {
            if (in != null) {
                cp.loadFromXML(in);
                in.close();
            } else {
                cp.loadFromXML(new File(path));
            }
        } catch (IOException e) {
        }

        return cp;

    }

    /**
     * Returns the provider to use when in a comment.
     *
     * @return The provider.
     * @see #createCodeCompletionProvider()
     * @see #createStringCompletionProvider()
     */
    private CompletionProvider createCommentCompletionProvider() {
        DefaultCompletionProvider cp = new DefaultCompletionProvider();
        cp.addCompletion(new BasicCompletion(cp, "TODO:", "A to-do reminder"));
        cp.addCompletion(new BasicCompletion(cp, "FIXME:", "A bug that needs to be fixed"));
        return cp;
    }

    /**
     * Creates the completion provider for a C editor. This provider can be
     * shared among multiple editors.
     *
     * @return The provider.
     */
    private CompletionProvider createCompletionProvider(String type) {

        // Create the provider used when typing code.
        CompletionProvider codeCP = createCodeCompletionProvider(type);

        // The provider used when typing a comment.
        CompletionProvider commentCP = createCommentCompletionProvider();

        // Create the "parent" completion provider.
        LanguageAwareCompletionProvider Provider = new LanguageAwareCompletionProvider(codeCP);
        Provider.setCommentCompletionProvider(commentCP);

        return Provider;

    }

    private void setTheme(String xml) throws FileNotFoundException {
        InputStream in =  getClass().getResourceAsStream(xml);
        try {
            Theme theme = Theme.load(in);
            theme.apply(coder);
        } catch (IOException e) {
        }
    }

    public int getStyle() {
        System.out.println(style);
        return style;
    }

}
