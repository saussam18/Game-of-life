package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Cell c = new Cell (0);
          Grid g = new Grid(c);
          g.fill();
        for(int i = 0; i <= 4; i++){
            g.printGrid();
        }


    }

}
