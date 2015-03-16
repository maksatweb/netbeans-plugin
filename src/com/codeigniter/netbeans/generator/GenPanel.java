/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeigniter.netbeans.generator;

import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.WizardDescriptor;

/**
 *
 * @author Maxence
 */
public class GenPanel extends javax.swing.JPanel {

    /**
     * Creates new form GenPanel
     */
    public GenPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nfLabel = new javax.swing.JLabel();
        sLabel = new javax.swing.JLabel();
        nfButton = new javax.swing.JButton();
        sButton = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(nfLabel, org.openide.util.NbBundle.getMessage(GenPanel.class, "GenPanel.nfLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(sLabel, org.openide.util.NbBundle.getMessage(GenPanel.class, "GenPanel.sLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(nfButton, org.openide.util.NbBundle.getMessage(GenPanel.class, "GenPanel.nfButton.text")); // NOI18N
        nfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nfButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(sButton, org.openide.util.NbBundle.getMessage(GenPanel.class, "GenPanel.sButton.text")); // NOI18N
        sButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(sLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(nfLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nfButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sButton, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nfButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sButton))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nfButtonActionPerformed
        // TODO add your handling code here:
        List<WizardDescriptor.Panel<WizardDescriptor>> panels = new ArrayList<WizardDescriptor.Panel<WizardDescriptor>>();
                panels.add(new GenwizardWizardPanel1());
                panels.add(new GenwizardWizardPanel2());
                String[] steps = new String[panels.size()];
                for (int i = 0; i < panels.size(); i++) {
                    Component c = panels.get(i).getComponent();
                    // Default step name to component name of panel.
                    steps[i] = c.getName();
                    if (c instanceof JComponent) { // assume Swing components
                        JComponent jc = (JComponent) c;
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                        jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, true);
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, true);
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, true);
                    }
                }
                WizardDescriptor wiz = new WizardDescriptor(new WizardDescriptor.ArrayIterator<WizardDescriptor>(panels));
                // {0} will be replaced by WizardDesriptor.Panel.getComponent().getName()
                wiz.setTitleFormat(new MessageFormat("{0}"));
                wiz.setTitle("New Files");
                if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
                    // do something
                    String name = (String) wiz.getProperty("name");
                    int selection = (Integer) wiz.getProperty("selection");
                    String path;
                    switch (selection) {
                        case 0:
                            path = "PROJECT_ROOT/application/models/";
                            try {
                                File file = new File(path + name + ".php");
                                FileWriter fw;
                                if (file.exists()) {
                                    fw = new FileWriter(file, true);//if file exists append to file. Works fine.
                                } else {
                                    fw = new FileWriter(file);// If file does not exist. Create it. This throws a FileNotFoundException. Why? 
                                }
                                fw.close();
                            } catch (Exception ex) {
                                System.out.println("Exception: Not working!!");
                            }
                            break;
                        case 1:
                            path = "PROJECT_ROOT/application/views/";
                            try {
                                File file = new File(path + name + ".php");
                                FileWriter fw;
                                if (file.exists()) {
                                    fw = new FileWriter(file, true);
                                } else {
                                    fw = new FileWriter(file);// If file does not exist. Create it. This throws a FileNotFoundException. Why? 
                                }
                                fw.close();
                            } catch (Exception ex) {
                                System.out.println("Exception: Not working!!");
                            }
                            break;
                        case 2:
                            path = "PROJECT_ROOT/application/controllers/";
                            try {
                                File file = new File(path + name + ".php");
                                FileWriter fw;
                                if (file.exists()) {
                                    fw = new FileWriter(file, true);
                                } else {
                                    fw = new FileWriter(file);// If file does not exist. Create it. This throws a FileNotFoundException. Why? 
                                }
                                fw.close();
                            } catch (Exception ex) {
                                System.out.println("Exception: Not working!!");
                            }
                            break;
                    }
                    DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message(name + " " + selection));

                }
    }//GEN-LAST:event_nfButtonActionPerformed

    private void sButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sButtonActionPerformed
        // TODO add your handling code here:
        List<WizardDescriptor.Panel<WizardDescriptor>> panels = new ArrayList<WizardDescriptor.Panel<WizardDescriptor>>();
                panels.add(new ScaffwizardWizardPanel1());
                String[] steps = new String[panels.size()];
                for (int i = 0; i < panels.size(); i++) {
                    Component c = panels.get(i).getComponent();
                    // Default step name to component name of panel.
                    steps[i] = c.getName();
                    if (c instanceof JComponent) { // assume Swing components
                        JComponent jc = (JComponent) c;
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                        jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, true);
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, true);
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, true);
                    }
                }
                WizardDescriptor wiz = new WizardDescriptor(new WizardDescriptor.ArrayIterator<WizardDescriptor>(panels));
                // {0} will be replaced by WizardDesriptor.Panel.getComponent().getName()
                wiz.setTitleFormat(new MessageFormat("{0}"));
                wiz.setTitle("Scaffolding");
                if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
                    // do something
                }
    }//GEN-LAST:event_sButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton nfButton;
    private javax.swing.JLabel nfLabel;
    private javax.swing.JButton sButton;
    private javax.swing.JLabel sLabel;
    // End of variables declaration//GEN-END:variables
}
