package GUI;

public class FileNotSelectedException extends Exception{
    FileNotSelectedException() {
        super("Plik nie został wybrany");
    }
}
