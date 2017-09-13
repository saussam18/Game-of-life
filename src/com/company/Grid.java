package com.company;

import java.util.Arrays;

public class Grid{

   private Cell [][] cells = new Cell[5][5] ;
   private Cell main;
   private int [][] living = new int [5][5];
   public Grid (Cell c){
        main = c;
    }

   public void changeCell (int x, int y) {
        Cell c;
       c = cells [x][y];
       if (c.getPop()== 0){
           c.setPop(1);
           cells [x][y] = c;
           changeInArr(x, y);
       }else if (c.getPop() == 1){
           c.setPop(0);
           cells [x][y] = c;
           changeInArr(x, y);
       }
       give(x, y);
    }
    private void changeInArr(int x, int y){
        cells [x][y] = main ;
        living [x][y] = main.getPop();
    }

    private void allChanges(){
        for(int i = 0; i < cells.length; i++){
           for(int j = 0; j <cells.length; j++){
               if(cells[i][j].getPop() == 0){
                   checkEmpty(i, j);
               }else if (cells[i][j].getPop() == 1){
                   checkFill(i, j);
               }
           }
        }
    }
    private boolean checkEmpty(int x, int y){

    }
    private boolean checkFill(int x, int y){
        int neighbors = checkAll(x, y);
    }
    private int checkAll(int x, int y){
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
    private int checkTop(int x, int y){
        int tell = 0;
        if (x == 0){
            x = 5;
        }
        cells [x - 1][y] = main;
        tell = main.getPop();
        return tell;
    }
    private int checkBot(int x, int y){
        int tell = 0;
        if (x == 4){
            x = -1;
        }
        cells [x + 1][y] = main;
        tell = main.getPop();
        return tell;
    }
    private int checkLeft(int x, int y){
        int tell = 0;
        if (y == 0){
            y = 5;
        }
        cells [x][y - 1] = main;
        tell = main.getPop();
        return tell;
    }
    private int checkRight(int x, int y){
        int tell = 0;
        if (y == 4){
            y = -1;
        }
        cells [x][y + 1] = main;
        tell = main.getPop();
        return tell;
    }
    private int checkRightLowDia(int x, int y){
        int tell = 0;
        if (y == 4){
            y = -1;
        }
        if (x == 4){
            x = -1;
        }
        cells [x + 1][y + 1] = main;
        tell = main.getPop();
        return tell;
    }
    private int checkRightTopDia(int x, int y){
        int tell = 0;
        if (y == 4){
            y = -1;
        }
        if (x == 0){
            x = 5;
        }
        cells [x - 1][y + 1] = main;
        tell = main.getPop();
        return tell;
    }
    private int checkLeftLowDia(int x, int y){
        int tell = 0;
        if (y == 0){
            y = 5;
        }
        if (x == 4){
            x = -1;
        }
        cells [x + 1][y - 1] = main;
        tell = main.getPop();
        return tell;
    }
    private int checkLeftTopDia(int x, int y){
        int tell = 0;
        if (y == 0){
            y = 5;
        }
        if (x == 0){
            x = 5;
        }
        cells [x - 1][y - 1] = main;
        tell = main.getPop();
        return tell;
    }



    public void give(int x, int y){
        int c = living[x][y];
        System.out.println(c);
    }

    public void printGrid() {
        System.out.println(Arrays.deepToString(this.living));
    }
    public void fill (){
        for(int i = 0 ; i < cells.length ; i++){
            for(int j = 0 ; j < cells.length ; j++){
                cells[i][j] = main;
                main.setPop(0);
                living[i][j] = main.getPop();
            }

        }
    }


}
