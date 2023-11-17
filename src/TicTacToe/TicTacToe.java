package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    static String[] cell = {"-", "-", "-", "-", "-", "-", "-", "-", "-"};
    static String currentPlayer = "X";
    static String winner = null;
    static boolean gameRunning = true;

    public static void main(String[] args) {
        while (gameRunning) {
            printCell();
            playerInput();
            checkIfWin();
            checkIfTie();
            switchPlayer();
        }
    }

    static void printCell() {
        System.out.println(cell[0] + " | " + cell[1] + " | " + cell[2]);
        System.out.println("---------");
        System.out.println(cell[3] + " | " + cell[4] + " | " + cell[5]);
        System.out.println("---------");
        System.out.println(cell[6] + " | " + cell[7] + " | " + cell[8]);
    }

    static void playerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a spot 1-9: ");
        int inp = scanner.nextInt();
        if (cell[inp - 1].equals("-")) {
            cell[inp - 1] = currentPlayer;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
        }
    }

    static boolean checkHorizontle() {
        if (cell[0].equals(cell[1]) && cell[1].equals(cell[2]) && !cell[0].equals("-")) {
            winner = cell[0];
            return true;
        } else if (cell[3].equals(cell[4]) && cell[4].equals(cell[5]) && !cell[3].equals("-")) {
            winner = cell[3];
            return true;
        } else return cell[6].equals(cell[7]) && cell[7].equals(cell[8]) && !cell[6].equals("-");
    }

    static boolean checkRow() {
        if (cell[0].equals(cell[3]) && cell[3].equals(cell[6]) && !cell[0].equals("-")) {
            winner = cell[0];
            return true;
        } else if (cell[1].equals(cell[4]) && cell[4].equals(cell[7]) && !cell[1].equals("-")) {
            winner = cell[1];
            return true;
        } else return cell[2].equals(cell[5]) && cell[5].equals(cell[8]) && !cell[2].equals("-");
    }

    static boolean checkDiag() {
        if (cell[0].equals(cell[4]) && cell[4].equals(cell[8]) && !cell[0].equals("-")) {
            winner = cell[0];
            return true;
        } else return cell[2].equals(cell[4]) && cell[4].equals(cell[6]) && !cell[4].equals("-");
    }

    static void checkIfWin() {
        if (checkHorizontle() || checkRow() || checkDiag()) {
            printCell();
            System.out.println("The winner is " + winner + "!");
            gameRunning = false;
        }
    }

    static void checkIfTie() {
        if (!gameRunning) return;
        for (String value : cell) {
            if (value.equals("-")) return;
        }
        printCell();
        System.out.println("Draw!");
        gameRunning = false;
    }

    static void switchPlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }
}
