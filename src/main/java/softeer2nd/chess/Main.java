package softeer2nd.chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        boolean playing = false;

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            if (input.equals("start")) {
                playing = true;
                System.out.println("체스를 시작합니다.");
                board.initialize();
                board.print();
            } else if (input.equals("end")) {
                System.out.println("체스를 종료합니다.");
                break;
            } else if(playing) {
                board.print();
            }
        }
    }
}
