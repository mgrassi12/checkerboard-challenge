package com.checkerboardchallenge;

public class Checkerboard {

    public static void main(String[] args) {
        //TODO: handle if args is empty.
        //TODO: handle if negative or zero.
        //TODO: handle if too many or not enough args have been input.
        //TODO: readme explaining what this is and how to run (i.e.
        // navigate to out\production\CheckerboardChallenge and then type
        // java com.checkerboardchallenge.Checkerboard 1 4). Also, list Java ver etc.
        int squareSize = -1;
        int boardSize = -1;

        //Prints the arg strings.
        System.out.println("First argument: " + args[0]);
        System.out.println("Second argument: " + args[1]);
        System.out.println();

        //Checks if the strings from args can be turned into integers.
        try {
            squareSize = Integer.parseInt(args[0], 10);
            boardSize = Integer.parseInt(args[1], 10);
        } catch (NumberFormatException e) {
            System.out.println("Invalid arguments supplied. Please try again with numbers.");
        }

        //Prints the checkered board.
        if (squareSize != -1 && boardSize != -1) {
            printDivider(squareSize, boardSize);
            for (int i = 1; i <= boardSize; i++) {
                printCheckerRow(squareSize, boardSize, i);
                printDivider(squareSize, boardSize);
            }
        }
    }

    private static void printDivider(int squareSize, int boardSize) {
        System.out.print("+");
        for (int j = 1; j <= boardSize; j++) {
            for (int i = 1; i <= squareSize; i++) {
                System.out.print("-");
                if (i == squareSize) {
                    System.out.print("+");
                }
            }
        }
        System.out.println();
    }

    private static void printCheckerRow(int squareSize, int boardSize, int rowCounter) {
        for (int j = 1; j <= squareSize; j++) {
            System.out.print("|");
            for (int i = 1; i <= boardSize; i++) {
                printCheckerLine(squareSize, i, rowCounter);
            }
            System.out.println();
        }
    }

    private static void printCheckerLine(int squareSize, int checkerCounter, int rowCounter) {
        String checkerShade = getCheckerShade(checkerCounter, rowCounter);

        for (int i = 1; i <= squareSize; i++) {
            System.out.print(checkerShade);
            if (i == squareSize) {
                System.out.print("|");
            }
        }
    }

    private static String getCheckerShade(int checkerCounter, int rowCounter) {
        String checkerShade;

        //The low bit will be set if counter is odd.
        //If the checker counter is an odd number, shade the checker.
        //If the row counter is an odd number, invert this logic.
        if ((checkerCounter & 1) == 0) {
            if ((rowCounter & 1) == 0) {
                checkerShade = "#";
            } else {
                checkerShade = " ";
            }
        } else {
            if ((rowCounter & 1) == 0) {
                checkerShade = " ";
            } else {
                checkerShade = "#";
            }
        }

        return checkerShade;
    }

}