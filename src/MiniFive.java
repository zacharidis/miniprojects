import java.util.Scanner;
import java.util.Arrays;

/**
 * MiniFive
 * επιστρεφει τα low & high index ενος πινακα
 * δηλαδη βρισκει ενα συγκεκριμενο ακεραιο στον πινακα και
 * την θεση του και ποσες φορες (αν) αυτος επαναλαμβανεται
 * @author zacharidis
 */


public class MiniFive {

    public static int zArray[] = { 0,1,4,4,4,6,7,8,8,8,8,9};

    public static void main(String[] args) {
        int selectedNum = 0 ;
        int higherMax = 0 ;
        int lowerMax = 0 ;

        Scanner in = new Scanner(System.in);
        System.out.println("Παρακαλω επιλεξτε αριθμο : ");
        selectedNum = in.nextInt();

        for  (int i = 0 ; i < zArray.length; i++ ){
            if (selectedNum == zArray[i] ) {
                System.out.println("βρεθηκε στην θεση " + i ); // αφου βρηκα την θεση σταματαω
                lowerMax  =i ;

                break;
            }
        }

        System.out.println(selectedNum + " Ο αριθμος που επιλεξατε ");
        System.out.println(lowerMax + " Ειναι το κατωτατο οριο του");

        // tωρα το higher index με μεθοδο
        higherMax = bounds(lowerMax +1 ,selectedNum); // + 1 για να παρει το αμεσως επομενο ο counter και να μην ξαναμετρησει την ηδη υαπρχοθσα θεση
        higherMax = lowerMax + higherMax ;

        System.out.println(higherMax + " ειναι το ανωτατο οριο του");

    }

    public static int bounds(int low , int selectedValue) {
        int counter = 0 ;

        for (int i = low ; i < zArray.length ; i ++) {
            if (zArray[i]== selectedValue ) {
                counter ++ ;

            }


        }
        return counter;
    }

}
