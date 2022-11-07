package cwiki07_10_2022_graWZycie;

import java.util.Random;

public class graWZycie {
    private int width,height;
    private int[][] board;
        graWZycie(int width, int height){
            this.width=width;
            this.height=height;
            board = new int[width][height];
            fillBoard();
        }


    private void fillBoard(){
            int randomizedValue;
        Random random = new Random();
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                randomizedValue=random.nextInt(7);
                if(randomizedValue==0){
                    board[j][i]=1;
                }
                else{
                    board[j][i]=0;
                }
            }
        }
    }
    public void printBoard(){
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(board[i][j]==1){
                    System.out.print("⚪");
                }
                else {System.out.print("⚫");}
            }
            System.out.println();
        }
        System.out.println();
    }
    public void makeXSteps(int x){
        for(int i=0;i<x;i++){
            makeOneStep();
            printBoard();
            System.out.println();
        }
    }
    private void makeOneStep(){
        int[][] newBoard = new int[width][height];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                int neighbours = countNeighbours(i,j);
                if(board[i][j]==1){
                    if(neighbours>=2){
                        newBoard[i][j]=1;
                    }
                    else{
                        newBoard[i][j]=0;
                    }
                }
                else {
                    if(neighbours>=3){
                        newBoard[i][j]=1;
                    }
                    else {newBoard[i][j]=0;}
                }
            }
        }
        board=newBoard;
    }
    private int countNeighbours(int w, int k){
        int neighbours=0;
        if(w==0){
            if(k==0){
                neighbours=board[w][k+1]+board[w+1][k]+board[w+1][k+1];
            }
            else if(k==width-1){
                neighbours=board[w][k-1]+board[w+1][k]+board[w+1][k-1];
            }
            else {
                neighbours=board[w][k-1]+board[w][k+1]+board[w+1][k-1]+board[w+1][k]+board[w+1][k+1];
            }
        }
        else if(w==height-1){
            if(k==0){
                neighbours=board[w][k+1]+board[w-1][k]+board[w-1][k+1];
            }
            else if(k==width-1){
                neighbours=board[w][k-1]+board[w-1][k]+board[w-1][k-1];
            }
            else {
                neighbours=board[w][k-1]+board[w][k+1]+board[w-1][k-1]+board[w-1][k]+board[w-1][k+1];
            }
        }
        else {
            if(k==0){
                neighbours=board[w-1][k]+board[w-1][k+1]+board[w][k+1]+board[w+1][k]+board[w+1][k+1];
            }
            else if(k==width-1){
                neighbours=board[w-1][k]+board[w-1][k-1]+board[w][k-1]+board[w+1][k]+board[w+1][k-1];
            }
            else {
                neighbours=board[w-1][k-1]+board[w-1][k]+board[w-1][k+1]+board[w][k-1]+board[w][k+1]+board[w+1][k-1]+board[w+1][k]+board[w+1][k+1];
            }

        }
        return neighbours;
    }
}
