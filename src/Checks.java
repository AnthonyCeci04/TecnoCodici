import java.util.Scanner;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Checks {
    public static int parseInt(String b) throws IOException{

        Scanner scanner = new Scanner(System.in);

        int a = 0;
        try {
            a = Integer.parseInt(b);
        } catch (NumberFormatException ex) {
            System.out.println("""
                    \tErrore durante la scelta, il numero inserito contiene una o più lettere.
                    \tRiavvio il programma.


                    Premere un tasto per continuare...""");
            scanner.nextLine();
            File file = new File("start.bat");
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
            System.exit(0);
        }
        return a;
    }
}