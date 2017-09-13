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

    }
    private int checkTop(){

    }
    private int checkBot(){

    }
    private int checkLeft(){

    }
    private int checkRight(){

    }
    private int checkRightLowDia(){

    }
    private int checkRightTopDia(){

    }
    private int checkLeftLowDia(){

    }
    private int checkLeftTopDia(){

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
