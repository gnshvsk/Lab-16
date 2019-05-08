package org;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Window extends Frame {
    private String key_msg = "STRANGE APP";
    private String mouse_msg = "";
    private static char[] haha = {1043,1054,1053,1040,1064,1045,1042,1057, 1050, 1040, 1071, 32, 1047, 1054, 1071, 32, 1048,1042,1058,45,49,55,51};
    private int mouseX = 30, mouseY = 30;

    public Window() {
        addKeyListener(new MyKeyAdapter(this));
        addWindowListener(new AwtWindowAdapter());              //обработка событий клавы, окна, мыши
        addMouseListener(new MyMouseAdapter(this));
    }

    public static void main(String[] args) {
        for(char c: haha){
            System.out.print(c);
        } System.out.print("\n");
        Window aw_win = new Window();                          //создаем основное диалоговое окно
        aw_win.setSize(300, 200);
        aw_win.setTitle("STRANGE APP");

        Button PRESS = new Button("Нажми меня");        //кнопка в основном окне
        PRESS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {      //вызов 2го диалогового окна при нажатии на кнопку
                Dialog();
            }
        });
        Panel panel = new Panel();
        panel.add(PRESS);
        aw_win.add(panel);
        aw_win.setVisible(true);
    }

    public static void Dialog(){
        for(char c: haha){
            System.out.print(c);
        } System.out.print("\n");
        Window aw_win1 = new Window();                      //создание 2го диалогового окна
        aw_win1.setSize(200, 100);
        aw_win1.setTitle("Window");
        Label l = new Label("Что делаем дальше?");
        Button GO = new Button("Уходим");            //кнопка, завершающая работу программы
        GO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Button STAY = new Button("Остаемся");       //кнопка, закрывающая только 2е диалоговое окно
        STAY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aw_win1.setVisible(false);
            }
        });
        Panel pane2 = new Panel();
        pane2.add(l);
        pane2.add(GO);
        pane2.add(STAY);
        aw_win1.add(pane2);
        aw_win1.setVisible(true);
    }

    class MyKeyAdapter extends KeyAdapter { //наследование абстрактного класс адаптера для того, чтобы получить события клавиатуры
        Window awtWindow;
        public MyKeyAdapter(Window awtWindow) {
            this.awtWindow = awtWindow;
        }

        public void keyTyped(KeyEvent ke) {
            awtWindow.key_msg +=ke.getKeyChar();
            awtWindow.repaint();
        }
    }

    class MyMouseAdapter extends MouseAdapter { //наследование абстрактного класс адаптера для того, чтобы получить события мыши
        Window awtWindow;
        public MyMouseAdapter(Window awtWindow) {
            this.awtWindow = awtWindow;
        }

        public void mousePressed(MouseEvent me) {
            awtWindow.mouseX = me.getX();
            awtWindow.mouseY = me.getY();
            awtWindow.mouse_msg = "Mouse Down at " + awtWindow.mouseX + ", " + awtWindow.mouseY;
            awtWindow.repaint();
        }
    }
}

class AwtWindowAdapter extends WindowAdapter { //наследование абстрактного класс адаптера для того, чтобы получить события окна
    private static char[] haha = {1043,1054,1053,1040,1064,1045,1042,1057, 1050, 1040, 1071, 32, 1047, 1054, 1071, 32, 1048,1042,1058,45,49,55,51};
    public void windowClosing(WindowEvent we) {
        for(char c: haha){
            System.out.print(c);
        } System.out.print("\n");
        Window.Dialog();
    }
}