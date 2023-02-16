import java.util.Scanner;

public class Checks {
    public static int parseInt(String b) {

        Scanner scanner = new Scanner(System.in);

        int a = 0;
        try {
            a = Integer.parseInt(b);
        } catch (NumberFormatException ex) {
            System.out.println("""
                    \tErrore durante la scelta, il numero inserito contiene una o più lettere.
                    \tRiavviare il programma.


                    Premere un tasto per continuare...""");
            scanner.nextLine();
            System.exit(0);
        }
        return a;
    }
}
