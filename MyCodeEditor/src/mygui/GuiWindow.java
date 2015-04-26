package mygui;

import chatandshare.ChatPanel;
import chatandshare.Client;
import chatandshare.runtimeSharingPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class GuiWindow extends javax.swing.JFrame {

    public int count = 1, tabCount = -1, chatTabCount = -1, clrccnt = -1;
    private ChatPanel chatPanel;
    private runtimeSharingPanel sharePanel;
    private final String name;
    private int flag = 0;
    public final javax.swing.JFrame guiFrame;
    public final RightSidePanel rightSidePanel;
    public JComponent guiContentPane;
    public final TitlePanel guiTitlePanel;
    public final CodePanel guiCodePanel;
    public final BottomPanel guiBottomPanel;
    private WindowDragger dragger;
    private javax.swing.JPanel leftSidePanle;
    private javax.swing.JButton addEdiitorTab;
    private javax.swing.JButton buildAndRun;
    private javax.swing.JButton copyToClipboard;
    private javax.swing.JButton shareMe;
    public NewJPanel panel;

    public GuiWindow(String name, String title) {
        this.name = name;
        guiCodePanel = new CodePanel();
        guiFrame = new javax.swing.JFrame();
        guiTitlePanel = new TitlePanel(title, createCloseButtonActionListener(), createMinimizeButtonActionListener(), createMaximizeButtonActionListener());
        guiBottomPanel = new BottomPanel(guiFrame);
        rightSidePanel = new RightSidePanel();
        leftSidePanle = new javax.swing.JPanel();
        panel = new NewJPanel(this, name);

        init();
    }

    private void init() {
        guiFrame.setUndecorated(true);
        guiFrame.getRootPane().setOpaque(false);

        WindowUtils.makeWindowNonOpaque(guiFrame);

        initLeftSidePanel();

        guiFrame.getRootPane().setBackground(Color.BLACK);
        guiCodePanel.add(guiTitlePanel, BorderLayout.NORTH);
        guiCodePanel.add(rightSidePanel, BorderLayout.WEST);
        guiCodePanel.add(leftSidePanle, BorderLayout.WEST);
        guiCodePanel.add(panel);
        guiFrame.setContentPane(guiCodePanel);

        WindowUtils.createAndInstallRepaintWindowFocusListener(guiFrame);
        dragger = new WindowDragger(guiFrame, guiTitlePanel);
    }

    public javax.swing.JFrame getJDialog() {
        return guiFrame;
    }

    public void makeResizeable() {
        guiCodePanel.add(guiBottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public JComponent getContentPane() {
        return guiContentPane;
    }

    public void setContentPane(JComponent contentPane) {
        if (guiContentPane != null) {
            guiCodePanel.remove(guiContentPane);
        }
        guiContentPane = contentPane;
        guiCodePanel.add(guiContentPane, BorderLayout.CENTER);
    }

    private ActionListener createCloseButtonActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
    }

    private ActionListener createMinimizeButtonActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                guiFrame.setState(javax.swing.JFrame.ICONIFIED);
            }
        };
    }

    private ActionListener createMaximizeButtonActionListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (guiBottomPanel.isResizableNow() == true) {
                    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
                    guiFrame.setLocation(0, 0);
                    guiFrame.setSize(size);
                    guiBottomPanel.setUnresizable();
                    dragger.setUndraggable();
                } else {
                    guiFrame.setSize(600, 650);
                    guiFrame.setLocationRelativeTo(null);
                    guiBottomPanel.setResizable();
                    dragger.setDraggable();
                }
            }
        };
    }

    private void initLeftSidePanel() {
        addEdiitorTab = new javax.swing.JButton();
        buildAndRun = new javax.swing.JButton();
        copyToClipboard = new javax.swing.JButton();
        shareMe = new javax.swing.JButton();

        leftSidePanle.setBackground(new java.awt.Color(0, 0, 0));
        leftSidePanle.setFocusable(false);
        leftSidePanle.setOpaque(false);

        addEdiitorTab.setBackground(new java.awt.Color(0, 0, 0));
        addEdiitorTab.setForeground(new java.awt.Color(0, 0, 0));
        addEdiitorTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/add.png"))); // NOI18N
        addEdiitorTab.setBorderPainted(false);
        addEdiitorTab.setContentAreaFilled(false);
        addEdiitorTab.setFocusPainted(false);
        addEdiitorTab.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/add_hover.png"))); // NOI18N
        addEdiitorTab.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addEdiitorTabActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(GuiWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        buildAndRun.setBackground(new java.awt.Color(0, 0, 0));
        buildAndRun.setForeground(new java.awt.Color(0, 0, 0));
        buildAndRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/run.png"))); // NOI18N
        buildAndRun.setBorderPainted(false);
        buildAndRun.setContentAreaFilled(false);
        buildAndRun.setFocusPainted(false);
        buildAndRun.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/run_hover.png"))); // NOI18N
        buildAndRun.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    buildAndRunActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(GuiWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        copyToClipboard.setBackground(new java.awt.Color(0, 0, 0));
        copyToClipboard.setForeground(new java.awt.Color(0, 0, 0));
        copyToClipboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/clipboard.png"))); // NOI18N
        copyToClipboard.setBorderPainted(false);
        copyToClipboard.setContentAreaFilled(false);
        copyToClipboard.setFocusPainted(false);
        copyToClipboard.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/clipboard_hover.png"))); // NOI18N
        copyToClipboard.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyToClipboardActionPerformed(evt);
            }
        });

        shareMe.setBackground(new java.awt.Color(0, 0, 0));
        shareMe.setForeground(new java.awt.Color(0, 0, 0));
        shareMe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/chat.png"))); // NOI18N
        shareMe.setBorderPainted(false);
        shareMe.setContentAreaFilled(false);
        shareMe.setFocusPainted(false);
        shareMe.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/chat_hover.png"))); // NOI18N
        shareMe.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    shareMeActionPerformed(evt);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GuiWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(leftSidePanle);
        leftSidePanle.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(buildAndRun, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(addEdiitorTab, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(copyToClipboard, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(shareMe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(34, 34, 34).addComponent(addEdiitorTab).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(buildAndRun).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(copyToClipboard).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(shareMe).addContainerGap(134, Short.MAX_VALUE)));
    }// </editor-fold>

    public void addTab() throws IOException {
        panel.jTabbedPane3.addTab("Untitled" + count, sharePanel = new runtimeSharingPanel(this));
        panel.jTabbedPane3.setTabPlacement(JTabbedPane.TOP);
        tabCount++;
        count++;
    }

    public void removeTab() {
        if (tabCount > -1) {
            int index0 = panel.jTabbedPane3.getSelectedIndex();
            System.out.println(index0);
            panel.jTabbedPane3.remove(index0);
            tabCount--;
        }
    }

    public runtimeSharingPanel setTab1() throws IOException {
        panel.jTabbedPane3.addTab("Untitled" + count, sharePanel = new runtimeSharingPanel(this));
        panel.jTabbedPane3.setTabPlacement(JTabbedPane.TOP);
        tabCount++;
        count++;
        return sharePanel;
    }

    public ChatPanel setTab2() {
        chatTabCount++;
        panel.jTabbedPane2.addTab(null, chatPanel = new ChatPanel());
        panel.jTabbedPane2.setTabPlacement(JTabbedPane.RIGHT);
        return chatPanel;
    }

    public JTabbedPane getObject1() {
        return panel.jTabbedPane3;
    }

    public JTabbedPane getObject2() {
        return panel.jTabbedPane2;
    }

    public RSyntaxTextArea findArea() {
        runtimeSharingPanel pan = (runtimeSharingPanel) panel.jTabbedPane3.getComponentAt(panel.jTabbedPane3.getSelectedIndex());
        return pan.coder;
    }

    private void addEdiitorTabActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
        addTab();
    }

    private void buildAndRunActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
        runtimeSharingPanel pan = (runtimeSharingPanel) panel.jTabbedPane3.getComponentAt(panel.jTabbedPane3.getSelectedIndex());
        int i = pan.getStyle();

        switch (i) {
            case 0:
                cRun();
                break;
            case 1:
                javaRun();
                break;
            case 2:
            case 3:
        }
    }

    private void copyToClipboardActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        runtimeSharingPanel pan = (runtimeSharingPanel) panel.jTabbedPane3.getComponentAt(panel.jTabbedPane3.getSelectedIndex());
        StringSelection sers = new StringSelection(pan.coder.getText());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sers ,null);
    }

    private void shareMeActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
        if (panel.isTabVisible()) {
            panel.resetTheSize();
        } else {
            panel.setTheSize();
        }

    }

    public void connectIP() throws IOException {
        if (panel.ipCollector.getText().compareTo("") != 0) {
            String ip = panel.ipCollector.getText();
            Client nj2 = new Client(ip, this, name);
        }
    }

    void save() throws IOException {
        String str = ".c";
        runtimeSharingPanel pan = (runtimeSharingPanel) panel.jTabbedPane3.getComponentAt(panel.jTabbedPane3.getSelectedIndex());
        int i = pan.getStyle();

        switch (i) {
            case 0:
                str = ".c"; break;
            case 1:
                str = ".java"; break;
            case 2:
                str = ".html"; break;
            case 3:
                str = ".php"; break;
        }

        String code = pan.coder.getText();
        FileWriter file = new FileWriter(panel.jTabbedPane3.getTitleAt(panel.jTabbedPane3.getSelectedIndex()) + str);
        pan.coder.write(file);
        file.close();
    }

    public void synStyle() throws FileNotFoundException {
        runtimeSharingPanel pan = (runtimeSharingPanel) panel.jTabbedPane3.getComponentAt(panel.jTabbedPane3.getSelectedIndex());
        int i = pan.getStyle();
        pan.setSynStyle((i + 1) % 4);
    }

    private void cRun() throws IOException {
        try {
            String str = panel.jTabbedPane3.getTitleAt(panel.jTabbedPane3.getSelectedIndex());
            Process p = Runtime.getRuntime().exec("gcc -o " + str + " " + str + ".c");
            BufferedReader stdError = new BufferedReader(new InputStreamReader(
                    p.getErrorStream()));
            String error = "";
            String s = null;
            while ((s = stdError.readLine()) != null) {
                error += s + "\n";
            }
            if (error == "") {
                Runtime.getRuntime().exec("cmd /c start " + str + ".exe");
            } else {
                JOptionPane.showMessageDialog(this, error);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void javaRun() {
        try {
            String str = panel.jTabbedPane3.getTitleAt(panel.jTabbedPane3.getSelectedIndex());
            Process p = Runtime.getRuntime().exec("javac " + str + ".java");
            BufferedReader stdError = new BufferedReader(new InputStreamReader(
                    p.getErrorStream()));
            String error = "";
            String s = null;
            while ((s = stdError.readLine()) != null) {
                error += s + "\n";
            }
            if (error == "") {
                Runtime.getRuntime().exec("java " + str);
            } else {
                JOptionPane.showMessageDialog(this, error);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}