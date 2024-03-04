package org.example;

import javax.swing.*;
import java.awt.*;

public class Styles {
    public void ButtonStyle(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
    }

    public void ButtonNoStyle(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBorder(null);
    }

    public void TextStyle(JLabel label) {
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
    }
}