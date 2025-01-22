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
public class ReadFrame extends JInternalFrame{
    public ReadFrame(){
        setTitle("Leer Registros");
        setSize(600, 400);
        setClosable(true);
        setLayout(null);
        
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Nombre", "Edad"},0);
        table.setModel(model);
        
        //Aqui se agregan los registros a la tabla 
        for(String[] record : CreateFrame.getRecords()){
            model.addRow(record);
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 30,500, 300);
        
        add(scrollPane);
    }
}
