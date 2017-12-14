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
package GUI;

import Core.Architecture.Memory.Memory;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emnga
 */
public class MemoryPane extends javax.swing.JPanel {

    /**
     * Creates new form MemoryPane
     */
    
    Memory mem;
    public MemoryPane(Memory mem) {
        initComponents();
        this.mem=mem;
    }
    
    public void setVisibleAdresses(int initial, int quantity){
        DefaultTableModel model=new DefaultTableModel(new String[]{"Adress","Sector","Value"}, 0);
        Object[] obj;
        for(int i=0;i<quantity; i++){
            obj=new Object[3];
            Memory.MemoryAdress aux=mem.getAdress(initial+i);
            try{
            obj[0]=aux.address;
            obj[1]=aux.sector;
            obj[2]=aux.value.toString();
            model.addRow(obj);
            }catch(NullPointerException e){
                break;
            }
        }
        this.tableMemory.setModel(model);
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
        tableMemory = new javax.swing.JTable();

        tableMemory.setEnabled(false);
        tableMemory.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tableMemory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableMemory;
    // End of variables declaration//GEN-END:variables

}