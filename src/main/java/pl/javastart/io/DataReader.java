package pl.javastart.io;
import pl.javastart.model.Book;
import pl.javastart.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner (System.in);

    public Book readAndCreateBook() {

        System.out.println ("Tytuł");
        String title = scanner.nextLine ();
        System.out.println ("Autor");
        String author = scanner.nextLine ();
        System.out.println ("Wydawnictwo");
        String publisher = scanner.nextLine ();
        System.out.println ("ISBN");
        String isbn = scanner.nextLine ();
        System.out.println ("Rok wydania: ");
        int releaseDate = getInt ();
        System.out.println ("Liczba stron: ");
        int pages = getInt ();
        return new Book (title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine(){

        System.out.println ("Tytuł");
        String title = scanner.nextLine ();
        System.out.println ("Wydawnictwo");
        String publisher = scanner.nextLine ();
        System.out.println ("Język");
        String language = scanner.nextLine ();
        System.out.println ("Rok wydania: ");
        int year = getInt ();
        System.out.println ("Miesiac: ");
        int month = getInt ();
        System.out.println ("Dzień: ");
        int day = getInt ();

        return new Magazine (title, publisher, language, year, month, day);
    }



    public int getInt() {
        int number = scanner.nextInt ();
        scanner.nextLine ();
        return number;
    }


    public void close() {
        scanner.close ();
    }
}
