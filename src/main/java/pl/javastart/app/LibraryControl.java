package pl.javastart.app;

import pl.javastart.exception.NoSuchOptionException;
import pl.javastart.io.ConsolePrinter;
import pl.javastart.io.DataReader;
import pl.javastart.model.Book;
import pl.javastart.model.Library;
import pl.javastart.model.Magazine;
import pl.javastart.model.Publication;

import java.util.InputMismatchException;

class LibraryControl {
    private ConsolePrinter consolePrinter = new ConsolePrinter ();
    private DataReader dataReader = new DataReader (consolePrinter);
    private Library library = new Library ();



    public void controlLoop() {
        Option option;

        do {
            printOptions ();
            option = getOption();

            switch (option) {
                case ADD_BOOK:
                    addBook ();
                    break;
                case ADD_MAGAZINE:
                    addMagazine ();
                    break;
                case PRINT_BOOKS:
                    printBooks ();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines ();
                    break;
                case EXIT:
                    exit ();
                    break;
                default:
                    consolePrinter.printLine ("Nie ma takiej opcji, wprowadź ponownie.");
            }
        } while (option != Option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option =null;
        while (!optionOk) {
            try {
                option = Option.createFromInt (dataReader.getInt ());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                consolePrinter.printLine (e.getMessage ());
            } catch (InputMismatchException e) {
                consolePrinter.printLine ("Wprowadzono wartość, która nie jest liczbą, podaj ponownie:");
            }
        } return option;
    }


    private void exit() {
        System.out.println ("Koniec programu, papa!");
        dataReader.close ();
    }

    private void printBooks() {
        Publication[] publications = library.getPublications ();
        consolePrinter.printBooks (publications);
    }

    private void printMagazines() {
        try {
        Publication[] publications = library.getPublications ();
        consolePrinter.printMagazines (publications);
        } catch (InputMismatchException e) {
            consolePrinter.printLine ("Nie udało sie utworzyć magazynu, niepoprawne dane.");
        } catch (ArrayIndexOutOfBoundsException e) {
            consolePrinter.printLine ("Osiągnieto limit pojemności, nie można dodać kolejnego magazynu");
        }
    }


    private void addBook() {
        try {
        Book book = dataReader.readAndCreateBook ();
        library.addBook (book);

        } catch (InputMismatchException e) {
            consolePrinter.printLine ("Nie udało sie utworzyć ksiązki, niepoprawne dane.");
        } catch (ArrayIndexOutOfBoundsException e) {
            consolePrinter.printLine ("Osiągnieto limit pojemności, nie można dodać kolejnej ksiązki");
        }
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine ();
        library.addMagazine (magazine);
    }


    private void printOptions() {
        consolePrinter.printLine ("Wybierz opcję:");
        for (Option option : Option.values ()) {
            consolePrinter.printLine (option.toString ());
        }
    }

}
