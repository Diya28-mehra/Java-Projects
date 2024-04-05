import board.Board;
import player.player1;
import game.Game;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("First Project -> Tic Tac Toe");

        Board b = new Board(3, '-');
      
        player1 p1 = new player1();
        p1.setplayernameandsymbol("Ravi", 'X');
        p1.getPlayerNameAndSymbol();
  
        player1 p2 = new player1();
        p2.setplayernameandsymbol("Akash", 'O');
        p2.getPlayerNameAndSymbol();
  
        Game game  = new Game(new player1[] {p1, p2}, b);
        game.play();
  
    }
}

