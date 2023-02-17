import java.util.Scanner;

public class Code {
    public static void open() {

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
        String strCode = scanner.nextLine().strip();

        int chooseCode = Checks.parseInt(strCode);

        while (chooseCode < 1 || chooseCode > 3) {
            System.out.print("\tErrore durante la scelta, il numero inserito non è valido.\n\tReinserisci il numero: ");
            strCode = scanner.nextLine().strip();
            chooseCode = Checks.parseInt(strCode);
        }

        String file_path = " ";
        String code = " ";
        switch (chooseCode) {
            case 1 -> {
                file_path = "Codici/Codice Civile.csv";
                code = "Civile";
            }
            case 2 -> {
                file_path = "Codici/Codice Penale.csv";
                code = "Penale";
            }
            case 3 -> {
                file_path = "Codici/Codice Stradale.csv";
                code = "Stradale";
            }
        }

        System.out.print("\nQuale articolo vuoi cercare? -> ");
        String strArt = scanner.nextLine().strip();
        System.out.println();
        int art = Checks.parseInt(strArt);

        File.reader(file_path, code, art);
    }
}


