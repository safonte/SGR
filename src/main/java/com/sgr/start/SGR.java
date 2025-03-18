/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sgr.start;

import View.TelaLogin;
import javax.swing.SwingUtilities;

/**
 *
 * @author safon
 */
public class SGR {

public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLogin login = new TelaLogin();
            login.setVisible(true);
        });
    }
}
