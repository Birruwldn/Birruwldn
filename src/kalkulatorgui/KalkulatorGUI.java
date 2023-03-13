/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kalkulatorgui;

/**
 *
 * @author Birru
 */


    import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KalkulatorGUI extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    private JTextField inputField;
    private double angkaPertama, angkaKedua, hasil;
    private int operator;
    
    public KalkulatorGUI() {
        super("Kalkulator");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        add(panel, BorderLayout.CENTER);
        
        inputField = new JTextField();
        inputField.setEditable(false);
        add(inputField, BorderLayout.NORTH);
        
        String[] tombolLabel = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        JButton[] tombol = new JButton[tombolLabel.length];
        
        for (int i = 0; i < tombolLabel.length; i++) {
            tombol[i] = new JButton(tombolLabel[i]);
            tombol[i].addActionListener(this);
            panel.add(tombol[i]);
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        
        if (s.matches("[0-9.]")) {
            inputField.setText(inputField.getText() + s);
        } else if (s.equals("+")) {
            angkaPertama = Double.parseDouble(inputField.getText());
            operator = 1;
            inputField.setText("");
        } else if (s.equals("-")) {
            angkaPertama = Double.parseDouble(inputField.getText());
            operator = 2;
            inputField.setText("");
        } else if (s.equals("*")) {
            angkaPertama = Double.parseDouble(inputField.getText());
            operator = 3;
            inputField.setText("");
        } else if (s.equals("/")) {
            angkaPertama = Double.parseDouble(inputField.getText());
            operator = 4;
            inputField.setText("");
        } else if (s.equals("=")) {
            angkaKedua = Double.parseDouble(inputField.getText());
            switch (operator) {
                case 1:
                    hasil = angkaPertama + angkaKedua;
                    break;
                case 2:
                    hasil = angkaPertama - angkaKedua;
                    break;
                case 3:
                    hasil = angkaPertama * angkaKedua;
                    break;
                case 4:
                    hasil = angkaPertama / angkaKedua;
                    break;
            }
            inputField.setText(String.valueOf(hasil));
        }
    }
    
    public static void main(String[] args) {
        new KalkulatorGUI();
    }
}