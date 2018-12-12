package com.checkerboardchallenge;

public class Checkerboard {

    public static void main(String[] args) {
        int squareSize = -1;
        int boardSize = -1;

        //Checks if the correct amount of args have been supplied.
        if (args.length != 2) {
            System.out.println("Incorrect amount of arguments have been input. Please provide this program with two integers (a square size and a board size).");
        } else {
            //Displays the user's input strings (from args).
            System.out.println("First argument: " + args[0]);
            System.out.println("Second argument: " + args[1]);
            System.out.println();

            //Checks if the strings from args can be turned into integers.
            try {
                squareSize = Integer.parseInt(args[0], 10);
                boardSize = Integer.parseInt(args[1], 10);
            } catch (NumberFormatException e) {
                System.out.println("The input arguments are not integers.");
            }

            //Prints the checkered board if square and board sizes are positive values.
            if (squareSize > 0 && boardSize > 0) {
                System.out.println("produces a " + boardSize + " x " + boardSize + " checkerboard with " + squareSize + " x " + squareSize + " squares:");
                System.out.println();
                printDivider(squareSize, boardSize);
                for (int i = 1; i <= boardSize; i++) {
                    printCheckerRow(squareSize, boardSize, i);
                    printDivider(squareSize, boardSize);
                }
            } else {
                System.out.println("Invalid arguments have been input. Please ensure you are entering positive integer values for square and board sizes.");
            }
        }

    }

    //Prints the divider between checkered rows (e.g. +---+---+---+).
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

    //Prints a full checkered row.
    private static void printCheckerRow(int squareSize, int boardSize, int rowCounter) {
        for (int j = 1; j <= squareSize; j++) {
            System.out.print("|");
            for (int i = 1; i <= boardSize; i++) {
                printCheckerLine(squareSize, i, rowCounter);
            }
            System.out.println();
        }
    }

    //Prints a single line from a checkered row (e.g. |###|   |###|   |###|)
    private static void printCheckerLine(int squareSize, int checkerCounter, int rowCounter) {
        String checkerShade = getCheckerShade(checkerCounter, rowCounter);

        for (int i = 1; i <= squareSize; i++) {
            System.out.print(checkerShade);
            if (i == squareSize) {
                System.out.print("|");
            }
        }
    }

    //Returns the shade that a square should be.
    private static String getCheckerShade(int checkerCounter, int rowCounter) {
        String checkerShade;

        //The low bit will be set if the checker counter is odd.
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