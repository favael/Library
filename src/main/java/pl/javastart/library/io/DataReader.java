package pl.javastart.library.io;
import pl.javastart.library.model.Book;
import pl.javastart.library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner (System.in);
    private ConsolePrinter consolePrinter;

    public DataReader(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public Book readAndCreateBook() {

        consolePrinter.printLine ("Tytuł");
        String title = scanner.nextLine ();
        consolePrinter.printLine ("Autor");
        String author = scanner.nextLine ();
        consolePrinter.printLine ("Wydawnictwo");
        String publisher = scanner.nextLine ();
        consolePrinter.printLine ("ISBN");
        String isbn = scanner.nextLine ();
        consolePrinter.printLine ("Rok wydania: ");
        int releaseDate = getInt ();
        consolePrinter.printLine ("Liczba stron: ");
        int pages = getInt ();
        return new Book (title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine(){

        consolePrinter.printLine ("Tytuł");
        String title = scanner.nextLine ();
        consolePrinter.printLine ("Wydawnictwo");
        String publisher = scanner.nextLine ();
        consolePrinter.printLine ("Język");
        String language = scanner.nextLine ();
        consolePrinter.printLine ("Rok wydania: ");
        int year = getInt ();
        consolePrinter.printLine ("Miesiac: ");
        int month = getInt ();
        consolePrinter.printLine ("Dzień: ");
        int day = getInt ();

        return new Magazine (title, publisher, language, year, month, day);
    }

public String getString () {
       return scanner.nextLine ();
}

    public int getInt() {
        try {
            return scanner.nextInt ();
        }finally {
            scanner.nextLine ();
        }
    }


    public void close() {
        scanner.close ();
    }
}
