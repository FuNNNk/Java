import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Token> board =  new ArrayList<>();
    int numberOfTokens;

    public Board(int n,int m){
        this.numberOfTokens = n;
        board.add(new Token(m));
        for(int i = 1; i<n;i++){
            boolean ok = true;
            Token token = new Token(m);
            if(!token.isBlank()){
                token.numberOfToken = 0;
            }
            for(int j=0;j<board.size();j++) {
                if (token == board.get(j)){
                    ok = false;
                    break;
                }
            }
            if(ok)
                board.add(token);
            else i--;
        }
    }

    public synchronized int  extractToken(int contor){
        int tokenextracted = board.get(contor).numberOfToken;
        return tokenextracted;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + board +
                ", numberOfTokens=" + numberOfTokens +
                '}';
    }
}
