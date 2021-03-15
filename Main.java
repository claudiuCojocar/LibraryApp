import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerForText = new Scanner(System.in);
        Scanner scannerForNumber = new Scanner(System.in);
        System.out.print("enter the library name:");
        String nameOfLibrary = scannerForText.nextLine();
        Library library = null;
        String chouse;
        do {
            System.out.print("Do you wanna auto-populate?(y/n)");
            chouse = scannerForText.nextLine();
            if (chouse.equalsIgnoreCase("y")) {
                library = new Library(nameOfLibrary, 10);
                library.autoPopulate();
                System.out.println();
            } else if (chouse.equalsIgnoreCase("n")) {
                System.out.print("enter the number of books:");
                int numberOfBooks = scannerForNumber.nextInt();
                library = new Library(nameOfLibrary, numberOfBooks);
                library.populateWithBooks();
                System.out.println();
            }
        } while (!chouse.equalsIgnoreCase("y") && !chouse.equalsIgnoreCase("n"));
        library.startApp();

    }
}
