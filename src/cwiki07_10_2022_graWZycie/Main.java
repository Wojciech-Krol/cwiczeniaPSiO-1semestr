package cwiki07_10_2022_graWZycie;

public class Main {
    public static void main(String[] args){
        graWZycie gra = new graWZycie(15,15);
        gra.printBoard();
        gra.makeXSteps(5);
        gra.printBoard();
    }

}
