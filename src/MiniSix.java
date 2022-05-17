/**
 * μεγιστο αθροισμα υποπινακα
 * @author zacharidis
 *
 * ο αλγοριθμος θα ξεκιναει απο το 0 κελι του πινακα και θα ελεγχει αν καθε
 * αριθμος που προστιθεται (δηλαδη τα επομενα κελια) διημιουργει ενα μεγαλυτερο αθροισμα
 * θα πρεπει βαση της εκφωνησης να εκτελειται με πολυπλοκοτητα O(n) αρα θα πρεπει να διατρεξει
 * τον πινακα μονο μια φορα και οχι το υπολοιπο του πινακα για καθε βημα δηλαδη οχι O(n^2).
 *
 */
public class MiniSix {

    public static void main(String[] args) {
        // Θεση μεταβλητων

        int[] testArray = {-2,1,-3,4,-1,2,1,-5,4};
        int[] testNegativeArray = { -2,-7,-8,-5,-11,-19,-1}; // τεστ μονο αρνητικων τιμων


        // εκτυπωση του πινακα πριν γινει ελεγχος για το μεγιστο αθροισμα υποπινακα

        for (int x : testArray) {
            System.out.printf("%d\n",x);
        }

        // εκτυπωση αποτελεσματος μετα απο κληση της μεθοδου

        System.out.println("Το μεγιστο αθροισμα υποπινακα ειναι : " + maxSubArray(testArray));

        for (int x : testNegativeArray) {
            System.out.printf("%d\n",x);
        }

        System.out.println("To μεγιστο αθροισμα υποπινακα αρνητικων τιμων ειναι : " + maxSubArray(testNegativeArray));






    }

    /**
     * Λαμβανει ενα πινακα ακεραιαων και τον ελεγχει για να βρει το μεγιστο αθροισμα που υπαρχει στους εκαστοτε υποπινακες
     *
     * @param zArray
     * @return  επιστρεφει το μεγιστο αθροισμα υποπινακα που βρηκε
     */
    public static String maxSubArray(int [] zArray) {

        int maxSub = Integer.MIN_VALUE ; // αν βαλουμε 0 τοτε δεν θα λειτουργει αν υπαρχουν αρνητικοι αριθμοι
        int localMaxStart = 0 ; // αθροισμα
        int localMaxEnd = 0 ; //
        int arrayLen = zArray.length; // μεγεθος πινακα
        int startPointer = 0; // για να κραταμε απο ποιο κελι αρχιζει το μεγιαστο αθροισμα
        int endPointer = 0 ;  // για να κραταμε σε ποιο κελι τελειωνει το αθροισμα


        // εστω το μεγιστο αθροισμα ειναι το πρωτο κελι
        localMaxEnd= zArray[0];
        localMaxStart = zArray[0];


        for (int i = 0 ; i < arrayLen ; i++ ){

            /*
             *  αν το καθε κελι που ελεγχουμε δινει αποτελεσμα μεγαλυτερο απο το ηδη υπαρχον
             *  τοτε θετουμε τον υποπινακα οτι ξεκιναει α πο το παρων κελι και ως μεγιστο αθροισμα
             * την τιμη εως αυτο το κελι
             * αλλιως θα δινει το ιδιο η μικροτερο αποτελεσμα αρα δεν αποτελει μερος της λυσης
             * α ν ειναι το 0 θα δινει ιδιο αποτελεσμα αλλα και παλι το κελι εκεινο δεν θα ειναι μερος της λυσης
             *
             *
             * */

            if (zArray[i] > localMaxEnd + zArray[i]) {
                startPointer = i;   // θετουμε την αρχη του μεγιστου υποπινακα
                localMaxEnd = zArray[i];
            } else {
                localMaxEnd = localMaxEnd + zArray[i];
            }


            // ελεγχουμε αν το εως τωρα αθροισμα ειναι μιρκοτερο απο το ηδη υπολογισμενο
            if (localMaxStart < localMaxEnd) {   // ε
                localMaxStart = localMaxEnd;
                endPointer = i ; // τελευταια θεση μεγιστου υποπινακα
            }


        }

        String result = ( localMaxStart + " " + " αναμεσα στις θεσεις : " + startPointer + " και " + endPointer   );

        return result;


    }



}
