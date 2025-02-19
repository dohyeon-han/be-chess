package softeer2nd.chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        View view = new View(board);

        boolean playing = false;

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.equals("start")) {
                playing = true;
                System.out.println("체스를 시작합니다.");
                game.initializeBoard();
                view.print();
            } else if (input.equals("end")) {
                System.out.println("체스를 종료합니다.");
                break;
            } else if (playing) {
                String[] tokens = input.split(" ");
                command(game, tokens);
                view.print();
            }
        }
    }

    private static void command(Game game, String[] tokens) {
        try {
            if (tokens.length == 3) {
                if (tokens[0].equals("move")) {
                    game.checkTurn(tokens[1]);
                    game.move(tokens[1], tokens[2]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
