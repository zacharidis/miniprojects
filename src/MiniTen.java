package minip;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  MiniTen
 * @author zacharidis
 *
 * Simulation of a cinema ticket reserve system
 *
 */

public class MiniTen {

    private static final int NUMBER_OF_ROWS = 26;
    private static final int NUMBER_OF_COLS = 12;
    private static Boolean ticketBoard[][] = new Boolean[NUMBER_OF_ROWS][NUMBER_OF_COLS];
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        int seatNumber =  0 ;
        int rowInt = 0;
        char rowChar = ' ';
        boolean exitMenu = false;
        char menuInput = 'E';

        String systemResponse = "";

        initTicketBoard(); //initialize the array

        while (!exitMenu) {

            System.out.println("Welcome to ticket reserve");
            System.out.println("Insert R for reservation , C for cancelation and E for exit");
            System.out.println("Insert S to see seat availability");

            menuInput = sc.next().charAt(0);

            if (menuInput=='E' || menuInput == 'e'){
                exitMenu = true;
                System.out.println("Goodbye");

            } else if (menuInput=='R' || menuInput =='r'){


                System.out.println("Please enter the character of seat you want (A,B,C etc)");

                rowChar = sc.next().charAt(0); // using the charToIntMap function to map characters to int
                rowInt = charToIntMap(rowChar);


                System.out.println(rowInt);
                System.out.println("Please enter the seat number");
                seatNumber = sc.nextInt();
                System.out.println("Your choice is : " + rowChar + seatNumber);


                if (checkSeatState(rowInt,seatNumber,'R')==true){
                    reserveTicket(rowChar,seatNumber);
                    System.out.println("You have successfully reserved ticket : " + rowChar + seatNumber );
                } else  {
                    System.out.println("Seat not available , please choose another seat");

                }



            } else if (menuInput=='C'|| menuInput=='c') {

                System.out.println("Please enter the character of seat you want to cacnel (A,B,C etc)");

                rowChar = sc.next().charAt(0); // using the charToIntMap function to map characters to int
                rowInt = charToIntMap(rowChar);


                System.out.println(rowInt);
                System.out.println("Please enter the seat number");
                seatNumber = sc.nextInt();
                System.out.println("Your choice is : " + rowChar + seatNumber);


                if (checkSeatState(rowInt,seatNumber,'C')==true){
                    cancelReservation(rowChar,seatNumber);
                    System.out.println("You have successfully cancelled ticket : " + rowChar + seatNumber );
                } else  {
                    System.out.println("Seat was not reserved , you can reserve it");

                }



            } else if (menuInput=='S' || menuInput=='s'){
                printTicketBoard();

            } else {
                System.out.println("Invalid choice , try again");
            }

        }









    }

    /**
     *
     * @param x the number of row
     * @param y the number of col
     * @param state R for Reserveation and C for Cancellation
     * @return boolean state of the sea either being taken or already empty
     */
    public static Boolean checkSeatState(int x , int y , char state ){


          if (state == 'R') {
              if (ticketBoard[x][y]==true) {
                  return false ; // the seat is already taken

              } else return true ;

          } else
                 {
              if(ticketBoard[x][y]==true ){
                  return true ; // the seat was taken but now canceled

              } else  return  false ;
          }

    }


    public static void cancelReservation(char column , int row ){
        int  mappedInt = charToIntMap(column);
        ticketBoard[mappedInt][row]= true;
    }

    public static void reserveTicket(char column , int row){
         int  mappedInt = charToIntMap(column);
         ticketBoard[mappedInt ][row]= true;
    }



    public static void initTicketBoard() {
        for (int i = 0  ; i < ticketBoard.length ; i++)  {

            for (int j = 0 ; j < ticketBoard[i].length; j++) {
                ticketBoard[i][j] = false;
            }
        }

    }

    public static void printTicketBoard() {



        char[] alphabet = new char[26];
        for(char c = 'a'; c <= 'z'; ++c) {
            alphabet[c - 'a'] = c;
        }

        for (int i = 0; i < ticketBoard.length ; i++) {

            System.out.print(alphabet[i] + "  :  ");
            for (int j = 0; j < ticketBoard[i].length; j++) {

                if (ticketBoard[i][j]) {
                    System.out.print( (j ) + " reserved" + " ");
                } else {
                    System.out.print( (j ) +" empty" + " ");

                }
            }
            System.out.println();

        }

    }

    public static int charToIntMap(char seatRow){

        int seatNumber = 0;

        switch (seatRow) {
            case  'A' : seatNumber = 0; break;
            case  'B' : seatNumber = 1; break;
            case  'C' : seatNumber = 2; break;
            case  'D' : seatNumber = 3; break;
            case  'E' : seatNumber = 4; break;
            case  'F' : seatNumber = 5; break;
            case  'G' : seatNumber = 6; break;
            case  'H' : seatNumber = 7; break;
            case  'I' : seatNumber = 8; break;
            case  'J' : seatNumber = 9; break;
            case  'K' : seatNumber = 10; break;
            case  'L' : seatNumber = 11; break;
            case  'M' : seatNumber = 12; break;
            case  'N' : seatNumber = 13; break;
            case  'O' : seatNumber = 14; break;
            case  'P' : seatNumber = 15; break;
            case  'Q' : seatNumber = 16; break;
            case  'R' : seatNumber = 17; break;
            case  'S' : seatNumber = 18; break;
            case  'T' : seatNumber = 19; break;
            case  'U' : seatNumber = 20; break;
            case  'V' : seatNumber = 21; break;
            case  'W' : seatNumber = 22; break;
            case  'X' : seatNumber = 23; break;
            case  'Y' : seatNumber = 24; break;
            case  'Z' : seatNumber = 25; break;



        }
        return seatNumber;



    }




}
