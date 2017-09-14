package com.company;

import java.util.Arrays;

public class Grid{

   private Cell [][] cells = new Cell[5][5] ;
   private Cell main;
   private int [][] living = new int [5][5];
   public Grid (Cell c){
        main = c;
    }


    public void printGrid() {
        System.out.println(Arrays.deepToString(this.living));
        allChanges();
    }
    private void changeInArr(int x, int y){
       Cell c =  cells [x][y];
        living [x][y] = c.getPop();
    }
    public void change (int x, int y) {
        cells[x][y].give();
        cells[x][y].changeCell();
        changeInArr(x, y);
        cells[x][y] = main;

    }

    private void allChanges(){
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
        cells[x][y].setPop(1);
        }else{
            cells[x][y].setPop(0);
        }
        changeInArr(x, y);
    }
    private void checkFill(int x, int y){
        int n = checkAll(x, y);
        if (n <= 1){
            cells[x][y].setPop(0);
        } else if (n == 2 || n == 3){
           Cell c = cells[x][y];
            cells[x][y].setPop(c.getPop());
        } else{
            cells[x][y].setPop(0);
        }
        changeInArr(x, y);
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



    public void fill (){
        for(int i = 0 ; i < cells.length ; i++){
            for(int j = 0 ; j < cells.length ; j++){
                main.setPop(0);
                cells[i][j] = main;
                living[i][j] = main.getPop();
            }

        }
    }


}
