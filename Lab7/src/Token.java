import java.util.Random;

public class Token {
    int size;
    int numberOfToken;

    public Token(int m){
        this.size = m;
        this.numberOfToken = setNumberOfToken();
    }

    public int setNumberOfToken() {
        return (new Random().nextInt(this.size))+1;
    }

    public boolean isBlank(){
        if(numberOfToken!=0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Token{" +
                "size=" + size +
                ", numberOfToken=" + numberOfToken +
                '}';
    }
}
