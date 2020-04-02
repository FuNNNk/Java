public class Player implements Runnable {
    String name;
    Board board;

    public Player(String name, Board board){
        this.name=name;
        this.board = board;
    }

    @Override
    public void run() {
        System.out.println(board.toString());
        int number,contor=0;
        while(board.board.size()!=contor)
        {
            number = board.extractToken(contor);
            System.out.println(number);
            contor++;
        }
    }
}
