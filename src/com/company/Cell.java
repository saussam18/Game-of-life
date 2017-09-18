package com.company;

public class Cell {

    private int pop = 0;


    public Cell(int pop){
        this.pop = pop;
    }//used int because it makes more sense to me, suppose to be boolean i know


    public void setPop(int pop) {
    this.pop = pop;
    }
    public int getPop(){
        return this.pop;
    }
    public void give(){ //Was just used to check if it was right or not
        System.out.println(pop);
    }
    public void changeCell(){
        if (pop == 0){
            pop = 1;
        }else if (pop == 1){
            pop = 0;
        }
    }



}
