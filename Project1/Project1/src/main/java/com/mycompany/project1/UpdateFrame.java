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
public class UpdateFrame extends JInternalFrame{
    public UpdateFrame(){
        setTitle("Actualizar Registro");
        setSize(600, 400);
        setClosable(true);
        setLayout(null);
        
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Nombre", "Edad"},0);
        table.setModel(model);
        
        for(String[]record : CreateFrame.getRecords()){
            model.addRow(record);
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 30, 500, 200);
        
        JLabel lblName = new JLabel("Nombre");
        JTextField txtName = new JTextField();
        JLabel lblAge = new JLabel("Edad:");
        JTextField txtAge = new JTextField();
        JButton btnUpdate = new JButton("Actualizar");
        
        lblName.setBounds(30, 250, 100, 30);
        txtName.setBounds(150, 250, 200, 30);
        lblAge.setBounds(30, 300, 100, 30);
        txtAge.setBounds(150, 300, 200, 30);
        btnUpdate.setBounds(400, 300, 120, 30);
        
        btnUpdate.addActionListener(e ->{
            int selectedRow = table.getSelectedRow();
            if(selectedRow != -1){
                String name = txtName.getText().trim();
                String age = txtAge.getText().trim();
                
                if(name.isEmpty() || age.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                    Integer.parseInt(age);
                    CreateFrame.getRecords().set(selectedRow, new String[]{name, age});
                    model.setValueAt(name, selectedRow, 0);
                    model.setValueAt(age, selectedRow, 1);
                    JOptionPane.showMessageDialog(this, "Registro actualizado.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "La edad debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Selecciona un registro para actualizar.", "Error", JOptionPane.WARNING_MESSAGE);
                
            }
        });
        
        add(scrollPane);
        add(lblName);
        add(txtName);
        add(lblAge);
        add(txtAge);
        add(btnUpdate);
    }
}
