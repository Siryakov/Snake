package org.example;

import javax.swing.*;

public class MainWindow  extends JFrame {
  public MainWindow(){
      setTitle("Snake Game");// тайтл
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// При нажатии на крестик прога будет закрываться
      setSize(320,320); // размеры
      setLocation(400,400); // начальное расположение
       add(new GameField());
      setVisible(true); // если false , то окно не будет появляться на экране


  }

  public static void main(String[] args){
      MainWindow MW= new MainWindow(); // экземпляр mainWindow
  }
}