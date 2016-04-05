/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Button;
import java.awt.Dimension;

/**
 *
 * @author pablo
 */
public class NumericButton extends Button {
    
    public NumericButton(String number) {
        this.setLabel(number);
        this.setMaximumSize(new Dimension(60, 60));
        this.setVisible(true);
    }
}
