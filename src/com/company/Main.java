package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame window = Interface.getJFrame();
        Interface game = new Interface();
        window.add(game);
    }
}
