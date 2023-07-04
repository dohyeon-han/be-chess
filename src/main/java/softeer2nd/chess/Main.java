package softeer2nd.chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.initialize();
        boolean playing = false;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            if (input.equals("start")) {
                playing = true;
                board.print();
            } else if (input.equals("end")) {
                break;
            } else if(playing) {
                board.print();
            }
        }
    }
}
