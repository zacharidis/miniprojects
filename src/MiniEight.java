import java.util.Scanner;

/**
 * εξομοιωση παιχνιδιου τριλιζας 2 ατομων - παικτων
 * @author zacharidis
 *
 */

public class MiniEight {

    public static char[][] tttArray = new char[3][3]; // κανω public τον πινακα για να το βλεπουν ολες οι μεθοδοι
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String playerOneName = " ";
        String playerTwoName = " ";
        double  coinflip = 0.0 ; // ποιος θα παιξει πρωτος
        int xPos = 0 ;
        int yPos = 0;
        int lastPlayerPlayed = 0 ; // παιρνει τιμες 0 ή 1 αναλογα με το ποιος επαιξε τελευταιος

        //αλληλεπιδραση με χρηστες αρχικα

        System.out.println("Παρακαλω δωστε το ονομα του παιχτη νουμερο 1 : ");
        playerOneName = in.next();
        System.out.println("Hello : " + playerOneName);
        System.out.println("Παρακαλω δωστε το ονομα του παιχτη νουμερο 2 : ");
        playerTwoName = in.next();
        System.out.println("Hello : " + playerTwoName);
        System.out.println("*************************************************");
        System.out.println("Τωρα θα ριξουμε κορωνα γραμματα ποιος παικτης θα παιξει πρωτος");
        System.out.println("Κορωνα παιζει ο  " + playerOneName + " και γραμματα παιζει ο " + playerTwoName);

        coinflip = Math.random();

        System.out.println(coinflip);
        if (coinflip >= 0.5 ) {
            System.out.println("Κορώνα!");
            System.out.println("Ο χρηστης : " + playerOneName + " παιζει πρωτος με τον χαρακτηρα X ");
        } else  {
            System.out.println("Γραμματα!");
            System.out.println("Ο χρηστης : "+ playerTwoName + " παιζει πρωτος με τον χαρακτηρα X ");
        }


    }


}
