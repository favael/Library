package pl.javastart.io;

import pl.javastart.model.Book;
import pl.javastart.model.Magazine;
import pl.javastart.model.Publication;

public class ConsolePrinter {

    public void printBooks(Publication[] publications) {
        int countBooks = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                System.out.println (publication);
                countBooks++;
            }
        }
        if (countBooks == 0) {
            printLine ("Brak książek w bibliotece");
        }
    }

    public void printMagazines(Publication[] publications) {
        int countMagazines = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine)
                System.out.println (publication);
            countMagazines++;
        }
        if (countMagazines == 0) {
            printLine ("Brak magazynów w bibliotece");
        }
    }

    public void printLine (String text) {
        System.out.println (text.toUpperCase ());
    }
}
