package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int x;
    static  int y;
    static int message;
    static char addChar;
    static char winChar;
    char[][] arr = new char[3][3];
    public static void main(String[] args) {
        System.out.print("Enter the cells: ");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        char[][] arr = new char[3][3];
        for (int i = 0; i< arr.length; i++){
            for (int j=0; j<arr.length; j++){
                arr[i][j] = line.charAt(i * 3  + j );
                if(arr[i][j]=='_'){
                    arr[i][j] = ' ';
                }
            }
        }


        printarr(arr);

        game(arr);


    }

    static void game(char[][] arr){
        imputxy(arr);
        printarr(add(arr, x, y));
        statesGame(arr);
    }

    static void statesGame(char[][] arr){
        //int message;
        boolean restart = false;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == ' '){
                    restart = true;
                }
            }
        }
        if (!restart) {
            message = 2;
        } else {
            message = 3;
        }
        if ( ((arr[0][0])==(arr[0][1])) && ((arr[0][2])==(arr[0][1]))&&(arr[0][0]!=' ') ){
            message = 1;
            winChar = arr[0][0];
        } else if (((arr[1][0])==(arr[1][1])) && ((arr[1][2])==(arr[1][1]))&&(arr[1][0]!=' ')){
            message = 1;
            winChar = arr[1][0];
        } else if(((arr[2][0])==(arr[2][1])) && ((arr[2][2])==(arr[2][1]))&&(arr[2][0]!=' ')){
            message = 1;
            winChar = arr[2][0];
        } else if (((arr[0][0])==(arr[1][0])) && ((arr[1][0])==(arr[2][0]))&&(arr[0][0]!=' ')){
            message = 1;
            winChar = arr[0][0];
        } else if (((arr[0][1])==(arr[1][1])) && ((arr[2][1])==(arr[1][1]))&&(arr[0][1]!=' ')){
            message = 1;
            winChar = arr[0][1];
        } else if (((arr[0][2])==(arr[1][2])) && ((arr[2][2])==(arr[1][2]))&&(arr[0][2]!=' ')){
            message = 1;
            winChar = arr[0][2];
        } else if (((arr[0][0])==(arr[1][1])) && ((arr[2][2])==(arr[1][1]))&&(arr[0][0]!=' ')){
            message = 1;
            winChar = arr[0][0];
        } else if (((arr[0][2])==(arr[1][1])) && ((arr[0][2])==(arr[2][0]))&&(arr[0][2]!=' ')){
            message = 1;
            winChar = arr[0][2];
        }
        switch (message){
            case 1:
                if (winChar == 'X'){
                    System.out.println( "X wins");
                } else {
                    System.out.println( "O wins");
                }

                break;
            case 2:
                System.out.println("Draw");
                break;
            case 3:
                System.out.println("Game not finished");
                game(arr);
                break;
        }


    }


    static char[][] add(char[][] arr, int x, int y){
        int countX = 0;
        int countO = 0;
        for (char[] chars : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (chars[j] == 'X') {
                    countX++;
                } else if (chars[j] == 'O') {
                    countO++;
                }
            }
        }
        if((countX == countO)||(countX < countO)){
            addChar= 'X';
        } else {
            addChar = 'O';
        }
        arr[x - 1][y - 1] = addChar;
        return arr;
    }

    static void printarr(char[][] arr){
        for (int i = 0; i< arr.length; i++) {
            if(i==0){
                System.out.println("---------");
            }
            System.out.print("|");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println(" |");
            if(i==2){
                System.out.println("---------");
            }
        }
    }


    static void imputxy(char[][] arr){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter the coordinates: ");
             x = sc.nextInt();
             y = sc.nextInt();
             if(!((x>=1)&&(x<=3)&&(y>=1)&&(y<=3))){
                 System.out.println("Coordinates should be from 1 to 3!");
                 imputxy(arr);
             }
             if(arr[x - 1][y - 1] != ' '){
                 System.out.println("This cell is occupied! Choose another one!");
                 imputxy(arr);
             }

        } catch (InputMismatchException e){
            System.out.println("You should enter numbers!");
            imputxy(arr);
        }
    }
}
