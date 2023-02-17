import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {

        Scanner scanner = new Scanner(System.in);

        Console.clear();

        System.out.print("TecnoCodici - by ToxicAnthony @NonSonoAntho\n\n\nAggiornamento dei codici in corso...");
        File.update();

        Console.clear();

        System.out.println("TecnoCodici - by ToxicAnthony @NonSonoAntho\n\n");

        String strChoose;

        System.out.print("""
                ┌────────────────────────────────────┐
                             MENU SCELTA\s

                  1) Desidero aprire i codici
                  2) Desidero cercare un articolo
                └────────────────────────────────────┘

                """);

        System.out.print("Effettua la tua scelta: ");
        strChoose = scanner.nextLine().strip();

        int choose = Checks.parseInt(strChoose);
        String redo;

        while (choose < 1 || choose > 2) {
            System.out.print("\tErrore durante la scelta, il numero inserito non è valido.\n\tReinserisci il numero: ");
            strChoose = scanner.nextLine().strip();
            choose = Checks.parseInt(strChoose);
        }
        ArrayList history = new ArrayList();
        switch (choose) {
            case 1 -> {
                do {
                    Link.open();
                    System.out.print("\n\n\nAprire un altro codice? (n per uscire) -> ");
                    redo = scanner.nextLine().strip();
                } while (!redo.equals("n"));
            }
            case 2 -> {
                do {
                    Code.open(history);
                    System.out.print("\n\n\nCercare un altro articolo?\n\t(n per uscire, h per guardare la cronologia) -> ");
                    redo = scanner.nextLine().strip();

                    if (redo.equals("h")) History.load(history);

                } while (!redo.equals("n"));
            }
        }
    }
}
