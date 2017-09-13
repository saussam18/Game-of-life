package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Cell c = new Cell (0);
          Grid g = new Grid(c);
          g.fill();
          g.changeCell(3,2);
          /*while(){
              g.printGrid();
          }*/
        for(int i = 0; i <= 2; i++){
            g.printGrid();
        }


    }

}
