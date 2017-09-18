package com.company;

import java.util.Arrays;
import java.util.Random;

public class Grid{

   private Cell [][] cells = new Cell[5][5];
   private Cell main;
   private int [][] living = new int [5][5];
   public Grid (Cell c){
        main = c;
    }

    public void fill (){ //fills randomly after initializing
        Random ran = new Random();
        for(int i = 0 ; i < cells.length ; i++){
            for(int j = 0 ; j < cells.length ; j++){
                cells[i][j] = new Cell (0);
                int n = ran.nextInt(2);
                if (n == 0){
                    main.setPop(0);
                } else if (n == 1){
                    main.setPop(1);
                }
                cells [i][j].setPop(main.getPop());
                living[i][j] = main.getPop();
            }
        }
    }
    public void printGrid() {
        for (int i = 0; i < living.length; i++){
            System.out.println(Arrays.toString(living[i]));
        }
        System.out.println("*******");
        allChanges();
    }
    private void changeInArr(int x, int y){//changes object array to match print array
        living [x][y] = cells[x][y].getPop();
    }
    private void allChanges(){// Does all the changes as the game continues
        for(int i = 0; i < cells.length; i++){
           for(int j = 0; j <cells[i].length; j++){
               if(cells[i][j].getPop() == 0){
                   checkEmpty(i, j);
               }else if (cells[i][j].getPop() == 1){
                   checkFill(i, j);
               }
           }
        }
    }
    private void checkEmpty(int x, int y){
        int n = checkAll(x, y);
        if (n == 3){
        cells[x][y].changeCell();
        changeInArr(x, y);
        }
    }
    private void checkFill(int x, int y){
        int n = checkAll(x, y);
        if (n <= 1){
            cells[x][y].changeCell();
            changeInArr(x, y);
        } else if (n >= 4 ){
            cells[x][y].changeCell();
            changeInArr(x, y);
        }

    }
    private int checkAll(int x, int y){//counts up all the neighbors
        int count = 0;
        if (checkTop(x, y) == 1){
            count++;
        }
        if (checkBot(x, y) == 1){
            count++;
        }
        if (checkLeft(x, y) == 1){
            count++;
        }
        if (checkRight(x, y) == 1){
            count++;
        }
        if (checkLeftLowDia(x, y) == 1){
            count++;
        }
        if (checkLeftTopDia(x, y) == 1){
            count++;
        }
        if (checkRightLowDia(x, y) == 1){
            count++;
        }
        if (checkRightTopDia(x, y) == 1){
            count++;
        }
        return count;
    }
    private int checkTop(int x, int y){//used ints again to make easier for me, boolean can be used also
        int tell = 0;
        if (x == 0){//For all, counts neighbors across boundries so it can move across
            x = cells.length;
        }
        tell = cells [x - 1][y].getPop();
        return tell;
    }
    private int checkBot(int x, int y){
        int tell = 0;
        if (x == cells.length-1){
            x = -1;
        }
        tell = cells [x + 1][y].getPop();
        return tell;
    }
    private int checkLeft(int x, int y){
        int tell = 0;
        if (y == 0){
            y = cells.length;
        }
        tell = cells [x][y - 1].getPop();
        return tell;
    }
    private int checkRight(int x, int y){
        int tell = 0;
        if (y == cells.length - 1){
            y = -1;
        }
        tell = cells [x][y + 1].getPop();
        return tell;
    }
    private int checkRightLowDia(int x, int y){
        int tell = 0;
        if (y == cells.length-1){
            y = -1;
        }
        if (x == cells.length-1){
            x = -1;
        }
        tell = cells [x + 1][y + 1].getPop();
        return tell;
    }
    private int checkRightTopDia(int x, int y){
        int tell = 0;
        if (y == cells.length-1){
            y = -1;
        }
        if (x == 0){
            x = cells.length;
        }
        tell = cells [x - 1][y + 1].getPop();
        return tell;
    }
    private int checkLeftLowDia(int x, int y){
        int tell = 0;
        if (y == 0){
            y = cells.length;
        }
        if (x == cells.length -1){
            x = -1;
        }
        tell = cells [x + 1][y - 1].getPop();
        return tell;
    }
    private int checkLeftTopDia(int x, int y){
        int tell = 0;
        if (y == 0){
            y = cells.length;
        }
        if (x == 0){
            x = cells.length;
        }
        tell = cells [x - 1][y - 1].getPop();
        return tell;
    }


}
