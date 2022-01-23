package com.company;

import javax.swing.*;
import java.awt.*;

public class Interface extends JComponent {
//    public static void main(String[] args) {
//        //JFrame window = getJFrame();
//    }
    public Interface(){
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
    static JFrame getJFrame(){
        JFrame window = new JFrame("tic-tac-toe");
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        window.setBounds(dimension.width/2-250, dimension.height/2-150, 450, 450);
        return window;
    }

    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        drawField(graphics);
    }
    void drawField(Graphics graphics){
        int width = getWidth();
        int height = getHeight();
        graphics.setColor(Color.red);
//        graphics.drawOval(10,10,100,100);
        for (int i = 1; i < 3; i++) {
            graphics.drawLine(0,height / 3 * i,width,height / 3 * i);
            graphics.drawLine(width / 3 * i,0,width / 3 * i, height);
        }
    }
}
