import java.util.Scanner;

/**
 * MiniTwo
 * Προσομειωση τηλεφωνικου καταλογου
 * με την χρηση πινακων.
 * Σωζει επωνυμο και ονομα και τηλεφωνο
 * σε ενα πινακα [500,3]
 * @author zacharidis
 */


public class MiniTwo {

    // public static για scope απο ολο το προγραμμα
    public static String [] [] catalog = new String[500][3];



    public static void main(String[] args) {
        // μεταβλητες

        String newName , newLastName , newTelNumber ;
        int userSelection = 0 ;
        String userInput = " ";
        boolean exitNow = false ;
        Scanner in = new Scanner(System.in);

        fillBook(); // γεμισε τον πινακα με 0 εκτος απο την 1η γραμμη για τεστ


        do  {
            System.out.println("ΚΑΛΩΣΗΡΘΑΤΕ ΣΤΟΝ ΝΕΟ ΤΗΛΕΦΩΝΙΚΟ ΚΑΤΑΛΟΓΟ");
            System.out.println("ΕΠΙΛΟΓΕΣ");
            System.out.println("1. για αναζητηση με βαση το τηλεφωνο ");
            System.out.println("2. για εισαγωγη νεας επαφης ");
            System.out.println("3. Ενημερωση επαφης (υπαρχουσας)");
            System.out.println("4. Διαγραφή επαφης  (υπαρχουσας)");
            System.out.println("5. Εξοδος ");

            userSelection = in.nextInt();

            switch(userSelection) {
                case 1:
                    System.out.println("Διαλεξατε αναζητηση με βαση το τηλεφωνο");
                    System.out.println("Δωστε αριθμο");
                    userInput = in.next();
                    System.out.println("Επιλεξατε : " + userInput);
                    System.out.println("Γινεται αναζητηση...");
                    System.out.println(findContact(userInput));


                    break;
                case 2:
                    System.out.println("Διαλεξατε εισαγωγη νεας επαφης");
                    newLastName = in.next();
                    newName = in.next();
                    newTelNumber = in.next();
                    System.out.println("Επιτυχια εγγραφης " + addContact(newLastName ,newName ,newTelNumber));


                    break;

                case 3:
                    System.out.println("Ενημερωση μιας υπαρχουσας επαφης");
                    System.out.println("Παρακαλω επιλεξτε επαφη βαση του του αριθμου ");
                    newTelNumber = in.next();
                    System.out.println("Παρακαλω δωστε τα νεα στοιχεια για την επαφη : " + newTelNumber);
                    newLastName = in.next();
                    newName = in.next();
                    System.out.println("Ενημερωη επαφης : " + updateContact(newLastName,newName,newTelNumber));




                    break;
                //
                case 4 :
                    System.out.println("Διαγραφη μιας υπαρχουσας επαφης");
                    System.out.println("Παρακαλω επιλεξτε επαφη για διαγραφη βαση του αριθμου");
                    userInput = in.next();
                    System.out.println("Eπιλεξατε την επαφη  : " + findContact(userInput) + " για διαγραφη ");
                    System.out.println("Για επιβεβαιωση δωστε 1 , για ακυρωση δωστε 2 ");
                    userSelection = in.nextInt() ;
                    if ( userSelection == 2 ) {
                        System.out.println("ακυρωση διαγραφης");

                    } else {
                        deleteContact(userInput);
                        System.out.println("ΔΙΕΓΡΑΦΗ");
                    }




                    break;

                default:

                    System.out.print("Διαλεξατε εξοδο , αντιο :) ");
                    exitNow = true;


            }

        } while (exitNow == false);


    }

    /***************************************methods*********************************************************/
    public static void fillBook(){
        for (int i = 0 ; i < catalog.length; i++){
            for (int j = 0 ; j < catalog[i].length; j++){
                catalog[i][j] = " ";
            }
        }
        // dokimastika dedomena
        catalog[0][0] ="George";
        catalog[0][1] ="Zach";
        catalog [0][2]= "696969";
    }


    //*******************************************************************************//


    public static String findContact(String checkForUser){
        String userFound = "Nothing found" ;

        for (int i = 0 ; i <catalog.length; i++ ) {

            if (catalog[i][2].equals(checkForUser)) {
                userFound = catalog[i][0] + "  " + catalog[i][1]  + " " + catalog[i][2] ;
            }
        }
        return userFound;
    }


    public static boolean updateContact(String lastName , String firstName , String telNumber ){
        boolean updated = false ;

        for (int i = 0 ; i < catalog.length ; i++ ){
            if (catalog[i][2].equals(telNumber)){
                System.out.println("Η εγγραφη βρεθηκε , γινεται ανανεωση ");
                catalog[i][0] = lastName;
                catalog[i][1] = firstName;

                updated = true ;
                System.out.println("Τα νεα στοιχεια ειναι : " + catalog[i][0] + " " +catalog[i][1] + " " + catalog[i][2]);

            }
        }


        return updated;

    }
    public static boolean addContact(String lastName , String firstName , String telNumber ){
        boolean add = false;


        for (int i = 0 ; i <catalog.length; i++ ) {

            if (catalog[i][2].equals(telNumber)) { //  ο αριθμος υπαρχει ηδη
                System.out.println("Η εγγραφη υπαρχει ηδη");
                return add ;

            }
        }


        for (int i = 0 ; i <catalog.length; i++ ){
            if (catalog[i][2].equals(" ")) {
                catalog[i][0] = lastName;
                catalog[i][1] = firstName;
                catalog[i][2] = telNumber;
                System.out.println("Εγγραφη επιτυχης");
                System.out.print("H εγγραφη : ");
                System.out.println(catalog[i][0] + " " +  catalog[i][1] + " " +  catalog[i][2]);
                System.out.println("καταχωρηθηκε επιτυχως");
                add = true;
                break;
            }

        }


        return add;

    }

    public static void deleteContact(String telNumber) {
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i][2].equals(telNumber)) {
                System.out.println("Η εγγραφη διαγραφεται ");
                catalog[i][0] = "0";
                catalog[i][1] = "0";
                catalog[i][2] = "0";
            }
        }


    }



}
