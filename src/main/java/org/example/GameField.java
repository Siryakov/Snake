package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameField extends JPanel implements ActionListener { // панель в которой будет происходить основные действия игры

    private final int SIZE =320;//размер поля
    private final int Dot_SIZE =16; // 1 клетка поля в пикселях
    private final int ALL_DOTS = 400; // максимальное кол клеток на поле
    private Image dot;
    private Image apple;
    private int appleX; // Координаты яблока
    private int appleY;

    private int[] x = new int [ALL_DOTS];
    private int[] y = new int [ALL_DOTS];
    private int dots; // размер змейки
    private Timer timer; // таймер
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;
    public GameField(){ // конструктор
        setBackground(Color.cyan);
        loadImages();
        initGame();
    }
    public void initGame(){
        dots =3;
        for (int i = 0 ; i< dots; i++)
        {
            x[i]=48-i*Dot_SIZE; // начальная позиция змейки Кратная 16!!!!!
            y[i]=48;
        }
        timer = new Timer(250,  this); // 250 - время перемещения из 1 клетки в другую
        timer.start();
        createApple();
    }

    public void createApple(){
        appleX= new Random().nextInt(20)*Dot_SIZE;
        appleY = new Random().nextInt(20)*Dot_SIZE;
    }
    public void loadImages(){
        ImageIcon iia = new ImageIcon("D:/code/Java/Snake/images/icons8-яблоко-16.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("D:/code/Java/Snake/images/icons8-яблоко-16.png");
        dot = iid.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(inGame){
            g.drawImage(apple,appleX,appleY,this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot,x[i],y[i],this);
            }
        }
    }

    public void move(){
        for (int i = dots; i > 0 ; i--) {
            x[i]=x[i-1];//сдвиг позиции
            y[i]=y[i-1];//сдвиг позиции
        }
        if(left){
            x[0]-=Dot_SIZE;
        }
        if(right){
            x[0]+=Dot_SIZE;
        }
        if(up){
            x[0]-=Dot_SIZE;
        }
        if(down){
            x[0]+=Dot_SIZE;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            move();
        }
        repaint();
    }
}
