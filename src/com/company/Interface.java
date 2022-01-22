package com.company;

import javax.swing.*;
import java.awt.*;

public class Interface {
    public static void main(String[] args) {
        JFrame window = getJFrame();
    }
    static JFrame getJFrame(){
        JFrame window = new JFrame("tic-tac-toe");
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        window.setBounds(dimension.width/2-250, dimension.height/2-150, 500, 300);
        return window;
    }
}
