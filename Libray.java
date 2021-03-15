package com.JavaFundamentals2;

import java.util.Scanner;

class Library {
    public String nameOfLibrary;
    public Book[] books;
    Scanner scannerForText = new Scanner(System.in);
    Scanner scannerForNumber = new Scanner(System.in);

    public Library(String nameOfLibrary, int numberOfBooks) {
        books = new Book[numberOfBooks];
        this.nameOfLibrary = nameOfLibrary;
    }

    public void populateWithBooks() {
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book no.:" + (i + 1));
            System.out.print("book name:");
            String name = scannerForText.nextLine();
            System.out.print("book isbn:");
            int isbn = scannerForNumber.nextInt();
            System.out.print("book author:");
            String authorName = scannerForText.nextLine();
            System.out.print("book number of pages:");
            int nrOfPages = scannerForNumber.nextInt();
            System.out.print("editorialName:");
            String editorialName = scannerForText.nextLine();
            System.out.print("book kind of literature:");
            String kindOfLiterature = scannerForText.nextLine();
            System.out.print("price:");
            double price = scannerForNumber.nextDouble();
            Book currentBook = new Book(name, isbn, authorName, nrOfPages, editorialName, kindOfLiterature, price);
            books[i] = currentBook;
        }
    }

    public void startApp() {
        System.out.println("Welcome to the " + nameOfLibrary + " library!");
        mainApp();
    }

    public void mainApp() {
        String chose;
        do {
            showMenu();
            System.out.print("chose:");
            chose = scannerForText.nextLine();
            switch (chose) {
                case "1":
                    showBooks();
                    break;
                case "2":
                    buyBook();
                    break;
                case "3":
                    bookByName();
                    break;
                case "4":
                    bookByAuthor();
                    break;
                case "5":
                    bookByEditorialName();
                    break;
                case "6":
                    bookByPrice();
                    break;
                case "7":
                    bookByPages();
                    break;
                case "8":
                    bookByKindOfLiterature();
                    break;
                case "9":
                    totalAvailableBooksPrice();
                    break;
                case "10":
                    averageAvailableBooksPrice();
                    break;
                case "11":
                    lowestPrice();
                    break;
                case "12":
                    highestPrice();
                    break;
                case "13":
                    largestPages();
                    break;
                case "14":
                    smallestPages();
                    break;
                case "15":
                    longestName();
                    break;
                case "16":
                    System.out.println("Bye Bye...");
                default:
                    System.out.println("Try a valid option or press 16...");
            }
        } while (!chose.equals("16"));
    }

    public void showMenu() {
        System.out.println(" 1.Show books.\n" +
                " 2.Buy a book. (Offer possibility to choose a book)\n" +
                " 3.Show books by name enter from the console. (Offer possibility to choose a book)\n" +
                " 4.Show books by authorNme enter from the console.(Offer possibility to choose a book)\n" +
                " 5.Show books by editorialName enter from the console.(Offer possibility to choose a book)\n" +
                " 6.Show books by price enter from the console.(Offer possibility to choose a book)\n" +
                " 7.Show books that have more then nrOfPages enter from the console.(Offer possibility to choose a book)\n" +
                " 8.Show books by kindOfLiterature enter from the console.(Offer possibility to choose a book)\n" +
                " 9.Calculate and show total price for all books in library.\n" +
                "10.Calculate and show the average price of all books.\n" +
                "11.Show the book with the lowest price.\n" +
                "12.Show the book with the highest price. \n" +
                "13.Show the book with the largest number of pages.\n" +
                "14.Show the book with the smallest number of pages.\n" +
                "15.Show the book with the longest name.\n" +
                "16.Exit");
    }

    public void longestName() {
        int longestName = books[0].name.length();
        int index = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].availability.equalsIgnoreCase("available") && books[i].name.length() > longestName) {
                longestName = books[i].name.length();
                index = i;
            }
        }
        System.out.println("The book with longest name is:");
        showBook(index);

    }

    public void smallestPages() {
        int index = 0;
        int smallestPages = books[0].nrOfPages;
        for (int i = 0; i < books.length; i++) {
            if (books[i].availability.equalsIgnoreCase("available") && books[i].nrOfPages < smallestPages) {
                smallestPages = books[i].nrOfPages;
                index = i;
            }
        }
        System.out.println("The book with largest number of pages is:");
        showBook(index);
    }

    public void largestPages() {
        int index = 0;
        int largesPages = books[0].nrOfPages;
        for (int i = 0; i < books.length; i++) {
            if (books[i].availability.equalsIgnoreCase("available") && books[i].nrOfPages > largesPages) {
                largesPages = books[i].nrOfPages;
                index = i;
            }
        }
        System.out.println("The book with largest number of pages is:");
        showBook(index);
    }

    public void highestPrice() {
        int highestBook = 0;
        double highestPrice = books[0].price;
        for (int i = 0; i < books.length; i++) {
            if (books[i].availability.equalsIgnoreCase("available") && books[i].price > highestPrice) {
                highestPrice = books[i].price;
                highestBook = i;
            }
        }
        System.out.println("The book with highest price is:");
        showBook(highestBook);
    }

    public void lowestPrice() {
        int loweBook = 0;
        double lowerPrice = books[0].price;
        for (int i = 0; i < books.length; i++) {
            if (books[i].availability.equalsIgnoreCase("available") && books[i].price < lowerPrice) {
                lowerPrice = books[i].price;
                loweBook = i;
            }
        }
        System.out.println("The book with lower price is:");
        showBook(loweBook);
    }

    public void averageAvailableBooksPrice() {
        double totalPrice = 0;
        for (Book book : books) {
            if (book.availability.equalsIgnoreCase("available")) {
                totalPrice += book.price;
            }
        }
        System.out.println("Average price of available books are " + (totalPrice / (books.length - 1)));
    }

    public void totalAvailableBooksPrice() {
        double totalPrice = 0;
        for (Book book : books) {
            if (book.availability.equalsIgnoreCase("available")) {
                totalPrice += book.price;
            }
        }
        System.out.println("Total price of available books are " + totalPrice);

    }

    public void bookByKindOfLiterature() {
        int ver = 0, control = 0;
        Book[] copyOfBooks;
        System.out.print("book kind of literature:");
        String currentKindOfLiterature = scannerForText.nextLine();
        for (Book book : books) {
            if (book.kindOfLiterature.equalsIgnoreCase(currentKindOfLiterature)) {
                ver++;
            }
        }
        if (ver == 0) {
            System.out.println("No book with this criteria...");
        } else {
            copyOfBooks = new Book[ver];
            for (Book book : books) {
                if (book.kindOfLiterature.equalsIgnoreCase(currentKindOfLiterature)) {
                    copyOfBooks[control] = book;
                    control++;
                }
            }
            showBooksCopy(copyOfBooks);
            buyCopyOfBooks(copyOfBooks);
        }
    }

    public void bookByPages() {
        int ver = 0, control = 0;
        Book[] copyOfBooks;
        System.out.print("book pages:");
        int currentPages = scannerForNumber.nextInt();
        for (Book book : books) {
            if (book.nrOfPages > currentPages) {
                ver++;
            }
        }
        if (ver == 0) {
            System.out.println("No book with this criteria...");
        } else {
            copyOfBooks = new Book[ver];
            for (Book book : books) {
                if (book.nrOfPages > currentPages) {
                    copyOfBooks[control] = book;
                    control++;
                }
            }
            showBooksCopy(copyOfBooks);
            buyCopyOfBooks(copyOfBooks);
        }
    }

    public void bookByPrice() {
        int ver = 0, control = 0;
        Book[] copyOfBooks;
        System.out.print("book price:");
        double currentPrice = scannerForNumber.nextDouble();
        for (Book book : books) {
            if (book.price == currentPrice) {
                ver++;
            }
        }
        if (ver == 0) {
            System.out.println("No book with this criteria...");
        } else {
            copyOfBooks = new Book[ver];
            for (Book book : books) {
                if (book.price == currentPrice) {
                    copyOfBooks[control] = book;
                    control++;
                }
            }
            showBooksCopy(copyOfBooks);
            buyCopyOfBooks(copyOfBooks);
        }
    }

    public void bookByName() {
        int ver = 0, control = 0;
        Book[] copyOfBooks;
        System.out.print("book name:");
        String currentName = scannerForText.nextLine();
        for (Book book : books) {
            if (book.name.equalsIgnoreCase(currentName)) {
                ver++;
            }
        }
        if (ver == 0) {
            System.out.println("No book with this criteria...");
        } else {
            copyOfBooks = new Book[ver];
            for (Book book : books) {
                if (book.name.equalsIgnoreCase(currentName)) {
                    copyOfBooks[control] = book;
                    control++;
                }
            }
            showBooksCopy(copyOfBooks);
            buyCopyOfBooks(copyOfBooks);
        }
    }

    public void bookByEditorialName() {
        int ver = 0, control = 0;
        Book[] copyOfBooks;
        System.out.print("editorial name:");
        String currentEditorialName = scannerForText.nextLine();
        for (Book book : books) {
            if (book.editorialName.equalsIgnoreCase(currentEditorialName)) {
                ver++;
            }
        }
        if (ver == 0) {
            System.out.println("No book with this criteria...");
        } else {
            copyOfBooks = new Book[ver];
            for (Book book : books) {
                if (book.editorialName.equalsIgnoreCase(currentEditorialName)) {
                    copyOfBooks[control] = book;
                    control++;
                }
            }
            showBooksCopy(copyOfBooks);
            buyCopyOfBooks(copyOfBooks);
        }
    }

    public void bookByAuthor() {
        int ver = 0, control = 0;
        Book[] copyOfBooks;
        System.out.print("author name:");
        String currentAuthor = scannerForText.nextLine();
        for (Book book : books) {
            if (book.authorName.equalsIgnoreCase(currentAuthor)) {
                ver++;
            }
        }
        if (ver == 0) {
            System.out.println("No book with this criteria...");
        } else {
            copyOfBooks = new Book[ver];
            for (Book book : books) {
                if (book.authorName.equalsIgnoreCase(currentAuthor)) {
                    copyOfBooks[control] = book;
                    control++;
                }
            }
            showBooksCopy(copyOfBooks);
            buyCopyOfBooks(copyOfBooks);
        }
    }

    public void showBooksCopy(Book[] copyOfBooksCopy) {
        for (int i = 0; i < copyOfBooksCopy.length; i++) {
            System.out.print("Book no." + (i + 1));
            System.out.print(" / " + copyOfBooksCopy[i].availability);
            System.out.print(" / name:" + copyOfBooksCopy[i].name);
            System.out.print(" / isbn:" + copyOfBooksCopy[i].isbn);
            System.out.print(" / author:" + copyOfBooksCopy[i].authorName);
            System.out.print(" / number of pages:" + copyOfBooksCopy[i].nrOfPages);
            System.out.print(" / editorial name:" + copyOfBooksCopy[i].editorialName);
            System.out.print(" / kind of literature:" + copyOfBooksCopy[i].kindOfLiterature);
            System.out.print(" / price:" + copyOfBooksCopy[i].price);
            System.out.println();
        }
    }

    public void showBooks() {
        for (int i = 0; i < books.length; i++) {
            System.out.print("Book no." + (i + 1));
            System.out.print(" / " + books[i].availability);
            System.out.print(" / name:" + books[i].name);
            System.out.print(" / isbn:" + books[i].isbn);
            System.out.print(" / author:" + books[i].authorName);
            System.out.print(" / number of pages:" + books[i].nrOfPages);
            System.out.print(" / editorial name:" + books[i].editorialName);
            System.out.print(" / kind of literature:" + books[i].kindOfLiterature);
            System.out.print(" / price:" + books[i].price);
            System.out.println();
        }
    }

    public void showBook(int i) {
        System.out.print("Book no." + (i + 1));
        System.out.print(" / " + books[i].availability);
        System.out.print(" / name:" + books[i].name);
        System.out.print(" / isbn:" + books[i].isbn);
        System.out.print(" / author:" + books[i].authorName);
        System.out.print(" / number of pages:" + books[i].nrOfPages);
        System.out.print(" / editorial name:" + books[i].editorialName);
        System.out.print(" / kind of literature:" + books[i].kindOfLiterature);
        System.out.print(" / price:" + books[i].price);
        System.out.println();
    }

    public void buyCopyOfBooks(Book[] copyOfBooks) {
        int bookForBuy;
        do {
            System.out.print("Witch book you wanna buy?(enter the number): ");
            bookForBuy = scannerForNumber.nextInt();
            if (bookForBuy < 1 || bookForBuy > copyOfBooks.length) {
                System.out.println("Not a valid number. Try again...");
            } else if (!copyOfBooks[bookForBuy - 1].availability.equalsIgnoreCase("available")) {
                System.out.println("This book it's not on stock. Try again...");
            } else {
                String buy;
                System.out.println("The price is " + copyOfBooks[bookForBuy - 1].price + ". You wanna buy it?(y/n)");
                do {
                    buy = scannerForText.nextLine();
                    if (!buy.equalsIgnoreCase("y") && !buy.equalsIgnoreCase("n")) {
                        System.out.println("Not a valid option. Try again...");
                    }
                } while (!buy.equalsIgnoreCase("y") && !buy.equalsIgnoreCase("n"));
                if (buy.equalsIgnoreCase("y")) {
                    System.out.println("Congrats. Pleasant reading !");
                    for (Book book : books) {
                        if (book.isbn == copyOfBooks[bookForBuy - 1].isbn) {
                            book.availability = "not available";
                        }
                    }
                }
            }
        } while (bookForBuy < 1 || bookForBuy > books.length);
    }

    public void buyBook() {
        showBooks();
        int bookForBuy;
        do {
            System.out.print("Witch book you wanna buy?(enter the number): ");
            bookForBuy = scannerForNumber.nextInt();
            if (bookForBuy < 1 || bookForBuy > books.length) {
                System.out.println("Not a valid number. Try again...");
            } else if (!books[bookForBuy - 1].availability.equalsIgnoreCase("available")) {
                System.out.println("This book it's not on stock. Try again...");
            } else {
                String buy;
                System.out.println("The price is " + books[bookForBuy - 1].price + ". You wanna buy it?(y/n)");
                do {
                    buy = scannerForText.nextLine();
                    if (!buy.equalsIgnoreCase("y") && !buy.equalsIgnoreCase("n")) {
                        System.out.println("Not a valid option. Try again...");
                    }
                } while (!buy.equalsIgnoreCase("y") && !buy.equalsIgnoreCase("n"));
                if (buy.equalsIgnoreCase("y")) {
                    System.out.println("Congrats. Pleasant reading !");
                    books[bookForBuy - 1].availability = "not available";
                }
            }
        } while (bookForBuy < 1 || bookForBuy > books.length);
    }

    public void autoPopulate() {
        books[0] = new Book("Amintiri din copilarie", 110641, "Ion Creanga", 178, "AdiArt", "basm", 26.75);
        books[1] = new Book("Poezii vol.1", 185431, "Mihai Eminescu", 79, "EdituraArt", "poezie", 18.90);
        books[2] = new Book("Enigma Otiliei", 815422, "Camil Petrescu", 312, "Climadia", "roman", 42.50);
        books[3] = new Book("Singur pe Lume vol.1", 442612, "Hector Malot", 210, "Speranta", "roman", 32.50);
        books[4] = new Book("Singur pe Lume vol.2", 442616, "Hector Malot", 230, "Speranta", "roman", 32.50);
        books[5] = new Book("Poezii vol.2", 185631, "Mihai Eminescu", 83, "EdituraArt", "poezie", 20.90);
        books[6] = new Book("Dragoste si razboi vol.1", 813521, "Camil Petrescu", 306, "Citim Impreuna", "roman", 44.39);
        books[7] = new Book("Basme populare", 710641, "Colectie Literara", 148, "Luminia", "basm", 26.11);
        books[8] = new Book("Printesa cea urata", 100001, "Cojocar Claudiu", 10, "Titan", "basm", 666.666);
        books[9] = new Book("Dragoste si razboi vol.2", 853521, "Camil Petrescu", 326, "Citim Impreuna", "roman", 46.39);
    }
}
