package pl.javastart.app;

public class LibraryApp {
    public static void main(String[] args) {
        final String appName = "Biblioteka v1.6";
        System.out.println (appName);
        LibraryControl libraryControl = new LibraryControl ();
        libraryControl.controlLoop ();
    }
}
