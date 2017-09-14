package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Cell c = new Cell (0);
          Grid g = new Grid(c);
          g.fill();
       //   g.change(2,2);
        //     g.change(1,2);
        //    g.change(1, 4);
          /*while(){
              g.printGrid();
          }*/
        for(int i = 0; i <= 2; i++){
            g.printGrid();
        }


    }

}
