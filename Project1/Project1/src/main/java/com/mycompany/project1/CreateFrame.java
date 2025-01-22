/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1;

import javax.swing.*;
import java.util.ArrayList;

public class CreateFrame extends JInternalFrame {
    // Lista para almacenar los datos
    private static ArrayList<String[]> records = new ArrayList<>();

    public CreateFrame() {
        setTitle("Crear Registro");
        setSize(400, 300);
        setClosable(true);
        setLayout(null);

        // Componentes de la interfaz
        JLabel lblName = new JLabel("Nombre:");
        JTextField txtName = new JTextField();
        JLabel lblAge = new JLabel("Edad:");
        JTextField txtAge = new JTextField();
        JButton btnSave = new JButton("Guardar");

        // Posiciones de los componentes
        lblName.setBounds(30, 30, 100, 30);
        txtName.setBounds(150, 30, 200, 30);
        lblAge.setBounds(30, 80, 100, 30);
        txtAge.setBounds(150, 80, 200, 30);
        btnSave.setBounds(150, 130, 100, 30);

        // Acción del botón Guardar
        btnSave.addActionListener(e -> {
            String name = txtName.getText().trim();
            String age = txtAge.getText().trim();

            if (name.isEmpty() || age.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Integer.parseInt(age); // Validar que la edad sea un número
                records.add(new String[]{name, age}); // Agregar a la lista
                JOptionPane.showMessageDialog(this, "Registro guardado exitosamente.");
                txtName.setText("");
                txtAge.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La edad debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Añadir componentes al frame
        add(lblName);
        add(txtName);
        add(lblAge);
        add(txtAge);
        add(btnSave);
    }

    // Método para obtener los registros (será usado por otras clases)
    public static ArrayList<String[]> getRecords() {
        return records;
    }
}
