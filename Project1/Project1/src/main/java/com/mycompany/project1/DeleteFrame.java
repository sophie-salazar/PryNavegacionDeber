/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aladi
 */
public class DeleteFrame extends JInternalFrame{
    public DeleteFrame(){
        setTitle("Eliminar Registro");
        setSize(600, 400);
        setClosable(true);
        setLayout(null);
        
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Nombre", "Edad"}, 0);
        table.setModel(model);
        
        for (String[] record : CreateFrame.getRecords()) {
            model.addRow(record);
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 30, 500, 300);

        JButton btnDelete = new JButton("Eliminar");
        btnDelete.setBounds(400, 350, 120, 30);
        
        btnDelete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                CreateFrame.getRecords().remove(selectedRow);
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Registro eliminado.");
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un registro para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        add(scrollPane);
        add(btnDelete);
    }
}
