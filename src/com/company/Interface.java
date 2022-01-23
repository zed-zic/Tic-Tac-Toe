package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Interface extends JComponent {
    public static final int FIELD_EMPTY = 0;
    public static final int FIELD_X = 10;
    public static final int FIELD_0 = 100;
    int [][]field;
    boolean isXTurn;


    public Interface(){
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        field = new int[3][3];
        initGame();
    }

    public void initGame(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                field[i][j] = FIELD_EMPTY;
            }
        }
        isXTurn = true;
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

    protected void processMouseEvent(MouseEvent mouseEvent){
        super.processMouseEvent(mouseEvent);
        if (mouseEvent.getButton() == mouseEvent.BUTTON1){
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            int i = (int) ((float)x / getWidth() * 3);
            int j = (int) ((float)y / getHeight() * 3);
            if (field[i][j] == FIELD_EMPTY){
                field[i][j] = isXTurn?FIELD_X:FIELD_0;
                isXTurn = !isXTurn;
                repaint();
            }
        }
    }

    void drawX(int i, int j, Graphics graphics){
        graphics.setColor(Color.BLACK);
        int dh = getHeight() / 3;
        int dw = getWidth() / 3;
        int x = i * dw;
        int y = j * dh;
        graphics.drawLine(x, y,x+dw,y+dh);
        graphics.drawLine(x, y+dh,x+dw, y);
    }

    void draw0(int i, int j, Graphics graphics){
        graphics.setColor(Color.BLACK);
        int dh = getHeight() / 3;
        int dw = getWidth() / 3;
        int x = i * dw;
        int y = j * dh;
        graphics.drawOval(x + 5 * dw /100, y, dw * 9 / 10, dh);
    }

    void drawX0(Graphics graphics){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (field[i][j] == FIELD_X) drawX(i, j, graphics);
                if (field[i][j] == FIELD_0) draw0(i, j, graphics);
            }
        }
    }
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        drawField(graphics);
        drawX0(graphics);
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
