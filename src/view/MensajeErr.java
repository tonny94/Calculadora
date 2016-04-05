/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author tonny
 */
public class MensajeErr {
    JFrame Ventana =new JFrame();
    JPanel p=new JPanel();
    JLabel jtf=new JLabel();
    
    public MensajeErr() {
        Ventana.setSize(355, 100);
        GridLayout btnGrid = new GridLayout(1, 1);
        p.setLayout(btnGrid);
        jtf.setText("Error en el número de parentesis");
        p.add(jtf);
        Ventana.add(p);
        Ventana.setLocationRelativeTo(null);
        Ventana.setVisible(false);
        
       
        
    }
    
    public void visibleON(){
        this.Ventana.setVisible(true);;
    }
    
    
    public void visibleOFF(){
        this.Ventana.setVisible(false);;
    }
    
    
}
