/*
 * Copyright (C) 2017 emnga
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package Core.GUI;

import Core.Architecture.Architecture;
import Core.Architecture.Memory.Mapping;
import Core.Architecture.Memory.Memory;
import Core.Architecture.Sector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author emnga
 */
public class MemoriesEditor extends javax.swing.JFrame {

    /**
     * Creates new form MemoriesEditor
     */
    Memory[] auxMemories;
    public main parent;

    public MemoriesEditor(main parent) {
        this.parent = parent;
        auxMemories = parent.cpu.getArchitecture().getMemory().clone();
        initComponents();
        initData();
        this.jList1.addMouseListener(new MouseAdapter() {

            Memory memory;

            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 1) {
                    try {
                        String memName = list.getSelectedValue().toString();
                        memory = MemoriesEditor.this.getMemoryFromIdentifier(memName);
                        MemoriesEditor.this.updateData(memory);
                        return;
                    } catch (NullPointerException e) {

                    }
                }
                if (evt.getClickCount() == 2) {
                    MemoriesEditor.this.openMemoryEditor(memory);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblIdentifier = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblRegSize = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblSize = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Memories"));

        jList1.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Properties"));

        jPanel1.setLayout(new java.awt.GridLayout(6, 1, 0, 5));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Identifier");
        jPanel1.add(jLabel5);

        lblIdentifier.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(lblIdentifier);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Register size");
        jPanel1.add(jLabel3);

        lblRegSize.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(lblRegSize);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Number of registers");
        jPanel1.add(jLabel1);

        lblSize.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(lblSize);

        jScrollPane2.setViewportView(jPanel1);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Mapping"));

        jList2.setModel(new DefaultListModel());
        jList2.setEnabled(false);
        jScrollPane3.setViewportView(jList2);

        jButton1.setText("Accept");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(7, 7, 7)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton2)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        openMemoryCreator();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        close();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        close();
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.parent.cpu.getArchitecture().setMemory(auxMemories);
        this.parent.updateArchitectureData();
        close();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblIdentifier;
    private javax.swing.JLabel lblRegSize;
    private javax.swing.JLabel lblSize;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        initList();

    }

    @SuppressWarnings("unchecked")
    private void initList() {
        if (this.auxMemories.length > 0) {
            for (Memory mem : this.auxMemories) {
                ((DefaultListModel) this.jList1.getModel()).addElement(mem.getIdentifier());
            }
        }
    }

    public void updateData(Memory mem) {
        if (mem == null) {
            DialogCreator.createErrorDialog(this, "Ooops", "You weren't supposed to see this error");
        }
        this.lblIdentifier.setText(mem.getIdentifier());
        this.lblRegSize.setText(Integer.toString(mem.getRegisterSize()));
        this.lblSize.setText(Integer.toString(mem.getSizeInBytes()));
        updateMapping(mem.getMapping());
    }

    @SuppressWarnings("unchecked")
    private void updateMapping(Mapping map) {
        DefaultListModel model = ((DefaultListModel) this.jList2.getModel());
        model.removeAllElements();
        for (Sector sect : map.getSectors()) {
            StringBuilder sb = new StringBuilder(sect.name);
            sb.append(",start:").append(sect.start);
            sb.append(",finish:").append(sect.finish);
            model.addElement(sb.toString());
        }
    }

    private Memory getMemoryFromIdentifier(String memory) {
        for (Memory auxMemorie : this.auxMemories) {
            if (auxMemorie.getIdentifier().equals(memory)) {
                return auxMemorie;
            }
        }
        return null;
    }

    private void openMemoryEditor(Memory memory) {
        new MemoryEditor(this, memory).setVisible(true);
        this.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    void updateMemoriesData() {
        DefaultListModel model = (DefaultListModel) this.jList1.getModel();
        model.removeAllElements();
        if (this.auxMemories.length > 0) {
            for (Memory mem : this.auxMemories) {
                model.addElement(mem.getIdentifier());
            }
        }
    }

    void addMemory(Memory me) {
        Memory[] aux = new Memory[this.auxMemories.length + 1];
        for (int i = 0; i < this.auxMemories.length; i++) {
            aux[i] = this.auxMemories[i];
        }
        aux[aux.length - 1] = me;
        this.auxMemories = aux;
    }

    private void openMemoryCreator() {
        new MemoryEditor(this).setVisible(true);
        this.setEnabled(false);
    }

    void deleteMemory(Memory memory) {
        Memory[] m = new Memory[this.auxMemories.length - 1];
        boolean aux = false;
        for (int i = 0; i < this.auxMemories.length; i++) {
            if (this.auxMemories[i].getIdentifier().equals(memory.getIdentifier())) {
                aux = true;
            }
            try {
                if (aux) {
                    m[i - 1] = this.auxMemories[i];
                } else {
                    m[i] = this.auxMemories[i];
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }
        this.auxMemories = m;
    }

    private void close() {
        this.parent.toFront();
        this.parent.setEnabled(true);
        this.dispose();
    }
}
