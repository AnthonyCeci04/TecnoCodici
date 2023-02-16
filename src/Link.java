import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Link {
    public static void open() throws URISyntaxException, IOException {

        Desktop desktop = Desktop.getDesktop();
        Scanner scanner = new Scanner(System.in);

        Console.clear();

        System.out.println("TecnoCodici - by ToxicAnthony @NonSonoAntho\n\n");

        System.out.print("""
                ┌────────────────────────────────────┐
                             MENU SCELTA\s

                  1) Codice Civile
                  2) Codice Penale
                  3) Codice Stradale
                └────────────────────────────────────┘

                """);

        System.out.print("Effettua la tua scelta: ");
        String strLink = scanner.nextLine().strip();

        int chooseLink = Checks.parseInt(strLink);

        while (chooseLink < 1 || chooseLink > 3) {
            System.out.print("\tErrore durante la scelta, il numero inserito non è valido.\n\tReinserisci il numero: ");
            strLink = scanner.nextLine().strip();
            chooseLink = Checks.parseInt(strLink);
        }

        switch (chooseLink) {
            case 1 -> {
                desktop.browse(new URI("https://docs.google.com/document/d/1JRMVVJn5JRsmwF3gl0zHjlhu6gUMsqAh5Q4cCFQdvCM/edit#heading=h.fvvtydsbngv"));
                System.out.print("Hai aperto con successo il Codice Civile");
            }
            case 2 -> {
                desktop.browse((new URI("https://docs.google.com/document/d/11n607oa4jbNTADLznxBjV80b3Kuaj4dr0y4MxDakvBE/edit#")));
                System.out.print("Hai aperto con successo il Codice Penale");
            }
            case 3 -> {
                desktop.browse((new URI("https://docs.google.com/document/d/148aM4VqIpN3jfodK8Dr6pExzYMUaB_byy0S17w_YzcE/edit#heading=h.a3wf3qhptxmg")));
                System.out.print("Hai aperto con successo il Codice Stradale");
            }
        }
    }
}
