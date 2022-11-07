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
        for(int j=0;j<height;j++){
            for(int i=0;i<width;i++){
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
        for(int j=0;j<height;j++){
            for(int i=0;i<width;i++){
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
    private int countNeighbours(int w,int k) {
        int neighbours = 0;
        for(int i = w-1; i < w+2; i++) {
            for(int j = k-1; j < k+2; j++) {
                if(i < 0 || i > width-1 || j < 0 || j > height-1) { }
                else if(i == w && j == k){ }
                else if(board[i][j] == 1) {
                    neighbours++;
                }
            }
        }
        return neighbours;
    }
}
