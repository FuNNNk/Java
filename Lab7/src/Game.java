public class Game {
    public static void main(String[] args) {
        Board board = new Board(10,20);
        Player player1 = new Player("Alex", board);
        Player player2 = new Player("Mircea", board);


        player1.run();
        player2.run();
    }
}
