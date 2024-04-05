package game;
import player.player1;
import board.Board;
import java.util.*;

public class Game {
    player1[] players;
    Board board;
    int turn;
    int noofmoves;
    boolean gameover;
    String zero;
    String cross;

    public Game(player1[] players, Board board){
        this.players=players;
        this.board = board;
        this.turn = 0;
        this.noofmoves = 0;
        this.gameover = false;

        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for (int i=0; i<board.size;i++){
            z.append('O');
            c.append('X');
        }

        this.zero = z.toString();
        this.cross = c.toString();
    }

    public void printBoardConfig(){
        int sz = this.board.size;
        for (int i=0; i<sz; i++){
            for (int j=0; j<sz; j++){
                System.out.print(board.matrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    public void play(){
        printBoardConfig();
        int sz = board.size;
        while (!gameover){
            noofmoves++;
            int idx = getIndex();
            int row = idx/sz;
            int col = idx%sz;
            board.matrix[row][col]=players[turn].getPlayerSymbol();
            if (noofmoves>=sz*sz){
                System.out.println("Game Draw");
                return;
            }

            if  (noofmoves >= (2 * sz) - 1 && checkCombination()==true) {
                gameover = true;
                printBoardConfig();
                System.out.println("Winner is: "+ players[turn].getPlayerName());
                return;
            }

            turn = (turn+1)%2;
            printBoardConfig();
        }
    }


    public int getIndex() {
        while(true) {
            // Player Aman give one position
            System.out.println("Player: " + players[turn].getPlayerName() + " give one position");
            Scanner scn = new Scanner(System.in);
            int pos = scn.nextInt()-1;

            int sz = board.size;

            int row = pos/sz;
            int col = pos%sz;

            // Checking for invalid position
            if (row <0 || row >= sz || col < 0 || col >= sz) {
                System.out.println("Invalid position");
                continue;
            }

            // Checking for vaccant position
            if (board.matrix[row][col] != '-') {
                System.out.println("Position already occupied");
                continue;
            }
            return pos;
        }
    }


    public boolean checkCombination(){
        int sz = board.size;

        //Rowwise
        for (int i=0; i<sz; i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<sz; j++){
                sb.append(board.matrix[i][j]);
            }
            String pattern = sb.toString();
            if (pattern.equals(cross) || pattern.equals(zero)){
                return true;
            }
        }

        //Columnwise
        for (int j=0; j<sz; j++){
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<sz; i++){
                sb.append(board.matrix[i][j]);
            }
            String pattern = sb.toString();
            if (pattern.equals(cross) || pattern.equals(zero)){
                return true;
            }
        }

        //Diagonalwise
        int i=0;
        int j=0;
        StringBuilder sb = new StringBuilder();
        while (i<sz){
            sb.append(board.matrix[i][j]);
            i++;
            j++;
        }

        String pattern = sb.toString();
        if (pattern.equals(cross) || pattern.equals(zero)){
            return true;
        }

        //AntiDiagonal
        sb = new StringBuilder();
        i=0;
        j=board.size-1;
        while (i<sz && j>=0){
            sb.append(board.matrix[i][j]);
            i++;
            j--;
        }
        pattern = sb.toString();
        if (pattern.equals(cross) || pattern.equals(zero)){
            return true;
        }
        return false;
    }
}

