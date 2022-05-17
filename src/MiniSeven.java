/**
 *  MiniSeven
 *  αντιγραφη πινακα με shallow & deep copy
 *  @author zacharidis
 *
 */

public class MiniSeven {

    public static void main(String[] args) {
        // μεταβλητες

        int arr1[] = {1,1,1,1,1,1,1,1,1,1};

        int arr2[] = new int[arr1.length];


        arr2 = arr1;

        arr2[5] = 2 ; // αλλαζουμε μια τιμη σε ενα κελι ενος απο τους δυο πινακες


        printTables("Εκτυπωση shallow copy" ,arr1,arr2); // εκτυπωση shallow copy θα αλλαξει την τιμη και στους δυο πινακες




        int arr3[] = {1,1,1,1,1,1,1,1,1,1};

        int arr4[] = new int[arr3.length];


        for (int i = 0 ; i < arr3.length ; i++ ){ // αντιγραφη ενα προς ενα deep copy

            arr4[i] = arr3[i];

        }

        arr4[5]= 2 ;

        printTables("Εκτυπωση deep copy" ,arr3,arr4); // εκτυπωση shallow copy θα αλλαξει την τιμη και στους δυο πινακες





        // επεξεργασια

        // εξοδος αποτελεσματων



    }

    public static void printTables(String message, int arr1[], int arr2[]){

        System.out.println(message);

        System.out.print("ο πινακας 1 περιεχει τις τιμες : ");
        for (int i = 0 ; i < arr1.length; i++ ){

            System.out.print(arr1[i] + " ");

        }
        System.out.println();

        System.out.print("o πινακας 2 περιεχει τις τιμες : ");
        for (int i = 0 ; i < arr1.length; i++ ){
            System.out.print(arr2[i] + " ");

        }

        System.out.println();
    }


}
