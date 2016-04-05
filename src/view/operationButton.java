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
public class operationButton extends Button {
    public operationButton(String number) {
        this.setLabel(number);
        this.setMaximumSize(new Dimension(50, 50));
        this.setVisible(true);
    }
}
