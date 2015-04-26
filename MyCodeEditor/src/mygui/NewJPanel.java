/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

/**
 *
 * @author Admin
 */
public class NewJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public String name;
    private GuiWindow owner;
    public NewJPanel(GuiWindow owner, String name) {
        this.name = name;
        this.owner = owner;
        initComponents();
        jTabbedPane2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        topButtonPanel = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        ipCollector = new javax.swing.JTextField();
        undo = new javax.swing.JButton();
        redo = new javax.swing.JButton();
        copy = new javax.swing.JButton();
        cut = new javax.swing.JButton();
        choose = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        paste1 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(0, 0, 0));
        setOpaque(false);

        topButtonPanel.setBackground(new java.awt.Color(0, 0, 0));
        topButtonPanel.setOpaque(false);

        connectButton.setBackground(new java.awt.Color(0, 0, 0));
        connectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/connect.png"))); // NOI18N
        connectButton.setBorderPainted(false);
        connectButton.setContentAreaFilled(false);
        connectButton.setFocusPainted(false);
        connectButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/connect_hover.png"))); // NOI18N
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        ipCollector.setBackground(new java.awt.Color(0, 0, 0));
        ipCollector.setForeground(new java.awt.Color(176, 176, 176));
        ipCollector.setCaretColor(new java.awt.Color(204, 204, 204));
        ipCollector.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        ipCollector.setMargin(new java.awt.Insets(0, 0, 0, 0));
        ipCollector.setOpaque(false);
        ipCollector.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        ipCollector.setSelectionColor(new java.awt.Color(204, 204, 204));
        ipCollector.setBorder(BorderFactory.createLineBorder (new java.awt.Color(112, 110, 110), 2));
        ipCollector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipCollectorActionPerformed(evt);
            }
        });

        undo.setBackground(new java.awt.Color(0, 0, 0));
        undo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/undo.png"))); // NOI18N
        undo.setBorderPainted(false);
        undo.setContentAreaFilled(false);
        undo.setFocusPainted(false);
        undo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/undo_hover.png"))); // NOI18N
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        redo.setBackground(new java.awt.Color(0, 0, 0));
        redo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/redo.png"))); // NOI18N
        redo.setBorderPainted(false);
        redo.setContentAreaFilled(false);
        redo.setFocusPainted(false);
        redo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/redo_hover.png"))); // NOI18N
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

        copy.setBackground(new java.awt.Color(0, 0, 0));
        copy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/copy.png"))); // NOI18N
        copy.setBorderPainted(false);
        copy.setContentAreaFilled(false);
        copy.setFocusPainted(false);
        copy.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/copy_hover.png"))); // NOI18N
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });

        cut.setBackground(new java.awt.Color(0, 0, 0));
        cut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/cut.png"))); // NOI18N
        cut.setBorderPainted(false);
        cut.setContentAreaFilled(false);
        cut.setFocusPainted(false);
        cut.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/cut.png"))); // NOI18N
        cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });

        choose.setBackground(new java.awt.Color(0, 0, 0));
        choose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/choose.png"))); // NOI18N
        choose.setBorderPainted(false);
        choose.setContentAreaFilled(false);
        choose.setFocusPainted(false);
        choose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/choose_hover.png"))); // NOI18N
        choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseActionPerformed(evt);
            }
        });

        Save.setBackground(new java.awt.Color(0, 0, 0));
        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/save.png"))); // NOI18N
        Save.setBorderPainted(false);
        Save.setContentAreaFilled(false);
        Save.setFocusPainted(false);
        Save.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/save_hover.png"))); // NOI18N
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        paste1.setBackground(new java.awt.Color(0, 0, 0));
        paste1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/paste.png"))); // NOI18N
        paste1.setBorderPainted(false);
        paste1.setContentAreaFilled(false);
        paste1.setFocusPainted(false);
        paste1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/mygui/Images/paste_hover.png"))); // NOI18N
        paste1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paste1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topButtonPanelLayout = new javax.swing.GroupLayout(topButtonPanel);
        topButtonPanel.setLayout(topButtonPanelLayout);
        topButtonPanelLayout.setHorizontalGroup(
            topButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topButtonPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(undo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(redo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cut, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(copy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paste1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(choose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ipCollector, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topButtonPanelLayout.setVerticalGroup(
            topButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topButtonPanelLayout.createSequentialGroup()
                .addGroup(topButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ipCollector)
                    .addComponent(undo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Save, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paste1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2)))
        );
    }// </editor-fold>//GEN-END:initComponents

    

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        try {
            // TODO add your handling code here:
            owner.connectIP();
            
        } catch (IOException ex) {
            Logger.getLogger(NewJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        // TODO add your handling code here:
        RSyntaxTextArea area = owner.findArea();
        area.undoLastAction();
    }//GEN-LAST:event_undoActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
        // TODO add your handling code here:
        RSyntaxTextArea area = owner.findArea();
        area.redoLastAction();
    }//GEN-LAST:event_redoActionPerformed

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
        // TODO add your handling code here:
        RSyntaxTextArea area = owner.findArea();
        area.copy();
    }//GEN-LAST:event_copyActionPerformed

    private void cutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutActionPerformed
        // TODO add your handling code here:
        RSyntaxTextArea area = owner.findArea();
        area.cut();
    }//GEN-LAST:event_cutActionPerformed

    private void chooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseActionPerformed
        try {
            // TODO add your handling code here:
            owner.synStyle();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chooseActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        try {
            // TODO add your handling code here:
            owner.save();
        } catch (IOException ex) {
            Logger.getLogger(NewJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void paste1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paste1ActionPerformed
        // TODO add your handling code here:
        RSyntaxTextArea area = owner.findArea();
        area.paste();
    }//GEN-LAST:event_paste1ActionPerformed

    private void ipCollectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipCollectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipCollectorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JButton choose;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton copy;
    private javax.swing.JButton cut;
    public javax.swing.JTextField ipCollector;
    private javax.swing.JButton jButton1;
    public javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JButton paste1;
    private javax.swing.JButton redo;
    public javax.swing.JPanel topButtonPanel;
    private javax.swing.JButton undo;
    // End of variables declaration//GEN-END:variables

    public void setTheSize() {
        jTabbedPane2.setVisible(true);
    }

    public void resetTheSize() {
        jTabbedPane2.setVisible(false);
    }

    public boolean isTabVisible() {
        if (jTabbedPane2.isVisible()) {
            return true;
        }
        return false;
    }
}
