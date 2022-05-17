import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 *  MiniProject One
 *  Συνδιασμοι αριθμων κατα εξαδες αλλα
 *  υπο προυποθεσεις
 *  καθε προυποθεση θα μπει σε μια μεθοδο που
 *  θα επιτρεπει η αποριπτει τον συνδυααμο.
 *
 *  @author zacharidis
 *
 *
 *
 */



public class MiniOne {



    public static void main(String[] args) throws FileNotFoundException {


    File inTxt = new File("input.txt");   // θα πρεπει να ειναι στο φακελο του προτζεκτ το αρχειο
    File outTxt = new File("output.txt");  // θα πρεπει να ειναι στο φακελο του προτζεκτ
    Scanner sc = new Scanner(inTxt);
    PrintStream printer = new PrintStream(outTxt);

    // non-io μεταβλητες
    // non-io vars
    int n = 6 ;
    int[] row = new int [6];
    ArrayList<Integer> inNumbers = new ArrayList<>();
    int counterTo49 =  0  ;
    int stopper ;

    // εντολες
    // γεμισμα του πινακα μεχρι να βρεθει το στοιχειο -1

        while (sc.hasNextInt() && counterTo49 <= 49 ) {
        inNumbers.add(sc.nextInt());

        stopper = inNumbers.get(counterTo49);

        if (stopper == -1  ){
            inNumbers.set(counterTo49,0); // αν βρεθει το -1 κανε το 0
            counterTo49 = 50;

        }

        counterTo49++;
    }
        sc.close();

    //  μετατροπη του ArrayList σε array
    Integer[] finalArray = inNumbers.toArray(new Integer[0]);
        Arrays.sort(finalArray);

    //  δημιουργια των εξαδων


        for (int i = 0; i <= finalArray.length - n; i++) {
        for (int j = i + 1; j <= finalArray.length - n + 1; j++) {
            for (int k = j + 1; k <= finalArray.length - n + 2; k++) {

                for (int m = k + 1; m <= finalArray.length -n +3; m++) {

                    for(int y = m +1 ; y <= finalArray.length -n +4; y++ ) {

                        for (int x = y +1; x < finalArray.length; x++ ) {

                            row[0] = finalArray[i];
                            row[1] = finalArray[j];
                            row[2] = finalArray[k];
                            row[3] = finalArray[m];
                            row[4] = finalArray[y];
                            row[5] = finalArray[x];

//                                    System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\n", finalArray[i], finalArray[j], finalArray[k], finalArray[m] ,finalArray[y],finalArray[x]);
                            // εδω θα καλουμε καθε μεθοδο με σκοπο να κανει το φιλτραρισμα



                            if ( (!isOdd(row)) && (!isCont(row)) &&(!isEven(row)) ){
                                System.out.println(row[0]+ " " + row[1] + " " +  row[2] + " " +  row[3] + " " + row[4] + " " + row[5]); // εμφανιση στην οθονη
                                printer.printf("%d\t%d\t%d\t%d\t%d\t%d\n", finalArray[i], finalArray[j], finalArray[k], finalArray[m] ,finalArray[y],finalArray[x]);
                            }


                        }

                    }


                }
            }
        }
    }



}

    public static boolean isEven(int[] row ) {

        int count = 0;

        for (int i = 0; i < row.length; i++) {
            if (row[i] % 2 == 0) count++;
        }

        return (count <= 4);
    }


    public static boolean isOdd(int[] row ) {
        int count = 0;

        for (int i = 0; i < row.length; i++) {
            if (row[i] % 2 != 0) count++;
        }

        return (count <= 4);
    }



    public static boolean isCont(int[] row ){

        int count = 0;

        for (int i = 0; i < row.length -1  ; i++) {
            // αν η διαφορα αναμεσα σε 2 κελια ειναι 1 τοτε ειναι
            // η -1 τοτε ειναι διαδοχικα

            if ( (row[i+1] - row[i] ) == 1 ) count++;
            if ( (row[i+1] - row[i] ) == -1 )  count++;

        }

        return (count <= 2);

    }

    public static boolean checkSameEnding(int[] row ){

        return false;

    }

    public static boolean checkDozen(int[] row ){
        return false;

    }



}

