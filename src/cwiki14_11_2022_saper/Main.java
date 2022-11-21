package cwiki14_11_2022_saper;

public class Main {
    public static void main(String[] args) {
        Board saper1 = new Board(8, 8);
        saper1.fillBoard(15);
        saper1.odkryjPlansze();
        saper1.printBoard();
        //saper1.graj(2);
    }
}